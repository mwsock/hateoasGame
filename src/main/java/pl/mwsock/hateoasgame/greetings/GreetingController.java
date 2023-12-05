package pl.mwsock.hateoasgame.greetings;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mwsock.hateoasgame.phrases.BasePhrase;
import pl.mwsock.hateoasgame.player.PlayerDto;
import pl.mwsock.hateoasgame.player.PlayerEntity;
import pl.mwsock.hateoasgame.player.PlayerService;

import java.util.List;

@RestController
@RequestMapping("/")
@Slf4j
public class GreetingController {

    private final PlayerService playerService;
    private final GreetingService greetingService;

    public GreetingController(PlayerService playerService, GreetingService greetingService) {
        this.playerService = playerService;
        this.greetingService = greetingService;
    }

    @GetMapping
    public ResponseEntity<BasePhrase> startGame(){
        return new ResponseEntity<>(greetingService.greetAndStart(),HttpStatus.OK);
    }

    @GetMapping("/show_names")
    public ResponseEntity<List<PlayerDto>> showAvailablePlayersNames(){
        List<PlayerDto> playerEntities = playerService.showAvailableNames();
        return new ResponseEntity<>(playerEntities,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerEntity> findPlayerById(@PathVariable Long id){
        return new ResponseEntity<>(playerService.findById(id).orElse(new PlayerEntity()),HttpStatus.OK);
    }

    @PostMapping("/name/select/{name}")
    public ResponseEntity<BasePhrase> choosePlayerName(@PathVariable String name){
        BasePhrase basePhrase = playerService.chooseName(name);
        return new ResponseEntity<>(basePhrase,HttpStatus.OK);
    }

    @GetMapping("/exit")
    public ResponseEntity<String> exitGame(){
        return new ResponseEntity<>("See you next time!",HttpStatus.OK);
    }
}
