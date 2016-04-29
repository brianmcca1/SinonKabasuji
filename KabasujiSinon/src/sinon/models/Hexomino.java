package sinon.models;

import java.awt.Color;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import sinon.models.data.HexominoCode;
import sinon.views.Observer;

/**
 * A Hexomino is an entity which is used for standard Kabasuji play.
 * 
 * Most of the logic for the shape of a Kabusuji piece is delegated to the
 * {@link #hexominoNumberSet} class.
 * 
 * @author Brian
 * @author Josh Desmond
 */
public class Hexomino implements Observable {

	/** @see HexominoNumberSet */
	HexominoNumberSet hexominoNumberSet;
	/** List of observers to notify after changes. */
	List<Observer> observers;
	/** Unique number to ID hexominoes in the board and the bullpen. **/
	UUID id;
	/** Color of the hexomino */
	Color color;

	/**
	 * Is a convenience constructor for quickly building a Hexomino.
	 * 
	 * @param a
	 *            The x component of the first coordinate point
	 * @param a1
	 *            the y component of the first coordinate point
	 */
	protected Hexomino(int a, int a1, int b, int b1, int c, int c1, int d, int d1, int e, int e1, int f, int f1) {

		this.hexominoNumberSet = NumberSetFactory.getByNumbers(a, a1, b, b1, c, c1, d, d1, e, e1, f, f1);
		this.id = UUID.randomUUID();
		this.observers = new LinkedList<Observer>();
	}

	public Hexomino(Set<Point> points) {
		if (points == null) {
			throw new IllegalArgumentException("Points can't be null");
		}

		List<Point> listOfPoints = new LinkedList<Point>(points);
		this.hexominoNumberSet = NumberSetFactory.getByList(listOfPoints);
		this.id = UUID.randomUUID();
		this.observers = new LinkedList<Observer>();
	}

	/**
	 * TODO
	 * 
	 * @param hexominoNumberSet
	 */
	public Hexomino(HexominoNumberSet hexominoNumberSet) {
		Objects.requireNonNull(hexominoNumberSet);
		this.hexominoNumberSet = hexominoNumberSet;
		this.id = UUID.randomUUID();
		this.observers = new LinkedList<Observer>();
	}

	/**
	 * Creates a Hexomino from a HexominoCode.
	 * 
	 * @param code
	 *            The immutable data object representing a HexominoNumberSet.
	 */
	public Hexomino(HexominoCode code) {
		Objects.requireNonNull(code);
		this.hexominoNumberSet = NumberSetFactory.getByCode(code);
		this.id = UUID.randomUUID();
		this.observers = new LinkedList<Observer>();
	}

	public Hexomino(HexominoCode code, Color color) {
		Objects.requireNonNull(code);
		this.hexominoNumberSet = NumberSetFactory.getByCode(code);
		this.id = UUID.randomUUID();
		this.observers = new LinkedList<Observer>();
		this.color = color;
	}

	/**
	 * Adds this hexomino to the given tile
	 * 
	 * @param t
	 *            Tile to add the hexomino to
	 * @return True if the Hexomino was added, otherwise False
	 */
	boolean addToTile(Tile t) {
		if (t == null) {
			throw new IllegalArgumentException("Given Tile was null");
		}
		if (t.canAddHex(this) == false) {
			return false;
		}
		t.addHexomino(this);
		return true;
	}

	/**
	 * Flip the Hexomino horizontally (over the y-axis)
	 */
	public void flipHorizontally() {
		hexominoNumberSet.flipHorizontally();
		update();
	}

	/**
	 * Flip the Hexomino vertically (over the x-axis)
	 */
	public void flipVertically() {
		hexominoNumberSet.flipVertically();
		update();
	}

	/**
	 * Rotate the Hexomino Clockwise
	 */
	public void rotateC() {
		hexominoNumberSet.rotateC();
		update();
	}

	/**
	 * Rotate the Hexomino Counter-Clockwise
	 */
	public void rotateCC() {
		hexominoNumberSet.rotateCC();
		update();
	}

	/**
	 * Get the Hexomino's Hexomino Number Set
	 * 
	 * @return The Hexomino Number Set
	 */
	public HexominoNumberSet getHexominoNumberSet() {
		return this.hexominoNumberSet;
	}

	/**
	 * Get this Hexomino's color
	 * 
	 * @return The color of this Hexomino
	 */
	public Color getColor() {
		return this.color;
	}

	/**
	 * Returns the translated set of points, such that every point is positive,
	 * and within the bounds of a 6x6 grid.
	 * 
	 * @return Returns a set of points that describes the Hexomino
	 */
	public List<Point> getNormalizedPoints() {
		return this.hexominoNumberSet.getNormalizedPoints();
	}

	public UUID getID() {
		return this.id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Hexomino))
			return false;
		Hexomino other = (Hexomino) obj;
		if (hexominoNumberSet == null) {
			if (other.hexominoNumberSet != null)
				return false;
		} else if (!hexominoNumberSet.equals(other.hexominoNumberSet))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Hex:" + hexominoNumberSet;
	}

	@Override
	public void registerObserver(Observer observer) {
		this.observers.add(observer);
	}

	@Override
	public void update() {
		for (Observer o : observers) {
			o.updated();
		}
	}
}
