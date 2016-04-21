package sinon.models;

import java.util.List;

/**
 * A BullPen is the game entity which stores all Hexominos in the Bullpen.
 * 
 *
 */
public class BullPen {

    /** ArrayList of all the hexominos that will be in this level's bullpen. */
    List<Hexomino> pieces;

    public BullPen(List<Hexomino> pieces) {
        this.pieces = pieces;
    }

    /**
     * Getter that returns a copy of all the hexominos in the bullpen.
     * 
     * @return List of all Hexominos
     */
    public List<Hexomino> getPieces() {
        // FIXME, return a copy, not original. Don't have faith people won't
        // accidentally destroy the list once given it.
        return this.pieces;
    }

    /**
     * Appends the given Hexomino to the end of the BullPen.
     * 
     * @param hex
     *            Hexomino to be added.
     */
    public void addHexomino(Hexomino hex) {
        if (hex == null) {
            throw new IllegalArgumentException("Can't add null to Bullpen");
        }
        pieces.add(hex);
    }

    /**
     * Removes the first occurrence of the specified element from this list, if
     * it is present.
     * 
     * @param hex
     *            Hexomino to be removed.
     * @return True if this list contained the specified element.
     */
    public boolean removeHexomino(Hexomino hex) {
        return this.pieces.remove(hex);
    }

    // FIXME this method is written wrong and is really concerning
    @Deprecated
    public void rotateHexominoClockwise(Hexomino hex) {
        if (this.pieces.contains(hex)) {
            hex.rotateC();
        } else {
            System.err.println("Bullpen does not contain that Hexomino");
        }
    }

    // FIXME this method is written wrong and is really concerning
    @Deprecated
    public void rotateHexominoCounterClockwise(Hexomino hex) {
        if (this.pieces.contains(hex)) {
            hex.rotateCC();
        } else {
            System.err.println("Bullpen does not contain that Hexomino");
        }
    }

    // FIXME this method is written wrong and is really concerning
    @Deprecated
    public void flipHexominoVertical(Hexomino hex) {
        if (this.pieces.contains(hex)) {
            hex.flipVertically();
        } else {
            System.err.println("Bullpen does not contain that Hexomino");
        }

    }

    // FIXME this method is written wrong and is really concerning
    @Deprecated
    public void flipHexominoHorizontal(Hexomino hex) {
        if (this.pieces.contains(hex)) {
            hex.flipHorizontally();
        } else {
            System.err.println("Bullpen does not contain that Hexomino");
        }

    }

    @Override
    public String toString() {
        return "BullPen [pieces=" + pieces + "]";
    }

}
