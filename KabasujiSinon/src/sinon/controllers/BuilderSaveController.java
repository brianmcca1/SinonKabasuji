package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sinon.main.Builder;
import sinon.models.data.LevelProperty;
import sinon.models.data.LevelType.Types;

public class BuilderSaveController implements ActionListener {

	private Builder builder;

	public BuilderSaveController(Builder b) {
		this.builder = b;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ENTERING SAVE CONTROLLER");

		if (FileHandler.currentFile != null) {

			// GET THIS LEVEL'S propertyValue
			Types thisLevelsType = this.builder.getLevel().getLevelData().getLevelType();
			int propertyValue = this.builder.getMainView().getLevelTypeInfoView().getValue();
			LevelProperty levelProp = null;

			switch (thisLevelsType) {
			case PUZZLE:
				levelProp = new LevelProperty(propertyValue, Types.PUZZLE);
				this.builder.getLevel().getLevelData().setLevelProperty(levelProp);
				break;
			case LIGHTNING:
				levelProp = new LevelProperty(propertyValue, Types.LIGHTNING);
				this.builder.getLevel().getLevelData().setLevelProperty(levelProp);
				break;
			case RELEASE:
				break;
			}

			FileHandler.builderSaveLevelToFile(FileHandler.currentFile, this.builder.getLevel(), levelProp);
		}
	}

}
