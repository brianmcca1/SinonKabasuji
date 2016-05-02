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
		nullCheck();

		hex.flipVertically();
		return true;
	}

	@Override
	public boolean undo() {
		this.nullCheck();

		hex.flipVertically();
		return true;
	}


}
