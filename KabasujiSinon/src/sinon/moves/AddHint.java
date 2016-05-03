package sinon.moves;

import java.util.Objects;

import sinon.models.Hint;
import sinon.models.Level;

/** 
 * Class that handles the move of adding a hint to the board.
 * It maintains the level and the actual hint that was added.
 * 
 * @author kartik
 *
 */
public class AddHint extends Move{

	/** The main model object associated with the move. */
	Level level;
	
	/** The actual hint that is involved in the move. */
	Hint hint;
	
	/** Constructor that takes the main level object and hint associated with the move. 
	 * @param level Level to add hint to.
	 * @param hint Hint to add to level.
	 */
	public AddHint(Level level, Hint hint) {
		this.level = Objects.requireNonNull(level);
		this.hint = Objects.requireNonNull(hint);
	}
	
	@Override
	public boolean doMove() {
		level.getBoard().addHint(this.hint);
		level.getBoard().update();
		return true;
	}

	@Override
	public boolean undo() {
		level.getBoard().removeHint(this.hint);
		level.getBoard().update();
		return true;
	}
	
}
