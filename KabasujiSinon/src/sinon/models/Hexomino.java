package sinon.models;

import java.awt.Point;
import java.io.Serializable;
import java.util.Set;

/**
 * A Hexomino is an entity which is used for standard Kabasuji play.
 * 
 * Most of the logic for the shape of a Kabusuji piece is delegated to the
 * {@link #hexominoNumberSet} class.
 * 
 * @author Brian
 * @author Josh Desmond
 */
public class Hexomino implements Serializable{

    /** @see HexominoNumberSet */
    HexominoNumberSet hexominoNumberSet;
    int anchorRow;
    int anchorColumn;

    /**
     * Is a convenience constructor for quickly building a Hexomino.
     * 
     * @param a
     *            The x component of the first coordinate point
     * @param a1
     *            the y component of the first coordinate point
     */
    public Hexomino(int a, int a1, int b, int b1, int c, int c1, int d, int d1,
            int e, int e1, int f, int f1) {

        this.hexominoNumberSet = new HexominoNumberSet(a, a1, b, b1, c, c1, d,
                d1, e, e1, f, f1);

    }
    
    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Hexomino [hexominoNumberSet=" + hexominoNumberSet + ", anchorRow=" + anchorRow + ", anchorColumn="
				+ anchorColumn + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anchorColumn;
		result = prime * result + anchorRow;
		result = prime * result + ((hexominoNumberSet == null) ? 0 : hexominoNumberSet.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hexomino other = (Hexomino) obj;
		if (anchorColumn != other.anchorColumn)
			return false;
		if (anchorRow != other.anchorRow)
			return false;
		if (hexominoNumberSet == null) {
			if (other.hexominoNumberSet != null)
				return false;
		} else if (!hexominoNumberSet.equals(other.hexominoNumberSet)){
			System.out.println("HexNumberSet said they weren't equal");
			return false;
		}
			
		return true;
	}

	public Hexomino(Set<Point> points){
    	this.hexominoNumberSet = new HexominoNumberSet(points);
    }

    /**
     * TODO
     * 
     * @param hexominoNumberSet
     */
    public Hexomino(HexominoNumberSet hexominoNumberSet) {
        this.hexominoNumberSet = hexominoNumberSet;
    }

    protected void addToTile(Tile t) {
        t.addHexomino(this);
    }

    public void flipHorizontally() {
        hexominoNumberSet.flipHorizontally();
    }

    public void flipVertically() {
        hexominoNumberSet.flipVertically();
    }

    public void rotateC() {
        hexominoNumberSet.rotateC();
    }

    public void rotateCC() {
        hexominoNumberSet.rotateCC();
    }
}
