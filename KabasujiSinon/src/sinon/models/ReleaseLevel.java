package sinon.models;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import sinon.models.data.BullPenData;
import sinon.models.data.LevelType.Types;

/**
 * This is the model class that extends the main level class. It encapsulates
 * the attributes and behaviors that are exclusive to the release level.
 *
 */
public class ReleaseLevel extends Level {

	Optional<ReleaseNumber> selectedReleaseNumber = Optional.empty();
	List<ReleaseNumber> releaseSets;

	/**
	 * Contructs a new Release level with the given parameters.
	 * @param b the board to be added.
	 * @param bp the bullpen to be added.
	 * @param releaseSets the release sets to be added.
	 */
	
	public ReleaseLevel(Board b, BullPen bp, List<ReleaseNumber> releaseSets) {
		super(Types.RELEASE, b, bp);
		this.releaseSets = releaseSets;
		((ReleaseBoard) this.getBoard()).addReleaseSet(this.releaseSets);
	}

	/**
	 * Constructs a new release level with a given level's data.
	 * @param level the level being converted into a release level.
	 */
	
	public ReleaseLevel(Level level) {
		super(Types.RELEASE, level.getBoard(), level.getBullpen());
		this.levelData = level.getLevelData();
		this.releaseSets = level.getLevelData().getLevelProperty().getReleaseSet();
		((ReleaseBoard) this.getBoard()).addReleaseSet(this.releaseSets);
	}

	/**
	 * @return An example release level, with the default board and an empty.
	 *         bullpen and ReleaseNumbers list.
	 */
	public static ReleaseLevel getExampleReleaseLevel() {
		ReleaseBoard board = new ReleaseBoard();
		BullPen bullpen = new BullPen(new BullPenData());
		ArrayList<ReleaseNumber> releaseNumbers = new ArrayList<ReleaseNumber>();
		return new ReleaseLevel(board, bullpen, releaseNumbers);
	}

	@Override
	public int countStars() {
		int starCount = 0;

		// Create a list of the three colors.
		List<Color> color = new LinkedList<Color>();
		color.add(Color.RED);
		color.add(Color.YELLOW);
		color.add(Color.GREEN);

		// For each of of the three colors.
		for (Color c : color) {
			List<ReleaseNumber> compList = getNumberSetForComparison(c);
			assert compList.size() == 6;
			for (ReleaseNumber r : this.releaseSets) {
				if (r.isCollected()) {
					// Remove from the comparison list the number if it's
					// collected.
					compList.remove(r);
				}
			}

			// If all six numbers were removed, then you have a color.
			if (compList.size() == 0) {
				starCount++;
			}
		}

		assert starCount <= 3;
		return starCount;
	}

	/**
	 * Retrieves a set of six ReleaseNumbers 1-6 for the given color.
	 * 
	 * @param color
	 *            The color of the release set.
	 * @return
	 */
	private List<ReleaseNumber> getNumberSetForComparison(Color color) {
		List<ReleaseNumber> list = new LinkedList<ReleaseNumber>();
		for (int i = 1; i <= 6; i++) {
			list.add(new ReleaseNumber(color, i));
		}

		return list;
	}

	/**
	 * Collect the ReleaseNumber at a specific location.
	 * 
	 * @param location
	 *            The location of the tile to collect.
	 */
	public void collectReleaseSet(Point location) {
		for (ReleaseNumber r : this.releaseSets) {
			if (r.getLocation().equals(location)) {
				r.collect();
			}
		}
	}

	/**
	 * @return True if the level has a ReleaseNumber selected, False otherwise.
	 */
	public boolean hasSelectedReleaseNumber() {
		return this.selectedReleaseNumber.isPresent();
	}

	/**
	 * Select a ReleaseNumber.
	 * 
	 * @param releaseNumber
	 *            The ReleaseNumber to select.
	 */
	public void selectReleaseNumber(ReleaseNumber releaseNumber) {
		this.selectedReleaseNumber = Optional.of(releaseNumber);
	}

	/**
	 * Deselects the currently selected ReleaseNumber.
	 */
	public void deselectReleaseNumber() {
		this.selectedReleaseNumber = Optional.empty();
	}

	/**
	 * @return The ReleaseNumber currently selected.
	 */
	public ReleaseNumber getSelectedReleaseNumber() {
		return this.selectedReleaseNumber.get();
	}

	/**
	 * @return The list of Collected Release Numbers.
	 */
	public List<ReleaseNumber> collectedReleaseNumbers() {
		ArrayList<ReleaseNumber> collectedReleaseNumbers = new ArrayList<ReleaseNumber>();
		for (ReleaseNumber r : this.releaseSets) {
			if (r.collected) {
				collectedReleaseNumbers.add(r);
			}
		}

		return collectedReleaseNumbers;
	}

	@Override
	public boolean incrementMoves() {
		return false;
	}

}
