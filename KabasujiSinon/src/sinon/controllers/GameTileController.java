package sinon.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import sinon.main.Game;
import sinon.models.Board;
import sinon.models.Level;
import sinon.moves.MoveInBoard;
import sinon.moves.MoveToBoardFromBullpen;
import sinon.views.MainView;
import sinon.views.TileView;

/**
 * A TileController is the mouse listener for a TileView.
 * 
 * A TileController is registered to an individual tile and tileView. Each
 * TileController must also be aware of it's current level, so that it can
 * access the board and know the selected piece.
 * 
 * @author Peter Debrine
 * @author Josh Desmond
 */
public class GameTileController extends TileController {

    public GameTileController(Level level, TileView view, MainView mainView) {
        super(level, view, mainView);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        

        // next we need to update the views
        game.getMainView().getBoardView().redrawTiles();
        game.getMainView().getBullpenView().redrawBullpenView();

    }

   

    /** Accesses the board from the fields this class has */
    private Board getBoard() {
        return level.getBoard();
    }

    @Override
    public void handleLeftClick() {
    	System.out.println("I AM A TILE AND I WAS JUST CLICKED ON!");

        if (level.hasSelected()) {

            // we have to determine what kind of move to create
            if (level.getBullpen().getPieces()
                    .contains(level.getSelectedHexomino().get())) {

            }

            if (level.getBullpen()
                    .containsHexID(level.getSelectedHexomino().get().getID())) {
                // else move from bullpen to board
                MoveToBoardFromBullpen move = new MoveToBoardFromBullpen(
                        this.level, this.tileView.getRow(), this.tileView.getColumn());

                if (move.doMove()) {
                    System.out.println("Move successfully completed!");
                    level.deselect();
                } else {
                    System.out.println("There was some error doing the move.");
                }
            }

            else if (level.getBoard() // TODO change to contains.
                    .containsHexID(level.getSelectedHexomino().get().getID())) {
                // then move from board to board
                int x, y;
                x = level.getBoard().getHexominoLocation(
                        level.getSelectedHexomino().get()).x;
                y = level.getBoard().getHexominoLocation(
                        level.getSelectedHexomino().get()).y;
                MoveInBoard move = new MoveInBoard(level, x, y, this.tileView.getRow(),
                        this.tileView.getColumn());

                if (move.doMove()) {
                    System.out.println("The move was successfully completed!");
                    level.deselect();
                } else {
                    System.out.println("The move couldn't be completed!");
                }

            }
        } else {
            if (this.tileView.getTile().hasHex()) {
                level.select(this.tileView.getTile().getHexomino().get());
            }
        }
    }

}
