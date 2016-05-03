package sinon.models;

import java.awt.Point;
import java.util.Objects;
import java.util.Optional;

import sinon.views.Observer;

/**
 * Main tile class that encapsulates the attributes and behaviors 
 * that are exclusive to tile.
 *
 */
public class Tile implements Observable {

	@Override
	public String toString() {
		return "Tile [playable=" + playable + ", hex=" + hex + ", location=" + location + ", observer=" + observer
				+ "]";
	}

	boolean playable;
	Optional<Hexomino> hex;
	Point location;
	Optional<Observer> observer;

	/**
	 * Creates a new tile with the given parameters
	 * @param location the point location of this tile
	 * @param playable boolean determining whether the tile is playable
	 */
	public Tile(Point location, boolean playable) {
		this.playable = playable;
		this.location = Objects.requireNonNull(location);
		hex = Optional.empty();
		this.observer = Optional.empty();
	}

	/**
	 * Determines if it is possible to add a Hexomino to the given tile
	 * 
	 * @return True if you can add the hex, False if you cannot
	 */
	public boolean canAddHex(Hexomino hex) {
		if (!this.playable) {
			return false;
		}

		if (this.hex.isPresent()) {
			return this.getHexomino().get().getID().equals(hex.getID());
		}
		// else
		return true;
	}

	/**
	 * 
	 * Adds the given Hexomino to the tile
	 * 
	 * Throws Runtime Exception if Hexomino is already present
	 * 
	 * @param hex
	 *            The Hexomino to be added. Can't be null.
	 * @return whether or not the hexomino was added.
	 */
	public boolean addHexomino(Hexomino hex) {
		if (hex == null)
			throw new NullPointerException();
		
		
		else if (this.canAddHex(hex) == false) {
			return false;
		}

		this.hex = Optional.of(hex);
		update();
		return true;
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
			update();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Changes the playability of the tile.
	 * 
	 * @param playability
	 *            True implies making the tile playable.
	 */
	public void setPlayable(boolean playability) {
		this.playable = playability;
		update();
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

	@Override
	public void registerObserver(Observer observer) {
		this.observer = Optional.of(observer);
	}

	@Override
	public void update() {
		if (this.observer.isPresent()) {
			this.observer.get().updated();
		}
	}
}
