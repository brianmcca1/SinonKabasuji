package sinon.models;

import java.awt.Point;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import sinon.models.data.HexominoCode;

public class Hint implements Serializable {

	Point anchorPos;
	HexominoCode hexominoCode;

	public Hint(Hexomino hex, Point anchor) {
		Objects.requireNonNull(hex);
		this.anchorPos = Objects.requireNonNull(anchor);
		this.hexominoCode = new HexominoCode(hex);
	}

	/**
	 * Creates a new HexominoNumberSet which represents this hint.
	 * 
	 * @return HexominoNumberSet
	 */
	public HexominoNumberSet getHexominoNumberSet() {
		return NumberSetFactory.getByCode(hexominoCode);
	}

	/**
	 * @return the hexominoCode
	 */
	public HexominoCode getHexominoCode() {
		return hexominoCode;
	}
	
	public Point getAnchor() {
		return this.anchorPos;
	}
}
