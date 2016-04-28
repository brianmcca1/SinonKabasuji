package sinon.moves;

import sinon.models.Hexomino;
import sinon.models.BullPen;

/**
 * Move class that flips hexominos horizontally.
 * @author kartik
 *
 */
public class FlipHorizontalMove extends BullPenMove {

	public FlipHorizontalMove(Hexomino hex) {
		this.hex = hex;
	}
	
	public boolean doMove() {
		if(hex == null) {
			return false;
			//throw new NullPointerException();
		}
		
		hex.flipHorizontally();
		return true;
	}

	public boolean undoMove() {
		if(hex == null) {
			return false;
			//throw new NullPointerException();
		}
		
		hex.flipHorizontally();
		return true;
	}

}
