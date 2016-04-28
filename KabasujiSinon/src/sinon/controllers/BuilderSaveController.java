package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import sinon.main.Builder;
import sinon.models.ReleaseNumber;
import sinon.models.data.LevelProperty;
import sinon.models.data.LevelType.Types;
import sinon.views.ReleaseInfoView;

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

			LevelProperty levelProp = null;

			switch (thisLevelsType) {
			case PUZZLE:
				int propertyValuePuzzle = this.builder.getMainView().getLevelTypeInfoView().getValue();
				levelProp = new LevelProperty(propertyValuePuzzle, Types.PUZZLE);
				this.builder.getLevel().getLevelData().setLevelProperty(levelProp);
				break;
			case LIGHTNING:
				int propertyValueLightning = this.builder.getMainView().getLevelTypeInfoView().getValue();
				levelProp = new LevelProperty(propertyValueLightning, Types.LIGHTNING);
				this.builder.getLevel().getLevelData().setLevelProperty(levelProp);
				break;
			case RELEASE:
				// TODO: Is there a more elegant way to do this?
				ArrayList<ReleaseNumber> propertyValueRelease = ((ReleaseInfoView) this.builder.getMainView()
						.getLevelTypeInfoView()).getReleaseSets();
				levelProp = new LevelProperty(propertyValueRelease, Types.RELEASE);
				break;
			}

			FileHandler.builderSaveLevelToFile(FileHandler.currentFile, this.builder.getLevel(), levelProp);
		}
	}

}
