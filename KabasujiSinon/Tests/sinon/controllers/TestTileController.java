package sinon.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Hexomino;
import sinon.models.PuzzleLevel;
import sinon.models.Tile;
import sinon.models.data.BullPenData;
import sinon.views.InfoPanel;
import sinon.views.MainView;
import sinon.views.PuzzleInfoView;
import sinon.views.TileView;

public class TestTileController {

	@Test
	public void testBuilderPuzzle() {
		PuzzleLevel level = new PuzzleLevel(new Board(), new BullPen(new BullPenData()), 10);

		Tile tile1 = level.getBoard().getTile(0, 0);
		Tile tile2 = level.getBoard().getTile(5, 5);
		TileView tileView1 = new TileView(tile1);
		TileView tileView2 = new TileView(tile2);
		InfoPanel infoPanel = new InfoPanel();
		PuzzleInfoView puzzleInfoView = new PuzzleInfoView(true, level);

		Hexomino hex = Hexomino.getExampleHexomino();
		level.getBullpen().addHexomino(hex);
		MainView mainView = new MainView(level, infoPanel, puzzleInfoView);
		BuilderTileController tileController1 = new BuilderTileController(level, tileView1, mainView);
		BuilderTileController tileController2 = new BuilderTileController(level, tileView2, mainView);
		level.select(hex);
		assertTrue(level.hasSelected());
		tileController1.handleLeftClick();
		assertFalse(level.hasSelected());
		assertTrue(tileController1.tile.hasHex());

		level.select(hex);
		assertTrue(level.hasSelected());
		tileController2.handleLeftClick();
		assertFalse(level.hasSelected());
		assertTrue(tileController2.tile.hasHex());

		tileController2.handleLeftClick();
		assertTrue(level.hasSelected());
		assertEquals(level.getSelectedHexomino().get(), hex);

	}

}
