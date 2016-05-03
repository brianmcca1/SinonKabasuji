package sinon.controllers;

import java.awt.event.ActionEvent;

import sinon.main.Builder;
import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.PuzzleLevel;
import sinon.models.data.BullPenData;
import sinon.views.PuzzleInfoView;
import sinon.views.builder.BuilderMenuBar;

/**
 * This is the controller associated with starting up a new puzzle level in the
 * builder.
 *
 */
public class BuilderNewPuzzleLevelController extends BuilderNewLevelController {

	/** The main builder application associated with the puzzle level. */
	private Builder builder;

	/** The menu bar associated with this puzzle level. */
	private BuilderMenuBar builderMenuBar;

	/**
	 * Controller for starting a Puzzle Level in the builder.
	 * 
	 * @param b
	 *            The Builder object.
	 * @param bMenuBar
	 *            The Menu Bar that the new level is created from.
	 */
	public BuilderNewPuzzleLevelController(Builder b, BuilderMenuBar bMenuBar) {
		this.builder = b;
		this.builderMenuBar = bMenuBar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Board board = new Board();
		BullPen bullpen = new BullPen(new BullPenData());
		PuzzleLevel level = new PuzzleLevel(board, bullpen, 10);
		this.builder.setLevel(level);
		this.handleNewLevel(this.builder, this.builderMenuBar, new PuzzleInfoView(true, level));
	}
}