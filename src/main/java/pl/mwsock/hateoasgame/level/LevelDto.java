package pl.mwsock.hateoasgame.level;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import pl.mwsock.hateoasgame.actions.ActionsDto;
import pl.mwsock.hateoasgame.greetings.GreetingController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Data
public class LevelDto extends RepresentationModel<LevelDto> {
    private String description;
    private List<ActionsDto> actions;

    public LevelDto() {
        this.actions = new ArrayList<>();
        this.add(linkTo(methodOn(GreetingController.class).exitGame())
                        .withRel("Inne akcje")
                        .withType("GET")
                        .withName("Wyjście z gry"));
    }
}
