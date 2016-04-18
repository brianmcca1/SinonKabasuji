package sinon.moves;

import sinon.models.AbsPiece;
import sinon.models.Board;
import sinon.models.BullPen;

/**
 * Move class for moving a hexomino from the bullpen to the board.
 * @author kartik
 *
 */
public class MoveToBullpenFromBoard extends BoardMove {

	/**
	 * This the bullpen object that we are moving the hexomino to.
	 */
	BullPen bullpen;
	
	/**
	 * This is the hexomino that we are moving.
	 */
	AbsPiece hex;
	
	/**
	 * This is the board that we are moving from.
	 */
	Board board;
	
	/**
	 * This is the source anchor-row that we are moving the hexomino from.
	 */
	int srcAnchorRow;
	
	/**
	 * This is the source anchor-column that we are moving the hexomino to.
	 */
	int srcAnchorColumn;
	
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
