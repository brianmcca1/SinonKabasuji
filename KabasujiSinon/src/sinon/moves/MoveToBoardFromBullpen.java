package sinon.moves;

import java.awt.Point;

import sinon.models.Hexomino;
import sinon.models.Level;
import sinon.models.LightningLevel;
import sinon.models.PuzzleLevel;

/**
 * Move class for when moving hexomino to the board from the bullpen.
 * 
 * @author kartik
 *
 */
public class MoveToBoardFromBullpen extends BoardMove {

    /**
     * This is the destination anchor-row for the hexomino. 
     */
    int destAnchorRow;

    /**
     * This the destination anchor-column for the hexomino. 
     */
    int destAnchorColumn;

    public MoveToBoardFromBullpen(Level level, int destAnchorRow,
            int destAnchorColumn) {

        this.level = level;
        if (level.hasSelected()) {
            this.hex = level.selectedHexomino.get();
        }
        this.destAnchorRow = destAnchorRow;
        this.destAnchorColumn = destAnchorColumn;

    }

    @Override
    public boolean doMove() {

        if (!this.valid()) {
            return false;
        }
        
        Hexomino hex = level.selectedHexomino.get();

        if (level instanceof PuzzleLevel) {
            ((PuzzleLevel) level).incrementMoves();
        } 
        
        level.getBullpen().removeHexomino(hex);
        level.getBoard().addHexomino(new Point(destAnchorRow, destAnchorColumn), hex);
        return true;

    }

    @Override
    public boolean undo() {
        level.getBullpen().addHexomino(hex);
        level.getBoard().removeHexomino(hex);
        return true;

    }

    @Override
    public boolean valid() {

        if (level.hasSelected()) {
            Hexomino hex = level.selectedHexomino.get();
            return level.getBoard().canAddHexomino((new Point(destAnchorRow, destAnchorColumn)), hex);
        } else {
            return false;
        }

    }

}
