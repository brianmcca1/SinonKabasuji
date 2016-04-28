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
	Hexomino hex1 = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5));
	Hexomino hex2 = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0));
	Hexomino hex3 = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 1, 0, 1, 1, 2, 0, 3, 0, 4, 0));
	

	@Before
	public void setUp() {
		hex1.flipVertically();
		hex2.flipHorizontally();
		hex2.flipHorizontally();

		ArrayList<Hexomino> bpList = new ArrayList<Hexomino>();
		BullPen bullpen = new BullPen(bpList);

		testLevel = new Level(LevelType.types.PUZZLE, new Board(), bullpen);
		testLevel.getBoard().addHexomino(new Point(11, 11), hex1);
		testLevel.getBoard().addHexomino(new Point(3, 3), hex2);
		
		testLevel.select(hex1);
		mib1 = new MoveInBoard(testLevel, 11, 11, 10, 10);
		mib3 = new MoveInBoard(testLevel, -3, -3, 5, 5);
		testLevel.select(hex2);
		mib5 = new MoveInBoard(testLevel, 5, 5, 5, 5);
		testLevel.select(hex2);
		mib4 = new MoveInBoard(testLevel, 11, 0, 3, 5);
		testLevel.select(hex3);
		mib2 = new MoveInBoard(testLevel, 0, 0, 11, 11);
	}
	
	@Test
	public void testBasicMove(){
		// Basic move
		assertTrue(mib1.doMove());
		hex2.flipHorizontally();
		testLevel.select(hex2);
		assertTrue(mib5.doMove());
		testLevel.select(hex2);
		assertFalse(mib3.doMove());
		testLevel.select(hex2);
		assertFalse(mib4.doMove());
		testLevel.select(hex3);
		assertFalse(mib2.doMove());
		mib1.level.getBoard().removeHexomino(mib1.hex);
		assertFalse(mib1.doMove());
		mib1.level.deselect();
		assertFalse(mib1.doMove());
		
		
	}
	
	@Test
	public void testUndo(){
		assertTrue(mib1.undo());
		assertTrue(mib5.undo());
	}
}
