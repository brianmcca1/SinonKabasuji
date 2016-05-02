package sinon.controllers;

import sinon.models.Level;
import sinon.moves.MoveToBullpenFromBoard;
import sinon.views.HexominoBullpenView;
import sinon.views.MainView;

/**
 * This controller responds to mouse interactions with HexominoBullpenViews in
 * the BullpenView.
 */
public class HexominoBullpenController extends AbstractHexStashController {

	public HexominoBullpenController(Level level, MainView mainView, HexominoBullpenView hex) {
		super(level, mainView, hex);
	}

	@Override
	protected void handleLeftClicked() {
		if (level.hasSelected()) {
			int x, y;
			if (level.getBoard().hasHex(level.getSelectedHexomino().get())) {
				x = level.getBoard().getHexominoLocation(level.getSelectedHexomino().get()).x;
				y = level.getBoard().getHexominoLocation(level.getSelectedHexomino().get()).y;
				MoveToBullpenFromBoard move = new MoveToBullpenFromBoard(level, x, y);
				if (move.doMove()) {
					level.pushMove(move);
				}
			} else {
				level.deselect();
			}
		} else {
			level.select(hex.getHexomino());
		}
	}

	@Override
	protected void handleRightClicked() {

	}
}
