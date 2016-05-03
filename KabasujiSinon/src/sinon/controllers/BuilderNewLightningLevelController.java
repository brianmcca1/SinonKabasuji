package sinon.controllers;

import java.awt.event.ActionEvent;

import sinon.main.Builder;
import sinon.models.BullPen;
import sinon.models.LightningBoard;
import sinon.models.LightningLevel;
import sinon.models.data.BullPenData;
import sinon.views.LightningInfoView;
import sinon.views.builder.BuilderMenuBar;

/**
 * This is the controller that is responsible for starting up a new lightning
 * level in the builder.
 *
 */
public class BuilderNewLightningLevelController extends BuilderNewLevelController {

	/** This is the main builder application associated with the controller. */
	private Builder builder;

	/** The menu bar for builder. */
	private BuilderMenuBar builderMenuBar;

	/**
	 * Controller for starting a Lightning Level in the builder.
	 * 
	 * @param b
	 *            The Builder object.
	 * @param bMenuBar
	 *            The Menu Bar that the new level is created from.
	 */
	public BuilderNewLightningLevelController(Builder b, BuilderMenuBar bMenuBar) {
		this.builder = b;
		this.builderMenuBar = bMenuBar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		LightningBoard board = new LightningBoard();
		BullPen bullpen = new BullPen(new BullPenData());
		LightningLevel level = new LightningLevel(board, bullpen, 60);
		this.builder.setLevel(level);
		this.handleNewLevel(this.builder, this.builderMenuBar, new LightningInfoView(true, level));
	}
}
