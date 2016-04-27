package sinon.views;

import java.awt.Color;

import javax.swing.JPanel;

import sinon.models.Tile;

/**
 * The view for a tile on the board
 * @author Brian
 *
 */
public class TileView extends JPanel {

    public Tile tile;
    int row, column;
    Color color;

    TileView(Tile tile) {
        this.tile = tile;
        this.setBackground(Color.white);
        this.row = tile.getLocation().x;
        this.column = tile.getLocation().y;
    }
    
    /**
     * Toggle the color from black to white, for unplayable and playable respectively
     */
    public void toggleColor(){
    	if(!(this.getBackground().equals(Color.black)))
    		this.setBackground(Color.black);
    	else
    		this.setBackground(Color.white);

    	this.repaint();
    	this.revalidate();
    }
    /**
     * Get the row this tile is on
     * @return The row number
     */
    public int getRow(){
    	return this.row;
    }
    /**
     * Get the column this tile is on
     * @return The column number
     */
    public int getColumn(){
    	return this.column;
    }
    /**
     * Get the tile this view is associated with
     * @return The tile the view is associated with
     */
    public Tile getTile(){
    	return this.tile;
    }
    /** Set the color of the tile
     * 
     * @param c The color to set
     */
    public void setColor(Color c){
    	this.setBackground(c);
    }
    
}
