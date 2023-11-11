package pl.mwsock.hateoasgame.intro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/intro")
@Slf4j
public class IntroController {

    @GetMapping("/intro")
    public ResponseEntity<String> gameIntro(){
        return new ResponseEntity<>("intro", HttpStatus.OK);
    }
}
