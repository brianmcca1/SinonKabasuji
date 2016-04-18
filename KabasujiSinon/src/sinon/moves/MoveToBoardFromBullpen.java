package sinon.moves;

import sinon.models.AbsPiece;
import sinon.models.Board;
import sinon.models.BullPen;

/**
 * Move class for when moving hexomino to the board from the bullpen.
 * @author kartik
 *
 */
public class MoveToBoardFromBullpen extends BoardMove{

	/**
	 * BullPen from where we are moving hexomino to the board.
	 */
	BullPen bullpen;
	
	/**
	 * Hexomino that is being moved.
	 */
	AbsPiece hex;
	
	/**
	 * Board that the hexomino is being added to.
	 */
	Board board;
	
	/**
	 * This is the destination anchor-row for the hexomino.
	 * TODO We might not need this field eventually.
	 */
	int destAnchorRow;
	
	/**
	 * This the destination anchor-column for the hexomino.
	 * TODO We might not need this field eventually.
	 */
	int destAnchorColumn;
	
	
	@Override
	public boolean doMove() {
		return false;
	}

	@Override
	public boolean undo() {
		return false;
	}

	@Override
	public boolean valid() {
		return false;
	}

}
