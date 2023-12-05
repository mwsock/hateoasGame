package pl.mwsock.hateoasgame.level;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
public class AbstractLevelController {
    private final LevelServiceInterface levelService;
    @GetMapping("/startLevel/{name}")
    public ResponseEntity<LevelDto> gameIntro(@PathVariable String name){
        return new ResponseEntity<>(levelService.start(name), HttpStatus.OK);
    }

    @GetMapping("/action/look_around")
    public ResponseEntity<LevelDto> lookAround(){
        return new ResponseEntity<>(levelService.lookAround(), HttpStatus.OK);
    }

    @GetMapping("/action/inspect")
    public ResponseEntity<LevelDto> inspect(){
        return new ResponseEntity<>(levelService.inspect(), HttpStatus.OK);
    }

    @GetMapping("/action/go_forward")
    public ResponseEntity<LevelDto> goForward(){
        return new ResponseEntity<>(levelService.goForward(), HttpStatus.OK);
    }
}
