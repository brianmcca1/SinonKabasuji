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
 *
 */
@SuppressWarnings("serial")
public class TileView extends JPanel implements Observer {

	public Tile tile;
	int row, column;
	Color color;
	boolean isShadow;
	private boolean isHint;

	TileView(Tile tile) {
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
	 * Toggle the color from black to white, for unplayable and playable
	 * respectively
	 */
	@Deprecated
	public void toggleColor() {
		if (!(this.getBackground().equals(Color.black)))
			this.setBackground(Color.black);
		else
			this.setBackground(Color.white);

		this.repaint();
		this.revalidate();
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
		
		if(this.isHint) {
			this.setColor(color.darker());
		}

		this.repaint();
		this.revalidate();
	}

	/**
	 * Get the row this tile is on
	 * 
	 * @return The row number
	 */
	public int getRow() {
		return this.row;
	}

	/**
	 * Get the column this tile is on
	 * 
	 * @return The column number
	 */
	public int getColumn() {
		return this.column;
	}

	/**
	 * Get the tile this view is associated with
	 * 
	 * @return The tile the view is associated with
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

	public boolean setShadow(boolean isShadow) {
		boolean returnValue = this.isShadow != isShadow;
		this.isShadow = isShadow;
		return returnValue;
	}
	
	public void setHint(boolean isHint) {
		this.isHint = isHint;
	}

	@Override
	public void updated() {
		this.redraw();
	}

}
