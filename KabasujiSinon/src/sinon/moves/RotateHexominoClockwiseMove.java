package sinon.moves;

import sinon.models.Hexomino;
import sinon.models.BullPen;

/**
 * Move class for rotating a hexomino clockwise.
 * @author kartik
 *
 */
public class RotateHexominoClockwiseMove extends BullPenMove {
	
	public RotateHexominoClockwiseMove(Hexomino hex) {
		this.hex = hex;
	}
	
	@Override
	public boolean doMove() {
		if(hex == null) {
			throw new NullPointerException();
		}
		
		hex.rotateC();
		return true;
	}

	@Override
	public boolean undoMove() {
		if(hex == null) {
			throw new NullPointerException();
		}
		
		hex.rotateCC();
		return true;
	}

}
