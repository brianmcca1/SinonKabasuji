package sinon.views;

import java.awt.Color;

import javax.swing.JPanel;

import sinon.models.LightningTile;
import sinon.models.Tile;

/**
 * The view for a tile on the board
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

    TileView(Tile tile) {
        this.tile = tile;
        this.color = Color.white;
        this.setBackground(color);
        this.row = tile.getLocation().x;
        this.column = tile.getLocation().y;
        this.tile.registerObserver(this);
        isShadow = false;
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

        if (tile.hasHex()) {
            this.setColor(tile.getHexomino().get().getColor());
        }

        else if (tile instanceof LightningTile) {
            if (((LightningTile) tile).isLightninged()) {
                this.setColor(Color.CYAN);
            }
        }

        if(this.isShadow) {
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
    
    public void setShadow(boolean isShadow) {
    	this.isShadow = isShadow;
    }
    
    @Override
    public void updated() {
        this.redraw();
    }

}
