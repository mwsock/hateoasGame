package pl.mwsock.hateoasgame.greetings;

import org.springframework.stereotype.Service;
import pl.mwsock.hateoasgame.phrases.BasePhrase;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class GreetingService {

    public BasePhrase greetAndStart() {
        String welcomePhrase = "Greetings, Player! Choose your name.";
        BasePhrase basePhrase = new BasePhrase();
        basePhrase.setWelcomePhrase(welcomePhrase);
        basePhrase.add(linkTo(methodOn(GreetingController.class).showAvailablePlayersNames()).withSelfRel())
                .add(linkTo(methodOn(GreetingController.class).exitGame()).withSelfRel());
        return basePhrase;
    }
}