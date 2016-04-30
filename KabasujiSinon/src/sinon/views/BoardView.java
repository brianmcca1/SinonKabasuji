package sinon.views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import sinon.models.Board;

/**
 * View in charge of displaying the board
 * 
 * @author Brian
 *
 */
public class BoardView extends JPanel {

	JPanel boardPanel;
	private Board board;
	Collection<TileView> tileViews;

	public BoardView(Board board) {
		this.board = Objects.requireNonNull(board);
		this.boardPanel = new JPanel();
		this.boardPanel.setLayout(new GridLayout(12, 12));
		this.boardPanel.setBounds(80, 26, 300, 300);
		this.boardPanel.setBackground(Color.BLACK);
		this.boardPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		this.tileViews = new ArrayList<TileView>();

		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				initializeTile(i, j);
			}
		}
	}

	/**
	 * Initialize a TileView
	 * 
	 * @param row
	 *            The row the tile is on
	 * @param column
	 *            The column the tile is on
	 */
	private void initializeTile(int row, int column) {
		TileView tileView = new TileView(board.getTile(row, column));
		if (tileView.getTile().isPlayable()) {
			tileView.setBackground(Color.white);
		} else {
			if (tileView.getTile().isPlayable() == false) {
				tileView.setBackground(Color.black);
			}
		}
		tileView.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
		this.tileViews.add(tileView);
		boardPanel.add(tileView);
	}

	/**
	 * Gives the collection of all TileViews that make up the BoardView
	 * 
	 * @return The TileViews as a Collection
	 */
	public Collection<TileView> getTileViews() {
		return tileViews;
	}

	/**
	 * Redraw all the tiles with the appropriate colors
	 */
	public void redrawTiles() {
		for (TileView tv : this.tileViews) {
			if (board.getTile(new Point(tv.row, tv.column)).hasHex()) {
				tv.setColor(Color.blue);
			} else if (board.getTile(new Point(tv.row, tv.column)).isPlayable()) {
				tv.setColor(Color.white);
			} else {
				tv.setColor(Color.black);
			}
		}
	}

	public void setShadow(List<Point> pointsToShadow) {
		for (TileView tv : this.tileViews) {
			tv.setShadow(pointsToShadow.contains(new Point(tv.row, tv.column)));
			tv.updated();
			// FIXME this can be optimized, by only calling updated if the change
			// actually did something.
		}
	}
}
