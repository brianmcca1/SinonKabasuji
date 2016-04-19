package sinon.moves;

import sinon.models.BullPen;
import sinon.models.Hexomino;

/**
 * Move class for rotating a hexomino clockwise.
 * @author kartik
 *
 */
public class RotateHexominoClockwiseMove extends BullPenMove {
	
	public RotateHexominoClockwiseMove(BullPen bp, Hexomino hex) {
		this.bullPen = bp;
		this.hex = hex;
	}
	
	@Override
	public boolean doMove() {
		if(hex == null) {
			throw new NullPointerException();
		}
		
		bullPen.rotateHexominoClockwise(hex);
		return true;
	}

	@Override
	public boolean undoMove() {
		if(hex == null) {
			throw new NullPointerException();
		}
		
		bullPen.rotateHexominoCounterClockwise(hex);
		return true;
	}

}
