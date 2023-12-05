package pl.mwsock.hateoasgame.actions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import pl.mwsock.hateoasgame.intro.IntroController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static pl.mwsock.hateoasgame.actions.Actions.*;

@Getter
@Setter
public class ActionsDto extends RepresentationModel<ActionsDto> {

    public ActionsDto(ActionBuilder actionBuilder) {
        this.add(actionBuilder.getLinks());
    }

    public static class ActionBuilder extends RepresentationModel<ActionsDto> {
        public ActionBuilder(Actions actions) {
            switch (actions) {
                case LOOK_AROUND:
                    this.add(WebMvcLinkBuilder.linkTo(methodOn(IntroController.class).lookAround())
                            .withSelfRel()
                            .withType("GET")
                            .withName(LOOK_AROUND.getAction()));
                    break;
                case GO_FORWARD:
                    this.add(linkTo(methodOn(IntroController.class).goForward())
                            .withSelfRel()
                            .withType("GET")
                            .withName(GO_FORWARD.getAction()));
                    break;
                case GO_BACKWARD:
                    this.add(linkTo(methodOn(IntroController.class).goForward())
                            .withSelfRel()
                            .withType("GET")
                            .withName(GO_BACKWARD.getAction()));
                    break;
                case TURN_LEFT:
                    this.add(linkTo(methodOn(IntroController.class).goForward())
                            .withSelfRel()
                            .withType("GET")
                            .withName(TURN_LEFT.getAction()));
                    break;
                case TURN_RIGHT:
                    this.add(linkTo(methodOn(IntroController.class).goForward())
                            .withSelfRel()
                            .withType("GET")
                            .withName(TURN_RIGHT.getAction()));
                    break;
                case DO_NOTHING:
                    this.add(linkTo(methodOn(IntroController.class).goForward())
                            .withSelfRel()
                            .withType("GET")
                            .withName(DO_NOTHING.getAction()));
                    break;
                case INSPECT:
                    this.add(linkTo(methodOn(IntroController.class).inspect())
                            .withSelfRel()
                            .withType("GET")
                            .withName(INSPECT.getAction()));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown action type");
            }
        }

        public ActionsDto build() {
            return new ActionsDto(this);
        }

    }


}
