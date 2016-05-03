package sinon.controllers;

import sinon.models.Level;
import sinon.moves.RotateHexominoClockwiseMove;
import sinon.views.HexominoBullpenView;

/**
 * Rotates Hexominos Clockwise.
 * 
 * @author Josh Desmond
 */
public class RotateHexominoClockwiseController extends AlterHexominoController {

    public RotateHexominoClockwiseController(Level level, HexominoBullpenView hexominoView) {
        super(level, hexominoView);
    }

    @Override
    protected void handleAction() {
        RotateHexominoClockwiseMove move = new RotateHexominoClockwiseMove(this.hexomino);
        move.doMove();
        level.pushMove(move);
    }
}
