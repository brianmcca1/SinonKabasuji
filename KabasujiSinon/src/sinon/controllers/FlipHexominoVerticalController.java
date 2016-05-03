package sinon.controllers;

import sinon.models.Level;
import sinon.moves.FlipVerticalMove;
import sinon.views.HexominoBullpenView;

/**
 * Controller for flipping Hexominos vertically.
 * 
 * @author Josh Desmond
 */
public class FlipHexominoVerticalController extends AlterHexominoController {

	/**
	 * Controller for flipping Hexominos vertically
	 * 
	 * @param level
	 *            The level object containing the hexominos
	 * @param hexomino
	 *            The HexominoBullpenView being flipped
	 */
	public FlipHexominoVerticalController(Level level, HexominoBullpenView hexomino) {
		super(level, hexomino);
	}

	@Override
	protected void handleAction() {
		FlipVerticalMove move = new FlipVerticalMove(this.hexomino);
		move.doMove();
		level.pushMove(move);
	}
}
