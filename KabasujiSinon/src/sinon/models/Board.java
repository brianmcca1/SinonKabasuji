package sinon.models;

import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import sinon.models.data.BoardData;

/**
 * Entity Class which represents the 12x12 area of game play.
 *
 * @author Josh Desmond
 * @author Brian
 **/
public class Board {

    private final static int WIDTH = 12;
    private final static int HEIGHT = 12;
    private final static int WIDTH_BY_ZERO = WIDTH - 1;
    private final static int HEIGHT_BY_ZERO = HEIGHT - 1;

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
     * Creates a 12 by 12 Board with playability set to match the given
     * BoardData.
     * 
     * @param boardData
     *            BoardData specifying which tiles are playable.
     */
    public Board(BoardData boardData) {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                boolean playable = boardData.getPlayableArray()[x][y];
                Point p = new Point(x, y);
                tilesViaPoints.put(p, new Tile(p, playable));
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
     * @param anchorLocation
     *            Location of where the anchor of the hexomino will go.
     * @param hex
     *            The Hexomino to be added
     * @return True if the move if possible, false otherwise.
     */
    public boolean canAddHexomino(Point anchorLocation, Hexomino hex) {
        boolean canAdd = true;
        HexominoNumberSet hexominoNumberSet = hex.getHexominoNumberSet();
        for (Point p : hexominoNumberSet.getPoints()) {
            Point pointToCheck = new Point(anchorLocation.x + p.x,
                    anchorLocation.y + p.y);
            if (!(this.isInBounds(pointToCheck.x, pointToCheck.y))){
            	return false;
            }
            if (!tilesViaPoints.get(pointToCheck).canAddHex()) {
                canAdd = false;
            }
        }

        return canAdd;
    }

    /**
     * Adds the given Hexomino to the board. Must be a valid move.
     * 
     * @param anchorLocation
     *            Location of where the anchor of the hexomino will go.
     * @param hex
     *            The Hexomino to be added
     * 
     */
    public void addHexomino(Point anchorLocation, Hexomino hex)
             {
       

        HexominoNumberSet hexominoNumberSet = hex.getHexominoNumberSet();
        for (Point p : hexominoNumberSet.getPoints()) {
            Point pointToAdd = new Point(anchorLocation.x + p.x,
                    anchorLocation.y + p.y);
            if (tilesViaPoints.get(pointToAdd).canAddHex()
                    & isInBounds(pointToAdd.x, pointToAdd.y)) {
                tilesViaPoints.get(pointToAdd).addHexomino(hex);
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
        return tilesViaPoints.get(new Point(row, column));
    }

    public Tile getTile(Point p) {
        return tilesViaPoints.get(p);
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
     * 
     * Note that this removes the Hexomino only if it is the exact same
     * instance. If the Hexomino given is .equals() but not ==, it doesn't
     * matter, it won't be removed.
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
     * Gets a iterable of all the tiles.
     * 
     * You can use this any time you want to do some kind of operation on all of
     * the tiles. Please be careful and don't actually edit the tiles with a
     * controller or something unless it's really needed.
     * 
     * Note that these tiles are not in order if you use this method.
     * 
     * @return An iterable of all of the tiles.
     */
    public Iterable<Tile> getTiles() {
        LinkedList<Tile> tempList = new LinkedList<Tile>();
        tilesViaPoints.forEach((k, v) -> tempList.add(v));
        return tempList;
    }

    // TODO equals and hash and ToString

}
