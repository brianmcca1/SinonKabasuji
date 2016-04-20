package sinon.views;

import javax.swing.JPanel;

import sinon.models.Tile;

public class TileView extends JPanel {

	public Tile tile;
	
	TileView(Tile tile){
		this.tile = tile;
	}

}
