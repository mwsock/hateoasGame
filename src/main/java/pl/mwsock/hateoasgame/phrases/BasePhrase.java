package pl.mwsock.hateoasgame.phrases;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@NoArgsConstructor
public class BasePhrase extends RepresentationModel<BasePhrase> {
    private String welcomePhrase;
    private String greetingPlayerByNamePhrase;
    private String exitPhrase;
}
