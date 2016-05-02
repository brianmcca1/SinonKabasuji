package sinon.moves;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Hexomino;
import sinon.models.Hint;
import sinon.models.Level;
import sinon.models.NumberSetFactory;
import sinon.models.PuzzleLevel;

public class TestAddHint {

	@Test
	public void testBasicHint() {
		Board board = new Board() ;
		List<Hexomino> hexList = new LinkedList<Hexomino> ();
		BullPen bullpen = new BullPen(hexList);
		Level puzzleLevel = new PuzzleLevel(board, bullpen, 1);
		Hexomino hex1 = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5));
		Hint firstHint = new Hint(hex1, new Point(0, 0));
		Move AddHint = new AddHint(puzzleLevel, firstHint);
		AddHint.doMove();
		assertEquals(board.getHints().get(0), firstHint);
		AddHint.undo();
		assertEquals(board.getHints().size(), 0);
	}
}
