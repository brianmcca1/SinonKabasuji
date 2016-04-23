package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sinon.main.Builder;
import sinon.models.Hexomino;
import sinon.views.HexominoBullpenView;
/**
 * This controller responds to mouse interactions with the HexominoBullpenViews in 
 * the bank of the builder.
 * @author kartik
 */
public class HexominoBankController implements ActionListener{

	Builder builder;
	HexominoBullpenView hexBullpenView;
	
	public HexominoBankController(Builder b, HexominoBullpenView view) {
		this.builder = b;
		this.hexBullpenView = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO This event basically adds a hexomino to the bullpen
		Hexomino beingAdded = hexBullpenView.getHexomino();
	}
	
	

}
