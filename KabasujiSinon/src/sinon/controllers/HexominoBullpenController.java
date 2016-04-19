package sinon.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import sinon.main.Kabasuji;
import sinon.views.BullpenView;
import sinon.views.HexominoBullpenView;

/**
 * This controller responds to mouse interactions with HexominoBullpenViews in the BullpenView.
 */
public class HexominoBullpenController implements MouseListener{

	Kabasuji kabasuji;
	HexominoBullpenView hexBullpenView;

	public HexominoBullpenController(Kabasuji k, HexominoBullpenView h){
		this.kabasuji = k;
		this.hexBullpenView = h;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("I AM A HEXOMINO AND I JUST GOT CLICKED ON!");
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
