package sinon.views;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import sinon.models.LightningTile;
import sinon.models.ReleaseNumber;
import sinon.models.ReleaseTile;
import sinon.models.Tile;

/**
 * The view for a tile on the board.
 * 
 * @author Brian
 */
@SuppressWarnings("serial")
public class TileView extends JPanel implements Observer {

	/** The Tile model that this view will represent. */
	public Tile tile;
	/** Row and column position of this TileView's Tile. */
	int row, column;
	/** Color of this TileView. */
	Color color;
	/** If this TileView's Tile contains a Hexomino's shadow. */
	boolean isShadow;
	/** If this TileView's Tile contains a hint. */
	private boolean isHint;

	/**
	 * Creates the TileView given a Tile.
	 * 
	 * @param tile
	 *            Tile to create a view for.
	 */
	public TileView(Tile tile) {
		this.tile = tile;
		this.color = Color.white;
		this.setBackground(color);
		this.row = tile.getLocation().x;
		this.column = tile.getLocation().y;
		this.tile.registerObserver(this);
		this.isShadow = false;
		this.isHint = false;

		if (tile instanceof ReleaseTile) {
			ReleaseTile releaseTile = (ReleaseTile) tile;
			if (releaseTile.hasReleaseNumber()) {
				ReleaseNumber releaseNumber = releaseTile.getReleaseNumber().get();
				JLabel number = new JLabel(Integer.toString(releaseNumber.getNumber()));

				if (releaseNumber.getColor() == Color.YELLOW) {
					number.setForeground(Color.BLUE);
				} else {
					number.setForeground(releaseNumber.getColor());
				}
				this.add(number);
			}
		}
	}

	/**
	 * Sets this tiles color to the proper color based on the tile it's viewing,
	 * and repaints the panel.
	 */
	protected void redraw() {
		assert this.tile != null;

		if (!tile.isPlayable()) {
			this.setColor(color.black);
		} else {
			this.setColor(color.WHITE);
		}

		if (tile instanceof ReleaseTile) {
			ReleaseTile releaseTile = (ReleaseTile) tile;
			if (releaseTile.hasReleaseNumber()) {
				ReleaseNumber releaseNumber = releaseTile.getReleaseNumber().get();
				JLabel number = new JLabel(Integer.toString(releaseNumber.getNumber()));
				if (releaseNumber.getColor() == Color.YELLOW) {
					number.setForeground(Color.ORANGE);
				} else {
					number.setForeground(releaseNumber.getColor());
				}
				this.add(number);
			} else {
				this.removeAll();
			}
		}

		if (tile.hasHex()) {
			this.setColor(tile.getHexomino().get().getColor());
		}

		else if (tile instanceof LightningTile) {
			if (((LightningTile) tile).isLightninged()) {
				this.setColor(Color.CYAN);
			}
		}

		if (this.isShadow) {
			this.setColor(color.darker());
		}

		if (this.isHint) {
			this.setColor(color.darker());
		}

		this.repaint();
		this.revalidate();
	}

	/**
	 * Get the row this tile is on.
	 * 
	 * @return The row number.
	 */
	public int getRow() {
		return this.row;
	}

	/**
	 * Get the column this tile is on.
	 * 
	 * @return The column number.
	 */
	public int getColumn() {
		return this.column;
	}

	/**
	 * Get the tile this view is associated with.
	 * 
	 * @return The tile the view is associated with.
	 */
	public Tile getTile() {
		return this.tile;
	}

	/**
	 * Set the color of the tile
	 * 
	 * @param c
	 *            The color to set
	 */
	public void setColor(Color c) {
		this.color = c;
		this.setBackground(c);
	}

	/**
	 * Sets a shadow on this TileView.
	 * @param isShadow If this TileView contains a Hexominio's shadow.
	 * @return The inverted boolean value of this TileView containing a Hexomino's shadow.
	 */
	public boolean setShadow(boolean isShadow) {
		boolean returnValue = this.isShadow != isShadow;
		this.isShadow = isShadow;
		return returnValue;
	}

	/**
	 * Sets a hint on this TileView.
	 * @param isHint If this tile contains a hint.
	 */
	public void setHint(boolean isHint) {
		this.isHint = isHint;
	}

	@Override
	public void updated() {
		this.redraw();
	}

}
