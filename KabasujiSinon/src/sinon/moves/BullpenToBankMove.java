package sinon.moves;

import java.util.Objects;
import java.util.Optional;

import sinon.models.Hexomino;
import sinon.models.Level;

/**
 * Class that encapsulates the move from the bullpen to the bank.
 * It is mainly for builder utility for removing hexominos that
 * were added to the bullpen. 
 * 
 * @author kartik
 *
 */
public class BullpenToBankMove extends Move {

	/** The main level class in which the move is being made. */
	Level level;
	
	/** The optional hexomino that is being moved to the bank. */
	Optional<Hexomino> hex;

	/** Constructor for the move that takes the level. */
	public BullpenToBankMove(Level level) {
		this.level = Objects.requireNonNull(level);
		this.hex = this.level.getSelectedHexomino();
	}

	@Override
	public boolean doMove() {
		if (!valid()) {
			return false;
		}

		this.level.getBullpen().removeHexomino(hex.get());
		level.deselect();
		return true;
	}

	@Override
	public boolean undo() {
		this.level.getBullpen().addHexomino(hex.get());

		return true;
	}

	/** Check if this move is valid. */
	public boolean valid() {
		if (!this.level.hasSelected()) {
			return false;
		}
		if (!this.level.getBullpen().containsHexID(hex.get().getID())) {
			return false;
		}
		return true;
	}

}
