package sinon.main;

import java.util.LinkedList;

import sinon.controllers.BullpenController;
import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Hexomino;
import sinon.models.Level;
import sinon.models.data.HexominoBankData;
import sinon.models.data.LevelType.types;
import sinon.views.MainView;
import sinon.views.builder.BankView;
import sinon.views.builder.HexominoContainerView;

public class Test extends Kabasuji {

    BullPen bullpen = new BullPen(HexominoBankData.getHexominos());
    Level testLevel;
    MainView mainView;

    public Test() {
        super();

        initializeModel();
        initializeMainView();
        initializeMainControllers();

        this.add(mainView);
        this.validate();

    }

    private void initializeModel() {
        testLevel = new Level(types.PUZZLE, new Board(), new BullPen(new LinkedList<Hexomino>()));

    }

    void initializeMainView() {
       // mainView = new MainView(new BankView(bullpen), testLevel);
        mainView.setVisible(true);
    }

    void initializeMainControllers() {
        HexominoContainerView sidePanel = (HexominoContainerView) mainView.getInfoPanel();

        sidePanel.registerControllers(new HexominoBankControllerFactory());

        mainView.getBullpenView().addMouseListener(new BullpenController(
                testLevel.getBullpen(), mainView.getBullpenView(), testLevel));
    }

    public static void main(String args[]) {
        @SuppressWarnings("unused")
        Test t = new Test();

    }

}
