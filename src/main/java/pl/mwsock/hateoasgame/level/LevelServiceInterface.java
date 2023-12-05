package pl.mwsock.hateoasgame.level;

public interface LevelServiceInterface {
    public LevelDto start(String name);
    public LevelDto lookAround();
    public LevelDto inspect();
    public LevelDto goForward();
}
