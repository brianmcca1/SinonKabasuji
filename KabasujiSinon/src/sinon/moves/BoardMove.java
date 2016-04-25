package sinon.moves;

import sinon.models.Level;

/**
 * BoardMove abstract class that is used when extending each 
 * individual move.
 * @author kartik
 *
 */
public abstract class BoardMove {
	
	Level level; 
	
	public abstract boolean doMove();
	
	public abstract boolean undo();
	
	public abstract boolean valid();
}
