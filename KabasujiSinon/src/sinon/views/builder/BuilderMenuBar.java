package sinon.views.builder;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import sinon.controllers.BuilderNewLightningLevelController;
import sinon.controllers.BuilderNewPuzzleLevelController;
import sinon.controllers.BuilderNewReleaseLevelController;
import sinon.controllers.BuilderOpenController;
import sinon.controllers.BuilderSaveAsController;
import sinon.controllers.BuilderSaveController;
import sinon.main.Builder;

/**
 * The BuilderMenuBar is the JMenuBar that is on the top of the Builder Frame.
 */
@SuppressWarnings("serial")
public class BuilderMenuBar extends JMenuBar {

	public JMenu mnFile;
	public JMenu mnEdit;
	public JMenu mntmNewLevel;
	public JMenuItem mntmOpen;
	public JMenuItem mntmSave;
	public JMenuItem mntmSaveAs;
	public JMenuItem mntmNewPuzzleLevel;
	public JMenuItem mntmNewLightningLevel;
	public JMenuItem mntmNewReleaseLevel;
	public JMenuItem mntmUndo;
	public JMenuItem mntmRedo;
	public JMenuItem mntmClearBoard;
	
	private Builder builder;
	
	private JPanel blankPanel;

	public BuilderMenuBar(Builder b, JPanel bPanel) {
		this.builder = b;
		this.blankPanel = bPanel;
		initFileMenu();
		initEditMenu();
	}

	private void initEditMenu() {
		mnEdit = new JMenu("Edit");
		this.add(mnEdit);

		mntmUndo = new JMenuItem("Undo");
		mntmRedo = new JMenuItem("Redo");
		mntmClearBoard = new JMenuItem("Clear Board");
		
		mnEdit.add(mntmUndo);
		mnEdit.add(mntmRedo);
		mnEdit.add(mntmClearBoard);
		
		mntmUndo.setEnabled(false);
		mntmRedo.setEnabled(false);
		mntmClearBoard.setEnabled(false);
	}

	private void initFileMenu() {
		mnFile = new JMenu("File");
		mntmOpen = new JMenuItem("Open");
		mntmNewLevel = new JMenu("New Level");
		mntmSave = new JMenuItem("Save");
		mntmSaveAs = new JMenuItem("Save As");
		mntmNewPuzzleLevel = new JMenuItem("Puzzle");
		mntmNewLightningLevel = new JMenuItem("Lightning");
		mntmNewReleaseLevel = new JMenuItem("Release");
		
		this.add(mnFile);
		mnFile.add(mntmOpen);
		mnFile.add(mntmNewLevel);
		mnFile.add(mntmSave);
		mnFile.add(mntmSaveAs);
		mntmNewLevel.add(mntmNewPuzzleLevel);
		mntmNewLevel.add(mntmNewLightningLevel);
		mntmNewLevel.add(mntmNewReleaseLevel);
		
		mntmSave.setEnabled(false);
		mntmSaveAs.setEnabled(false);
		
		mntmSave.addActionListener(new BuilderSaveController(this.builder));
		mntmSaveAs.addActionListener(new BuilderSaveAsController(this.builder, this));
		mntmNewPuzzleLevel.addActionListener(new BuilderNewPuzzleLevelController(this.builder, this.blankPanel, this));
		mntmNewLightningLevel.addActionListener(new BuilderNewLightningLevelController(this.builder, this.blankPanel, this));
		mntmNewReleaseLevel.addActionListener(new BuilderNewReleaseLevelController(this.builder, this.blankPanel, this));
		mntmOpen.addActionListener(new BuilderOpenController(this.builder, this));
	}
}
