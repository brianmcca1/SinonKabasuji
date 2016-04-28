package sinon.moves;

import sinon.models.Hexomino;

/**
 * Move class that flips hexominos horizontally.
 * 
 * @author kartik
 *
 */
public class FlipHorizontalMove extends BullPenMove {

	public FlipHorizontalMove(Hexomino hex) {
		this.hex = hex;
	}

	@Override
	public boolean doMove() {
		if (hex == null) {
			throw new NullPointerException();
		}

		hex.flipHorizontally();
		return true;
	}

	@Override
	public boolean undoMove() {
		if (hex == null) {
			throw new NullPointerException();
		}

		hex.flipHorizontally();
		return true;
	}

}
