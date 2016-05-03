package sinon.moves;

import sinon.models.Hexomino;

/**
 * Move class that flips hexominos horizontally.
 * 
 * @author kartik
 *
 */
public class FlipHorizontalMove extends BullPenMove {

	/**
	 * Constructs a new Flip horizontal move with the given hex.
	 * @param hex the hex being added.
	 */
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
