package sinon.models;

import java.awt.Point;

public class LightningTile extends Tile {

	public boolean lightninged;

	public LightningTile(Point location, boolean playable) {
		super(location, playable);
	}

	@Override
	public boolean canAddHex(Hexomino hex) {
		assert hex != null;
		if (!this.playable) {
			return false;
		}
		return true;
	}

	@Override
	public void addHexomino(Hexomino hex) {
		this.lightninged = true;
		update();
	}

	/**
	 * Determines if this tile has been marked or not.
	 * 
	 * @return True if it's been lightninged.
	 */
	public boolean isLightninged() {
		return this.lightninged;
	}

}
