package sinon.models;

import java.awt.Color;
import java.awt.Point;
import java.util.Optional;

import sinon.models.data.ReleaseNumberData;

/**
 * A ReleaseNumber is part of the Release Number sets. It has a Color, a number,
 * and a location on the board
 * 
 * @author Brian
 *
 */
public class ReleaseNumber {

	Color color;
	int number;
	Optional<Point> location;
	boolean collected;

	public ReleaseNumber(Color color, int number, Point location) {
		super();
		this.color = color;
		this.number = number;
		this.location = Optional.of(location);
		this.collected = false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReleaseNumber [color=" + color + ", number=" + number + ", location=" + location + ", collected="
				+ collected + "]";
	}

	public ReleaseNumber(Color color, int number) {
		super();
		this.color = color;
		this.number = number;
		this.collected = false;
		this.location = Optional.empty();
	}

	public ReleaseNumber(ReleaseNumberData releaseNumberData) {
		this.color = releaseNumberData.getColor();
		this.number = releaseNumberData.getNumber();
		this.location = Optional.of(releaseNumberData.getLocation());
		this.collected = releaseNumberData.isCollected();
	}

	/**
	 * Set the location of the ReleaseNumber
	 * 
	 * @param location
	 *            Location of the ReleaseNumber as a Point
	 */
	public void setLocation(Point location) {
		this.location = Optional.of(location);
	}

	/**
	 * Remove the associated location
	 * 
	 * This would be used if a number set is removed from the board, to avoid an
	 * inaccurate or misleading location
	 */
	public void removeLocation() {
		this.location = Optional.empty();
	}

	/**
	 * Returns whether or not the ReleaseNumber has been collected
	 * 
	 * @return Whether the ReleaseNumber has been collected
	 */
	public boolean isCollected() {
		return this.collected;
	}

	/**
	 * Gets the location of the ReleaseNumber on the board
	 * 
	 * @return The location of the ReleaseNumber as a Point
	 */
	public Optional<Point> getLocation() {
		return this.location;
	}

	/**
	 * Collect the ReleaseNumber
	 */
	public void collect() {
		collected = true;
	}

	/**
	 * Uncollect the ReleaseNumber
	 * 
	 * This is used when a Hexomino is removed from a tile
	 */
	public void uncollect() {
		collected = false;
	}

	/**
	 * Get the Color of the ReleaseNumber
	 * 
	 * @return The color of the ReleaseNumber
	 */
	public Color getColor() {
		return this.color;
	}

	/**
	 * Get the number associated with the ReleaseNumber
	 * 
	 * @return The number associated with the ReleaseNumber
	 */
	public int getNumber() {
		return this.number;
	}

	public boolean hasLocation() {
		return this.location.isPresent();
	}

}
