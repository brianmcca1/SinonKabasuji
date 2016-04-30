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
		this.builder.setLevel(
				new ReleaseLevel(new ReleaseBoard(), new BullPen(new BullPenData()), new ArrayList<ReleaseNumber>()));
		this.handleNewLevel(this.builder, this.builderMenuBar, new ReleaseInfoView());
	}
}
