package sinon.models;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

public class TestLightingLevel {

	@Test
	public void testHasWon() {
		ArrayList<Hexomino> bpList = new ArrayList<Hexomino>();
		Hexomino hex1 = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5));
		Hexomino hex2 = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0));
		bpList.add(hex1);
		bpList.add(hex2);
		
		Board b = new Board();
		BullPen bp = new BullPen(bpList);
		LightningLevel level = new LightningLevel(b, bp, 1);
		assertFalse(level.hasWon());
		for(Tile t : level.getBoard().getTiles()){
			t.addHexomino(hex1);
		}
		assertTrue(level.hasWon());
		for (int i = 0; i < 2; i++){
			for (int j = 0; j < 2; j++){
				level.board.getTile(new Point(i ,j)).removeHex();
			}
		}
		assertEquals(level.countStars(), 2);
		for (int i = 2; i < 4; i++){
			for (int j = 2; j < 4; j++){
				level.board.getTile(new Point(i ,j)).removeHex();
			}
		}
		assertEquals(level.countStars(), 1);
	}

}
