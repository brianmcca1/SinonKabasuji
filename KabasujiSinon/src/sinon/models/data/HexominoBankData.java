package sinon.models.data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import sinon.models.Hexomino;
import sinon.models.NumberSetFactory;

/**
 * This is the master class which is in charge of getting all 35 of the default
 * Hexominos.
 * 
 * The only method of interest is {@link #getHexmonios()}, which returns a list
 * of all the Hexominos.
 * 
 * @author Josh Desmond
 */
public class HexominoBankData {

	/**
	 * Reads from disk all of the stored Hexominos and builds Hexomino Objects
	 * for use when populating the BankView or other things.
	 * 
	 * @return List of all Hexominos.
	 */
	public static List<Hexomino> getHexominos() {
		return createHexominos();
	}

	private static List<Hexomino> createHexominos() {
		ArrayList<Hexomino> hexList = new ArrayList<Hexomino>();

		List<int[]> list = new LinkedList<int[]>();
		list.add(new int[] { 0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5 });
		list.add(new int[] { 0, 0, 1, 0, 0, 1, 0, 2, 0, 3, 0, 4 });
		list.add(new int[] { 0, 0, 0, 1, 1, 1, 0, 2, 0, 3, 0, 4 });
		list.add(new int[] { 0, 0, 0, 1, 0, 2, 1, 2, 0, 3, 0, 4 });
		list.add(new int[] { 0, 0, 0, 1, -1, 1, -1, 2, -1, 3, -1, 4 });
		list.add(new int[] { 0, 0, 0, 1, 1, 0, 1, 1, 0, 2, 0, 3 });
		list.add(new int[] { 0, 0, 1, 0, 0, 1, 0, 2, 1, 2, 0, 3 });
		list.add(new int[] { 0, 0, 1, 0, 0, 1, 0, 2, 0, 3, 1, 3 });
		list.add(new int[] { 0, 0, 0, 1, 1, 1, 0, 2, 1, 2, 0, 3 });
		list.add(new int[] { 0, 0, 0, 1, 0, 2, 0, 3, 1, 0, 2, 0 });
		list.add(new int[] { 0, 0, 0, 1, 1, 1, 2, 1, 0, 2, 0, 3 });
		list.add(new int[] { 0, 0, 1, 0, 2, 0, 1, 1, 1, 2, 1, 3 });
		list.add(new int[] { 0, 0, 1, 0, 0, 1, -1, 1, 0, 2, 0, 3 });
		list.add(new int[] { 0, 0, 1, 0, 0, 1, 0, 2, -1, 2, 0, 3 });
		list.add(new int[] { 0, 0, 1, 0, 0, 1, 0, 2, 0, 3, -1, 3 });
		list.add(new int[] { 0, 0, 0, 1, 1, 1, 0, 2, -1, 2, 0, 3 });
		list.add(new int[] { 0, 0, 0, 1, 1, 1, -1, 1, 0, 2, 0, 3 });
		list.add(new int[] { 0, 0, 1, 0, 1, -1, 2, 0, 0, 1, 0, 2 });
		list.add(new int[] { 0, 0, 1, 0, 1, -1, 0, 1, 0, 2, 1, 2 });
		list.add(new int[] { 0, 0, 0, 1, 0, 2, -1, 2, -1, 3, -1, 4 });
		list.add(new int[] { 0, 0, 1, 0, 1, -1, 0, 1, 1, 1, 0, 2 });
		list.add(new int[] { 0, 0, 0, 1, 0, 2, 1, 0, 1, 1, 1, 2 });
		list.add(new int[] { 0, 0, 1, 0, 2, 0, 2, -1, 1, 1, 1, 2 });
		list.add(new int[] { 0, 0, 1, 0, 2, 0, 1, 1, 2, 1, 1, 2 });
		list.add(new int[] { 0, 0, 1, 0, 1, -1, 0, 1, -1, 1, 0, 2 });
		list.add(new int[] { 0, 0, 1, 0, 2, 0, 2, -1, 0, 1, 0, 2 });
		list.add(new int[] { 0, 0, 1, 0, 1, -1, 2, -1, 0, 1, 0, 2 });
		list.add(new int[] { 0, 0, 1, 0, 2, 0, 2, 1, 0, 1, 0, 2 });
		list.add(new int[] { 0, 0, 2, 0, 0, 1, 1, 1, 2, 1, 0, 2 });
		list.add(new int[] { 0, 0, 1, 0, 0, 1, 0, 2, -1, 2, -1, 3 });
		list.add(new int[] { 0, 0, 0, 1, 1, 1, 1, 2, 2, 1, 0, 2 });
		list.add(new int[] { 0, 0, 0, 1, 1, 1, 0, 2, 1, 2, 2, 2 });
		list.add(new int[] { 0, 0, 1, 0, 1, -1, 2, 0, 0, 1, 1, 1 });
		list.add(new int[] { 0, 0, 1, 0, 2, 0, 2, -1, 0, 1, 1, 1 });
		list.add(new int[] { 0, 0, 0, 1, -1, 1, -1, 2, -2, 2, -2, 3 });

		// etc
		for (int[] h : list) {
			hexList.add(new Hexomino(NumberSetFactory.getByNumbers(h[0], h[1], h[2], h[3], h[4], h[5], h[6], h[7], h[8],
					h[9], h[10], h[11])));
		}

		return hexList;
	}

}
