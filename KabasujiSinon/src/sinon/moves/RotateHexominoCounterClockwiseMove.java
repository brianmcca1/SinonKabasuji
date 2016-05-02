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
        this.hex = hex;
        this.nullCheck();
    }

    @Override
    public boolean doMove() {
        this.nullCheck();

        hex.rotateCC();
        return true;

    }

    @Override
    public boolean undo() {
       this.nullCheck();

        hex.rotateC();
        return true;
    }

}
