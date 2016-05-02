package sinon.controllers;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Hexomino;
import sinon.models.Level;
import sinon.models.data.BoardData;
import sinon.models.data.LevelType.Types;

public class TestSave {

	@Test
	public void testSave() {
		ArrayList<Hexomino> hexominos = new ArrayList<Hexomino>();
		Hexomino hex = Hexomino.getExampleHexomino();
		hexominos.add(hex);
		Board board = new Board(new BoardData());
		BullPen bullpen = new BullPen(hexominos);

		Level level = new Level(Types.PUZZLE, board, bullpen);
		File file = new File("testsavepuzzle.dat");

		FileHandler.builderSaveLevelToFile(file, level);

	}

}
