package sinon.controllers;

import java.awt.event.ActionEvent;

import sinon.main.Builder;
import sinon.models.BullPen;
import sinon.models.Level;
import sinon.models.ReleaseBoard;
import sinon.models.data.BullPenData;
import sinon.models.data.LevelType.Types;
import sinon.views.ReleaseInfoView;
import sinon.views.builder.BuilderMenuBar;

public class BuilderNewReleaseLevelController extends BuilderNewLevelController {

	private Builder builder;

	private BuilderMenuBar builderMenuBar;

	public BuilderNewReleaseLevelController(Builder b, BuilderMenuBar bMenuBar) {
		this.builder = b;
		this.builderMenuBar = bMenuBar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("CREATING NEW RELEASE LEVEL");
		this.builder.setLevel(new Level(Types.RELEASE, new ReleaseBoard(), new BullPen(new BullPenData())));
		this.handleNewLevel(this.builder, this.builderMenuBar, new ReleaseInfoView());
	}
}
