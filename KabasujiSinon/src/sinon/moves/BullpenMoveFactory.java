package sinon.moves;

import sinon.models.Hexomino;

public class BullpenMoveFactory {



	public static BullPenMove getRotateCMove(Hexomino hex) {
		return new RotateHexominoClockwiseMove(hex);
	}

	public static BullPenMove getRotateCCMove(Hexomino hex) {
		return new RotateHexominoCounterClockwiseMove(hex);
	}

}
