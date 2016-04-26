package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sinon.main.Kabasuji;
import sinon.moves.FlipVerticalMove;
import sinon.moves.RotateHexominoCounterClockwiseMove;
import sinon.views.HexominoBullpenView;

/**
 * This controller responds to actions with a HexominoBullpenView.
 */
public class RotateHexominoAnticlockwiseController implements ActionListener {

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
	public RotateHexominoAnticlockwiseController(Kabasuji k, HexominoBullpenView h){
		this.kabasuji = k;
		this.hexBullpenView = h;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("(TEMP) ROTATING BULLPEN HEXOMINO ANTICLOCKWISE. . .");
		RotateHexominoCounterClockwiseMove move = new RotateHexominoCounterClockwiseMove(hexBullpenView.getHexomino());
		move.doMove();
	}
}
