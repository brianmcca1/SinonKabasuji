package sinon.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Optional;
import sinon.main.Builder;
import sinon.models.Hexomino;
import sinon.views.HexominoBullpenView;
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
		if(this.builder.getCurrentLevel() != null){
			// TODO This event basically adds a hexomino to the bullpen
			Optional<Hexomino> hex = Optional.of(this.hexBullpenView.getHexomino()); 
			
			this.builder.getCurrentLevel().select(hex);
			
			System.out.println("SELECTED HEXOMINO IN BUILDER'S LEVEL: " + this.builder.getCurrentLevel().selectedHexomino.toString());
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
