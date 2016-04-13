package sinon.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;

public class Builder {

    JFrame frame;
    private JTextField textField;
    /**
     * @wbp.nonvisual location=282,-31
     */

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Builder window = new Builder();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Builder() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel LevelView = new JPanel();
        LevelView.setPreferredSize(new Dimension(605, 10));
        LevelView.setBorder(new LineBorder(new Color(0, 0, 0)));
        frame.getContentPane().add(LevelView, BorderLayout.WEST);
        LevelView.setLayout(new BorderLayout(0, 0));

        JPanel Bullpen = new JPanel();
        Bullpen.setPreferredSize(new Dimension(10, 180));
        LevelView.add(Bullpen, BorderLayout.NORTH);
        Bullpen.setLayout(null);

        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.setBounds(22, 6, 150, 149);
        Bullpen.add(btnNewButton_1);

        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setBorder(new LineBorder(new Color(0, 0, 0)));
        scrollBar.setOrientation(JScrollBar.HORIZONTAL);
        scrollBar.setBounds(0, 163, 603, 17);
        Bullpen.add(scrollBar);

        JPanel BoardView = new JPanel();
        BoardView.setPreferredSize(new Dimension(10, 300));
        LevelView.add(BoardView, BorderLayout.CENTER);
        BoardView.setLayout(null);

        JButton btnNewButton_2 = new JButton("12x12 Board\r\n");
        btnNewButton_2.setBounds(141, 26, 300, 298);
        BoardView.add(btnNewButton_2);

        ReleaseButtonView releaseButtonView = new ReleaseButtonView();
        BoardView.add(releaseButtonView);

        JPanel InteractionsView = new JPanel();
        InteractionsView.setPreferredSize(new Dimension(180, 800));
        InteractionsView.setMinimumSize(new Dimension(150, 800));
        InteractionsView.setBorder(new LineBorder(new Color(0, 0, 0)));
        frame.getContentPane().add(InteractionsView, BorderLayout.EAST);
        InteractionsView.setLayout(null);

        JButton button = new JButton("");
        button.setBounds(23, 11, 150, 149);
        InteractionsView.add(button);

        JScrollBar scrollBar_1 = new JScrollBar();
        scrollBar_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        scrollBar_1.setBounds(0, 0, 17, 540);
        InteractionsView.add(scrollBar_1);

        JButton button_1 = new JButton("");
        button_1.setBounds(23, 171, 150, 149);
        InteractionsView.add(button_1);

        JButton button_2 = new JButton("");
        button_2.setBounds(23, 331, 150, 149);
        InteractionsView.add(button_2);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

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

        System.out.print(LevelView.getHeight());
        System.out.print(LevelView.getWidth());
    }
}
