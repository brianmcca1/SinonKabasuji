package sinon.controllers;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import sinon.main.Builder;
import sinon.models.BullPen;
import sinon.models.ReleaseBoard;
import sinon.models.ReleaseLevel;
import sinon.models.ReleaseNumber;
import sinon.models.data.BullPenData;
import sinon.views.ReleaseInfoView;
import sinon.views.builder.BuilderMenuBar;

/**
 * This is the controller associated with starting a new release level in the
 * builder.
 *
 */
public class BuilderNewReleaseLevelController extends BuilderNewLevelController {

	private Builder builder;

	private BuilderMenuBar builderMenuBar;

	/**
	 * Controller for starting a Release Level in the builder
	 * 
	 * @param b
	 *            The Builder object
	 * @param bMenuBar
	 *            The Menu Bar that the new level is created from
	 */
	public BuilderNewReleaseLevelController(Builder b, BuilderMenuBar bMenuBar) {
		this.builder = b;
		this.builderMenuBar = bMenuBar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.builder.setLevel(
				new ReleaseLevel(new ReleaseBoard(), new BullPen(new BullPenData()), new ArrayList<ReleaseNumber>()));
		this.handleNewLevel(this.builder, this.builderMenuBar, new ReleaseInfoView(this.builder.getLevel()));
	}
}
