package sinon.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import sinon.models.Level;
import sinon.models.Tile;
import sinon.moves.MoveInBoard;
import sinon.moves.MoveToBoardFromBullpen;
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

	public void handleLeftClick() {
		System.out.println("I AM A TILE AND I WAS JUST CLICKED ON!");

		if (level.hasSelected()) {

			if (level.getBullpen().containsHexID(level.getSelectedHexomino().get().getID())) {
				// else move from bullpen to board
				MoveToBoardFromBullpen move = new MoveToBoardFromBullpen(
						this.level, this.tileView.getRow(),
						this.tileView.getColumn());

				if (move.doMove()) {
					level.pushMove(move);
					System.out.println("Move successfully completed!");
					level.deselect();
				} else {
					System.out.println("There was some error doing the move.");
				}
			}

			else if (level.getBoard().containsHexID(level.getSelectedHexomino().get().getID())) {
				// then move from board to board
				int x, y;
				x = level.getBoard().getHexominoLocation(
						level.getSelectedHexomino().get()).x;
				y = level.getBoard().getHexominoLocation(
						level.getSelectedHexomino().get()).y;
				MoveInBoard move = new MoveInBoard(level, x, y,
						this.tileView.getRow(), this.tileView.getColumn());

				if (move.doMove()) {
					level.pushMove(move);
					System.out.println("The move was successfully completed!");
					level.deselect();
				} else {
					System.out.println("The move couldn't be completed!");
				}

			}
		} else {
			if (this.tileView.getTile().hasHex()) {
				level.select(this.tileView.getTile().getHexomino().get());
			}
		}
	}
}
