package sinon.models;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import sinon.models.data.HexominoCode;

/**
 * A Hexomino is an entity which is used for standard Kabasuji play.
 * 
 * Most of the logic for the shape of a Kabusuji piece is delegated to the
 * {@link #hexominoNumberSet} class.
 * 
 * @author Brian
 * @author Josh Desmond
 */
public class Hexomino {

    /** @see HexominoNumberSet */
    HexominoNumberSet hexominoNumberSet;

    /**
     * Is a convenience constructor for quickly building a Hexomino.
     * 
     * @param a
     *            The x component of the first coordinate point
     * @param a1
     *            the y component of the first coordinate point
     */
    
    protected Hexomino(int a, int a1, int b, int b1, int c, int c1, int d,
            int d1, int e, int e1, int f, int f1) {

        this.hexominoNumberSet = NumberSetFactory.getByNumbers(a, a1, b, b1, c,
                c1, d, d1, e, e1, f, f1);
    }

    public Hexomino(Set<Point> points) {
        if (points == null) {
            throw new IllegalArgumentException("Points can't be null");
        }

        List<Point> listOfPoints = new LinkedList<Point>(points);
        this.hexominoNumberSet = NumberSetFactory.getByList(listOfPoints);
    }

    /**
     * TODO
     * 
     * @param hexominoNumberSet
     */
    public Hexomino(HexominoNumberSet hexominoNumberSet) {
        this.hexominoNumberSet = hexominoNumberSet;
    }

    /**
     * Creates a Hexomino from a HexominoCode.
     * 
     * @param code
     *            The immutable data object representing a HexominoNumberSet.
     */
    public Hexomino(HexominoCode code) {
        this.hexominoNumberSet = NumberSetFactory.getByCode(code);
    }

    /**
     * Adds this hexomino to the given tile
     * 
     * @param t Tile to add the hexomino to
     * @return True if the Hexomino was added, otherwise False
     */
    boolean addToTile(Tile t) {
        if (t == null) {
            throw new IllegalArgumentException("Given Tile was null");
        }
        if(t.canAddHex() == false){
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
    }
    
    /**
     * Flip the Hexomino vertically (over the x-axis)
     */
    public void flipVertically() {
        hexominoNumberSet.flipVertically();
    }
    /**
     * Rotate the Hexomino Clockwise
     */
    public void rotateC() {
        hexominoNumberSet.rotateC();
    }

    /**
     * Rotate the Hexomino Counter-Clockwise
     */
    public void rotateCC() {
        hexominoNumberSet.rotateCC();
    }

    /**
     * Get the Hexomino's Hexomino Number Set
     * @return The Hexomino Number Set
     */
    public HexominoNumberSet getHexominoNumberSet(){
    	return this.hexominoNumberSet;
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
     * @see java.lang.Object#hashCode()
     */
    //@Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((hexominoNumberSet == null) ? 0
//                : hexominoNumberSet.hashCode());
//        return result;
//    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Hex:" + hexominoNumberSet;
    }
}
