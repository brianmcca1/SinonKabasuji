package sinon.controllers;

import sinon.models.Level;
import sinon.moves.FlipHorizontalMove;
import sinon.views.HexominoBullpenView;

/**
 * Controller for flipping Hexominos horizontally.
 * 
 * @author Josh Desmond
 */
public class FlipHexominoHorizontallyController extends AlterHexominoController {

	/**
	 * Controller for flipping Hexominos horizontally
	 * 
	 * @param level
	 *            The level object containing the hexominos
	 * @param hexomino
	 *            The HexominoBullpenView being flipped
	 */
	public FlipHexominoHorizontallyController(Level level, HexominoBullpenView hexomino) {
		super(level, hexomino);
	}

	@Override
	protected void handleAction() {
		FlipHorizontalMove move = new FlipHorizontalMove(this.hexomino);
		move.doMove();
		level.pushMove(move);
	}
}
