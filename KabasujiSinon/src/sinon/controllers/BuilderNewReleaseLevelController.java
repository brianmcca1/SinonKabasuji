package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sinon.main.Builder;
import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Level;
import sinon.models.data.BullPenData;
import sinon.models.data.LevelType.types;

public class BuilderNewReleaseLevelController implements ActionListener {

	private Builder builder;

	public BuilderNewReleaseLevelController(Builder b){
		this.builder = b;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("CREATING NEW RELEASE LEVEL");
		this.builder.setCurrentLevel(new Level(types.RELEASE, new Board(), new BullPen(new BullPenData())));
	}
}
