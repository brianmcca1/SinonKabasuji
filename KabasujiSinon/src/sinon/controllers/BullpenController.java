package sinon.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import sinon.main.Kabasuji;
import sinon.views.BullpenView;

/**
 * This controller responds to mouse interactions with the BullpenView.
 */
public class BullpenController implements MouseListener{

	Kabasuji kabasuji;
	BullpenView bullpenView;
	
	public BullpenController(Kabasuji k, BullpenView b){
		this.kabasuji = k;
		this.bullpenView = b;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("I AM A BULLPEN AND I JUST GOT CLICKED ON!");
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
