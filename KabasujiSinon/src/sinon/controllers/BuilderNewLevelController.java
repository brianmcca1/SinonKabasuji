package sinon.controllers;

import javax.swing.JPanel;
import sinon.main.Builder;
import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Level;
import sinon.models.data.BullPenData;
import sinon.models.data.HexominoBankData;
import sinon.models.data.LevelType.types;
import sinon.views.MainView;
import sinon.views.builder.BankView;
import sinon.views.builder.BuilderMenuBar;

public abstract class BuilderNewLevelController {
	
	/**
	 * Used by all the New Level Controllers, starts the MainView and handles enabling/disabling of menu bar items.
	 * @param blankPanel The blank panel to remove from the builder.
	 * @param builder Overall Builder object.
	 * @param bMenuBar The menu bar at the top of the frame.
	 */
	public void handleNewLevel(Builder builder, BuilderMenuBar bMenuBar){
		builder.initializeMainView();
		bMenuBar.mntmSaveAs.setEnabled(true);
		bMenuBar.mntmSave.setEnabled(false);
		bMenuBar.mntmUndo.setEnabled(true);
		bMenuBar.mntmRedo.setEnabled(true);
        bMenuBar.mntmClearBoard.setEnabled(true);
	}
	
}
