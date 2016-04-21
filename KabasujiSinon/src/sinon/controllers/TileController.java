package sinon.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import sinon.models.Board;
import sinon.models.Hexomino;
import sinon.models.Level;
import sinon.models.Tile;
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
public class TileController implements MouseListener, MouseMotionListener {

    Level level;
    TileView view;
    Tile tile;

    public TileController(Level level, TileView view, Tile tile) {
        this.level = level;
        this.view = view;
        this.tile = tile;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("I AM A TILE AND I WAS JUST CLICKED ON!");

        if (level.hasSelected()) {
            final Hexomino selectedHex = level.selected.get();

            if (getBoard().canAddHexomino(tile.getLocation(), selectedHex)) {

                getBoard().addHexomino(tile.getLocation(), selectedHex);
            }

            // Else do nothing. TODO maybe one day you could unselect it. for
            // now this is okay.
        }

        else {
            assert (!level.hasSelected());
            if (tile.hasHex()) {
                level.select(tile.getHexomino());
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO handle shadows.
    }

    /** Accesses the board from the fields this class has */
    private Board getBoard() {
        return level.board;
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
