package sinon.models;

import java.awt.Color;
import java.awt.Point;
import java.util.Optional;

public class ReleaseNumber {
	public ReleaseNumber(Color color, int number, Point location) {
		super();
		this.color = color;
		this.number = number;
		this.location = Optional.of(location);
		this.collected = false;
	}

	public ReleaseNumber(Color color, int number) {
		super();
		this.color = color;
		this.number = number;
		this.collected = false;
		this.location = Optional.empty();
	}

	Color color;
	int number;
	Optional<Point> location;
	boolean collected;

	public void setLocation(Point location) {
		this.location = Optional.of(location);
	}

	public void removeLocation() {
		this.location = Optional.empty();
	}

	public boolean isCollected() {
		return this.collected;
	}

	public Optional<Point> getLocation() {
		return this.location;
	}

	public void collect() {
		collected = true;
	}

	public Color getColor() {
		return this.color;
	}

}
