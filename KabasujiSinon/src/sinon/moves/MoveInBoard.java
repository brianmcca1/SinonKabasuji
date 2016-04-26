package sinon.moves;

import sinon.models.Hexomino;
import sinon.models.Level;
import sinon.models.Board;

/**
 * Move class for moving a hexomino from one position in the board to the next.
 * @author kartik
 *
 */
public class MoveInBoard extends BoardMove{

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
	
	public MoveInBoard(Level level, int srcAnchorRow, int srcAnchorColumn, int destAnchorRow, int destAnchorColumn) {
		
		this.level = level;
		
		if(level.hasSelected()) {
		this.hex = level.selectedHexomino.get();
		}
		
		this.srcAnchorRow = srcAnchorRow;
		this.srcAnchorColumn = srcAnchorColumn;
		this.destAnchorRow = destAnchorRow;
		this.destAnchorColumn = destAnchorColumn;
	
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
		// TODO Auto-generated method stub
		return false;
	}

}
