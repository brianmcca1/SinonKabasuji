package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sinon.main.Builder;
import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Level;
import sinon.models.data.BullPenData;
import sinon.models.data.LevelType.types;

public class BuilderNewLightningLevelController implements ActionListener {
	
	private Builder builder;

	public BuilderNewLightningLevelController(Builder b){
		this.builder = b;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("CREATING NEW LIGHTNING LEVEL");
		this.builder.setCurrentLevel(new Level(types.LIGHTNING, new Board(), new BullPen(new BullPenData())));
	}
}
