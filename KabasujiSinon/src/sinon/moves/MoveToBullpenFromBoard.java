package sinon.moves;

import sinon.models.Hexomino;
import sinon.models.Level;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean valid() {
		if (!level.hasSelected()) return false;
		if (level.getBoard().
		return false;
	}

}
