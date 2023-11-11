package pl.mwsock.hateoasgame.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public PlayerEntity savePlayer(String name){
        PlayerEntity player = new PlayerEntity();
        player.setName(name);
        return playerRepository.save(player);
    }
}
