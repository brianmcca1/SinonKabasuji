package sinon.moves;

import sinon.models.Hexomino;

/**
 * Abstract class for moves within the bullpen.
 * 
 * The two main types are rotating and flipping.
 * @author kartik
 * @author Josh Desmond
 */
public abstract class BullPenMove {

	/**
	 * This is the hexomino that is being rotated.
	 */
	Hexomino hex;

	/**
	 * This is the move operation where a move is being made.
	 * 
	 * @return Returns true if move has been successfully completed.
	 */
	public abstract boolean doMove();

	/**
	 * This is the undo functionality that we need for a move.
	 * 
	 * @return Returns true if undo has been successfully completed.
	 */
	public abstract boolean undoMove();
}
