package sinon.moves;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Hexomino;
import sinon.models.Level;
import sinon.models.NumberSetFactory;
import sinon.models.data.LevelType;

public class TestMoveToBullpenFromBoard {
	Level testLevel;
	MoveToBoardFromBullpen moveToBoard1;
	MoveToBoardFromBullpen moveToBoard2;
	MoveToBullpenFromBoard move1;
	MoveToBullpenFromBoard move2;
	MoveToBullpenFromBoard move3;
	MoveToBullpenFromBoard move4;
	MoveToBullpenFromBoard move5;
	MoveToBullpenFromBoard move6;
	MoveToBullpenFromBoard move7;
	Hexomino hex1;

	@Before
	public void setUp() {
		hex1 = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0));

		Hexomino hex2 = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0));
		// hex2.flipHorizontally();

		ArrayList<Hexomino> bpList = new ArrayList<Hexomino>();
		BullPen bullpen = new BullPen(bpList);
		bullpen.addHexomino(hex1);
		bullpen.addHexomino(hex2);

		testLevel = new Level(LevelType.Types.PUZZLE, new Board(), new BullPen(bpList));
		testLevel.select(hex1);
		moveToBoard1 = new MoveToBoardFromBullpen(testLevel, 5, 5);
		testLevel.select(hex2);
		moveToBoard2 = new MoveToBoardFromBullpen(testLevel, 6, 2);

		testLevel.select(hex1);
		move1 = new MoveToBullpenFromBoard(testLevel, 0, 11);
		move2 = new MoveToBullpenFromBoard(testLevel, 6, 2);
		// move3 = new MoveToBullpenFromBoard(testLevel, -3, -3);
		// move4 = new MoveToBullpenFromBoard(testLevel, 11, 0);
		// testLevel.select(hex2);
		// move5 = new MoveToBullpenFromBoard(testLevel, 5, 5);
		// move6 = new MoveToBullpenFromBoard(testLevel, 0, 11);
		// move7 = new MoveToBullpenFromBoard(testLevel, 11, 11);

	}

	@Test
	public void testBasicMove() {

		assertTrue(moveToBoard1.valid());
		// Place the pieces
		assertTrue(moveToBoard1.doMove());
		assertTrue(moveToBoard2.doMove());
		// Bullpen should be empty
		assertEquals(testLevel.getBullpen().hexominoCount(), 0);

		// Remove 1 piece
		assertTrue(move1.doMove());
		// Bullpen should have 1 piece
		assertEquals(testLevel.getBullpen().hexominoCount(), 1);
		// Put it back
		assertTrue(move1.undo());
		// Bullpen should be empty again
		assertEquals(testLevel.getBullpen().hexominoCount(), 0);
		// Board should have piece 
		assertTrue(testLevel.getBoard().hasHex(hex1));
		// Trying to do move 2 should return false, since it's invalid (no hex
		// selected)
		move2.hex = Optional.empty();
		assertFalse(move2.doMove());

	}
	
	@Test
	public void testUndo(){
	}
}
