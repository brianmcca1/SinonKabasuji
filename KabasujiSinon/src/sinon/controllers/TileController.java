package sinon.controllers;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import sinon.main.Kabasuji;
import sinon.models.Board;
import sinon.models.Hexomino;
import sinon.models.Tile;
import sinon.views.TileView;

public class TileController implements MouseListener {

    Kabasuji kabasuji;
    TileView view;
    Tile tile;

    public TileController(Kabasuji kabasuji, TileView view, Point point) {
        this.kabasuji = kabasuji;
        this.view = view;
        this.tile = kabasuji.openedLevel.board.getTile(point.x, point.y);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("I AM A TILE AND I WAS JUST CLICKED ON!");
        // The possible outcomes from this event are
        // create a board to board
        // create a bullpen to board
        // select a hexomino
        // or do nothing

        if (kabasuji.hasSelected()) {
            final Hexomino selectedHex = kabasuji.selected.get();

            if (getBoard().canAddHexomino(tile.getLocation(), selectedHex)) {

                getBoard().addHexomino(tile.getLocation(), selectedHex);
            }

            // Else do nothing. TODO maybe one day you could unselect it. for
            // now this is okay.
        }

        else {
            assert (!kabasuji.hasSelected());
            if (tile.hasHex()) {
                kabasuji.select(tile.getHexomino());
            }
        }
    }

    private Board getBoard() {
        return kabasuji.openedLevel.board;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO shadows

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO shadows

    }

}
