package sinon.controllers;

import org.junit.Before;

import sinon.models.BullPen;
import sinon.models.LightningLevel;
import sinon.views.BullpenView;
import sinon.views.LightningInfoView;
import sinon.views.MainView;
import sinon.views.builder.BankView;

public class TestHexStashRegistration {

    LightningLevel level;
    MainView mainView;
    BankView bankView;
    BullPen bullpen;
    BullpenView bullpenView;

    @Before
    public void setUp() throws Exception {
        level = LightningLevel.getExampleLevel();
        bankView = new BankView();
        LightningInfoView lView = new LightningInfoView(true, level);
        mainView = new MainView(level, bankView, lView);
        this.bullpen = level.getBullpen();
        this.bullpenView = mainView.getBullpenView();
        HexStashRegistrator bankReg = new HexStashRegistrator(level, mainView,
                true);
        ((BankView) mainView.getInfoPanel()).setRegistrator(bankReg);

        HexStashRegistrator bullpenReg = new HexStashRegistrator(level,
                mainView, false);
        mainView.getBullpenView().setRegistrator(bullpenReg);
    }

}
