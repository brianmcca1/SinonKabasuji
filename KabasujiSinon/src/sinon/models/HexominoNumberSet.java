package sinon.models;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

public class HexominoNumberSet {

    /* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((points == null) ? 0 : points.hashCode());
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
		HexominoNumberSet other = (HexominoNumberSet) obj;
		if (points == null) {
			if (other.points != null)
				return false;
		} else if (points.equals(other.points))
			return true;
		
		return true;
	}

	Set<Point> points;

    public HexominoNumberSet(int a, int a1, int b, int b1, int c, int c1, int d, int d1,
            int e, int e1, int f, int f1) {
    	points = new HashSet<Point>();
    	
    	points.add(new Point(a, a1));
    	points.add(new Point(b, b1));
    	points.add(new Point(c, c1));
    	points.add(new Point(d, d1));
    	points.add(new Point(e, e1));
    	points.add(new Point(f, f1));
       
    }
    
    

    public void flipHorizontally() {
    	System.out.println("got to HexNumSet");
        for (Point p : points) {
            p.x = p.x * -1;
        }
        /*
         * for (int i = 0; i < 6; i++) { int temp = squares[i].x; temp = temp *
         * (-1); squares[i].x = temp; }
         */
    }

    public void flipVertically() {
        for (Point p : points) {
            p.y = p.y * -1;
        }
    }

    public void rotateC() {
        for (Point p : points) {
            int newX;
            int newY;

            // Perform rotation, Matrix is
            // [0 1]
            // [-1 0]
            newX = p.y;
            newY = p.x * -1;

            // set new location
           	p.move(newX, newY);
        }
    }

    public void rotateCC() {
        rotateC();
        rotateC();
        rotateC();
    }

}
