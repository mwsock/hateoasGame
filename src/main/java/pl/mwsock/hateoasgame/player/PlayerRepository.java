package pl.mwsock.hateoasgame.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity,Long> {
    PlayerEntity findPlayerEntityByName(String name);
}
