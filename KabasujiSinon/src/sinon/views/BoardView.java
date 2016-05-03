package sinon.views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import sinon.models.Board;
import sinon.models.Hint;

/**
 * Class that is linked to the Board Entity. It maintains the information
 * required for representing a board class in the Kabasuji class JFrame. It
 * extends JPanel which makes it drawable on JFrame.
 * 
 * @author Brian
 *
 */
public class BoardView extends JPanel implements Observer {

	private static final long serialVersionUID = -5335188988716751398L;

	/** This is the panel on which the tiles are drawn. */
	JPanel boardPanel;

	/** This is the board entity class that this class is associated with. */
	private Board board;

	/**
	 * This is the collection of tile views that the board view must contain.
	 */
	Collection<TileView> tileViews;

	/**
	 * Constructor for BoardView. It only takes in a board and extracts all
	 * other information from the Board object that is passed in.
	 * 
	 * @param board
	 */
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
		this.board.registerObserver(this);
	}

	/**
	 * Initialize a TileView. This is a helper function that is called from the
	 * constructor of this class.
	 * 
	 * @param row
	 *            The row the tile is on.
	 * @param column
	 *            The column the tile is on.
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
	 * Gives the collection of all TileViews that make up the BoardView.
	 * 
	 * @return The TileViews as a Collection.
	 */
	public Collection<TileView> getTileViews() {
		return tileViews;
	}

	/**
	 * Place a shadow on the given list of points.
	 * 
	 * @param pointsToShadow
	 *            The list of points to place a shadow on.
	 */
	public void setShadow(List<Point> pointsToShadow) {
		for (TileView tv : this.tileViews) {
			if (tv.setShadow(pointsToShadow.contains(new Point(tv.row, tv.column))))
				tv.updated();
		}
	}

	/**
	 * Function that updates all the tileViews that this BoardView class has. It
	 * is called from the updated() method of this class when a change is made
	 * to the model so that the view gets repainted accordingly.
	 */
	public void updateHints() {
		List<Hint> hints = this.board.getHints();
		List<Point> absoluteHintLocations = new LinkedList<Point>();

		for (Hint h : hints) {
			absoluteHintLocations.addAll(this.board.getPoints(h.getAnchor(), h.getHexominoNumberSet()));
		}

		for (TileView tv : this.tileViews) {
			if (absoluteHintLocations.contains(new Point(tv.getRow(), tv.getColumn()))) {
				tv.setHint(true);
			} else {
				tv.setHint(false);
			}
		}

	}

	@Override
	public void updated() {
		updateHints();
		for (TileView tv : tileViews) {
			tv.updated();
		}
	}
}
