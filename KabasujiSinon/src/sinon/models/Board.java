package sinon.models;

import java.util.List;

public class Board {
    /** */
    List<Tile> tiles;

    private final static int WIDTH = 12;
    private final static int HEIGHT = 12;
    private final static int WIDTH_BY_ZERO = WIDTH - 1;
    private final static int HEIGHT_BY_ZERO = HEIGHT - 1;

    /**
     * 
     * @param tiles
     *            The list of initialized tiles.
     */
    Board(List<Tile> tiles) {
        // TODO this is going to need a factory to actually start up a Board and
        // get it going.
        this.tiles = tiles;
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
    public boolean canAddHexomino(AbsPiece hex, int anchorRow,
            int anchorColumn) {
        // TODO
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
     *            * The column number where the anchor square will go
     * 
     */
    public void addHexomino(AbsPiece hex, int anchorRow, int anchorColumn) {
        // FIXME errors are not handled right.
        for (int i = 0; i < 6; i++) {
            int deltaX = hex.squares[i].x;
            int deltaY = hex.squares[i].y;

            int row = anchorRow + deltaX;
            int column = anchorColumn + deltaY;

            Tile t = this.getTile(row, column);
            if (t.playable == true) {
                hex.addToTile(t);
            } else {
                System.err.println("Piece is not playable at that location");
            }

        }
    }

    /**
     * Gets the Tile at the specified position
     * 
     * @param row
     * @param column
     * @return The Tile found.
     */
    public Tile getTile(int row, int column) {
        // FIXME no error checking.
        for (Tile t : tiles) {
            if ((t.row == row) & (t.column == column)) {
                return t;
            }
        }
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

    public void removeHexomino(AbsPiece hex) {

        for (Tile t : tiles) {
            if (t.getHexomino().isPresent()) {
                if (t.getHexomino().get() == hex) {
                    t.removeHex();
                }
            }
        }

    }

    @Override
    public String toString() {
        return "Board [tiles=" + tiles;
    }

    // TODO equals and hash

}
