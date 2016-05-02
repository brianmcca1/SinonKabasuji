package sinon.moves;

import java.util.Optional;

import sinon.models.Hexomino;
import sinon.models.Level;

/**
 * BoardMove abstract class that is used when extending each 
 * individual move.
 * @author kartik
 *
 */
public abstract class BoardMove extends Move {
	
	/** This is the level in which the move is being made. */
	Level level; 
	
	/** The hexomino that is being moved.  */
	Optional<Hexomino> hex;
	
	public abstract boolean doMove();
	
	public abstract boolean undo();
	
	public abstract boolean valid();
	
	/**
	 * Throws a Null Pointer Exception if the hex is null
	 */
	
	public void nullCheck() {
		if (hex == null) { 
			throw new NullPointerException();
		}
	}
}
