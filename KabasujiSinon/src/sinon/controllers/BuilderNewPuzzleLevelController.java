package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sinon.main.Builder;
import sinon.models.Level;
import sinon.models.data.LevelType.types;

public class BuilderNewPuzzleLevelController implements ActionListener{

	private Builder builder;

	public BuilderNewPuzzleLevelController(Builder b){
		this.builder = b;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("CREATING NEW PUZZLE LEVEL");
		this.builder.setCurrentLevel(new Level(types.PUZZLE));
	}
}
