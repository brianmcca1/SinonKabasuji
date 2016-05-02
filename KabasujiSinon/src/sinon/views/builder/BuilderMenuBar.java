package sinon.views.builder;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import sinon.controllers.BuilderNewLightningLevelController;
import sinon.controllers.BuilderNewPuzzleLevelController;
import sinon.controllers.BuilderNewReleaseLevelController;
import sinon.controllers.BuilderOpenController;
import sinon.controllers.BuilderSaveAsController;
import sinon.controllers.BuilderSaveController;
import sinon.main.Builder;

/**
 * A JMenuBar that is on the top of the Builder Frame.
 */
@SuppressWarnings("serial")
public class BuilderMenuBar extends JMenuBar {

	/** Top-level File menu. */
	public JMenu mnFile;
	/** Top-level Edit menu. */
	public JMenu mnEdit;
	/** New Level option. */
	public JMenu mntmNewLevel;	
	/** New puzzle level option. */
	public JMenuItem mntmNewPuzzleLevel;
	/** New lightning level option. */
	public JMenuItem mntmNewLightningLevel;
	/** New release level option. */
	public JMenuItem mntmNewReleaseLevel;
	/** Open level option. */
	public JMenuItem mntmOpen;
	/** Save level option. */
	public JMenuItem mntmSave;
	/** Save level As option. */
	public JMenuItem mntmSaveAs;
	/** Undo option. */
	public JMenuItem mntmUndo;
	/** Redo option. */
	public JMenuItem mntmRedo;
	/** Overall Builder. */
	private Builder builder;

	/**
	 * Creates the BuilderMenuBar.
	 * @param b Overall Builder.
	 */
	public BuilderMenuBar(Builder b) {
		this.builder = b;
		initFileMenu();
		initEditMenu();
	}

	/**
	 * Sets up all necessary options in the Edit menu.
	 */
	private void initEditMenu() {
		mnEdit = new JMenu("Edit");
		this.add(mnEdit);

		mntmUndo = new JMenuItem("Undo");
		mntmRedo = new JMenuItem("Redo");
		
		mnEdit.add(mntmUndo);
		mnEdit.add(mntmRedo);
		
		mntmUndo.setEnabled(false);
		mntmRedo.setEnabled(false);
		
	}
	 
	/**
	 * Sets up all necessary options in the File menu and applies their controllers.
	 */
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
		mntmNewPuzzleLevel.addActionListener(new BuilderNewPuzzleLevelController(this.builder, this));
		mntmNewLightningLevel.addActionListener(new BuilderNewLightningLevelController(this.builder, this));
		mntmNewReleaseLevel.addActionListener(new BuilderNewReleaseLevelController(this.builder, this));
		mntmOpen.addActionListener(new BuilderOpenController(this.builder, this));
	}
}
