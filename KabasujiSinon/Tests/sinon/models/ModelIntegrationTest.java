package sinon.models;

import static org.junit.Assert.fail;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

import sinon.models.data.LevelType.Types;
import sinon.moves.MoveToBoardFromBullpen;

public class ModelIntegrationTest {

	BullPen bullpen;
	Hexomino hex1;
	Hexomino hex2;
	Hexomino hex3;
	Hexomino hex4;
	Hexomino hex5;
	Hexomino hex6;
	MoveToBoardFromBullpen move1;
	MoveToBoardFromBullpen move2;
	MoveToBoardFromBullpen move3;
	MoveToBoardFromBullpen move4;
	MoveToBoardFromBullpen move5;
	Board board;

	
	public ModelIntegrationTest() {
		constructHexominos();
		initializeBullpen();
		initializeBoard();
	}
	
	void initializeBullpen() {
		ArrayList<Hexomino> hexList = new ArrayList<Hexomino>();
		assert hex1 != null;
		hexList.add(hex1);
		hexList.add(hex2);
		hexList.add(hex3);
		hexList.add(hex4);
		hexList.add(hex5);
		hexList.add(hex6);
		this.bullpen = new BullPen(hexList);
	}

	void constructHexominos() {
		HexominoNumberSet hexset1 = NumberSetFactory.getByNumbers(0, 0, 1, 0, 0, 1, 1, 1, -1, 1, 0, 2);
		hex1 = new Hexomino(hexset1);
		hex2 = new Hexomino(hexset1);
		hex3 = new Hexomino(hexset1);
		hex1.flipVertically();
		hex2.rotateC();
		hex4 = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 1, 0, 2, 0, 3, 0, 1, 1, 1, 2));
		hex4.flipVertically();

		hex5 = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 1, 0, 2, 0, 2, 1, 3, 0, 4, 0));
		hex6 = new Hexomino(NumberSetFactory.getByNumbers(0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0));
	}

	

	void initializeBoard() {
		Board b = new Board();

		
		// Now set the top left box to be playable.
		// it's a 9x4 box that's supposed to be playable.
		Point topLeft1 = new Point(9, 0);
		Point bottomRight1 = new Point(11, 11);
		Point topLeft2 = new Point(0, 4);
		Point bottomRight2 = new Point(11, 11);
		
		b.setUnplayableRectangle(topLeft1, bottomRight1);
		b.setUnplayableRectangle(topLeft2, bottomRight2);

		b.getTile(new Point(0, 0)).setPlayable(false);
		b.getTile(new Point(0, 2)).setPlayable(false);
		b.getTile(new Point(0, 3)).setPlayable(false);
		b.getTile(new Point(7, 3)).setPlayable(false);
		b.getTile(new Point(8, 2)).setPlayable(false);
		b.getTile(new Point(8, 3)).setPlayable(false);
		
		this.board = b;
	}
	
	Board getBoard() {
		return this.board;
	}
	
	BullPen getBullpen() {
		return this.bullpen;
	}

}
