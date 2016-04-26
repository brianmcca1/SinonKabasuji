package sinon.views;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import sinon.models.Tile;

public class TileView extends JPanel {

    public Tile tile;
    int row, column;
    Color color;

    TileView(Tile tile) {
        this.tile = tile;
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        this.row = tile.getLocation().x;
        this.column = tile.getLocation().y;
    }

    public void toggleColor() {
        if (!(this.getBackground().equals(Color.black)))
            this.setBackground(Color.black);
        else
            this.setBackground(Color.white);

        this.repaint();
        this.revalidate();
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public Tile getTile() {
        return this.tile;
    }

    public void setColor(Color c) {
        this.setBackground(Color.blue);
    }

}
