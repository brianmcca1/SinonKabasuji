package sinon.models;

import java.awt.Point;

/**
 * This is the tile for a lightning level that extends tile.
 * We need this because in a lightning level  pieces can be
 * placed over other pieces in a lightning level.
 *
 */
public class LightningTile extends Tile {

	public boolean lightninged;

	public LightningTile(Point location, boolean playable) {
		super(location, playable);
	}

	@Override
	public boolean canAddHex(Hexomino hex) {
		System.out.println("Lightning Tile " + location.toString() + " checking if i can add a hex");
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
