package sinon.moves;

import sinon.models.Hexomino;

/**
 * Move class for rotating a hexomino clockwise.
 * 
 * @author kartik
 *
 */
public class RotateHexominoClockwiseMove extends BullPenMove {

    public RotateHexominoClockwiseMove(Hexomino hex) {
        this.nullCheck();
        this.hex = hex;
    }

    @Override
    public boolean doMove() {
        if (hex == null) {
            return false;
            // For testing
            // throw new NullPointerException();
        }

        hex.rotateC();
        return true;
    }

    @Override
    public boolean undo() {
        if (hex == null) {
            return false; // for testing
           // this.nullCheck();
        }

        hex.rotateCC();
        return true;
    }

}
