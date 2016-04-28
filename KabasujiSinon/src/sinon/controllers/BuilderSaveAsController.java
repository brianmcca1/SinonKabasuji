package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import sinon.main.Builder;
import sinon.models.ReleaseNumber;
import sinon.models.data.LevelProperty;
import sinon.models.data.LevelType.Types;
import sinon.views.ReleaseInfoView;
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

			FileHandler.builderSaveLevelToFile(file, this.builder.getLevel());

			this.builderMenuBar.mntmSave.setEnabled(true);
		}
	}
}

/*
 * FIELDS TO SET FOR LEVEL this.builder.getLevel() int levelNum; DONE Board
 * board; DONE? Map<Point, Tile> tilesViaPoints; DONE? BullPen bullpen; DONE
 * List<Hexomino> pieces; DONE int stars; DONE int starRecord; DONE LevelData
 * levelData; DONE types levelType; DONE int levelNum; DONE BoardData boardData;
 * DONE boolean[][] playable; DONE BullPenData bullpenData; DONE
 * ArrayList<HexominoCode> hexominos; DONE int starRecord; DONE (THIS IS SET BY
 * THE GAME TO SAVE THE EARNED STARS) LevelProperty levelProperty; DONE
 */