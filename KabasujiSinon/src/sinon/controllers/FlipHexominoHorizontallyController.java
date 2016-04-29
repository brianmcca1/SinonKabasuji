package sinon.controllers;

import sinon.models.Level;
import sinon.moves.FlipHorizontalMove;
import sinon.views.HexominoBullpenView;

/**
 * Controller for flipping Hexominos horizontally.
 * 
 * @author Josh Desmond
 */
public class FlipHexominoHorizontallyController
        extends AlterHexominoController {

    public FlipHexominoHorizontallyController(Level level,
            HexominoBullpenView hexomino) {
        super(level, hexomino);
    }

    @Override
    protected void handleAction() {
        FlipHorizontalMove move = new FlipHorizontalMove(this.hexomino);
        move.doMove();
        level.pushMove(move);
    }
}
