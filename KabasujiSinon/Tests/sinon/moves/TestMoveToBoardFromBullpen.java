package sinon.moves;

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
		Hexomino hex1 = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5));
		hex1.flipVertically();
		Hexomino hex2 = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0));
		hex2.flipHorizontally();

		ArrayList<Hexomino> bpList = new ArrayList<Hexomino>();
		BullPen bullpen = new BullPen(bpList);
		bullpen.addHexomino(hex1);
		bullpen.addHexomino(hex2);

		testLevel = new Level(LevelType.Types.PUZZLE, new Board(), bullpen);
		testLevel.select(hex1);
		mtbfbp1 = new MoveToBoardFromBullpen(testLevel, 11, 0);
		mtbfbp2 = new MoveToBoardFromBullpen(testLevel, 11, 11);
		mtbfbp3 = new MoveToBoardFromBullpen(testLevel, -3, -3);
		mtbfbp6 = new MoveToBoardFromBullpen(testLevel, 0, 11);
		testLevel.select(hex2);
		mtbfbp4 = new MoveToBoardFromBullpen(testLevel, 5, 5);
		mtbfbp7 = new MoveToBoardFromBullpen(testLevel, 11, 0);
		mtbfbp5 = new MoveToBoardFromBullpen(testLevel, 11, 11);

	}

	@Test
	public void testBasicMoves() {

		// A valid move
		assertTrue(mtbfbp1.doMove());
		mtbfbp1.level.select(mtbfbp1.hex.get());
		// You can't make the same move twice
		assertFalse(mtbfbp1.doMove());
		assertTrue(mtbfbp1.undo());
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
		mtbfbp4.hex = Optional.empty();
		assertFalse(mtbfbp4.valid());

	}

	@Test
	public void testBounds() {

		mtbfbp5.hex.get().flipHorizontally();
		mtbfbp5.level.select(mtbfbp5.hex.get());
		mtbfbp2.level.select(mtbfbp2.hex.get());
		assertFalse(mtbfbp2.doMove());
		assertFalse(mtbfbp5.doMove());
		mtbfbp5.hex.get().flipHorizontally();
		assertTrue(mtbfbp7.level.hasSelected());
		assertFalse(mtbfbp7.valid());
		assertFalse(mtbfbp7.doMove());
		assertFalse(mtbfbp6.doMove());
		// can't add to -3, -3
		assertFalse(mtbfbp3.doMove());
	}

}
