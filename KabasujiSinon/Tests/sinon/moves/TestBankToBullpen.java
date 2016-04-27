package sinon.moves;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import sinon.models.BullPen;
import sinon.models.Hexomino;
import sinon.models.NumberSetFactory;

public class TestBankToBullpen {


	@Test
	public void testBasicMove() {
		//make the empty bullpen here
		LinkedList<Hexomino> hexList = new LinkedList<Hexomino> ();
		BullPen bp = new BullPen(hexList);
		
		//this is the hexomino that we need to add
		Hexomino hex1 = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5));
		
		BankToBullpenMove move = new BankToBullpenMove(bp, hex1);
		
		assertTrue(move.doMove());
		assertEquals(bp.getPieces().size(), 1);
		assertTrue(bp.getPieces().contains(hex1));
	}
	
	@Test
	public void testInvalidUndo() {
		//make the empty bullpen here
		LinkedList<Hexomino> hexList = new LinkedList<Hexomino> ();
		BullPen bp = new BullPen(hexList);
		
		//this is the hexomino that we need to add
		Hexomino hex1 = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5));
		
		BankToBullpenMove move = new BankToBullpenMove(bp, hex1);
		
		assertFalse(move.undo());
		assertTrue(move.doMove());
		assertTrue(move.undo());
	}
}
