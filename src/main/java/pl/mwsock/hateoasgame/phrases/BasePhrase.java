package pl.mwsock.hateoasgame.phrases;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import pl.mwsock.hateoasgame.greetings.GreetingController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Getter
@Setter
public class BasePhrase extends RepresentationModel<BasePhrase> {
    private String phrase;

    public BasePhrase() {
        this.add(linkTo(methodOn(GreetingController.class).exitGame())
                .withSelfRel()
                .withType("GET")
        );
    }
}
