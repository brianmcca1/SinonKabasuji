package sinon.models;

import java.util.LinkedList;
import java.util.List;

import sinon.models.data.BullPenData;
import sinon.models.data.HexominoCode;

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

    public BullPen(BullPenData bullPenData) {
        pieces = new LinkedList<Hexomino>();
        for (HexominoCode code : bullPenData.getHexominos()) {
            pieces.add(new Hexomino(code));
        }
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


    @Override
    public String toString() {
        return "BullPen [pieces=" + pieces + "]";
    }

}
