package sinon.controllers;

import javax.swing.JPanel;
import sinon.main.Builder;
import sinon.views.MainView;
import sinon.views.builder.BankView;
import sinon.views.builder.BuilderMenuBar;

public abstract class BuilderNewLevelController {
	
	/**
	 * Used by all the New Level Controllers, starts the MainView and handles enabling/disabling of file options.
	 * @param blankPanel The blank panel to remove from the builder.
	 * @param builder Overall Builder object.
	 * @param bMenuBar The menu bar at the top of the frame.
	 */
	public void startLevel(JPanel blankPanel, Builder builder, BuilderMenuBar bMenuBar){
		builder.startNextPanel(blankPanel, new MainView(builder, new BankView(builder)));
		bMenuBar.mntmSaveAs.setEnabled(true);
		bMenuBar.mntmSave.setEnabled(false);
		bMenuBar.mntmUndo.setEnabled(true);
		bMenuBar.mntmRedo.setEnabled(true);
        bMenuBar.mntmClearBoard.setEnabled(true);
	}
	
}
