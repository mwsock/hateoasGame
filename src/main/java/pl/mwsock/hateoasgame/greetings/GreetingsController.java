package pl.mwsock.hateoasgame.greetings;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mwsock.hateoasgame.player.PlayerEntity;
import pl.mwsock.hateoasgame.player.PlayerRepository;
import pl.mwsock.hateoasgame.player.PlayerService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/")
public class GreetingsController {

    private final PlayerService playerService;
    private final PlayerRepository playerRepository;

    public GreetingsController(PlayerService playerService, PlayerRepository playerRepository) {
        this.playerService = playerService;
        this.playerRepository = playerRepository;
    }


    @GetMapping
    public ResponseEntity<List<PlayerEntity>> showGreetings(){
        List<PlayerEntity> playerEntities = playerRepository.findAll();
        for (PlayerEntity entity: playerEntities){
            entity.add(linkTo(
                    methodOn(GreetingsController.class).findPlayerById(entity.getId())
            ).withSelfRel());
        }
        return new ResponseEntity<>(playerEntities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerEntity> findPlayerById(@PathVariable Long id){
        Optional<PlayerEntity> playerEntity = playerRepository.findById(id);
        return new ResponseEntity<>(playerEntity.orElse(new PlayerEntity()),HttpStatus.OK);
    }
}
