package sinon.models;

import java.awt.Point;

public class LightningTile extends Tile {

	public boolean lightninged;
	
	public LightningTile(Point location, boolean playable) {
		super(location, playable);
	}
	
	public boolean canAddHex(Hexomino hex){
		assert hex != null;
		if (!this.playable) {
			return false;
		}
		return true;
	}
	
	public void addHexomino(Hexomino hex){
		this.lightninged = true;
	}

}
