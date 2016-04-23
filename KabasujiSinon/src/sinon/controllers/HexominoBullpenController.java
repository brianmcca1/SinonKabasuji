package sinon.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Optional;

import sinon.main.Kabasuji;
import sinon.models.BullPen;
import sinon.models.Hexomino;
import sinon.models.Level;
import sinon.views.BullpenView;
import sinon.views.HexominoBullpenView;

/**
 * This controller responds to mouse interactions with HexominoBullpenViews in the BullpenView.
 */
public class HexominoBullpenController implements MouseListener{

	/** View associated with this controller. */
	HexominoBullpenView hexBullpenView;
	
	/** View associated with the Bullpen that contains this hexomino. */
	BullpenView bpview;
	
	/** Current level that the game/builder is in.  */
	Level level;
	
	/** Bullpen which contains hexominos in both game and builder. */
	BullPen bullpen;
	
	/** Hexomino model that's associated with this controller. */
	Hexomino hex;
	
	public HexominoBullpenController(HexominoBullpenView view, Level level, BullPen bullpen){
		this.hexBullpenView = view;
		this.level = level;
		this.bullpen = bullpen;
	}
	

	/** Event where a hexomino gets selected
	 * from the bullpen.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("I AM A HEXOMINO AND I JUST GOT CLICKED ON!");
		
		if(level.hasSelected()) {
			Hexomino alreadySelected = level.selectedHexomino.get();
			bullpen.addHexomino(alreadySelected);
			//we will have to  refresh the bullpenview here
		} else {
			level.select(Optional.of(hex));
			//refresh the views here? 
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
