package sinon.views.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/** The BuilderMenuBar is the JMenuBar that is on the top of the Builder Frame. */
@SuppressWarnings("serial")
public class BuilderMenuBar extends JMenuBar {

	/** File menu */
	private JMenu mnFile;
	/** Edit menu */
	private JMenu mnEdit;

	public BuilderMenuBar() {
		initFileMenu();
		initEditMenu();
	}

	private void initEditMenu() {
		mnEdit = new JMenu("Edit");
		this.add(mnEdit);

		JMenuItem mntmUndo = new JMenuItem("Undo");
		mntmUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
				InputEvent.CTRL_MASK));
		mnEdit.add(mntmUndo);

		JMenuItem mntmRedo = new JMenuItem("Redo");
		mnEdit.add(mntmRedo);

		JMenuItem mntmClearBoard = new JMenuItem("Clear Board");
		mnEdit.add(mntmClearBoard);
	}

	private void initFileMenu() {
		mnFile = new JMenu("File");
		this.add(mnFile);

		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				InputEvent.CTRL_MASK));
		mnFile.add(mntmOpen);

		JMenuItem mntmNewLevel = new JMenuItem("New Level");
		mntmNewLevel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				InputEvent.CTRL_MASK));
		mnFile.add(mntmNewLevel);
		mntmNewLevel.addActionListener(new ActionListener() {

			// TODO this is a rough n' dirty ActionListener. These kinds of
			// things should be handled with controllers not anonymous classes.

			@Override
			public void actionPerformed(ActionEvent e) {
				// Show the NewMenuWizard
				NewLevelWizard wizard = new NewLevelWizard();

			}

		});

		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				InputEvent.CTRL_MASK));
		mnFile.add(mntmSave);

		JMenuItem mntmSaveAs = new JMenuItem("Save As");
		mnFile.add(mntmSaveAs);

		JMenuItem mntmQuit = new JMenuItem("Quit");
		mnFile.add(mntmQuit);
	}
}
