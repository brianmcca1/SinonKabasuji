package sinon.moves;

import sinon.models.Hexomino;

/**
 * Abstract class for moves within the bullpen.
 * 
 * The two main types are rotating and flipping.
 * 
 * @author kartik
 * @author Josh Desmond
 */
public abstract class BullPenMove extends Move {

    /**
     * This is the hexomino that is being rotated.
     */
    Hexomino hex;

    /**
     * Throws a Null Pointer Exception if the hex is null
     */
    public void nullCheck() {
        if (hex == null) {
            throw new NullPointerException();
        }
    }
}
