package sinon.models;

import java.awt.Point;
import java.util.Optional;

/**
 * A Tile used in a release level.
 * 
 * The Release Tile can have a Release Number associated with it
 * 
 * @author Brian
 *
 */
public class ReleaseTile extends Tile {

	Optional<ReleaseNumber> releaseNumber = Optional.empty();

	/**
	 * Creates a new tile with the given parameters.
	 * @param location the point location of this tile.
	 * @param playable boolean determining whether the tile is playable.
	 */
	public ReleaseTile(Point location, boolean playable) {
		super(location, playable);
	}

	/**
	 * Add a Release Number to the tile.
	 * 
	 * @param releaseNumber
	 *            the Release Number to be added.
	 * @return True if the Release Number was added successfully, false
	 *         otherwise.
	 */
	public boolean addReleaseNumber(ReleaseNumber releaseNumber) {
		if (this.releaseNumber.isPresent()) {
			return false;
		}
		this.releaseNumber = Optional.of(releaseNumber);
		this.releaseNumber.get().setLocation(this.location);
		update();
		return true;
	}

	/**
	 * Removes the Release Number from the tile.
	 * 
	 * @return True if the Release Number was removed successfully, false
	 *         otherwise.
	 */
	public boolean removeReleaseNumber() {
		if (!this.releaseNumber.isPresent()) {
			return false;
		}
		this.releaseNumber.get().removeLocation();
		this.releaseNumber = Optional.empty();
		update();
		return true;
	}

	/**
	 * Get the ReleaseNumber currently on this tile.
	 * 
	 * @return The ReleaseNumber occupying this tile.
	 */
	public Optional<ReleaseNumber> getReleaseNumber() {
		return this.releaseNumber;
	}

	/**
	 * Determines if the tile is currently occupied by a ReleaseNumber.
	 * 
	 * @return True if the tile is occupied by a ReleaseNumber, False otherwise.
	 */
	public boolean hasReleaseNumber() {
		return this.releaseNumber.isPresent();
	}

	@Override
	public boolean addHexomino(Hexomino hex) {
		if (this.releaseNumber.isPresent()) {
			this.releaseNumber.get().collect();
		}
		return super.addHexomino(hex);
	}

	@Override
	public boolean removeHex() {
		if (this.releaseNumber.isPresent()) {
			if (this.releaseNumber.get().collected) {
				this.releaseNumber.get().uncollect();
			}
		}
		return super.removeHex();
	}
}
