package sinon.models;

import java.util.Optional;

public class Tile {
	@Override
	public String toString() {
		return "Tile [row=" + row + ", column=" + column + ", playable=" + playable + ", hex=" + hex + ", numberSet="
				+ numberSet + "]";
	}

	int row;
	int column;
	boolean playable;
	Optional<Hexomino> hex;
	Optional<Hint> hint;
	Optional<Shadow> shadow;
	NumberSet numberSet;
	// Shadow shadow;
	// Hint hint;

	public Tile(int row, int column, boolean playable) {
		this.row = row;
		this.column = column;
		this.playable = playable;
		this.hint = null;
		this.shadow = null;
	}

	/**
	 * Determines if it is possible to add a Hexomino to the given tile
	 * 
	 * @return True if you can add the hex, False if you cannot
	 */
	public boolean canAddHex() {
		if (this.hex.isPresent() || this.playable == false) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * 
	 * Adds the given Hexomino to the tile Throws Runtime Exception if Hexomino
	 * is already present
	 * 
	 * @param hex
	 *            The hexomino to be added
	 */
	public void addHexomino(Hexomino hex) {
		if (this.hex.isPresent()) {
			throw new RuntimeException("Tile already contains a Hexomino");

		} else {
			this.hex = Optional.of(hex);
		}
	}

	/**
	 * Adds the given Hint to the tile Throws Runtime Exception if Hint is
	 * already present
	 * 
	 * @param hint
	 *            The hint to be added
	 */
	public void addHint(Hint hint) {
		if (this.hint.isPresent()) {
			throw new RuntimeException("Tile already contains a hint");
		} else {
			this.hint = Optional.of(hint);
		}
	}

	/**
	 * Adds the given Shadow to the tile Throws Runtime Exception if Shadow is
	 * already present
	 * 
	 * @param shadow
	 *            The shadow to be added
	 */
	public void addShadow(Shadow shadow) {
		if (this.shadow.isPresent()) {
			throw new RuntimeException("Tile already contains a shadow");
		} else {
			this.shadow = Optional.of(shadow);
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
	 * Gets the Hint currently on this tile
	 * 
	 * @return the hint that is on this tile
	 */
	public Optional<Hint> getHint() {
		return this.hint;
	}

	/**
	 * Gets the Shadow currently on this tile
	 * 
	 * @return the shadow that is on this tile
	 */
	public Optional<Shadow> getShadow() {
		return this.shadow;
	}

	/**
	 * Removes Hexomino from this tile, if there is one Throws Runtime Exception
	 * if tile does not contain a Hexomino
	 * 
	 */
	public void removeHex() {
		if (this.hex.isPresent()) {
			this.hex = null;
		} else {
			throw new RuntimeException("Tile does not contain a Hexomino");
		}

	}

	/**
	 * Changes the playability of the tile
	 * 
	 * @param bool
	 *            The playability to give this tile
	 */
	public void setPlayable(boolean bool) {
		this.playable = bool;
	}

	/**
	 * Determines if the tile currently is occupied by a Hexomino
	 * 
	 * @return True if the tile is occupied by a Hex, False if not
	 */
	public boolean hasHex() {
		if (this.hex.isPresent()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Determines if the tile is currently occupied by a Hint
	 * 
	 * @return True if the tile is occupied by a Hint, False if not
	 */
	public boolean hasHint() {
		if (this.hint.isPresent()) {
			return true;
		} else
			return false;
	}

	/**
	 * Determines if the tile is currently occupied by a Tile
	 * 
	 * @return True if the tile is occupied by a Shadow, False if not
	 */
	public boolean hasShadow() {
		if (this.shadow.isPresent()) {
			return true;
		} else
			return false;
	}

}
