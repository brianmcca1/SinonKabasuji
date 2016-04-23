package sinon.models;

import java.awt.Point;

/**
 * The order of points is based on firstthe x coordinate, then the y coordinate.
 * 
 * @author Josh Desmond
 */
public class ComparablePoint extends Point implements Comparable<Point> {
    private static final long serialVersionUID = 7792570492873134990L;

    public ComparablePoint(Point p) {
        super(p.x, p.y);
    }

    public ComparablePoint(int x, int y) {
        super(x, y);
    }

    @Override
    public int compareTo(Point o) {
        if (o.x != this.x) {
            return this.x - o.x;
        }

        assert o.x == this.x;
        return this.y - o.y;
    }

}
