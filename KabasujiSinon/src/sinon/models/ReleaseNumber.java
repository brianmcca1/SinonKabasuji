package sinon.models;

import java.awt.Point;

public class ReleaseNumber {
	public ReleaseNumber(String color, int number, Point location) {
		super();
		this.color = color;
		this.number = number;
		this.location = location;
		this.collected = false;
	}

	String color;
	int number;
	Point location;
	boolean collected;

	public boolean getCollected() {
		return this.collected;
	}

	public Point getLocation() {
		return this.location;
	}

	public void collect() {
		collected = true;
	}

	public String getColor() {
		return this.color;
	}

}
