package sinon.moves;

import java.util.Objects;
import java.util.Optional;

import sinon.models.Hexomino;
import sinon.models.Level;

public class BullpenToBankMove extends Move {

	Level level;
	Optional<Hexomino> hex;

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
