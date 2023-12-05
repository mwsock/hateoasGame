package pl.mwsock.hateoasgame.levels;

import pl.mwsock.hateoasgame.phrases.BasePhrase;

public abstract class GameLevel {
    private String levelName = "Base level";
    private String levelDescription = "None";
    private boolean isCompleted;

    public GameLevel(String levelName, String levelDescription) {
        this.levelName = levelName;
        this.levelDescription = levelDescription;
        this.isCompleted = false;
    }

    public GameLevel() {
    }

    public String getLevelName() {
        return levelName;
    }

    public String getLevelDescription() {
        return levelDescription;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void completeLevel() {
        this.isCompleted = true;
    }

    public abstract BasePhrase startLevel();
}