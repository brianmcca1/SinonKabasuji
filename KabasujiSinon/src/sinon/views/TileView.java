package sinon.views;

import javax.swing.JPanel;

import sinon.models.Tile;

public class TileView extends JPanel {

    public Tile tile;
    int row, col;

    TileView(Tile tile) {
        this.tile = tile;
    }

}
