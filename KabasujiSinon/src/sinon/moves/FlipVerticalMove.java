package sinon.moves;

import sinon.models.Hexomino;

/**
 * Move class for flipping the hexomino vertically.
 * 
 * @author kartik
 *
 */
public class FlipVerticalMove extends BullPenMove {

	public FlipVerticalMove(Hexomino hex) {
		this.hex = hex;
	}

	@Override
	public boolean doMove() {
		if (hex == null) { // TODO move to super class this logic.
			// https://en.wikipedia.org/wiki/Don%27t_repeat_yourself
			throw new NullPointerException();
		}

		hex.flipVertically();
		return true;
	}

	@Override
	public boolean undo() {
		if (hex == null) {
			throw new NullPointerException();
		}

		hex.flipVertically();
		return true;
	}

	@Override
	public boolean redo() {
		return this.doMove();
	}

}
