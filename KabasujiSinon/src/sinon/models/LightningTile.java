package sinon.models;

import java.awt.Point;

/**
 * This is the tile for a lightning level that extends tile. We need this
 * because in a lightning level pieces can be placed over other pieces in a
 * lightning level.
 *
 */
public class LightningTile extends Tile {
	/** Whether the tile has been marked or not. */
	public boolean lightninged;

	/**
	 * Creates a LightningTile with the given point, and playability.
	 * 
	 * @param location
	 *            The location the Tile is at.
	 * @param playable
	 *            Whether the tile is playable.
	 */
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
	public boolean addHexomino(Hexomino hex) {
		if (hex == null) {
			return false;
		}
		this.lightninged = true;
		update();
		return true;
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
