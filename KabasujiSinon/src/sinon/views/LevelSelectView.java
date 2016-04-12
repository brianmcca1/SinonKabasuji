package sinon.views;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;

import sinon.controllers.LevelStartController;

public class LevelSelectView {
	LevelSelectButtonView[] btns = new LevelSelectButtonView[15];
	JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelSelectView window = new LevelSelectView();
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
	public LevelSelectView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//initialize the frame
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 235));
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//initialize the panel
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		panel.setBounds(115, 188, 529, 156);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 5, 40, 15));
		
		//initialize all the button views on the screen
		for(int i = 0; i < 15; i++) {
			btns[i] = new LevelSelectButtonView();
			String newI = Integer.toString(i+1); 
			panel.add(btns[i].initialize(newI));
		}
		
		LevelStartController[] start = new LevelStartController[15];
		for(int i = 0; i < 15; i++){
			start[i] = new LevelStartController(btns[i]);			
		}
		
		/*
		JButton btnNewButton_2 = new JButton("1");
		btnNewButton_2.setBackground(Color.BLUE);
		btnNewButton_2.setForeground(new Color(127, 255, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			 public void actionPerformed(java.awt.event.ActionEvent evt) {
	                
	                    Player player = new Player();
	                    player.frame.setVisible(true);
	                }

	            });
	
		panel.add(btnNewButton_2);
		*/
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 235));
		panel_1.setBounds(126, 63, 518, 45);
		frame.getContentPane().add(panel_1);
		
		JLabel lblLevelSelect = new JLabel("LEVEL SELECT\n");
		lblLevelSelect.setFont(new Font("DejaVu Sans", Font.BOLD, 20));
		lblLevelSelect.setForeground(new Color(0, 0, 128));
		panel_1.add(lblLevelSelect);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(30, 144, 255));
		panel_2.setBounds(0, 0, 788, 17);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblKabasuji = new JLabel("KABASUJI");
		lblKabasuji.setBounds(12, 0, 63, 15);
		panel_2.add(lblKabasuji);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(30, 144, 255));
		panel_3.setBounds(0, 432, 800, 140);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblPuzzleLevel = new JLabel("PUZZLE LEVEL");
		lblPuzzleLevel.setForeground(new Color(0, 0, 205));
		lblPuzzleLevel.setBounds(12, 40, 108, 15);
		panel_3.add(lblPuzzleLevel);
		
		JLabel lblLevelPuzzle = new JLabel("LEVEL 1\n");
		lblLevelPuzzle.setBounds(12, 0, 178, 48);
		panel_3.add(lblLevelPuzzle);
		lblLevelPuzzle.setFont(new Font("Dialog", Font.BOLD, 22));
		lblLevelPuzzle.setForeground(new Color(0, 0, 128));
		
		JLabel lblDescription = new JLabel("The puzzle level gives you a limited number of moves. ");
		lblDescription.setBounds(149, 12, 450, 75);
		panel_3.add(lblDescription);
	}
}
