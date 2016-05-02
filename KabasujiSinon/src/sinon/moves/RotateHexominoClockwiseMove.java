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
        this.hex = hex;
        this.nullCheck();
    }

    @Override
    public boolean doMove() {
    	this.nullCheck();

        hex.rotateC();
        return true;
    }

    @Override
    public boolean undo() {
        this.nullCheck();

        hex.rotateCC();
        return true;
    }

}
