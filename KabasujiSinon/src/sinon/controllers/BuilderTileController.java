package sinon.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import sinon.models.Hexomino;
import sinon.models.Level;
import sinon.moves.MoveToBoardFromBullpen;
import sinon.views.BoardView;
import sinon.views.TileView;

public class BuilderTileController implements MouseListener {

	private Level level;
	private BoardView boardView;
	private TileView tileView;

	public BuilderTileController(TileView t, Level l, BoardView boardView) {
		this.tileView = t;
		this.level = l;
		this.boardView = boardView;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (SwingUtilities.isRightMouseButton(e)) {
			// TODO inline this method so this can be tested. See the EBC
			// project from Heinman's stuff for the logic on why.
			System.out
			.println("I AM A TILEVIEW AND I WAS JUST RIGHT CLICKED ON");
			int row = tileView.getRow();
			int column = tileView.getColumn();

			tileView.toggleColor();
			System.out.println("PLAYABLE BEFORE: "
					+ tileView.getTile().isPlayable());
			tileView.getTile().setPlayable(!tileView.getTile().isPlayable());
			System.out.println("PLAYABLE AFTER: "
					+ tileView.getTile().isPlayable());
		} else {
			// else if a hexomino had been selected, then add that to the board
			// at row, column
			System.out
			.println("I AM A TILEVIEW AND I WAS JUST LEFT CLICKED ON");
			if (level.hasSelected()) {
				Hexomino hex = level.selectedHexomino.get();
				int row = tileView.getRow();
				int column = tileView.getColumn();

				MoveToBoardFromBullpen move = new MoveToBoardFromBullpen(
						level, hex, row, column);

				if (move.doMove()) {
					System.out.println("Move successfully completed!");
					// Since the move is completed we should add to the stack,
					// not sure how
					// that would work
				} else {
					System.out.println("There was some error doing the move.");
				}

				// next we need to update the views
				/* Let the level update its view.
				boardView.redrawTiles();
				bullpenView.redrawBullpenView(); */
			}
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

}
