package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sinon.main.Builder;
import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Level;
import sinon.models.LightningLevel;
import sinon.models.data.BullPenData;
import sinon.models.data.LevelType.Types;
import sinon.views.LightningInfoView;
import sinon.views.builder.BuilderMenuBar;

public class BuilderNewLightningLevelController extends BuilderNewLevelController implements ActionListener {
	
	private Builder builder;

	private BuilderMenuBar builderMenuBar;
	
	public BuilderNewLightningLevelController(Builder b, BuilderMenuBar bMenuBar){
		this.builder = b;
		this.builderMenuBar = bMenuBar;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Board board = new Board();
		BullPen bullpen = new BullPen(new BullPenData());
		LightningLevel level = new LightningLevel(board, bullpen, 60);
		System.out.println("CREATING NEW LIGHTNING LEVEL");
		this.builder.setLevel(level);
		this.handleNewLevel(this.builder, this.builderMenuBar, new LightningInfoView(true, level));
	}
}
