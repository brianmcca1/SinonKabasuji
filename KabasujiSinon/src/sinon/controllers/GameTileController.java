package sinon.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Optional;

import sinon.main.Game;
import sinon.models.Board;
import sinon.models.Hexomino;
import sinon.models.Level;
import sinon.models.Tile;
import sinon.moves.MoveInBoard;
import sinon.moves.MoveToBoardFromBullpen;
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
public class GameTileController implements MouseListener, MouseMotionListener {

	Game game;
    Level level;
    TileView view;

    public GameTileController(Game game, Level level, TileView view) {
    	this.game = game;
        this.level = level;
        this.view = view;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("I AM A TILE AND I WAS JUST CLICKED ON!");

        if(level.hasSelected()) {
        	
        	//we have to determine what kind of move to create
        	
        	if (level.getBullpen().containsHexID(level.selectedHexomino.get().getID())){
        		//else move from bullpen to board
        		MoveToBoardFromBullpen move = new MoveToBoardFromBullpen(this.level, view.getRow(), view.getColumn());
        		
        		if(move.doMove()){
    				System.out.println("Move successfully completed!");
    				level.selectedHexomino = null;
    			} else {
    				System.out.println("There was some error doing the move.");
    			}
        	} 
        	
        	else if(level.getBoard().containsHexID(level.selectedHexomino.get().getID())) {
        		//then move from board to board
        		int x, y;
            	x = level.getBoard().getHexominoLocation(level.selectedHexomino.get()).x;
            	y = level.getBoard().getHexominoLocation(level.selectedHexomino.get()).y;
            	MoveInBoard move = new MoveInBoard(level, x, y, view.getRow(), view.getColumn());
            	
            	if(move.doMove()) {
            		System.out.println("The move was successfully completed!");
            		level.selectedHexomino = null;
            	} else {
            		System.out.println("The move couldn't be completed!");
            	}

        	} 
        }
       	else {
        	if(view.getTile().hasHex()){
        		level.select(view.getTile().getHexomino().get());
        	}
        }
    	
      //next we need to update the views 
		game.boardView.redrawTiles();
		game.bullpenView.redrawBullpenView();

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO handle shadows.
    }

    /** Accesses the board from the fields this class has */
    private Board getBoard() {
        return level.getBoard();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

}
