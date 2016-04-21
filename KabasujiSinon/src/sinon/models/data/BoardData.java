package sinon.models.data;

import java.io.Serializable;

/**
 * A BoardData contains all the information needed to represent a board offline.
 * 
 * @author Josh Desmond
 *
 */
public final class BoardData implements Serializable {

    /**
     * An array of 144 values each representing whether the tile is playable or
     * not. playable[0] represents (0,0); playable[12] represents (0,1);
     */
    boolean[][] playable;

    /** Creates a new BoardData where all tiles are unplayable */
    public BoardData() {
        playable = new boolean[12][12];
    }

    /**
     * This array should only ever be accessed for the purposes of reading and
     * writing a level to disk.
     */
    public boolean[][] getPlayableArray() {
        return playable;
    }
}
