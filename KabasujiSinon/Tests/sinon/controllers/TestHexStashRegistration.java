package sinon.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sinon.models.BullPen;
import sinon.models.Hexomino;
import sinon.models.LightningLevel;
import sinon.moves.BankToBullpenMove;
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

	@Test
	public void testCreateBullpenview() {
		BankToBullpenMove move = new BankToBullpenMove(bullpen, Hexomino.getExampleHexomino());
		assertTrue(move.doMove());
		BankToBullpenMove move2 = new BankToBullpenMove(bullpen, Hexomino.getExampleHexomino());
		assertTrue(move2.doMove());

		// still working on this TODO
	}

}
