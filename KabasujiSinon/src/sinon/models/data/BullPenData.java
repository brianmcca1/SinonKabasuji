package sinon.models.data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * BullPenData is used for serialization of the Hexominos that are stored in the
 * BullPen.
 * 
 * @author Josh Desmond
 */
public final class BullPenData implements Serializable {

    /**
     * The list of hexominos in the order that they are to appear in the BullPen
     */
    ArrayList<HexominoCode> hexominos;

    /** Creates an empty BullPenData object */
    public BullPenData() {
        hexominos = new ArrayList<HexominoCode>();
    }

    /**
     * Appends the given HexominoCode to the end of the list of Bullpen
     * Hexomino.
     * 
     * @param hex
     *            The HexominoCode to be added
     */
    void addHexomino(HexominoCode hex) {
        this.hexominos.add(hex);
    }

    /**
     * Returns the ArrayList of HexominoCodes
     * 
     * @return The list of Hexominos.
     */
    public ArrayList<HexominoCode> getHexominos() {
        return this.hexominos;
    }
}
