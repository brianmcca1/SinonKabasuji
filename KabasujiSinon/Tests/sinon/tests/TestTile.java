package sinon.tests;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import sinon.models.Board;
import sinon.models.Hexomino;
import sinon.models.Tile;

public class TestTile {

	@Test
	public void test() {
		Point p = new Point(0,0);
		Tile t1 = new Tile(p, true);
		
		//Hexomino hex = new Hexomino(0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 1);
		//Optional<Hexomino> hex = t1.getHexomino();

		//assertEquals(hex.isPresent(), false);
		
		Hexomino hex2 = new Hexomino(0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 1);
		t1.addHexomino(hex2);
		assertEquals(t1.getHexomino(), hex2);
		
	
	}

}
