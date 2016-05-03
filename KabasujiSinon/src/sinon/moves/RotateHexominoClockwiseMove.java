package sinon.moves;

import sinon.models.Hexomino;

/**
 * Move class for rotating a hexomino clockwise.
 * 
 * @author kartik
 *
 */
public class RotateHexominoClockwiseMove extends BullPenMove {

	/**
	 * Rotates a Hexomino Clockwise
	 * 
	 * @param hex
	 *            The hexomino to rotate
	 */
	public RotateHexominoClockwiseMove(Hexomino hex) {
		this.hex = hex;
		this.nullCheck();
	}

	/**
	 * Performs the move
	 */
	@Override
	public boolean doMove() {
		this.nullCheck();

		hex.rotateC();
		return true;
	}

	/**
	 * Undoes the move
	 */
	@Override
	public boolean undo() {
		this.nullCheck();

		hex.rotateCC();
		return true;
	}

}
