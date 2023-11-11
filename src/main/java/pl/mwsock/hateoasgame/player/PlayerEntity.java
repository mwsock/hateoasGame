package pl.mwsock.hateoasgame.player;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name ="players")
public class PlayerEntity extends RepresentationModel<PlayerEntity> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonCreator
    public PlayerEntity(@JsonProperty("id") Long id,@JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public String greetPlayer(){
        return "Greetings," + this.name + ". Let's play a game!";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PlayerEntity that = (PlayerEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name);
    }
}
