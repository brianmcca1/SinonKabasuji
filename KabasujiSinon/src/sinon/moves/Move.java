package sinon.moves;

import sinon.models.Hexomino;

/**
 * The abstract class that is the parent for all other move classes
 * in this package. 
 * @author kartik
 *
 */
public abstract class Move {

	/**
	 * The hexomino being moved.
	 */
	public Hexomino hex;
	
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
	public abstract boolean undo();
	
	
	
	
}
