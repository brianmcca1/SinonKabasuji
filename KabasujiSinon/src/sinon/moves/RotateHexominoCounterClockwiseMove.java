package sinon.moves;

import sinon.models.BullPen;
import sinon.models.Hexomino;

/**
 * This is the move class for rotating the hexomino counter clockwise.
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
			return false;
		}
		
		bullPen.rotateHexominoCounterClockwise(hex);
		return true;
		
	}

	@Override
	public boolean undoMove() {
		if(hex == null) {
			return false;
		}
		
		bullPen.rotateHexominoClockwise(hex);
		return true;
	}

}
