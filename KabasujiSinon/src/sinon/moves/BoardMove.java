package sinon.moves;

/**
 * BoardMove abstract class that is used when extending each 
 * individual move.
 * @author kartik
 *
 */
public abstract class BoardMove {
	public abstract boolean doMove();
	
	public abstract boolean undo();
	
	public abstract boolean valid();
}
