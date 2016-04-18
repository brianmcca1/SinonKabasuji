package sinon.tests;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import sinon.models.Hexomino;

public class HexominoTest {

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * 
	 * @return {[0,0],[0,1],[0,2],[0,3],[0,4],[1,4]}
	 */
	private static Hexomino buildExampleHexomino() {
		Point[] points = new Point[6];
		points[0] = new Point(0, 0);
		points[1] = new Point(0, 1);
		points[2] = new Point(0, 2);
		points[3] = new Point(0, 3);
		points[4] = new Point(0, 4);
		points[5] = new Point(1, 4);
		System.out.println(new Hexomino(points));
		return new Hexomino(points);
	}

	@Test
	public void test() {
		Hexomino hex = buildExampleHexomino();
		hex.flipHorizontally();


	}

}
