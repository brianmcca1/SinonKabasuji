package sinon.models;

import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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
    Map<Point, Tile> tilesViaPoints;

    /**
     * Creates a 12 by 12 Board with tiles initialized to all playable tiles.
     */
    public Board() {
        tilesViaPoints = new HashMap<Point, Tile>();
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                Point p = new Point(x, y);
                tilesViaPoints.put(p, new Tile(p, true));
            }
        }
    }

    /**
     * Determines if there is a hexomino at the given position.
     * 
     * @param row
     * @param column
     * @return True if there is a hexomino on this tile
     */
    public boolean hasHex(int row, int column) {
        return getTile(row, column).hasHex();
    }

    /**
     * Determines whether it's possible to add a Hexomino at the given location.
     * 
     * 
     * @param anchorRow
     *            The row number where the anchor square will go
     * @param anchorColumn
     *            The column number where the anchor square will go
     * @param hex
     *            The Hexomino to be added
     * @return True if the move if possible, false otherwise.
     */
    public boolean canAddHexomino(int anchorRow, int anchorColumn,
            Hexomino hex) {
        return false;
    }

    /**
     * Adds the given Hexomino to the board. Must be a valid move.
     * 
     *
     * @param anchorRow
     *            The row number where the anchor square will go
     * @param anchorColumn
     *            The column number where the anchor square will go
     * @param hex
     *            The Hexomino to be added
     * 
     */
    public void addHexomino(int anchorRow, int anchorColumn, Hexomino hex) {
        if (!canAddHexomino(anchorRow, anchorColumn, hex)) {
            throw new IllegalArgumentException("TODO"); // TODO
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
        return tilesViaPoints.get(new Point(row, column));
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
        } else if (row < 0 || column < 0) {
            return false;
        } else
            return true;
    }

    /**
     * Completely removes the specified Hexomino from the board.
     */
    public void removeHexomino(Hexomino hex) {
        for (Tile t : getTiles()) {
            if (t.getHexomino().isPresent()) {
                if (t.getHexomino().get() == hex) { // TODO is this correct
                    t.removeHex();
                }
            }
        }

    }

    /**
     * 
     * @return An iterable of all of the tiles.
     */
    public Iterable<Tile> getTiles() {
        LinkedList<Tile> tempList = new LinkedList<Tile>();
        tilesViaPoints.forEach((k, v) -> tempList.add(v));
        return tempList;
    }

    // TODO equals and hash

}
