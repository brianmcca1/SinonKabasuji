package sinon.controllers;

import java.awt.event.ActionListener;

import sinon.main.Builder;
import sinon.views.LevelTypeInfoView;
import sinon.views.builder.BuilderMenuBar;

/**
 * This is the controller associated with starting a new builder level 
 * in builder mode. 
 * 
 */
public abstract class BuilderNewLevelController implements ActionListener {

	/**
	 * Used by all the New Level Controllers, starts the MainView and handles
	 * enabling/disabling of menu bar items.
	 * 
	 * @param lvlTypeInfoView The LevelTypeInfoView to add to this new level.
	 * @param builder
	 *            Overall Builder object.
	 * @param bMenuBar
	 *            The menu bar at the top of the frame.
	 */
	public void handleNewLevel(Builder builder, BuilderMenuBar bMenuBar, LevelTypeInfoView lvlTypeInfoView) {
		builder.initializeMainView(lvlTypeInfoView);
		bMenuBar.mntmSaveAs.setEnabled(true);
		bMenuBar.mntmSave.setEnabled(false);
		bMenuBar.mntmUndo.setEnabled(true);
		bMenuBar.mntmRedo.setEnabled(true);
	}

}
