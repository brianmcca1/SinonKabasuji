package sinon.moves;

import sinon.models.BullPen;
import sinon.models.Hexomino;

/**
 * This is the move class for rotating a hexomino clockwise.
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
			return false;
		}
		
		bullPen.rotateHexominoClockwise(hex);
		return true;
	}

	@Override
	public boolean undoMove() {
		if(hex == null) {
			return false;
		}
		
		bullPen.rotateHexominoCounterClockwise(hex);
		return true;
	}

}
