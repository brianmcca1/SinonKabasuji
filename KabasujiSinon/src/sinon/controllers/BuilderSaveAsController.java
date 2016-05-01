package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import sinon.main.Builder;
import sinon.models.ReleaseBoard;
import sinon.models.ReleaseNumber;
import sinon.models.data.LevelProperty;
import sinon.models.data.LevelType.Types;
import sinon.views.builder.BuilderMenuBar;

/**
 * This class responds to the "Save As" option in the Builder and opens a Save
 * As menu, and saves the currently built Level to a chosen file.
 * 
 * @author Kyle
 */
public class BuilderSaveAsController implements ActionListener {

	/** Overall Builder object */
	private Builder builder;

	final JFileChooser fc = new JFileChooser();

	private BuilderMenuBar builderMenuBar;

	public BuilderSaveAsController(Builder b, BuilderMenuBar bMenuBar) {
		this.builder = b;
		this.builderMenuBar = bMenuBar;
	}

	/**
	 * Responds to a click on the "Save As" JMenuItem. Will then open a
	 * JFileChooser and allow the user to select a file to save this level to
	 * When "Save" is clicked on the JFileChooser, it will attempt to serialize
	 * a LevelData to the selected file/filename in the selected directory with
	 * the level currently built in the builder.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ENTERING SAVE AS CONTROLLER");
		int returnVal = fc.showSaveDialog(this.builder);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			FileHandler.currentFile = file;

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
			FileHandler.builderSaveLevelToFile(file, this.builder.getLevel());

			this.builderMenuBar.mntmSave.setEnabled(true);
		}
	}
}