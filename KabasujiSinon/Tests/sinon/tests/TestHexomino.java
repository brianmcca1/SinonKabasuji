package sinon.tests;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Hexomino;
import sinon.models.Hint;
import sinon.models.Shadow;
import sinon.models.Tile;

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
		
		ArrayList<Hexomino> bullPenHexominos = new ArrayList<Hexomino>();
		BullPen bp = new BullPen(bullPenHexominos);
		Hexomino hex = new Hexomino(points, 5, 5);
		
		Hint hint = new Hint(points,2,3);
		Shadow shadow = new Shadow(points,4,4);
		
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		for(int i = 0; i < 12; i++){
			for(int j = 0; j < 12; j++){
				Tile t = new Tile(i, j, true);
				tiles.add(t);
			}
		}
		Board board = new Board(tiles);
		board.getTile(10, 10).setPlayable(false);
		
		assertEquals(board.getTile(12, 12), null);
		
		assertEquals(board.getTile(0, 0).hasHex(), false);
		board.getTile(0, 0).removeHex();
		System.out.println(board.getTile(0, 0).toString());
		
		// These should return with errors
		bp.removeHexomino(hex); 
		bp.rotateHexominoClockwise(hex);
		bp.rotateHexominoCounterClockwise(hex);
		bp.flipHexominoHorizontal(hex);
		bp.flipHexominoVertical(hex); 
		

		bp.addHexomino(hex);
		bp.rotateHexominoClockwise(hex);
		
		assertEquals(points[1].x, -1);
		assertEquals(points[5].x, -3);
		assertEquals(points[5].y, -1);
			
		bp.flipHexominoHorizontal(hex);
		assertEquals(points[5].x, 3);
		assertEquals(points[5].y, -1);
	
		bp.flipHexominoVertical(hex);
		assertEquals(points[5].x, 3);
		assertEquals(points[5].y, 1);
		
		bp.rotateHexominoCounterClockwise(hex);
		assertEquals(points[5].x, -1);
		assertEquals(points[5].y, 3);
		
		board.addPiece(hex);
		
		board.addPiece(hint);
		board.addPiece(shadow);
		
		Tile tile = board.getTile(5, 5);
		Tile tile2 = board.getTile(2, 3);
		Tile tile3 = board.getTile(4, 4);
		
		assertEquals(tile.getHexomino(), hex);
		assertEquals(tile.hasHex(), true);
		assertEquals(tile2.getHint(), hint);
		assertEquals(tile3.getShadow(), shadow);
		
		tile = board.getTile(4, 8);
		assertEquals(tile.getHexomino(), hex);
		
		
		board.removeHexomino(hex);
		
		assertEquals(tile.getHexomino(), null);
		
		bp.removeHexomino(hex);
		
	}

}
