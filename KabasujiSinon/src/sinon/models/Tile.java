package sinon.models;

import java.awt.Point;
import java.util.Optional;

public class Tile {

    boolean playable;
    Optional<Hexomino> hex;
    Point location;

    public Tile(Point location, boolean playable) {
        this.playable = playable;
        this.location = location;
        hex = Optional.empty();
    }

    /**
     * Determines if it is possible to add a Hexomino to the given tile
     * 
     * @return True if you can add the hex, False if you cannot
     */
    public boolean canAddHex() {
        if (this.hex.isPresent() || this.playable == false) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 
     * Adds the given Hexomino to the tile Throws Runtime Exception if Hexomino
     * is already present
     * 
     * @param hex
     *            The hexomino to be added
     */
    public void addHexomino(Hexomino hex) {
        if (this.hex.isPresent()) {
            throw new RuntimeException("Tile already contains a Hexomino");

        } else {
            this.hex = Optional.of(hex);
        }
    }

    /**
     * Gets the hexomino currently on this tile
     * 
     * @return The hexomino that is on this tile
     */
    public Optional<Hexomino> getHexomino() {
        return this.hex;
    }

    /**
     * Removes Hexomino from this tile, if there is one Throws Runtime Exception
     * if tile does not contain a Hexomino
     * 
     * 
     */
    public void removeHex() {
        /*
         * TODO not sure if it's cool to be throwing an error here. We could
         * like, return false or true or something instead? What if you just
         * want to clear the board for example, and remove everything off every
         * tile.
         */
        if (this.hex.isPresent()) {
            this.hex = Optional.empty();
        } else {
            throw new RuntimeException("Tile does not contain a Hexomino");
        }
    }

    /**
     * Changes the playability of the tile.
     * 
     * @param bool
     *            True implies making the tile playable.
     */
    public void setPlayable(boolean bool) {
        this.playable = bool;
    }

    /**
     * @return the location
     */
    public Point getLocation() {
        return location;
    }

    /**
     * Determines if the tile currently is occupied by a Hexomino
     * 
     * @return True if the tile is occupied by a Hex, False if not
     */
    public boolean hasHex() {
        return hex.isPresent();
    }
}
