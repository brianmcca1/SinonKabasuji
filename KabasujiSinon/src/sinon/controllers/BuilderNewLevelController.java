package sinon.controllers;

import sinon.main.Builder;
import sinon.views.LevelTypeInfoView;
import sinon.views.builder.BuilderMenuBar;

public abstract class BuilderNewLevelController {
	
	/**
	 * Used by all the New Level Controllers, starts the MainView and handles enabling/disabling of menu bar items.
	 * @param blankPanel The blank panel to remove from the builder.
	 * @param builder Overall Builder object.
	 * @param bMenuBar The menu bar at the top of the frame.
	 */
	public void handleNewLevel(Builder builder, BuilderMenuBar bMenuBar, LevelTypeInfoView lvlTypeInfoView){
		builder.initializeMainView(lvlTypeInfoView);
		bMenuBar.mntmSaveAs.setEnabled(true);
		bMenuBar.mntmSave.setEnabled(false);
		bMenuBar.mntmUndo.setEnabled(true);
		bMenuBar.mntmRedo.setEnabled(true);
        bMenuBar.mntmClearBoard.setEnabled(true);
	}
	
}
