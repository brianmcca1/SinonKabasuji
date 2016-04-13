package sinon.views;


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

import sinon.main.Game;

import javax.swing.JButton;
import javax.swing.JScrollBar;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

public class PlayerView extends JPanel {

	Game game;
	
    public PlayerView(Game g) {
    	this.game = g;
        initialize();
    }

    public void initialize() {
        this.setMinimumSize(new Dimension(800, 600));
        this.setPreferredSize(new Dimension(800, 600));
        this.setBounds(100, 100, 450, 300);
        this.setLayout(new BorderLayout(0, 0));

        JPanel LevelView = new JPanel();
        LevelView.setPreferredSize(new Dimension(605, 10));
        LevelView.setBorder(new LineBorder(new Color(0, 0, 0)));
        this.add(LevelView, BorderLayout.WEST);
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
        this.add(InteractionsView, BorderLayout.EAST);
        InteractionsView.setLayout(null);

        JScrollBar scrollBar_1 = new JScrollBar();
        scrollBar_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        scrollBar_1.setBounds(0, 0, 17, 540);
        InteractionsView.add(scrollBar_1);
        
        JButton btnRestart = new JButton("Restart\r\n");
        btnRestart.setBounds(45, 20, 100, 50);
        InteractionsView.add(btnRestart);
        
        JButton btnExit = new JButton("Exit\r\n");
        btnExit.setBounds(45, 100, 100, 50);
        InteractionsView.add(btnExit);
        
        JButton button_2 = new JButton("Next Level\r\n");
        button_2.setBounds(45, 180, 100, 50);
        InteractionsView.add(button_2);
    	
		PlayerView current = this;
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				 game.startNextPanel(current, new LevelSelectView(game));
			 }
		});
    	
    	/*
        JPanel LevelView = new JPanel();
        LevelView.setPreferredSize(new Dimension(605, 10));
        LevelView.setBorder(new LineBorder(new Color(0, 0, 0)));
        this.add(LevelView, BorderLayout.WEST);
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
        InteractionsView.setBackground(SystemColor.menu);
        InteractionsView.setPreferredSize(new Dimension(180, 600));
        InteractionsView.setMinimumSize(new Dimension(150, 600));
        InteractionsView.setBorder(new LineBorder(new Color(0, 0, 0)));
        this.add(InteractionsView, BorderLayout.EAST);
        InteractionsView.setLayout(null);
        
        JButton btnRestart = new JButton("Restart\r\n");
        btnRestart.setFont(new Font("Gotham Light", Font.BOLD, 20));
        btnRestart.setBounds(25, 24, 130, 98);
        InteractionsView.add(btnRestart);
        
        JButton btnExit = new JButton("Exit\r\n");
        btnExit.setFont(new Font("Gotham Light", Font.BOLD, 20));
        btnExit.setBounds(25, 154, 130, 98);
        InteractionsView.add(btnExit);
        
		PlayerView current = this;
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				 game.startNextPanel(current, new LevelSelectView(game));
			 }
		});
        
        JButton btnNextLevel = new JButton("Next Level\r\n");
        btnNextLevel.setEnabled(false);
        btnNextLevel.setFont(new Font("Gotham Light", Font.BOLD, 14));
        btnNextLevel.setBounds(25, 285, 130, 98);
        InteractionsView.add(btnNextLevel);
        
        JTextPane txtpnMovesLeft = new JTextPane();
        txtpnMovesLeft.setBackground(SystemColor.menu);
        txtpnMovesLeft.setFont(new Font("Gotham Light", Font.PLAIN, 14));
        txtpnMovesLeft.setText("Moves Left: 10");
        txtpnMovesLeft.setBounds(32, 412, 115, 20);
        InteractionsView.add(txtpnMovesLeft);
        */
    }
}
