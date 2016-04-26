package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sinon.main.Kabasuji;
import sinon.moves.RotateHexominoClockwiseMove;
import sinon.moves.RotateHexominoCounterClockwiseMove;
import sinon.views.HexominoBullpenView;

/**
 * This controller responds to actions with a HexominoBullpenView.
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
		RotateHexominoClockwiseMove move = new RotateHexominoClockwiseMove(hexBullpenView.getHexomino());
		move.doMove();
	}

}
