package sinon.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Optional;
import sinon.main.Builder;
import sinon.models.BullPen;
import sinon.models.Hexomino;
import sinon.views.HexominoBullpenView;
import sinon.views.MainView;
/**
 * This controller responds to mouse interactions with the HexominoBullpenViews in 
 * the bank of the builder.
 * @author kartik
 */
public class HexominoBankController implements MouseListener{

	Builder builder;
	HexominoBullpenView hexBullpenView;
	
	public HexominoBankController(Builder b, HexominoBullpenView view) {
		this.builder = b; 
		this.hexBullpenView = view;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		System.out.println("I AM A BANK HEXOMINO AND I GOT CLICKED ON");
		if(this.builder.getCurrentLevel() != null){
			// TODO This event basically adds a hexomino to the bullpen
			Hexomino hex = this.hexBullpenView.getHexomino(); 
			//when a bank hexomino gets clicked on, it just gets added to the bullpen
			
			BullPen bp = this.builder.getCurrentLevel().getBullpen();
			bp.addHexomino(hex);
			System.out.println(bp.getPieces().toString());

		}
	}

	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e){}
	@Override
	public void mouseExited(MouseEvent e) {}
}
