package sinon.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import sinon.views.NewLevelWizard;

public class Builder extends Kabasuji {

    // MODELS AND VIEWS SPECIFIC TO BUIDLER GO HERE

    public Builder() {
        super();
        createMenuBar();
        startSplash("Kabasuji Builder", new sinon.views.BuilderView());
    }

    // TODO add a menubar to this frame

    public static void main(String args[]) {
        Builder builder = new Builder();
    }

    public JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);

        JMenuItem mntmOpen = new JMenuItem("Open");
        mntmOpen.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        mnFile.add(mntmOpen);

        JMenuItem mntmNewLevel = new JMenuItem("New Level");
        mntmNewLevel.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        mnFile.add(mntmNewLevel);
        mntmNewLevel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Show the NewMenuWizard
                NewLevelWizard wizard = new NewLevelWizard();

            }

        });

        JMenuItem mntmSave = new JMenuItem("Save");
        mntmSave.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        mnFile.add(mntmSave);

        JMenuItem mntmSaveAs = new JMenuItem("Save As");
        mnFile.add(mntmSaveAs);

        JMenuItem mntmQuit = new JMenuItem("Quit");
        mnFile.add(mntmQuit);

        JMenu mnEdit = new JMenu("Edit");
        menuBar.add(mnEdit);

        JMenuItem mntmUndo = new JMenuItem("Undo");
        mntmUndo.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
        mnEdit.add(mntmUndo);

        JMenuItem mntmRedo = new JMenuItem("Redo");
        mnEdit.add(mntmRedo);

        JMenuItem mntmClearBoard = new JMenuItem("Clear Board");
        mnEdit.add(mntmClearBoard);
        return menuBar;
    }
}
