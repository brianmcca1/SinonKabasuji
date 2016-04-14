package sinon.moves;

import sinon.models.BullPen;
import sinon.models.Hexomino;

/**
 * Move class for rotating the hexomino counter clockwise.
 * @author kartik
 *
 */
public class RotateHexominoCounterClockwiseMove extends BullPenMove {

	public RotateHexominoCounterClockwiseMove(BullPen bp, Hexomino hex) {
		this.bullPen = bp;
		this.hex = hex;
	}
	
	@Override
	public boolean doMove() {
		if(hex == null) {
			throw new NullPointerException();
		}
		
		bullPen.rotateHexominoCounterClockwise(hex);
		return true;
		
	}

	@Override
	public boolean undoMove() {
		if(hex == null) {
			throw new NullPointerException();
		}
		
		bullPen.rotateHexominoClockwise(hex);
		return true;
	}

}
