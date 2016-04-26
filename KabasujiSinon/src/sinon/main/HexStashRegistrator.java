package sinon.main;

import java.util.Objects;
import java.util.function.Function;

import sinon.controllers.AbstractHexStashController;
import sinon.controllers.HexominoBankController;
import sinon.controllers.HexominoBullpenController;
import sinon.models.Level;
import sinon.views.HexominoBullpenView;
import sinon.views.MainView;

public class HexStashRegistrator {

    public static final Function<NewControllerParameter, AbstractHexStashController> BANK_CONTROLLER = (
            NewControllerParameter c) -> (new HexominoBankController(c.level,
                    c.mainView, c.hex));

    public static final Function<NewControllerParameter, AbstractHexStashController> BULLPEN_CONTROLLER = (
            NewControllerParameter c) -> (new HexominoBullpenController(c.level,
                    c.mainView, c.hex));

    Level level;
    MainView mainView;
    Function<NewControllerParameter, AbstractHexStashController> controller;

    public HexStashRegistrator(Level level, MainView mainView,
            Function<NewControllerParameter, AbstractHexStashController> controllerCreater) {
        this.level = Objects.requireNonNull(level);
        this.mainView = Objects.requireNonNull(mainView);
        this.controller = controllerCreater;
    }

    public void registerHexominoView(HexominoBullpenView hex) {
        assert hex != null;
        assert level != null;
        assert mainView != null;
        NewControllerParameter c = new NewControllerParameter(level, mainView,
                hex);
        hex.addMouseListener(controller.apply(c));

        System.out.println("Registration attempt");
        System.out.println(hex.getHexomino());
    }
}