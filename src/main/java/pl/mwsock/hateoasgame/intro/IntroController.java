package pl.mwsock.hateoasgame.intro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mwsock.hateoasgame.phrases.BasePhrase;

@RestController
@RequestMapping("/intro")
@Slf4j
public class IntroController {

    private final IntroLevelService introLevelService;

    public IntroController(IntroLevelService introLevelService) {
        this.introLevelService = introLevelService;
    }

    @GetMapping("/startLevel")
    public ResponseEntity<BasePhrase> gameIntro(){
        return new ResponseEntity<>(introLevelService.startLevel(), HttpStatus.OK);
    }
}
