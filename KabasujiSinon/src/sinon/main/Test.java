package sinon.main;

import java.util.LinkedList;

import sinon.controllers.BullpenController;
import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Hexomino;
import sinon.models.Level;
import sinon.models.data.HexominoBankData;
import sinon.views.MainView;
import sinon.views.builder.BankView;

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
        testLevel = new Level(5, new Board(),
                new BullPen(new LinkedList<Hexomino>()));

    }

    void initializeMainView() {
        mainView = new MainView(new BankView(bullpen), testLevel);
        mainView.setVisible(true);
    }

    void initializeMainControllers() {
        BankView sidePanel = (BankView) mainView.getInfoPanel();

        sidePanel.registerControllers(new HexominoBankControllerFactory());

        mainView.getBullpenView().addMouseListener(new BullpenController(
                testLevel.getBullpen(), mainView.getBullpenView(), testLevel));
    }

    public static void main(String args[]) {
        @SuppressWarnings("unused")
        Test t = new Test();

    }

}
