package sinon.models;

import java.awt.Point;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import sinon.models.data.HexominoCode;

public class Hint implements Serializable {

	Point anchorPos;
	HexominoCode pointSet;

	public Hint(Hexomino hex, Point anchor) {
		Objects.requireNonNull(hex);
		this.anchorPos = Objects.requireNonNull(anchor);
		
		//we need to create a new list of points to avoid association with hex
		List<Point> points = new LinkedList<Point> ();
		for(Point p : hex.getHexominoNumberSet().getPoints()) {
			points.add(new Point(p.x, p.y));
		}
		
		this.pointSet = new HexominoCode(points);
	}

	/**
	 * Creates a new HexominoNumberSet which represents this hint.
	 * 
	 * @return HexominoNumberSet
	 */
	public HexominoNumberSet getHexominoNumberSet() {
		return new HexominoNumberSet(this.pointSet.getPoints());
	}

	public Point getAnchor() {
		return this.anchorPos;
	}
}
