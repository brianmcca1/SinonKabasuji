package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sinon.main.Builder;
import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Level;
import sinon.models.data.BullPenData;
import sinon.models.data.LevelType.types;
import sinon.views.builder.BuilderMenuBar;

public class BuilderNewPuzzleLevelController extends BuilderNewLevelController implements ActionListener {

	private Builder builder;
	
	private BuilderMenuBar builderMenuBar;

	public BuilderNewPuzzleLevelController(Builder b, BuilderMenuBar bMenuBar){
		this.builder = b;
		this.builderMenuBar = bMenuBar;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("CREATING NEW PUZZLE LEVEL");
		this.builder.setLevel(new Level(1, types.PUZZLE, new Board(), new BullPen(new BullPenData())));
		this.handleNewLevel(this.builder, this.builderMenuBar);
	}
}