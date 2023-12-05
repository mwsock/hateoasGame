package pl.mwsock.hateoasgame.actions;

import lombok.Getter;

@Getter
public enum Actions {
    LOOK_AROUND("Rozejrzyj się"),
    GO_FORWARD("Idź naprzód"),
    GO_BACKWARD("Cofnij się"),
    TURN_LEFT("Skręć w lewo"),
    TURN_RIGHT("Skręć w prawo"),
    DO_NOTHING("Nic nie rób"),
    INSPECT("Obejrzyj");

    private final String action;

    Actions(String action) {
        this.action = action;
    }
}
