package sinon.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import sinon.models.data.LevelType.Types;

/**
 * This is the lightning level model class that is responsible for attributes
 * and behaviors that are exclusive to lightning level games such as the maximum
 * time available and the time left.
 *
 */
public class LightningLevel extends Level {

    /** Maximum amount of time allowed, in seconds */
    int maxTime;
    /** Time left, in seconds */
    int timeLeft;

    public LightningLevel(Board b, BullPen bp, int maxTime) {
        super(Types.LIGHTNING, b, bp);
        if (maxTime < 0) {
            throw new IllegalArgumentException(String.format(
                    "The given time %s is not valid as it is negative.",
                    maxTime));
        }
        this.maxTime = maxTime;
        this.timeLeft = maxTime;
    }

    public LightningLevel(Level level) {
        super(Types.LIGHTNING, level.getBoard(), level.getBullpen());
        this.levelData = level.levelData;
        this.maxTime = this.levelData.getLevelProperty().getMaxTime();
        this.timeLeft = this.maxTime;

    }

    @Override
    public int countStars() {
        int numNotPlayed = 0;
        LinkedList<Tile> tiles = (LinkedList<Tile>) this.board.getTiles();
        ArrayList<LightningTile> lightningTiles = new ArrayList<LightningTile>(
                tiles.size());

        for (Tile t : tiles) {
            if (t instanceof LightningTile) {
                LightningTile lightningTile = (LightningTile) t;
                lightningTiles.add(lightningTile);
            } else {
                throw new IllegalArgumentException(
                        "Lightning Level contained a non-Lightning tile");
            }

        }

        for (LightningTile t : lightningTiles) {
            if (!t.lightninged & t.isPlayable()) {
                numNotPlayed++;
            }
        }

        if (numNotPlayed == 0) {
            return 3;
        }

        if (numNotPlayed <= 6) {
            return 2;
        }

        if (numNotPlayed <= 12) {
            return 1;
        }

        return 0;
    }

    @Override
    public boolean hasLost() {
        // You have lost a game if there is no more time remaining.
        int time = getTimeLeft();
        if (time <= 0) {
            return true;
        }

        return false;
    }

    public int getMaxTime() {
        return this.maxTime;
    }

    public int getTimeLeft() {
        if (this.timeLeft < 0) {
            throw new IllegalStateException("Time should never be negative");
        }
        return this.timeLeft;
    }

    /**
     * Decrement the time left by 1 second
     * 
     * @return True if the time was decremented successfully, False if not
     */
    public boolean tickTimeLeft() {
        if (this.timeLeft <= 0) {
            return false;
        }
        this.timeLeft--;
        return true;

    }

    @Override
    public boolean incrementMoves() {
        // TODO what's going on with this. I just noticed this method here and
        // am wondering why this is like, a thing at all. Shouldn't this just
        // not be overriden and not be called? Or like? Hmmm?
        return false;
    }

    /**
     * Creates and returns a new LightningLevel. This method is here for testing
     * purposes only, and is an alternative to the lengthy process of building a
     * board and bullpen.
     * 
     * @return A new LightningLevel with one piece in the bullpen, and 30
     *         seconds of max time.
     */
    public static LightningLevel getExampleLevel() {
        List<Hexomino> hexList = new LinkedList<Hexomino>();
        hexList.add(Hexomino.getExampleHexomino());
        BullPen bp = new BullPen(hexList);
        Board b = new LightningBoard();
        LightningLevel l = new LightningLevel(b, bp, 30);
        return l;
    }

}
