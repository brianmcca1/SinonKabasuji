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

    public FlipHexominoVerticalController(Level level,
            HexominoBullpenView hexomino) {
        super(level, hexomino);
    }

    @Override
    protected void handleAction() {
        FlipVerticalMove move = new FlipVerticalMove(this.hexomino);
        move.doMove();
        level.pushMove(move);
    }
}
