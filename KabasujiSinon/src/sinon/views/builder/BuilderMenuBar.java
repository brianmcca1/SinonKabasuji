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

	/** File menu */
	private JMenu mnFile;
	/** Edit menu */
	private JMenu mnEdit;
	
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

		JMenuItem mntmUndo = new JMenuItem("Undo");
		mntmUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		JMenuItem mntmRedo = new JMenuItem("Redo");
		JMenuItem mntmClearBoard = new JMenuItem("Clear Board");
		mnEdit.add(mntmUndo);
		mnEdit.add(mntmRedo);
		mnEdit.add(mntmClearBoard);
	}

	private void initFileMenu() {
		mnFile = new JMenu("File");
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		JMenu mntmNewLevel = new JMenu("New Level");
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		JMenuItem mntmSaveAs = new JMenuItem("Save As");
		JMenuItem mntmQuit = new JMenuItem("Quit");
		JMenuItem mntmNewPuzzleLevel = new JMenuItem("Puzzle");
		JMenuItem mntmNewLightningLevel = new JMenuItem("Lightning");
		JMenuItem mntmNewReleaseLevel = new JMenuItem("Release");
		
		this.add(mnFile);
		mnFile.add(mntmOpen);
		mnFile.add(mntmNewLevel);
		mntmNewLevel.add(mntmNewPuzzleLevel);
		mntmNewLevel.add(mntmNewLightningLevel);
		mntmNewLevel.add(mntmNewReleaseLevel);
		mnFile.add(mntmSave);
		mnFile.add(mntmSaveAs);
		mnFile.add(mntmQuit);
		
		mntmSave.addActionListener(new BuilderSaveController(this.builder));
		mntmSaveAs.addActionListener(new BuilderSaveAsController(this.builder));
		mntmNewPuzzleLevel.addActionListener(new BuilderNewPuzzleLevelController(this.builder, this.blankPanel));
		mntmNewLightningLevel.addActionListener(new BuilderNewLightningLevelController(this.builder, this.blankPanel));
		mntmNewReleaseLevel.addActionListener(new BuilderNewReleaseLevelController(this.builder, this.blankPanel));
		mntmOpen.addActionListener(new BuilderOpenController(this.builder));
	}
}
