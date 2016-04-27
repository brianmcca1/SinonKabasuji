package sinon.moves;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Hexomino;
import sinon.models.Level;
import sinon.models.NumberSetFactory;
import sinon.models.data.LevelType;

public class TestMoveToBoardFromBullpen {

	Level testLevel;
	MoveToBoardFromBullpen mtbfbp1;
	MoveToBoardFromBullpen mtbfbp2;
	MoveToBoardFromBullpen mtbfbp3;
	MoveToBoardFromBullpen mtbfbp4;
	MoveToBoardFromBullpen mtbfbp5;
	MoveToBoardFromBullpen mtbfbp6;
	MoveToBoardFromBullpen mtbfbp7;

	@Before
	public void setUp() {
		NumberSetFactory nsf = new NumberSetFactory();
		Hexomino hex1 = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5));
		hex1.flipVertically();
		Hexomino hex2 = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0));
		hex2.flipHorizontally();

		ArrayList<Hexomino> bpList = new ArrayList<Hexomino>();
		BullPen bullpen = new BullPen(bpList);
		bullpen.addHexomino(hex1);
		bullpen.addHexomino(hex2);

		testLevel = new Level(LevelType.types.PUZZLE, new Board(), new BullPen(bpList));
		testLevel.select(hex1);
		mtbfbp1 = new MoveToBoardFromBullpen(testLevel, 11, 11);
		mtbfbp2 = new MoveToBoardFromBullpen(testLevel, 0, 0);
		mtbfbp3 = new MoveToBoardFromBullpen(testLevel, -3, -3);
		mtbfbp6 = new MoveToBoardFromBullpen(testLevel, 11, 0);
		testLevel.select(hex2);
		mtbfbp4 = new MoveToBoardFromBullpen(testLevel, 5, 5);
		mtbfbp7 = new MoveToBoardFromBullpen(testLevel, 0, 11);
		mtbfbp5 = new MoveToBoardFromBullpen(testLevel, 11, 11);

	}

	@Test
	public void testBasicMoves() {

		// A valid move
		assertTrue(mtbfbp1.doMove());
		mtbfbp1.level.select(mtbfbp1.hex);
		// You can't make the same move twice
		assertFalse(mtbfbp1.doMove());
		// Can't add to the same place
		assertFalse(mtbfbp5.doMove());
		while (mtbfbp4.level.getBullpen().getPieces().size() > 0) {
			mtbfbp4.level.getBullpen().removeHexomino(mtbfbp4.level.getBullpen().getPieces().get(0));
		}
		// Doesn't check if the bullpen has the hex
		assertFalse(mtbfbp4.doMove());
		mtbfbp5.level.deselect();
		// Nothing selected
		assertFalse(mtbfbp5.doMove());

	}

	@Test
	public void testBounds() {

		mtbfbp5.hex.flipHorizontally();
		mtbfbp5.level.select(mtbfbp5.hex);
		fixSelected(mtbfbp2);
		assertFalse(mtbfbp2.doMove());
		assertFalse(mtbfbp5.doMove());
		mtbfbp5.hex.flipHorizontally();
		assertTrue(mtbfbp7.level.hasSelected());
		assertFalse(mtbfbp7.valid());
		assertFalse(mtbfbp7.doMove());
		assertFalse(mtbfbp6.doMove());
		// can't add to -3, -3
		assertFalse(mtbfbp3.doMove());
	}

	@Test
	public void testUndos() {
		// Undoing a valid move
		assertTrue(mtbfbp1.undo());
		// Undo's are not finished, no testing to see if can undo
		// assertFalse(mtbfbp1.undo());
	}

	public void fixSelected(MoveToBoardFromBullpen m) {
		m.level.select(m.hex);
	}

}
