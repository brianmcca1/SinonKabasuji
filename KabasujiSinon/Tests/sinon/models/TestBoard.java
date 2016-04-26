package sinon.models;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class TestBoard {
/*
	// TODO: test constructor with BoardData
	@Test
	public void testAddHex() {
		Hexomino hex = new Hexomino(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 1, 4);
		Board board = new Board();
		assertFalse(board.hasHex(1, 1));
		assertTrue(board.canAddHexomino(new Point(1, 1), hex));
		board.addHexomino(new Point(1, 1), hex);
		assertTrue(board.hasHex(1, 1));
		assertFalse(board.canAddHexomino(new Point(1, 1), hex));
		board.removeHexomino(hex);
		assertFalse(board.hasHex(1, 1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidAdd(){
		Hexomino hex = new Hexomino(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 1, 4);
		Board board = new Board();
		board.addHexomino(new Point(0, 0), hex);
		board.addHexomino(new Point(0, 1), hex);
		
	}
	*/
	@Test
	public void testHasHex(){
		Board b = new Board();
		Hexomino hex = new Hexomino(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 1, 4);
		b.addHexomino(new Point(0, 0), hex);
		assertTrue(b.hasHex(hex));
	}

}
