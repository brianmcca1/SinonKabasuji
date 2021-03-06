package sinon.moves;

import java.awt.Point;
import java.util.Objects;

import sinon.models.Level;
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

	/**
	 * Constructs a new to board from bullpen move with the given parameters
	 * @param level the level being moved in
	 * @param destAnchorRow the destination anchor row
	 * @param destAnchorColumn the destination anchor column
	 */
	public MoveToBoardFromBullpen(Level level, int destAnchorRow, int destAnchorColumn) {

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

		level.incrementMoves();

		level.getBullpen().removeHexomino(hex.get());
		level.getBoard().addHexomino(new Point(destAnchorRow, destAnchorColumn), hex.get());
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
			return false;
		}

		if (level.getBullpen().hasHex(this.hex.get())) {
			return level.getBoard().canAddHexomino((new Point(destAnchorRow, destAnchorColumn)), this.hex.get());
		} else {
			return false;
		}

	}

}
