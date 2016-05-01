package sinon.moves;

import sinon.models.Hexomino;

/**
 * Move class for rotating the hexomino counter clockwise.
 * 
 * @author kartik
 *
 */
public class RotateHexominoCounterClockwiseMove extends BullPenMove {

    public RotateHexominoCounterClockwiseMove(Hexomino hex) {
        if (hex == null) {
            throw new NullPointerException();
        }
        this.hex = hex;
    }

    @Override
    public boolean doMove() {
        if (hex == null) {
            return false;
            // For testing
            // throw new NullPointerException();
        }

        hex.rotateCC();
        return true;

    }

    @Override
    public boolean undo() {
        if (hex == null) {
            return false;
            // For testing
            // throw new NullPointerException();
        }

        hex.rotateC();
        return true;
    }

}
