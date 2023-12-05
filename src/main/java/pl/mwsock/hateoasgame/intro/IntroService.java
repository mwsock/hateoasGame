package pl.mwsock.hateoasgame.intro;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.mwsock.hateoasgame.actions.Actions;
import pl.mwsock.hateoasgame.actions.ActionsDto;
import pl.mwsock.hateoasgame.level.*;

@Service
public class IntroService implements LevelServiceInterface {
    private Level level;
    @Value("${intro.level.name}")
    private String levelName;
    @Value("${intro.level.description}")
    private String levelDescription;
    private LevelDto levelDto;

    public LevelDto start(String name) {
        level = new Level(levelName, levelDescription, name);
        levelDto = new LevelDto();
        levelDto.setDescription(level.getDescription());
        ActionsDto lookAroundAction = new ActionsDto.ActionBuilder(Actions.LOOK_AROUND).build();
        ActionsDto goForward = new ActionsDto.ActionBuilder(Actions.GO_FORWARD).build();
        levelDto.getActions().add(lookAroundAction);
        levelDto.getActions().add(goForward);
        return levelDto;
    }

    public LevelDto lookAround() {
        levelDto.setDescription("Widzisz ciekawą rzecz.");
        levelDto.getActions().clear();
        ActionsDto inspectAction = new ActionsDto.ActionBuilder(Actions.INSPECT).build();
        levelDto.getActions().add(inspectAction);
        return levelDto;
    }

    public LevelDto inspect() {
        levelDto.setDescription("Oglądana rzecz jest ciekawa");
        levelDto.getActions().clear();
        ActionsDto lookAroundAction = new ActionsDto.ActionBuilder(Actions.LOOK_AROUND).build();
        ActionsDto goForwardAction = new ActionsDto.ActionBuilder(Actions.GO_FORWARD).build();
        levelDto.getActions().add(goForwardAction);
        levelDto.getActions().add(lookAroundAction);
        return levelDto;
    }

    public LevelDto goForward() {
        levelDto.setDescription("Idziesz przed siebie.");
        levelDto.getActions().clear();
        ActionsDto goForwardAction = new ActionsDto.ActionBuilder(Actions.GO_FORWARD).build();
        levelDto.getActions().add(goForwardAction);
        return levelDto;
    }


}