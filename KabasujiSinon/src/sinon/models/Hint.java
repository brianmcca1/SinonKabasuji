package sinon.models;

import java.awt.Point;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import sinon.models.data.HexominoCode;

/**
 * Class to represent hints on the board. Note that we have functionality such
 * that we can have multiple hints for a game.
 * 
 * @author kartik
 *
 */
public class Hint implements Serializable {
	/** The Serializer ID. */
	private static final long serialVersionUID = -202111253704126873L;
	/** The Hint's anchor position. */
	Point anchorPos;
	/** The points the Hint consists of. */
	HexominoCode pointSet;

	/**
	 * Creates a Hint based off a given Hexomino, at a given anchor point.
	 * 
	 * @param hex
	 *            The Hexomino the Hint is based off of.
	 * @param anchor
	 *            The anchor point to place the Hint.
	 */
	public Hint(Hexomino hex, Point anchor) {
		Objects.requireNonNull(hex);
		this.anchorPos = Objects.requireNonNull(anchor);

		// we need to create a new list of points to avoid association with hex
		List<Point> points = new LinkedList<Point>();
		for (Point p : hex.getHexominoNumberSet().getPoints()) {
			points.add(new Point(p.x, p.y));
		}

		this.pointSet = new HexominoCode(points);
	}

	/**
	 * Creates a new HexominoNumberSet which represents this hint.
	 * 
	 * @return HexominoNumberSet.
	 */
	public HexominoNumberSet getHexominoNumberSet() {
		return new HexominoNumberSet(this.pointSet.getPoints());
	}

	/**
	 * @return The anchor of the hint.
	 */
	public Point getAnchor() {
		return this.anchorPos;
	}
}
