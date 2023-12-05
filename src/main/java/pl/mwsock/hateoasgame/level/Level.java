package pl.mwsock.hateoasgame.level;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class Level extends RepresentationModel<Level> {

    private String levelName;
    private String levelDescription;
    private boolean isCompleted;

    private String getDescription(String playersName, String levelDescription) {
        return String.format(levelDescription, playersName);
    }

    public String getDescription() {
        return levelDescription;
    }

    public Level(String levelName, String levelDescription, String playersName) {
        this.levelName = levelName;
        this.levelDescription = getDescription(playersName, levelDescription);
        this.isCompleted = false;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void completeLevel() {
        this.isCompleted = true;
    }

}