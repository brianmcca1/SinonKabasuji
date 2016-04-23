package sinon.main;

import java.util.LinkedList;

import sinon.controllers.BullpenController;
import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Hexomino;
import sinon.models.Level;
import sinon.views.MainView;
import sinon.views.builder.BankView;
import sinon.views.game.GameInfoView;

public class Test extends Kabasuji {

    Level testLevel;
    MainView mainView;

    public Test() {
        super();

        initializeModel();

    }

    private void initializeModel() {
        Level testLevel = new Level(5, new Board(),
                new BullPen(new LinkedList<Hexomino>()));

    }

    void initializeMainView() {
        mainView = new MainView(new BankView(), testLevel);
    }

    void initializeMainControllers() {
        BankView sidePanel = (BankView) mainView.getInfoPanel();

        sidePanel.registerControllers(new )

        mainView.getBullpenView().addMouseListener(new BullpenController(
                testLevel.getBullpen(), mainView.getBullpenView(), testLevel));
    }

    public static void main(String args[]) {
        @SuppressWarnings("unused")
        Game game = new Game();

    }

}
