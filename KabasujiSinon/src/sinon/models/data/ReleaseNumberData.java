package sinon.models.data;

import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;

import sinon.models.ReleaseNumber;

public class ReleaseNumberData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8404989976806635226L;
	Color color;
	int number;
	Point location;
	boolean collected;

	public ReleaseNumberData(ReleaseNumber releaseNumber) {
		this.color = releaseNumber.getColor();
		this.number = releaseNumber.getNumber();
		if (releaseNumber.hasLocation()) {
			this.location = releaseNumber.getLocation().get();
		}
		this.collected = releaseNumber.isCollected();
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @return the location
	 */
	public Point getLocation() {
		return location;
	}

	/**
	 * @return the collected
	 */
	public boolean isCollected() {
		return collected;
	}

}
