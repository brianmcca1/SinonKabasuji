package sinon.models;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import sinon.models.data.LevelType.Types;

public class TestLevel {

	@Test
	public void testNewLevel() {
		Board board = new Board();
		ArrayList<Hexomino> pieces = new ArrayList<Hexomino>();
		BullPen bullpen = new BullPen(pieces);
		Level level = new Level(Types.PUZZLE, board, bullpen);
		Hexomino hex = new Hexomino(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 1, 4);
		bullpen.addHexomino(hex);
		
		assertEquals(level.getBoard(), board);
		assertEquals(level.getBullpen(), bullpen);
		
		level.select(hex);
		assertTrue(level.hasSelected());
		
		level.deselect();
		assertFalse(level.hasSelected());
		
		// These should never be called
		assertFalse(level.hasWon());
		assertEquals(level.countStars(), 0);
		
	}

}
