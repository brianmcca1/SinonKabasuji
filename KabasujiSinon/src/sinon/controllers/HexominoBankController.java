package sinon.controllers;

import sinon.models.Hexomino;
import sinon.models.HexominoNumberSet;
import sinon.models.Level;
import sinon.models.NumberSetFactory;
import sinon.models.data.HexominoCode;
import sinon.moves.BankToBullpenMove;
import sinon.moves.BullpenToBankMove;
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

	/**
	 * Controller for a Hexomino in the Bank in a builder
	 * 
	 * @param level
	 *            The level the Bank is contained in
	 * @param mainView
	 *            The MainView object
	 * @param hex
	 *            The HexominoBullpenView associated with the controller
	 */
	public HexominoBankController(Level level, MainView mainView, HexominoBullpenView hex) {
		super(level, mainView, hex);
	}

	@Override
	protected void handleLeftClicked() {
		if (!this.level.hasSelected()) {
			// Create a copy of the hexomino set to avoid duplicates.
			HexominoNumberSet s = NumberSetFactory.getByCode(new HexominoCode(hex.getHexomino()));
			Hexomino hexomino = new Hexomino(s);
			BankToBullpenMove move = new BankToBullpenMove(level.getBullpen(), hexomino);

			if (move.doMove()) {
				level.pushMove(move);
				assert level.getBullpen().getPieces().contains(hexomino);
			}
		} else {
			if (this.level.getBullpen().containsHexID(this.level.getSelectedHexomino().get().getID())) {

				BullpenToBankMove move = new BullpenToBankMove(this.level);
				if (move.doMove()) {
					level.pushMove(move);

				}
			}
		}
	}

	@Override
	protected void handleRightClicked() {
	}
}
