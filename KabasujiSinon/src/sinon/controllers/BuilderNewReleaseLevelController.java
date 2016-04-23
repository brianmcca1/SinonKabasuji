package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import sinon.main.Builder;
import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Level;
import sinon.models.data.BullPenData;
import sinon.models.data.LevelType.types;
import sinon.views.MainView;
import sinon.views.builder.BankView;
import sinon.views.builder.BuilderMenuBar;

public class BuilderNewReleaseLevelController extends BuilderNewLevelController implements ActionListener {

	private Builder builder;
	
	private JPanel blankPanel;

	private BuilderMenuBar builderMenuBar;

	public BuilderNewReleaseLevelController(Builder b, JPanel bPanel, BuilderMenuBar bMenuBar){
		this.builder = b;
		this.blankPanel = bPanel;
		this.builderMenuBar = bMenuBar;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("CREATING NEW RELEASE LEVEL");
		this.startLevel(this.blankPanel, this.builder, this.builderMenuBar);
		this.builder.setCurrentLevel(new Level(types.RELEASE, new Board(), new BullPen(new BullPenData())));
	}
}
