package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sinon.main.Kabasuji;
import sinon.moves.FlipVerticalMove;
import sinon.views.HexominoBullpenView;

/**
 * This controller responds to mouse interactions with a HexominoBullpenView.
 */
public class FlipHexominoVerticalController implements ActionListener{

	/**Top level game/builder object*/
	Kabasuji kabasuji;
	/** This is the hexomino view that is being flipped.*/
	HexominoBullpenView hexBullpenView;
	
	/**
	 * @param k 
	 * 		Top level game/builder object
	 * @param h
	 * 		Hexomino view to be flipped
	 */
	public FlipHexominoVerticalController(Kabasuji k, HexominoBullpenView h){
		this.kabasuji = k;
		this.hexBullpenView = h;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("(TEMP) FLIPPING BULLPEN HEXOMINO VERTICALLY. . .");
		FlipVerticalMove move = new FlipVerticalMove(hexBullpenView.getHexomino());
		move.doMove();
		// TODO Is kabasuji supposed to be there??
		
	}
}
