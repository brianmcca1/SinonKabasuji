package sinon.models;

import java.util.ArrayList;
import java.util.LinkedList;

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

        for (int i = 0; i < tiles.size(); i++) {
            lightningTiles.add(((LightningTile) tiles.get(i)));
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
    
    public boolean incrementMoves(){
    	return false;
    }

}
