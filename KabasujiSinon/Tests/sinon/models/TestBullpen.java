package sinon.models;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import sinon.models.data.BullPenData;

public class TestBullpen {

	@Test
	public void testNewBullpen() {
		ArrayList<Hexomino> pieces = new ArrayList<Hexomino>();
		BullPen bullPen = new BullPen(pieces);
		assertEquals(bullPen.hexominoCount(), 0);
		
		Hexomino hexomino = new Hexomino(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 1, 4);
		bullPen.addHexomino(hexomino);
		assertEquals(bullPen.hexominoCount(), 1);
		ArrayList<Hexomino> piecesCopy = new ArrayList<Hexomino>();
		piecesCopy.add(hexomino);
		assertEquals(bullPen.getPieces(), piecesCopy);
	
		bullPen.removeHexomino(hexomino);
		assertEquals(bullPen.hexominoCount(), 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void invalidAddHex(){
		ArrayList<Hexomino> pieces = new ArrayList<Hexomino>();
		BullPen bullpen = new BullPen(pieces);
		
		bullpen.addHexomino(null);
	}
	
	@Test
	public void constructedFromData(){
		ArrayList<Hexomino> pieces = new ArrayList<Hexomino>();
		Hexomino hexomino = new Hexomino(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 1, 4);
		pieces.add(hexomino);
		BullPen bullPen1 = new BullPen(pieces);
		BullPenData bullPenData = new BullPenData(bullPen1);
		BullPen bullPen2 = new BullPen(bullPenData);
		assertEquals(bullPen2.hexominoCount(), 1);
		
	}

}
