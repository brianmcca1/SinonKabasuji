package sinon.tests;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.List;

import org.junit.Test;

import sinon.models.Board;
import sinon.models.Hexomino;
import sinon.models.Tile;

public class TestTile {

	@Test
	public void test() {
		Tile t1 = new Tile(0, 0, true);
		
		Point[] points = new Point[6];
		points[0] = new Point();
		points[0].move(0, 0);
		points[1] = new Point();
		points[1].move(0, 1);
		points[2] = new Point();
		points[2].move(1, 1);
		points[3] = new Point();
		points[3].move(1, 2);
		points[4] = new Point();
		points[4].move(2, 2);
		points[5] = new Point();
		points[5].move(2, 1);
		
		Hexomino hex = new Hexomino(points);
		
		t1.addHexomino(hex);
		assertEquals(t1.getHexomino(), hex);
		
	
	}

}
