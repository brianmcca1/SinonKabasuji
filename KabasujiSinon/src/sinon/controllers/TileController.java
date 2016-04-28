package sinon.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import sinon.models.Level;
import sinon.models.Tile;
import sinon.views.MainView;
import sinon.views.TileView;

/**
 * A TileController is the mouse listener for a TileView.
 * 
 * A TileController is registered to an individual tile and tileView. Each
 * TileController must also be aware of it's current level, so that it can
 * access the board and know the selected piece.
 * 
 * @author Josh Desmond
 */
public abstract class TileController implements MouseListener {

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

	public abstract void handleRightClick();

	public abstract void handleLeftClick();
}
