package sinon.controllers;

import java.awt.Point;

import org.junit.Test;

import sinon.models.Hexomino;
import sinon.models.Level;
import sinon.models.Tile;
import sinon.models.data.LevelData;
import sinon.models.data.LevelType.Types;
import sinon.views.MainView;
import sinon.views.TileView;

public class TestTileController {

	@Test
	public void testBuilder() {
		Level level = new Level(new LevelData(Types.PUZZLE));
		Tile tile = new Tile(new Point(0, 0), true);
		TileView tileView = new TileView(tile);

		Hexomino hex = Hexomino.getExampleHexomino();
		MainView mainView = new MainView(level, null, null);
		BuilderTileController tileController = new BuilderTileController(level, tileView, mainView);
		level.select(hex);

		// tileController.mousePressed(new MouseEvent(tileController, 0, 0, 0,
		// ));
	}

}
