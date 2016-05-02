package sinon.controllers;

import sinon.models.Level;
import sinon.moves.RotateHexominoCounterClockwiseMove;
import sinon.views.HexominoBullpenView;

/**
 * Rotates Hexominos AntiClockwise.
 * 
 * @author Josh Desmond
 */
public class RotateHexominoAnticlockwiseController extends
AlterHexominoController {

	public RotateHexominoAnticlockwiseController(Level level, HexominoBullpenView hexominoView) {
		super(level, hexominoView);
	}

	@Override
	protected void handleAction() {
		RotateHexominoCounterClockwiseMove move = new RotateHexominoCounterClockwiseMove(this.hexomino);

		move.doMove();
		level.pushMove(move);
	}
}
