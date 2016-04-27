package sinon.controllers;

import java.awt.event.MouseListener;

import sinon.main.Builder;
import sinon.models.Level;
import sinon.moves.MoveToBoardFromBullpen;
import sinon.views.MainView;
import sinon.views.TileView;

public class BuilderTileController extends TileController {

    public BuilderTileController(Level level, TileView tileView, MainView mainView) {
    	super(level, tileView, mainView);
    }

    @Override
    public void handleLeftClick() {
		// else if a hexomino had been selected, then add that to the board
		// at row, column
		System.out
		        .println("I AM A TILEVIEW AND I WAS JUST LEFT CLICKED ON");

		int row = tileView.getRow();
		int column = tileView.getColumn();

		MoveToBoardFromBullpen move = new MoveToBoardFromBullpen(level, row,
		        column);

		if (move.doMove()) {
		    System.out.println("Move successfully completed!");
		    level.deselect();
		    System.out.println(level.hasSelected());
		} else {
		    System.out.println("There was some error doing the move.");
		}

		// next we need to update the views
		this.mainView.getBoardView().redrawTiles();
		this.mainView.getBullpenView().redrawBullpenView();
	}

    
	void handleRightClick() {
		System.out
		        .println("I AM A TILEVIEW AND I WAS JUST RIGHT CLICKED ON");
		int row = tileView.getRow();
		int column = tileView.getColumn();

		tileView.toggleColor();
		System.out.println(
		        "PLAYABLE BEFORE: " + tileView.getTile().isPlayable());
		tileView.getTile().setPlayable(!tileView.getTile().isPlayable());
		System.out.println(
		        "PLAYABLE AFTER: " + tileView.getTile().isPlayable());
		this.mainView.getBoardView().redrawTiles();
	}

}
