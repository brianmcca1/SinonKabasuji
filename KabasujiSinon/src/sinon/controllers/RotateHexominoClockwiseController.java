package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sinon.models.AbsPiece;
import sinon.models.BullPen;

/** This is the controller that is associated
 * with the rotateHexomino option  that allows the player/builder 
 * to rotate a hexomino within the bullPen.
 * @author kartik
 *
 */
public class RotateHexominoClockwiseController implements ActionListener{
	/** This is the bullpen in which the hexomino is 
	 * being rotated.
	 */
	BullPen bullPen;
	
	/** This is the hexomino that is being rotated.
	 */
	AbsPiece hex;
	
	public RotateHexominoClockwiseController(BullPen bullPen, AbsPiece hex) {
		
		this.bullPen = bullPen;
		this.hex = hex;
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
