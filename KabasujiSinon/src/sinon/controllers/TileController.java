package sinon.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import sinon.models.Level;
import sinon.models.Tile;
import sinon.views.MainView;
import sinon.views.TileView;

public abstract class TileController implements MouseListener{

	protected Level level;
	protected TileView tileView;
	protected MainView mainView;
	protected Tile tile;

	public TileController(Level level, TileView tileView, MainView mainView) {
		this.level = level;
		this.mainView = mainView;
		this.tileView = tileView;
		this.tile = tileView.getTile();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	
	    if (SwingUtilities.isRightMouseButton(e)) {
	        handleRightClick();
	
	    } else {
	        handleLeftClick();
	    }
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	public void handleRightClick(){}
	
	public void handleLeftClick(){}
}
