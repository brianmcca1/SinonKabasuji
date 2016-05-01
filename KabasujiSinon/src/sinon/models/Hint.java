package sinon.models;

import java.awt.Point;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import sinon.models.data.HexominoCode;

public class Hint implements Serializable {

	Point anchorPos;
	HexominoNumberSet hexominoNumberSet;

	public Hint(Hexomino hex, Point anchor) {
		Objects.requireNonNull(hex);
		this.anchorPos = Objects.requireNonNull(anchor);
		this.hexominoNumberSet = hex.getHexominoNumberSet();
	}

	/**
	 * Creates a new HexominoNumberSet which represents this hint.
	 * 
	 * @return HexominoNumberSet
	 */
	public HexominoNumberSet getHexominoNumberSet() {
		return this.hexominoNumberSet;
	}

	public Point getAnchor() {
		return this.anchorPos;
	}
}
