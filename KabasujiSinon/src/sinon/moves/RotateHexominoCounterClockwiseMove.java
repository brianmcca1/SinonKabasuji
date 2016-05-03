package sinon.moves;

import sinon.models.Hexomino;

/**
 * Move class for rotating the hexomino counter clockwise.
 * 
 * @author kartik
 *
 */
public class RotateHexominoCounterClockwiseMove extends BullPenMove {

	/**
	 * Rotates a Hexomino CounterClockwise
	 * 
	 * @param hex
	 *            The Hexomino to rotate
	 */
	public RotateHexominoCounterClockwiseMove(Hexomino hex) {
		this.hex = hex;
		this.nullCheck();
	}

	/**
	 * Performs the move
	 */
	@Override
	public boolean doMove() {
		this.nullCheck();

		hex.rotateCC();
		return true;

	}

	/**
	 * Undoes the move
	 */
	@Override
	public boolean undo() {
		this.nullCheck();

		hex.rotateC();
		return true;
	}

}
