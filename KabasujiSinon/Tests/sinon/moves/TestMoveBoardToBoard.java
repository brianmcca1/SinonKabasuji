package sinon.moves;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Hexomino;
import sinon.models.Level;
import sinon.models.NumberSetFactory;
import sinon.models.data.LevelType;

public class TestMoveBoardToBoard {
	Level testLevel;
	MoveInBoard mib1;
	MoveInBoard mib2;
	MoveInBoard mib3;
	MoveInBoard mib4;
	MoveInBoard mib5;
	

	@Before
	public void setUp() {
		Hexomino hex1 = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5));
		hex1.flipVertically();
		Hexomino hex2 = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0));
		hex2.flipHorizontally();

		ArrayList<Hexomino> bpList = new ArrayList<Hexomino>();
		BullPen bullpen = new BullPen(bpList);

		testLevel = new Level(LevelType.types.PUZZLE, new Board(), bullpen);
		testLevel.getBoard().addHexomino(new Point(11, 11), hex1);
		testLevel.getBoard().addHexomino(new Point(7, 7), hex2);
		
		testLevel.select(hex1);
		mib1 = new MoveInBoard(testLevel, 11, 11, 10, 10);
		mib2 = new MoveInBoard(testLevel, 0, 0, 11, 11);
		mib3 = new MoveInBoard(testLevel, -3, -3, 5, 5);
		mib4 = new MoveInBoard(testLevel, 11, 0, 5, 5);
		testLevel.select(hex2);
		mib5 = new MoveInBoard(testLevel, 5, 5, 5, 5);

	}
	
	@Test
	public void testBasicMove(){
		assertTrue(mib1.doMove());
		assertFalse(mib5.doMove());
		assertFalse(mib3.doMove());
		
	}
	
	@Test
	public void testUndo(){
		assertTrue(mib1.undo());
		assertTrue(mib5.undo());
	}
}
