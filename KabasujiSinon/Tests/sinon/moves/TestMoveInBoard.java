package sinon.moves;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Hexomino;
import sinon.models.Level;
import sinon.models.NumberSetFactory;
import sinon.models.PuzzleLevel;

public class TestMoveInBoard {

	@Test
	public void testBasicMove() {
		Board board = new Board();
		List<Hexomino> hexList = new LinkedList<Hexomino> ();
		BullPen bullpen = new BullPen(hexList);
		Level puzzleLevel = new PuzzleLevel(board, bullpen, 1);
		Hexomino hex = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5));
		board.addHexomino(new Point(1, 1), hex);
		puzzleLevel.select(board.getTile(1, 1).getHexomino().get());
		Move move = new MoveInBoard(puzzleLevel, 1, 1, 2, 2);
		assertTrue(move.doMove());
		assertTrue(board.getTile(2, 2).hasHex());
		assertTrue(move.undo());
		assertFalse(board.getTile(2, 2).hasHex());
		assertTrue(board.getTile(1, 1).hasHex());
	}

}
