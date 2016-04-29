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

	public HexominoBullpenController(Level level, MainView mainView,
			HexominoBullpenView hex) {
		super(level, mainView, hex);
	}

	@Override
	protected void handleClicked() {
		System.out
		.println("I AM A BULLPEN HEXOMINO AND I JUST GOT CLICKED ON!");

		// FIXME A new move is NOT always created when you click on the bullpen
		if (level.hasSelected()) {
			// compare this.hex to level.selectedHexomino.get()
			if (this.level.getBullpen().containsHexID(
					level.getSelectedHexomino().get().getID())) {
				System.out.println("THIS HEXOMINO IS ALREADY SELECTED");
				return;
			}

			int x, y;
			if (level.getBoard().hasHex(level.getSelectedHexomino().get())) {
				x = level.getBoard().getHexominoLocation(
						level.getSelectedHexomino().get()).x;
				y = level.getBoard().getHexominoLocation(
						level.getSelectedHexomino().get()).y;
				MoveToBullpenFromBoard move = new MoveToBullpenFromBoard(level,
						x, y);
				if (move.doMove()){
					level.pushMove(move);
				}
			} else {
				level.getBullpen().addHexomino(
						level.getSelectedHexomino().get());
			}

			System.out.println("SELECTED HEXOMINO HAS BEEN DESELECTED");
		} else {
			level.select(hex.getHexomino());
			System.out.println("NEWLY SELECTED HEXOMINO: "
					+ level.getSelectedHexomino().toString());
		}
	}
}
