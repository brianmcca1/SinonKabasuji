package sinon.models;

import java.util.ArrayList;

/**
 * Entity Class which represents the 12x12 area of game play.
 *
 * @author Josh Desmond
 * @author Brian
 * 
 **/
public class Board {

    private final static int WIDTH = 12;
    private final static int HEIGHT = 12;
    private final static int WIDTH_BY_ZERO = WIDTH - 1;
    private final static int HEIGHT_BY_ZERO = HEIGHT - 1;

    // TODO this should be changed to either a double array
    ArrayList<Tile> tiles;

    @Deprecated
    public Board(ArrayList<Tile> tiles) {
        // TODO this is a pretty lame way of making a Board. Let's make an
        // actual constructor with some logic in this class.
        // If there are test cases that need a constructor like this I guess
        // it's okay though.
        this.tiles = tiles;
    }

    public void addPiece(Hexomino piece) {

        /*
         * This code is pretty unusable. for (int i = 0; i < 6; i++) { int
         * deltaX = piece.squares[i].x; int deltaY = piece.squares[i].y;
         * 
         * int row = piece.anchorRow + deltaX; int column = piece.anchorColumn +
         * deltaY;
         * 
         * Tile t = this.getTile(row, column); }
         */
    }

    public boolean hasHex(int row, int column) {
        return getTile(row, column).hasHex();
    }

    /**
     * Determines whether it's possible to add a Hexomino at the given location.
     * 
     * @param hex
     *            The Hexomino to be added
     * @param anchorRow
     *            The row number where the anchor square will go
     * @param anchorColumn
     *            The column number where the anchor square will go
     * @return True if the move if possible, false otherwise.
     */
    public boolean canAddHexomino(Hexomino hex, int anchorRow,
            int anchorColumn) {
        return false;
    }

    /**
     * Adds the given Hexomino to the board. Must be a valid move.
     * 
     * @param hex
     *            The Hexomino to be added
     * @param anchorRow
     *            The row number where the anchor square will go
     * @param anchorColumn
     *            The column number where the anchor square will go
     * 
     */
    public void addHexomino(Hexomino hex, int anchorRow, int anchorColumn) {
        // TODO
    }

    /**
     * Gets the Tile at the specified position
     * 
     * @param row
     * @param column
     * @return The Tile found.
     */
    public Tile getTile(int row, int column) {
        // TODO
        return null;
    }

    /**
     * Returns whether given row and column are in bounds in the existing game
     * region. I.E. if the given row and column are outside of the 12 by 12
     * grid, this will return false.
     * 
     * Note this has nothing to do with whether a tile is playable or not.
     * 
     * @param row
     * @param column
     * @return True if the location is in bounds
     */
    private boolean isInBounds(int row, int column) {
        if (row > HEIGHT_BY_ZERO || row > WIDTH_BY_ZERO) {
            return false;
        }

        if (row < 0 || column < 0) {
            return false;
        }

        else
            return true;
    }

    public void removeHexomino(Hexomino hex) {

        for (Tile t : tiles) {
            if (t.getHexomino().isPresent()) {
                if (t.getHexomino().get() == hex) {
                    t.removeHex();
                }
            }
        }

    }

    // TODO equals and hash

}
