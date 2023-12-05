package pl.mwsock.hateoasgame.intro;

import org.springframework.stereotype.Service;
import pl.mwsock.hateoasgame.levels.GameLevel;
import pl.mwsock.hateoasgame.phrases.BasePhrase;

@Service
public class IntroLevelService extends GameLevel {

    public IntroLevelService() {
        super();
    }

    @Override
    public BasePhrase startLevel() {
        BasePhrase basePhrase = new BasePhrase();
        basePhrase.setWelcomePhrase("Witaj w poziomie " + getLevelName() + "! " + getLevelDescription());
//        basePhrase.add(linkTo(methodOn(IntroController.class).gameIntro())
//                .withSelfRel()
//                .withTitle("GET Method")
//        );
        return basePhrase;
    }
}