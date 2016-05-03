package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import sinon.main.Builder;
import sinon.models.ReleaseBoard;
import sinon.models.ReleaseNumber;
import sinon.models.data.LevelProperty;
import sinon.models.data.LevelType.Types;

/**
 * This is the controller responsible for saving a file that already exists but
 * has been modified in the builder.
 *
 */
public class BuilderSaveController implements ActionListener {

	/** The main high level builder application associated with this controller. */
	private Builder builder;

	/**
	 * Controller for saving a level which has been modified.
	 * 
	 * @param b
	 *            The Builder object.
	 * @param bMenuBar
	 *            The Menu Bar that the level is saved from.
	 */
	public BuilderSaveController(Builder b) {
		this.builder = b;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (FileHandler.currentFile != null) {
			Types thisLevelsType = this.builder.getLevel().getLevelData().getLevelType();
			LevelProperty levelProp = null;

			switch (thisLevelsType) {
			case PUZZLE:
				int propertyValuePuzzle = this.builder.getMainView().getLevelTypeInfoView().getValue();
				levelProp = new LevelProperty(propertyValuePuzzle, Types.PUZZLE);
				break;
			case LIGHTNING:
				int propertyValueLightning = this.builder.getMainView().getLevelTypeInfoView().getValue();
				levelProp = new LevelProperty(propertyValueLightning, Types.LIGHTNING);

				break;
			case RELEASE:
				ReleaseBoard releaseBoard = (ReleaseBoard) this.builder.getLevel().getBoard();
				ArrayList<ReleaseNumber> propertyValueRelease = releaseBoard.getReleaseSet();
				levelProp = new LevelProperty(propertyValueRelease, Types.RELEASE);

				break;
			}
			this.builder.getLevel().getLevelData().setLevelProperty(levelProp);
			FileHandler.builderSaveLevelToFile(FileHandler.currentFile, this.builder.getLevel());
		}
	}

}
