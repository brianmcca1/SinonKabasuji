package sinon.moves;

import sinon.models.Hexomino;
import sinon.models.BullPen;

/**
 * Move class for flipping the hexomino vertically.
 * @author kartik
 *
 */
public class FlipVerticalMove extends BullPenMove{

	public FlipVerticalMove(BullPen bp, Hexomino hex) {
		this.bullPen = bp;
		this.hex = hex;
	}
	@Override
	public boolean doMove() {
		if(hex == null) {
			throw new NullPointerException();
		}
		
		bullPen.flipHexominoVertical(hex);
		return true;
	}

	@Override
	public boolean undoMove() {
		if(hex == null) {
			throw new NullPointerException();
		}
		
		bullPen.flipHexominoVertical(hex);
		return true;
	}

}
