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
	
	/** Hexomino model that's associated with this controller. */
	Hexomino hex;
	
	public HexominoBullpenController(HexominoBullpenView view, Level level, BullpenView bullpenView){
		this.hexBullpenView = view;
		this.hex = hexBullpenView.getHexomino();
		this.level = level;
		this.bpview = bullpenView;
	}
	

	/** Event where a hexomino gets selected
	 * from the bullpen.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("I AM A BULLPEN HEXOMINO AND I JUST GOT CLICKED ON!");
		
		if(level.hasSelected()) {
			Hexomino alreadySelected = level.selectedHexomino;
			this.level.getBullpen().addHexomino(alreadySelected);
			bpview.redrawBullpenView();
			level.deselect();
			System.out.println("SELECTED HEXOMINO HAS BEEN DESELECTED");
		} 
		else {
			level.select(hex);
			System.out.println("NEWLY SELECTED HEXOMINO: " + level.selectedHexomino.toString());
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}
