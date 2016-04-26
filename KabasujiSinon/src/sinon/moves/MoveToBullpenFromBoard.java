package sinon.moves;

import sinon.models.Hexomino;
import sinon.models.Level;

import java.awt.Point;

import sinon.models.Board;
import sinon.models.BullPen;

/**
 * Move class for moving a hexomino from the bullpen to the board.
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
	
	public MoveToBullpenFromBoard (Level level, int srcAnchorRow, int srcAnchorColumn) {
		
		this.level = level;
		if(level.hasSelected()) {
			this.hex = level.selectedHexomino.get();
		}
		
		this.srcAnchorRow = srcAnchorRow;
		this.srcAnchorColumn = srcAnchorColumn;
		
	}
	
	@Override
	public boolean doMove() {
		if (!valid()) return false;
		level.getBullpen().addHexomino(hex);
		level.deselect();
		return true;
	}

	@Override
	public boolean undo() {
		//FIXME valid checks if the board has the hex. When we're undoing, the board SHOULDN'T have the hex.
		//if (!valid()) return false;
		level.getBoard().addHexomino(new Point(srcAnchorRow, srcAnchorColumn), hex);
		return true;
	}

	@Override
	public boolean valid() {
		if (!level.hasSelected()) return false;
		if (!level.getBoard().hasHex(hex)) return false;
		return true;
	}

}
