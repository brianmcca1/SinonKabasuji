package sinon.moves;

import sinon.models.Hexomino;
import sinon.models.BullPen;

/** This is the abstract class Move that is used for having moves on the bullpen/board.
 * @author kartik
 *
 */
public abstract class BullPenMove {
	/** 
	 * This is the bullpen within which we are rotating.
	 */
	BullPen bullPen;
	
	/**
	 * This is the hexomino that is being rotated.
	 */
	Hexomino hex;
	
	/** 
	 * This is the move operation where a move is being made.
	 * @return Returns true if move has been successfully completed.
	 */
	public abstract boolean doMove();
	
	/**
	 * This is the undo functionality that we need for a move.
	 * @return Returns true if undo has been successfully completed.
	 */
	public abstract boolean undoMove();
}
