package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sinon.main.Builder;
import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Level;
import sinon.models.PuzzleLevel;
import sinon.models.data.BullPenData;
import sinon.models.data.LevelType.types;
import sinon.views.PuzzleInfoView;
import sinon.views.builder.BuilderMenuBar;

/**
 * Controller that handles the opening of a new puzzle level in the builder. 
 * 
 *
 */
public class BuilderNewPuzzleLevelController extends BuilderNewLevelController implements ActionListener {

	/** The builder application that this controller is associated with. */
	private Builder builder;
	
	/** The menu bar from which this controller is fired through an option. */
	private BuilderMenuBar builderMenuBar;

	public BuilderNewPuzzleLevelController(Builder b, BuilderMenuBar bMenuBar){
		this.builder = b;
		this.builderMenuBar = bMenuBar;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Board board = new Board();
		BullPen bullpen = new BullPen(new BullPenData());
		PuzzleLevel level = new PuzzleLevel(board, bullpen, 10);
		System.out.println("CREATING NEW PUZZLE LEVEL");
		this.builder.setLevel(level);
		this.handleNewLevel(this.builder, this.builderMenuBar, new PuzzleInfoView(true, level));
	}
}