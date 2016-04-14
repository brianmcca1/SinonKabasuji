package sinon.moves;

import sinon.models.BullPen;
import sinon.models.Hexomino;

/**
 * Move class that flips hexominos horizontally.
 * @author kartik
 *
 */
public class FlipHorizontalMove extends BullPenMove {

	public FlipHorizontalMove(BullPen bp, Hexomino hex) {
		this.bullPen = bp;
		this.hex = hex;
	}
	
	public boolean doMove() {
		if(hex == null) {
			throw new NullPointerException();
		}
		
		bullPen.flipHexominoHorizontal(hex);
		return true;
	}

	public boolean undoMove() {
		if(hex == null) {
			throw new NullPointerException();
		}
		
		bullPen.flipHexominoHorizontal(hex);
		return true;
	}

}
