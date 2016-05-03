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
		this.nullCheck();

		hex.flipHorizontally();
		return true;
	}

	@Override
	public boolean undo() {
		this.nullCheck();

		hex.flipHorizontally();
		return true;
	}

}
