package pl.mwsock.hateoasgame.intro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mwsock.hateoasgame.level.AbstractLevelController;

@RestController
@RequestMapping("/intro")
@Slf4j
public class IntroController extends AbstractLevelController {

    public IntroController(IntroService introService) {
        super(introService);
    }
}
