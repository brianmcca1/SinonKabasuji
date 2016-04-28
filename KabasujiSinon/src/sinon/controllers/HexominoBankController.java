package sinon.controllers;

import sinon.models.Level;
import sinon.moves.BankToBullpenMove;
import sinon.views.HexominoBullpenView;
import sinon.views.MainView;

/**
 * This controller responds to mouse interactions with the HexominoBullpenViews
 * in the bank of the builder.
 * 
 * @author kartik
 * @author Josh Desmond
 */
public class HexominoBankController extends AbstractHexStashController {

	public HexominoBankController(Level level, MainView mainView,
			HexominoBullpenView hex) {
		super(level, mainView, hex);
	}

	@Override
	protected void handleClicked() {
		System.out.println("I AM A BANK HEXOMINO AND I GOT CLICKED ON");

		BankToBullpenMove move = new BankToBullpenMove(level.getBullpen(),
				hex.getHexomino());

		if (move.doMove()) {
			System.out.println("Move was made successfully!");
		} else {
			System.out.println("For some reason, move was not completed.");
		}
	}
}
