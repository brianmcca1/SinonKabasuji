package sinon.models;

import java.awt.Point;
import java.util.Optional;

public class Tile {

	boolean playable;
	Optional<Hexomino> hex;
	Point location;

	public Tile(Point location, boolean playable) {
		this.playable = playable;
		this.location = location;
		hex = Optional.empty();
	}

	/**
	 * Determines if it is possible to add a Hexomino to the given tile
	 * 
	 * @return True if you can add the hex, False if you cannot
	 */
	public boolean canAddHex(Hexomino hex) {
		if (this.playable == false) {
			return false;
		}
		if (this.hex.isPresent() & (this.getHexomino().get().getID() != hex.getID())) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 
	 * Adds the given Hexomino to the tile
	 * 
	 * Throws Runtime Exception if Hexomino is already present
	 * 
	 * @param hex
	 *            The hexomino to be added
	 */
	public void addHexomino(Hexomino hex) {

		if (this.hex.isPresent()) {
			throw new RuntimeException("Tile already contains a Hexomino");

		} else if (this.playable == false) {
			throw new RuntimeException("Tile is not playable");
		} else {
			this.hex = Optional.of(hex);
		}
	}

	/**
	 * Gets the hexomino currently on this tile
	 * 
	 * @return The hexomino that is on this tile
	 */
	public Optional<Hexomino> getHexomino() {
		return this.hex;
	}

	/**
	 * Removes Hexomino from this tile, if there is one
	 * 
	 * @return True if a hexomino was removed, false if there was none to remove
	 * 
	 */
	public boolean removeHex() {

		if (this.hex.isPresent()) {
			this.hex = Optional.empty();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Changes the playability of the tile.
	 * 
	 * @param bool
	 *            True implies making the tile playable.
	 */
	public void setPlayable(boolean playability) {
		this.playable = playability;
	}

	/**
	 * @return the location
	 */
	public Point getLocation() {
		return location;
	}

	/**
	 * Determines if the tile currently is occupied by a Hexomino
	 * 
	 * @return True if the tile is occupied by a Hex, False if not
	 */
	public boolean hasHex() {
		return hex.isPresent();
	}

	/**
	 * Determines if the tile is playable or not.
	 * 
	 * Note that this has nothing to do with whether or not you can actually
	 * place something on a tile. Use {@link #canAddHex()} for that one.
	 * 
	 * @return True if the tile is playable.
	 */
	public boolean isPlayable() {
		return this.playable;
	}
}
