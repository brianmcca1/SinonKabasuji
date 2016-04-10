package main;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Builder {

    private JFrame frame;
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
        
        JButton Red1 = new JButton("1");
        Red1.setForeground(Color.RED);
        Red1.setBounds(451, 26, 39, 25);
        BoardView.add(Red1);
        
        JButton Red2 = new JButton("2");
        Red2.setForeground(Color.RED);
        Red2.setBounds(451, 62, 39, 25);
        BoardView.add(Red2);
        
        JButton Red3 = new JButton("3");
        Red3.setForeground(Color.RED);
        Red3.setBounds(451, 98, 39, 25);
        BoardView.add(Red3);
        
        JButton Red4 = new JButton("4");
        Red4.setForeground(Color.RED);
        Red4.setBounds(451, 134, 39, 25);
        BoardView.add(Red4);
        
        JButton Red5 = new JButton("5");
        Red5.setForeground(Color.RED);
        Red5.setBounds(451, 170, 39, 25);
        BoardView.add(Red5);
        
        JButton Red6 = new JButton("6");
        Red6.setForeground(Color.RED);
        Red6.setBounds(451, 206, 39, 25);
        BoardView.add(Red6);
        
        JButton Yellow1 = new JButton("1");
        Yellow1.setForeground(Color.YELLOW);
        Yellow1.setBounds(500, 26, 39, 25);
        BoardView.add(Yellow1);
        
        JButton Yellow2 = new JButton("2");
        Yellow2.setForeground(Color.YELLOW);
        Yellow2.setBounds(500, 62, 39, 25);
        BoardView.add(Yellow2);
        
        JButton Yellow3 = new JButton("3");
        Yellow3.setForeground(Color.YELLOW);
        Yellow3.setBounds(500, 98, 39, 25);
        BoardView.add(Yellow3);
        
        JButton Yellow4 = new JButton("4");
        Yellow4.setForeground(Color.YELLOW);
        Yellow4.setBounds(500, 134, 39, 25);
        BoardView.add(Yellow4);
        
        JButton Yellow5 = new JButton("5");
        Yellow5.setForeground(Color.YELLOW);
        Yellow5.setBounds(500, 170, 39, 25);
        BoardView.add(Yellow5);
        
        JButton Yellow6 = new JButton("6");
        Yellow6.setForeground(Color.YELLOW);
        Yellow6.setBounds(500, 206, 39, 25);
        BoardView.add(Yellow6);
        
        JButton Green1 = new JButton("1");
        Green1.setForeground(new Color(50, 205, 50));
        Green1.setBounds(549, 26, 39, 25);
        BoardView.add(Green1);
        
        JButton Green2 = new JButton("2");
        Green2.setForeground(new Color(50, 205, 50));
        Green2.setBounds(549, 62, 39, 25);
        BoardView.add(Green2);
        
        JButton Green3 = new JButton("3");
        Green3.setForeground(new Color(50, 205, 50));
        Green3.setBounds(549, 98, 39, 25);
        BoardView.add(Green3);
        
        JButton Green4 = new JButton("4");
        Green4.setForeground(new Color(50, 205, 50));
        Green4.setBounds(549, 134, 39, 25);
        BoardView.add(Green4);
        
        JButton Green5 = new JButton("5");
        Green5.setForeground(new Color(50, 205, 50));
        Green5.setBounds(549, 170, 39, 25);
        BoardView.add(Green5);
        
        JButton Green6 = new JButton("6");
        Green6.setForeground(new Color(50, 205, 50));
        Green6.setBounds(549, 206, 39, 25);
        BoardView.add(Green6);
        
        JLabel lblTotalMovesAllowed = new JLabel("Total Time:");
        lblTotalMovesAllowed.setBounds(474, 260, 65, 14);
        BoardView.add(lblTotalMovesAllowed);
        
        textField = new JTextField();
        textField.setBounds(532, 257, 25, 20);
        BoardView.add(textField);
        textField.setColumns(10);
        
        JLabel lblS = new JLabel("sec");
        lblS.setBounds(560, 260, 46, 14);
        BoardView.add(lblS);

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
        mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        mnFile.add(mntmOpen);

        JMenuItem mntmNewLevel = new JMenuItem("New Level");
        mntmNewLevel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        mnFile.add(mntmNewLevel);

        JMenuItem mntmSave = new JMenuItem("Save");
        mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        mnFile.add(mntmSave);

        JMenuItem mntmSaveAs = new JMenuItem("Save As");
        mnFile.add(mntmSaveAs);

        JMenuItem mntmQuit = new JMenuItem("Quit");
        mnFile.add(mntmQuit);

        JMenu mnEdit = new JMenu("Edit");
        menuBar.add(mnEdit);

        JMenuItem mntmUndo = new JMenuItem("Undo");
        mntmUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
        mnEdit.add(mntmUndo);

        JMenuItem mntmRedo = new JMenuItem("Redo");
        mnEdit.add(mntmRedo);
        
        JMenuItem mntmClearBoard = new JMenuItem("Clear Board");
        mnEdit.add(mntmClearBoard);
        
        System.out.print(LevelView.getHeight());
        System.out.print(LevelView.getWidth());
    }
}
