package pl.mwsock.hateoasgame.greetings;


import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mwsock.hateoasgame.namesApi.NamesApiService;
import pl.mwsock.hateoasgame.player.Phrase;
import pl.mwsock.hateoasgame.player.PlayerEntity;
import pl.mwsock.hateoasgame.player.PlayerRepository;
import pl.mwsock.hateoasgame.player.PlayerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/")
@Slf4j
public class GreetingsController {

    private final PlayerService playerService;
    private final PlayerRepository playerRepository;
    private final NamesApiService namesApiService;

    public GreetingsController(PlayerService playerService, PlayerRepository playerRepository, NamesApiService namesApiService) {
        this.playerService = playerService;
        this.playerRepository = playerRepository;
        this.namesApiService = namesApiService;
    }

    @GetMapping
    public ResponseEntity<Phrase> startGame(){
        String welcomePhrase = "Greetings, Player! Choose your name.";
        Phrase phrase = new Phrase();
        phrase.setWelcomePhrase(welcomePhrase);
        phrase.add(linkTo(methodOn(GreetingsController.class).showAvailablePlayersNames()).withSelfRel());
        return new ResponseEntity<>(phrase,HttpStatus.OK);
    }


    @GetMapping("/show_names")
    public ResponseEntity<List<PlayerEntity>> showAvailablePlayersNames(){
        List<PlayerEntity> playerEntities = new ArrayList<>();
        for (String s : namesApiService.getNamesFromApi().getBody()) {
            PlayerEntity player = new PlayerEntity();
            player.setName(s);
            player.add(linkTo(methodOn(GreetingsController.class).choosePlayer(player.getName())).withSelfRel()
                    .andAffordance(afford(methodOn(GreetingsController.class).choosePlayer(player.getName()))));
            playerEntities.add(player);
        }
        return new ResponseEntity<>(playerEntities,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerEntity> findPlayerById(@PathVariable Long id){
        Optional<PlayerEntity> playerEntity = playerRepository.findById(id);
        return new ResponseEntity<>(playerEntity.orElse(new PlayerEntity()),HttpStatus.OK);
    }

    @PostMapping("/{name}")
    public ResponseEntity<PlayerEntity> choosePlayer(@PathVariable String name){
        PlayerEntity player = playerService.savePlayer(name);
        return new ResponseEntity<>(player,HttpStatus.OK);
    }
}
