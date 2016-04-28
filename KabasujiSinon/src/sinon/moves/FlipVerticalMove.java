package sinon.moves;

import sinon.models.Hexomino;
import sinon.models.BullPen;

/**
 * Move class for flipping the hexomino vertically.
 * @author kartik
 *
 */
public class FlipVerticalMove extends BullPenMove{

	public FlipVerticalMove(Hexomino hex) {
		this.hex = hex;
	}
	@Override
	public boolean doMove() {
		if(hex == null) {
			return false;
			//throw new NullPointerException();
		}
		
		hex.flipVertically();
		return true;
	}

	@Override
	public boolean undoMove() {
		if(hex == null) {
			return false;
			//throw new NullPointerException();
		}
		
		hex.flipVertically();
		return true;
	}

}
