package sinon.main;

import java.util.LinkedList;

import sinon.controllers.BullpenController;
import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Hexomino;
import sinon.models.Level;
import sinon.views.MainView;
import sinon.views.game.GameInfoView;

@SuppressWarnings("serial")
public class Game extends Kabasuji {

    // MODELS AND VIEWS SPECIFIC TO GAME GO HERE
    Level testLevel;
    MainView mainView;

    public Game() {
        super();

        Level testLevel = new Level(5, new Board(),
                new BullPen(new LinkedList<Hexomino>()));
    }

    void initializeMainView() {
        mainView = new MainView(new GameInfoView(testLevel), testLevel);
    }

    void initializeMainControllers() {
        GameInfoView sidePanel = (GameInfoView) mainView.getInfoPanel();

        sidePanel.getExitButton().addActionListener(
                new sinon.controllers.ExitGameController(this, mainView));

        mainView.getBullpenView().addMouseListener(new BullpenController(
                testLevel.getBullpen(), mainView.getBullpenView(), testLevel));
    }

    public static void main(String args[]) {
        @SuppressWarnings("unused")
        Game game = new Game();

    }

}
