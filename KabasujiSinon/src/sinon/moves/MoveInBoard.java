package sinon.moves;

import java.awt.Point;

import sinon.models.Level;

/**
 * Move class for moving a hexomino from one position in the board to the next.
 * 
 * @author kartik
 *
 */
public class MoveInBoard extends BoardMove {

    /**
     * These are the source anchor positions on the board.
     */
    int srcAnchorRow;
    int srcAnchorColumn;

    /**
     * These are the destination anchor positions on the board.
     */
    int destAnchorRow;
    int destAnchorColumn;

    public MoveInBoard(Level level, int srcAnchorRow, int srcAnchorColumn,
            int destAnchorRow, int destAnchorColumn) {

        this.level = level;

        if (level.hasSelected()) {
            this.hex = level.getSelectedHexomino().get();
        }

        this.srcAnchorRow = srcAnchorRow;
        this.srcAnchorColumn = srcAnchorColumn;
        this.destAnchorRow = destAnchorRow;
        this.destAnchorColumn = destAnchorColumn;

    }

    @Override
    public boolean doMove() {
        if (!valid())
            return false;
        level.getBoard().removeHexomino(hex);
        level.getBoard().addHexomino(new Point(destAnchorRow, destAnchorColumn),
                hex);
        level.deselect();
        return true;
    }

    @Override
    public boolean undo() {
        level.getBoard().removeHexomino(hex);
        level.getBoard().addHexomino(new Point(srcAnchorRow, srcAnchorColumn),
                hex);
        return true;
    }

    @Override
    public boolean valid() {
    	//FIXME Doesn't check if the tile is on the board in the location specified
        if (!level.hasSelected())
            return false;
        if (!level.getBoard().canAddHexomino(
                new Point(destAnchorRow, destAnchorColumn), hex))
            return false;
        if (!level.getBoard().hasHex(hex))
            return false;
        return true;
    }

}
