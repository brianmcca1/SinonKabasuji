package sinon.moves;

import java.util.Optional;

import sinon.models.Hexomino;

public abstract class Move {

	public Optional<Hexomino> hex;
	
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
	
	/**
	 * Redoes the undone move
	 * Generally calls this.do, however some of the board move classes need to bypass valid()
	 * @return returns the status of the redo
	 */
	public abstract boolean redo();
	
}
