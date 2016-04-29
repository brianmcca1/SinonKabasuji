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
	PuzzleLevel level;

	
	public ModelIntegrationTest() {
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

	void initializeMoves(Level level) {
		// Move Hexomino 1 to (1, 0)
		this.move1 = new MoveToBoardFromBullpen(level, 2, 2);
		// Move Hexomino 2 to (5, 1)
		this.move2 = new MoveToBoardFromBullpen(level, 5, 1);
		// Move Hexomino 3 to (7, 0)
		this.move3 = new MoveToBoardFromBullpen(level, 7, 0);
		// Move Hexomino 4 to (3, 1)
		this.move4 = new MoveToBoardFromBullpen(level, 3, 1);
		// Move Hexomino 5 to (2, 0)
		this.move5 = new MoveToBoardFromBullpen(level, 2, 0);
	}

	void newPuzzleLevel() {
		Level level = new Level(Types.PUZZLE, this.board, this.bullpen);
		PuzzleLevel puzzleLevel = new PuzzleLevel(level);
		this.level = puzzleLevel;
	}

	public BullPen getBullPen() {
		constructHexominos();
		ArrayList<Hexomino> hexList = new ArrayList<Hexomino>();
		assert hex1 != null;
		hexList.add(hex1);
		hexList.add(hex2);
		hexList.add(hex3);
		hexList.add(hex4);
		hexList.add(hex5);
		hexList.add(hex6);
		return new BullPen(hexList);
	}

	public Board getBoard() {
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

		return b;
	}

}
