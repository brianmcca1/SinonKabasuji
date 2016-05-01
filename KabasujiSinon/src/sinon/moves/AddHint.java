package sinon.moves;

import java.util.Objects;

import sinon.models.Hint;
import sinon.models.Level;

public class AddHint extends Move{

	Level level;
	
	Hint hint;
	
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
