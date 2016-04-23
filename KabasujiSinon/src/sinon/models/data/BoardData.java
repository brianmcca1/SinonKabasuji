package sinon.models.data;

import java.awt.Point;
import java.io.Serializable;
import java.util.Arrays;

import sinon.models.Board;
import sinon.models.Tile;

/**
 * A BoardData contains all the information needed to represent a board offline.
 * 
 * @author Josh Desmond
 *
 */
public final class BoardData implements Serializable {
    private static final long serialVersionUID = -8929440974891572306L;

    /**
     * An array of 144 values each representing whether the tile is playable or
     * not. playable[0] represents (0,0); playable[12] represents (0,1);
     */
    boolean[][] playable;

    /** Length and width of the Board */
    private static final int SIZE = 12;

    /** Creates a new BoardData where all tiles are unplayable */
    public BoardData() {
        playable = new boolean[SIZE][SIZE];
    }

    /**
     * Creates a Board data from an existing Board. Use this to save a Board for
     * offline storage. Note this will only save the playability of tiles and
     * will not store the hint.
     * 
     * @param board
     *            The board to save to disk.
     */
    public BoardData(Board board) {
        if (board == null) {
            throw new IllegalArgumentException("Board can't be null");
        }
        playable = new boolean[SIZE][SIZE];
        for (Tile t : board.getTiles()) {
            Point p = t.getLocation();
            playable[p.x][p.y] = t.isPlayable();
        }
    }

    /**
     * This array should only ever be accessed for the purposes of reading and
     * writing a level to disk.
     */
    public boolean[][] getPlayableArray() {
        return playable;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.deepHashCode(playable);
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof BoardData))
            return false;
        BoardData other = (BoardData) obj;
        if (!Arrays.deepEquals(playable, other.playable))
            return false;
        return true;
    }

}
