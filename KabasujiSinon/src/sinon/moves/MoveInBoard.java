package sinon.moves;

import sinon.models.Board;
import sinon.models.Hexomino;

/**
 * Move class for moving a hexomino from one position in the board to the next.
 * @author kartik
 *
 */
public class MoveInBoard extends BoardMove{

	/**
	 * This is the board that we are moving in.
	 */
	Board board;
	
	/**
	 * This is the hexomino that we are moving.
	 */
	Hexomino hex;
	
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
