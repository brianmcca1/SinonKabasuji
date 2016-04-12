package sinon.tests;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import sinon.models.Hexomino;

public class TestHexomino {

	@Test
	public void test() {
		Point[] points = new Point[6];
		points[0] = new Point();
		points[0].move(0, 0);
		points[1] = new Point();
		points[1].move(0, -1);
		points[2] = new Point();
		points[2].move(0, -2);
		points[3] = new Point();
		points[3].move(-1, -2);
		points[4] = new Point();
		points[4].move(1, -2);
		points[5] = new Point();
		points[5].move(1, -3);
		
		Hexomino hex = new Hexomino(points, 0, 0);
		
		System.out.println(hex.toString());
		
		hex.rotateC();
		
		assertEquals(points[1].x, -1);
		System.out.println(hex.toString());
		
	}

}
