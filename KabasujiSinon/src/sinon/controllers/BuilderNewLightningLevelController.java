package sinon.controllers;

import java.awt.event.ActionEvent;

import sinon.main.Builder;
import sinon.models.BullPen;
import sinon.models.LightningBoard;
import sinon.models.LightningLevel;
import sinon.models.data.BullPenData;
import sinon.views.LightningInfoView;
import sinon.views.builder.BuilderMenuBar;

public class BuilderNewLightningLevelController extends BuilderNewLevelController {

	private Builder builder;

	private BuilderMenuBar builderMenuBar;

	public BuilderNewLightningLevelController(Builder b, BuilderMenuBar bMenuBar) {
		this.builder = b;
		this.builderMenuBar = bMenuBar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		LightningBoard board = new LightningBoard();
		BullPen bullpen = new BullPen(new BullPenData());
		LightningLevel level = new LightningLevel(board, bullpen, 60);
		System.out.println("CREATING NEW LIGHTNING LEVEL");
		this.builder.setLevel(level);
		this.handleNewLevel(this.builder, this.builderMenuBar, new LightningInfoView(true, level));
	}
}
