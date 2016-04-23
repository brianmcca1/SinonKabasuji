package sinon.models.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import sinon.models.BullPen;
import sinon.models.Hexomino;

/**
 * BullPenData is used for serialization of the Hexominos that are stored in the
 * BullPen.
 * 
 * @author Josh Desmond
 */
public final class BullPenData implements Serializable {
    private static final long serialVersionUID = -8267652387948547852L;

    /**
     * The list of hexominos in the order that they are to appear in the BullPen
     */
    ArrayList<HexominoCode> hexominos;

    /** Creates an empty BullPenData object */
    public BullPenData() {
        hexominos = new ArrayList<HexominoCode>();
    }

    /**
     * Creates a BullPenData from a given BullPen. Use this to store a BullPen
     * offline for later use.
     * 
     * @param bullpen
     */
    public BullPenData(BullPen bullpen) {
        if (bullpen == null) {
            throw new IllegalArgumentException("Bullpen can't be null");
        }

        List<Hexomino> pieces = bullpen.getPieces();
        hexominos = new ArrayList<HexominoCode>(pieces.size());
        for (Hexomino h : pieces) {
            HexominoCode code = new HexominoCode(h);
            hexominos.add(code);
        }
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
