package sinon.moves;

import sinon.models.BullPen;
import sinon.models.Hexomino;

/**
 * Class that encapsulates a move from the bank to the bullpen
 * in the builder.
 * 
 * @author kartik
 *
 */
public class BankToBullpenMove {
	
	/**
	 * Bullpen to which we are moving.
	 */
	BullPen bp;
	
	/**
	 * Hexomino that we are moving to the bullpen
	 */
	Hexomino hex;
	
	public BankToBullpenMove(BullPen bp, Hexomino hex) {
		
		this.bp = bp;
		this.hex = hex;
	
	}
	
	/**
	 * Operation that adds the hexomino to the bank.
	 * @return boolean that says if the move was successful
	 */
	public boolean doMove() {
		
		bp.addHexomino(hex);
		return true;
		
	}
	
	/**
	 * Operation that undoes the move.
	 * @return boolean that says if undo was successful
	 */
	public boolean undo() {
		return bp.removeHexomino(hex);
	}
}
