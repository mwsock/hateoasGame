package pl.mwsock.hateoasgame.greetings;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mwsock.hateoasgame.player.PlayerService;

@RestController
@RequestMapping("/")
public class GreetingsController {

    private final PlayerService playerService;

    public GreetingsController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public String showGreetings(){
        return "Greetings stranger!";
    }

    @GetMapping("/{playerName}")
    public String showGreetingsWithName(@PathVariable String playerName){
        return playerService.greetPlayer(playerName);
    }
}
