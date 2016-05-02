package sinon.models;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import sinon.models.data.BoardData;

public class TestBoard {

	// TODO: test constructor with BoardData
	
	@Test
	public void testBoardData(){
		Board testBoard;
		Board board = new Board();
		board.getTile(new Point(0, 0)).setPlayable(false);
		BoardData data1 = new BoardData(board);
		BoardData data = new BoardData(board);
		testBoard = new Board(data1);
		board.getTile(new Point(1, 0)).setPlayable(false);
		BoardData data2 = new BoardData(board);
		assertFalse(testBoard.getTile(new Point(0, 0)).playable);
		data1.toString();
		assertFalse(data1.equals(data2));
		data1.hashCode();
		BoardData data3 = new BoardData();
		Board testBoard2 = new Board(data3);
		data3.equals(data3);
		for (Tile t : testBoard2.getTiles()){
			assertFalse(t.isPlayable());
		}
		BoardData data5 = null;
		data3.equals(data5);
		data3.equals(board);
		data.equals(data1);
		
		
		
	}
	
	@Test
	public void testAddHex() {
		Hexomino hex = new Hexomino(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 1, 4);
		Hexomino hex1 = new Hexomino(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 1, 4);
		Board board = new Board();
		assertFalse(board.hasHex(1, 1));
		assertTrue(board.canAddHexomino(new Point(1, 1), hex));
		board.addHexomino(new Point(1, 1), hex);
		assertTrue(board.hasHex(1, 1));
		assertTrue(board.canAddHexomino(new Point(1, 1), hex));
		board.removeHexomino(hex);
		assertFalse(board.hasHex(1, 1));
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidAdd(){
		Hexomino hex = new Hexomino(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 1, 4);
		Hexomino hex2 = new Hexomino(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5);
		Board board = new Board();
		board.addHexomino(new Point(0, 0), hex);
		board.addHexomino(new Point(0, 1), hex2);
		
	}
	
	@Test
	public void testHasHex(){
		Board b = new Board();
		Hexomino hex = new Hexomino(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 1, 4);
		b.addHexomino(new Point(0, 0), hex);
		assertTrue(b.hasHex(hex));
	}

}
