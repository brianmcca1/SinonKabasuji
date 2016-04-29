package sinon.moves;

import java.awt.Point;
import java.util.Objects;

import sinon.models.Level;
import sinon.models.PuzzleLevel;
import sinon.models.data.LevelType.Types;

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

        this.level = Objects.requireNonNull(level);

        this.hex = level.getSelectedHexomino();

        this.destAnchorRow = destAnchorRow;
        this.destAnchorColumn = destAnchorColumn;

    }

    @Override
    public boolean doMove() {

        if (!this.valid()) {
            return false;
        }

        if (level instanceof PuzzleLevel) {
            ((PuzzleLevel) level).incrementMoves();
        }

        level.getBullpen().removeHexomino(hex.get());
        level.getBoard().addHexomino(new Point(destAnchorRow, destAnchorColumn),
                hex.get());
        if (level.getLevelData().getLevelType() == Types.LIGHTNING) {
            level.getBullpen().addRandomHexomino();
        }
        return true;

    }

    @Override
    public boolean undo() {
        level.getBullpen().addHexomino(hex.get());
        level.getBoard().removeHexomino(hex.get());
        return true;

    }

    @Override
    public boolean valid() {

        if (!this.hex.isPresent()) {
            System.out.println("Hexomino not selected!");
            return false;
        }

        if (level.getBullpen().hasHex(this.hex.get())) {
            return level.getBoard().canAddHexomino(
                    (new Point(destAnchorRow, destAnchorColumn)),
                    this.hex.get());
        } else {
            return false;
        }

    }

    public int getDestRow() {
        return this.destAnchorRow;
    }

    public int getDestColumn() {
        return this.destAnchorColumn;
    }

}
