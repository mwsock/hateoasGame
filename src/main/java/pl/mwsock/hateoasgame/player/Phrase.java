package pl.mwsock.hateoasgame.player;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@NoArgsConstructor
public class Phrase extends RepresentationModel<Phrase> {
    private String welcomePhrase;
}
