package sinon.moves;

import java.awt.Point;

import sinon.models.Level;

/**
 * Move class for moving a hexomino from the bullpen to the board.
 * 
 * @author kartik
 *
 */
public class MoveToBullpenFromBoard extends BoardMove {

	/**
	 * This is the source anchor-row that we are moving the hexomino from.
	 */
	int srcAnchorRow;

	/**
	 * This is the source anchor-column that we are moving the hexomino to.
	 */
	int srcAnchorColumn;

	public MoveToBullpenFromBoard(Level level, int srcAnchorRow, int srcAnchorColumn) {

		this.level = level;
		if (level.hasSelected()) {
			this.hex = level.getSelectedHexomino().get();
		}

		this.srcAnchorRow = srcAnchorRow;
		this.srcAnchorColumn = srcAnchorColumn;

	}

	@Override
	public boolean doMove() {
		if (!valid())
			return false;
		level.getBullpen().addHexomino(hex);
		level.getBoard().removeHexomino(hex);
		level.deselect();
		return true;
	}

	@Override
	public boolean undo() {
		level.getBoard().addHexomino(new Point(srcAnchorRow, srcAnchorColumn), hex);
		level.getBullpen().removeHexomino(hex);
		return true;
	}

	@Override
	public boolean valid() {
		if (!level.hasSelected())
			return false;
		if (!level.getBoard().hasHex(hex))
			return false;
		return true;
	}

}
