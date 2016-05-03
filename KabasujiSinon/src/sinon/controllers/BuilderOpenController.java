package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import sinon.main.Builder;
import sinon.models.Level;
import sinon.models.LightningLevel;
import sinon.models.PuzzleLevel;
import sinon.models.ReleaseLevel;
import sinon.models.data.LevelData;
import sinon.models.data.LevelType.Types;
import sinon.serial.Deserializer;
import sinon.views.LevelTypeInfoView;
import sinon.views.LightningInfoView;
import sinon.views.PuzzleInfoView;
import sinon.views.ReleaseInfoView;
import sinon.views.builder.BuilderMenuBar;

/**
 * This is the controller that handles opening up an existing level in the
 * builder.
 *
 */
public class BuilderOpenController extends BuilderNewLevelController implements ActionListener {

	/** Overall Builder object */
	private Builder builder;

	final JFileChooser fc = new JFileChooser();

	private BuilderMenuBar builderMenuBar;

	/**
	 * Controller for opening a level in the builder
	 * 
	 * @param b
	 *            The Builder object
	 * @param bMenuBar
	 *            The Menu Bar that the new level is opened from
	 */
	public BuilderOpenController(Builder b, BuilderMenuBar bMenuBar) {
		this.builder = b;
		this.builderMenuBar = bMenuBar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int returnVal = fc.showOpenDialog(this.builder);

		if (returnVal == JFileChooser.APPROVE_OPTION) {

			File file = fc.getSelectedFile();
			openFile(file);

		}
	}

	/**
	 * Open a file in the builder
	 * 
	 * @param file
	 *            The level file to open
	 * @return True if the file was opened successfully, false otherwise
	 */
	public boolean openFile(File file) {
		if (FileHandler.currentFile != null) {
			if (file.compareTo(FileHandler.currentFile) == 0) {
				return false;
			}
		}

		FileHandler.currentFile = file;

		Deserializer deserializer = new Deserializer(file);
		LevelData levelData = deserializer.deserializeFile();

		// CREATE levelFromFile FROM levelData HERE
		Level levelFromFile = new Level(levelData);

		// FIND OUT WHICH LevelTypeInfoView TO GIVE TO MAINVIEW
		LevelTypeInfoView lvlTypeInfoView = null;
		Types thisLevelsType = levelData.getLevelType();

		switch (thisLevelsType) {
		case PUZZLE:
			PuzzleLevel puzzleLevel = new PuzzleLevel(levelFromFile);
			lvlTypeInfoView = new PuzzleInfoView(true, puzzleLevel);
			this.builder.setLevel(puzzleLevel);
			break;
		case LIGHTNING:
			LightningLevel lightningLevel = new LightningLevel(levelFromFile);
			lvlTypeInfoView = new LightningInfoView(true, lightningLevel);
			this.builder.setLevel(lightningLevel);
			break;
		case RELEASE:
			ReleaseLevel releaseLevel = new ReleaseLevel(levelFromFile);
			lvlTypeInfoView = new ReleaseInfoView(releaseLevel, this.builder);
			this.builder.setLevel(releaseLevel);
			break;
		}

		this.builder.initializeMainView(lvlTypeInfoView);
		this.handleOpenLevel(this.builderMenuBar);
		return true;
	}

	/**
	 * Sets the file options and then initializes the MainView.
	 * 
	 * @param bMenuBar
	 *            BuilderMenuBar used to set the appropriate file options.
	 */
	public void handleOpenLevel(BuilderMenuBar bMenuBar) {
		bMenuBar.mntmSaveAs.setEnabled(true);
		bMenuBar.mntmSave.setEnabled(true);
		bMenuBar.mntmUndo.setEnabled(true);
		bMenuBar.mntmRedo.setEnabled(true);
		this.builderMenuBar.mntmSave.setEnabled(true);
	}
}
