package sinon.models.data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * BullPenData is used for serialization of the Hexominos that are stored in the
 * BullPen.
 * 
 * @author Josh Desmond
 */
public class BullPenData implements Serializable {
    private static final long serialVersionUID = -6457296944808697390L;

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
