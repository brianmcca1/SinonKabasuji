package sinon.moves;

import sinon.models.Hexomino;

/**
 * Abstract class for moves within the bullpen.
 * 
 * The two main types are rotating and flipping.
 * @author kartik
 * @author Josh Desmond
 */
public abstract class BullPenMove extends Move {

	/**
	 * This is the hexomino that is being rotated.
	 */
	Hexomino hex;

	/**
	 * TODO
	 */
	
	public void nullCheck() {
		if (hex == null) { // TODO move to super class this logic.
			// https://en.wikipedia.org/wiki/Don%27t_repeat_yourself
			throw new NullPointerException();
		}
	}
}
