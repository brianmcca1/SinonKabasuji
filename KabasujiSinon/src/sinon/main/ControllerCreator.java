package sinon.main;

import java.util.function.Function;

import sinon.controllers.AbstractHexStashController;

public interface ControllerCreator
        extends Function<NewControllerParameter, AbstractHexStashController> {

}
