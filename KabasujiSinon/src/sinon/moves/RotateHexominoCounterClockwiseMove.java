package sinon.moves;

import sinon.models.Hexomino;
import sinon.models.BullPen;

/**
 * Move class for rotating the hexomino counter clockwise.
 * @author kartik
 *
 */
public class RotateHexominoCounterClockwiseMove extends BullPenMove {

	public RotateHexominoCounterClockwiseMove(Hexomino hex) {
		this.hex = hex;
	}
	
	@Override
	public boolean doMove() {
		if(hex == null) {
			throw new NullPointerException();
		}
		
		hex.rotateCC();
		return true;
		
	}

	@Override
	public boolean undoMove() {
		if(hex == null) {
			throw new NullPointerException();
		}
		
		hex.rotateC();
		return true;
	}

}
