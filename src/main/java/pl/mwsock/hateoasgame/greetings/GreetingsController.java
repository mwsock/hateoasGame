package pl.mwsock.hateoasgame.greetings;


import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mwsock.hateoasgame.namesApi.NamesApiService;
import pl.mwsock.hateoasgame.player.Phrase;
import pl.mwsock.hateoasgame.player.PlayerEntity;
import pl.mwsock.hateoasgame.player.PlayerRepository;
import pl.mwsock.hateoasgame.player.PlayerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
    public ResponseEntity<List<Phrase>> startGame(){
        String welcomePhrase = "Greetings, Player! Choose your name.";
        Phrase phrase = new Phrase();
        phrase.setWelcomePhrase(welcomePhrase);
        List<Phrase> welcomePhrases = List.of(phrase);
        for (Phrase elem : welcomePhrases) {
           elem.add(linkTo(methodOn(GreetingsController.class).showAvailablePlayersNames()).withSelfRel());
        }
        ResponseEntity<List<Phrase>> response = new ResponseEntity<>(welcomePhrases,HttpStatus.OK);
        return response;
    }


    @GetMapping("/show_names")
    public ResponseEntity<List<PlayerEntity>> showAvailablePlayersNames(){
//        List<PlayerEntity> playerEntities = playerRepository.findAll();
        List<PlayerEntity> playerEntities = new ArrayList<>();
        for (String s : namesApiService.getNamesFromApi().getBody()) {
            PlayerEntity player = new PlayerEntity();
            player.setName(s);
            playerEntities.add(player);
        }
        for (PlayerEntity entity: playerEntities){
            entity.add(linkTo(
//                    methodOn(GreetingsController.class).findPlayerById(entity.getId())
                            methodOn(GreetingsController.class).findPlayerById(1L)
            ).withSelfRel())
                    .add(Link.of("http://www.google.pl"));
        }



        return new ResponseEntity<>(playerEntities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerEntity> findPlayerById(@PathVariable Long id){
        Optional<PlayerEntity> playerEntity = playerRepository.findById(id);
        return new ResponseEntity<>(playerEntity.orElse(new PlayerEntity()),HttpStatus.OK);
    }
}
