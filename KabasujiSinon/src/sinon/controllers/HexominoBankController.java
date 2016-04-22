package sinon.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import sinon.main.Builder;
import sinon.models.Hexomino;
import sinon.views.HexominoBullpenView;
/**
 * This controller responds to mouse interactions with the HexominoBullpenViews in 
 * the bank of the builder.
 * @author kartik
 *
 */
public class HexominoBankController implements MouseListener{

	Builder B;
	HexominoBullpenView hexBullpenView;
	
	public HexominoBankController(Builder b, HexominoBullpenView view) {
		this.B = b;
		this.hexBullpenView = view;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO This event basically adds a hexomino to the bullpen
		Hexomino beingAdded = hexBullpenView.getHexomino();
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
