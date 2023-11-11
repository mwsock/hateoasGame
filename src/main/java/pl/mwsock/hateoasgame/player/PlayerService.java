package pl.mwsock.hateoasgame.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mwsock.hateoasgame.greetings.GreetingController;
import pl.mwsock.hateoasgame.intro.IntroController;
import pl.mwsock.hateoasgame.namesApi.NamesApiService;
import pl.mwsock.hateoasgame.phrases.BasePhrase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    private final NamesApiService namesApiService;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, NamesApiService namesApiService) {
        this.playerRepository = playerRepository;
        this.namesApiService = namesApiService;
    }

    public PlayerEntity savePlayer(String name){
        PlayerEntity player = new PlayerEntity();
        player.setName(name);
        return playerRepository.save(player);
    }

    public Optional<PlayerEntity> findById(Long id) {
        Optional<PlayerEntity> playerEntity = playerRepository.findById(id);
        return playerEntity;
    }

    public BasePhrase chooseName(String name) {
        PlayerEntity player = savePlayer(name);
        BasePhrase basePhrase = new BasePhrase();
        basePhrase.setGreetingPlayerByNamePhrase(player.greetPlayer());
        basePhrase.add(linkTo(methodOn(IntroController.class).gameIntro())
                .withSelfRel()
                .withTitle("GET Method")
        );
        return basePhrase;
    }

    public List<PlayerEntity> showAvailableNames() {
        List<PlayerEntity> playerEntities = new ArrayList<>();
        for (String s : Objects.requireNonNull(namesApiService.getNamesFromApi().getBody())) {
            PlayerEntity player = new PlayerEntity();
            player.setName(s);
            player.add(linkTo(methodOn(GreetingController.class).choosePlayerName(player.getName())).withSelfRel());
            playerEntities.add(player);
        }
        return playerEntities;
    }
}
