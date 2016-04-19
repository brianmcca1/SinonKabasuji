package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sinon.main.Kabasuji;
import sinon.views.HexominoBullpenView;

/** This is the controller that is associated
 * with the rotateHexomino option  that allows the player/builder 
 * to rotate a hexomino within the bullPen.
 * @author kartik
 *
 */
public class RotateHexominoClockwiseController implements ActionListener{
	
	/**Top level game/builder object*/
	Kabasuji kabasuji;
	/** This is the hexomino view that is being rotated.*/
	HexominoBullpenView hexBullpenView;
	
	/**
	 * @param k 
	 * 		Top level game/builder object
	 * @param h
	 * 		Hexomino view to be rotated
	 */
	public RotateHexominoClockwiseController(Kabasuji k, HexominoBullpenView h) {
		this.kabasuji = k;
		this.hexBullpenView = h;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("(TEMP) ROTATING BULLPEN HEXOMINO CLOCKWISE. . .");
	}

}
