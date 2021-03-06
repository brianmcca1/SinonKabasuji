package sinon.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import sinon.models.data.BullPenData;
import sinon.models.data.HexominoBankData;
import sinon.models.data.HexominoCode;
import sinon.views.Observer;

/**
 * A BullPen is the game entity which stores all Hexominos in the Bullpen.
 * 
 *
 */
public class BullPen implements Observable {

	/** ArrayList of all the hexominos that will be in this level's bullpen. */
	List<Hexomino> pieces;
	/** The observer which is observing this Observable object. */
	Optional<Observer> observer;

	/**
	 * Creates a Bullpen containing the given pieces.
	 * 
	 * @param pieces
	 *            The Hexominos the Bullpen will contain.
	 */
	public BullPen(List<Hexomino> pieces) {
		this.pieces = pieces;
		this.observer = Optional.empty();
	}

	/**
	 * Creates a Bullpen from the given BullpenData.
	 * 
	 * @param bullPenData
	 *            The BullpenData to create the Bullpen from.
	 */
	public BullPen(BullPenData bullPenData) {
		pieces = new LinkedList<Hexomino>();
		for (HexominoCode code : bullPenData.getHexominos()) {
			pieces.add(new Hexomino(code));
		}
		this.observer = Optional.empty();
	}

	/**
	 * Getter that returns a copy of all the hexominos in the bullpen.
	 * 
	 * @return List of all Hexominos.
	 */
	public List<Hexomino> getPieces() {

		ArrayList<Hexomino> piecesCopy = new ArrayList<Hexomino>();
		for (Hexomino h : this.pieces) {
			piecesCopy.add(h);
		}
		return piecesCopy;
	}

	/**
	 * Appends the given Hexomino to the end of the BullPen.
	 * 
	 * @param hex
	 *            Hexomino to be added.
	 */
	public void addHexomino(Hexomino hex) {
		if (hex == null) {
			throw new IllegalArgumentException("Can't add null to Bullpen");
		}
		pieces.add(hex);
		update();
	}

	/**
	 * Removes the first occurrence of the specified element from this list, if
	 * it is present.
	 * 
	 * @param hex
	 *            Hexomino to be removed.
	 * @return True if this list contained the specified element.
	 */
	public boolean removeHexomino(Hexomino hex) {
		boolean b = this.pieces.remove(hex);
		update();
		return b;
	}

	/**
	 * Creates a new hexomino based on {@link HexominoBankData}'s list of
	 * Hexominos.
	 */
	public void addRandomHexomino() {
		Random randomGenerator = new Random();
		Hexomino hex;
		ArrayList<Hexomino> hexominos = (ArrayList<Hexomino>) HexominoBankData.getHexominos();
		int index = randomGenerator.nextInt(hexominos.size());
		hex = hexominos.get(index);
		this.addHexomino(hex);

		update();
	}

	/**
	 * Gives the number of Hexominos in the bullpen.
	 * 
	 * @return The number of Hexominos.
	 */
	public int hexominoCount() {
		return this.pieces.size();
	}

	/**
	 * Determines if any hexomino with the passed in ID exists in the bullpen.
	 * @param id ID of hexomino.
	 * @return id whether or not this Bullpen contains the hexomino.
	 */
	public boolean containsHexID(UUID id) {

		for (Hexomino hex : this.pieces) {
			if (hex.getID().equals(id)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String toString() {
		return "BullPen [pieces=" + pieces + "]";
	}

	/**
	 * Searches through this bullpen looking for the hexomino hex.
	 * 
	 * @param hex
	 *            the Hexomino being searched for
	 * @return True if the hexomino is in this bullpen, otherwise false.
	 */

	public boolean hasHex(Hexomino hex) {
		Objects.requireNonNull(hex);
		return this.containsHexID(hex.id);
	}

	@Override
	public void registerObserver(Observer observer) {
		this.observer = Optional.of(observer);
	}

	@Override
	public void update() {
		validateState();

		if (this.observer.isPresent()) {
			this.observer.get().updated();
		}

	}

	/**
	 * Ensures that there are no duplicate Hexominos in the bullpen.
	 * 
	 * Note: Duplicate Hexominos refer to Hexominos with the same ID, NOT
	 * Hexominos that are visually the same.
	 * 
	 */
	private void validateState() {
		for (Hexomino h : this.getPieces()) {
			int freq = Collections.frequency(this.getPieces(), h);
			if (freq > 1) {
				throw new IllegalStateException("There are duplicate Hexominos in the bullpen");
			}
		}
	}

}
