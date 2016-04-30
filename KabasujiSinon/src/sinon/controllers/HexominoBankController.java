package sinon.controllers;

import sinon.models.Hexomino;
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
	protected void handleLeftClicked() {
		System.out.println("I AM A BANK HEXOMINO AND I GOT CLICKED ON");


		Hexomino hexomino = new Hexomino(hex.getHexomino().getHexominoNumberSet());
		BankToBullpenMove move = new BankToBullpenMove(level.getBullpen(), hexomino);

		if (move.doMove()) {
			level.pushMove(move);
			System.out.println("Move was made successfully!");
			assert level.getBullpen().getPieces().contains(hexomino);
		} else {
			System.out.println("For some reason, move was not completed.");
		}
	}

	@Override
	protected void handleRightClicked() {
	}
}
