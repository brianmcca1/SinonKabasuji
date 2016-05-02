package sinon.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Test;

import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Hexomino;
import sinon.models.PuzzleLevel;
import sinon.models.ReleaseBoard;
import sinon.models.ReleaseLevel;
import sinon.models.ReleaseNumber;
import sinon.models.ReleaseTile;
import sinon.models.Tile;
import sinon.models.data.BullPenData;
import sinon.views.InfoPanel;
import sinon.views.MainView;
import sinon.views.PuzzleInfoView;
import sinon.views.ReleaseInfoView;
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

	@Test
	public void testBuilderRelease() {
		ArrayList<ReleaseNumber> releaseNumbers = new ArrayList<ReleaseNumber>();
		ReleaseLevel level = new ReleaseLevel(new ReleaseBoard(), new BullPen(new BullPenData()), releaseNumbers);
		ReleaseTile tile1 = (ReleaseTile) level.getBoard().getTile(0, 0);
		ReleaseTile tile2 = (ReleaseTile) level.getBoard().getTile(5, 5);

		TileView tileView1 = new TileView(tile1);
		TileView tileView2 = new TileView(tile2);
		InfoPanel infoPanel = new InfoPanel();

		ReleaseInfoView releaseInfoView = new ReleaseInfoView(level);
		Hexomino hex = Hexomino.getExampleHexomino();
		level.getBullpen().addHexomino(hex);
		MainView mainView = new MainView(level, infoPanel, releaseInfoView);
		ReleaseBuilderTileController tileController1 = new ReleaseBuilderTileController(level, tileView1, mainView);
		ReleaseBuilderTileController tileController2 = new ReleaseBuilderTileController(level, tileView2, mainView);
		level.select(hex);
		assertTrue(level.hasSelected());
		tileController1.handleLeftClick();
		assertFalse(level.hasSelected());
		assertTrue(tileController1.tile.hasHex());

		tileController1.handleLeftClick();
		assertTrue(level.hasSelected());
		tileController2.handleLeftClick();
		assertFalse(level.hasSelected());
		assertTrue(tileController2.tile.hasHex());

		ReleaseNumber releaseNumber = new ReleaseNumber(Color.BLUE, 1);
		level.selectReleaseNumber(releaseNumber);
		assertTrue(level.hasSelectedReleaseNumber());
		tileController1.handleLeftClick();

		assertFalse(level.hasSelectedReleaseNumber());
		assertTrue(tile1.hasReleaseNumber());
		assertEquals(tile1.getReleaseNumber().get(), releaseNumber);
	}

	@Test
	public void testGame() {
		PuzzleLevel level = new PuzzleLevel(new Board(), new BullPen(new BullPenData()), 10);
		Tile tile1 = level.getBoard().getTile(0, 0);
		Tile tile2 = level.getBoard().getTile(5, 5);

		TileView tileView1 = new TileView(tile1);
		TileView tileView2 = new TileView(tile2);
		InfoPanel infoPanel = new InfoPanel();

		ReleaseInfoView releaseInfoView = new ReleaseInfoView(level);
		Hexomino hex = Hexomino.getExampleHexomino();
		level.getBullpen().addHexomino(hex);
		MainView mainView = new MainView(level, infoPanel, releaseInfoView);
		GameTileController tileController1 = new GameTileController(level, tileView1, mainView);
		GameTileController tileController2 = new GameTileController(level, tileView2, mainView);

		level.select(hex);
		assertTrue(level.hasSelected());
		tileController1.handleLeftClick();
		assertFalse(level.hasSelected());
		assertTrue(tileController1.tile.hasHex());

		tileController1.handleLeftClick();
		assertTrue(level.hasSelected());
		tileController2.handleLeftClick();
		assertFalse(level.hasSelected());
		assertTrue(tileController2.tile.hasHex());

	}

}
