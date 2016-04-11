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

public class LevelSelect {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelSelect window = new LevelSelect();
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
	public LevelSelect() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 235));
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		panel.setBounds(115, 188, 529, 156);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 5, 40, 15));
		
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
		
		JButton btnNewButton_8 = new JButton("2");
		btnNewButton_8.setBackground(new Color(0, 0, 255));
		btnNewButton_8.setForeground(new Color(127, 255, 0));
		panel.add(btnNewButton_8);
		
		JButton button = new JButton("3");
		button.setBackground(new Color(0, 0, 255));
		button.setForeground(new Color(127, 255, 0));
		panel.add(button);
		
		JButton btnNewButton_7 = new JButton("4");
		btnNewButton_7.setBackground(new Color(0, 0, 255));
		btnNewButton_7.setForeground(new Color(127, 255, 0));
		panel.add(btnNewButton_7);
		
		JButton btnNewButton = new JButton("5");
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.setForeground(new Color(127, 255, 0));
		panel.add(btnNewButton);
		
		JButton btnNewButton_6 = new JButton("6");
		btnNewButton_6.setBackground(new Color(0, 0, 255));
		btnNewButton_6.setForeground(new Color(127, 255, 0));
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_5 = new JButton("7");
		btnNewButton_5.setBackground(new Color(0, 0, 255));
		btnNewButton_5.setForeground(new Color(127, 255, 0));
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_4 = new JButton("8");
		btnNewButton_4.setBackground(new Color(0, 0, 255));
		btnNewButton_4.setForeground(new Color(127, 255, 0));
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_11 = new JButton("9");
		btnNewButton_11.setBackground(new Color(0, 0, 255));
		btnNewButton_11.setForeground(new Color(127, 255, 0));
		panel.add(btnNewButton_11);
		
		JButton btnNewButton_3 = new JButton("10");
		btnNewButton_3.setBackground(new Color(0, 0, 255));
		btnNewButton_3.setForeground(new Color(127, 255, 0));
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_9 = new JButton("11");
		btnNewButton_9.setBackground(new Color(0, 0, 255));
		btnNewButton_9.setForeground(new Color(127, 255, 0));
		panel.add(btnNewButton_9);
		
		JButton btnNewButton_1 = new JButton("12");
		btnNewButton_1.setBackground(new Color(0, 0, 255));
		btnNewButton_1.setForeground(new Color(127, 255, 0));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_10 = new JButton("13");
		btnNewButton_10.setBackground(new Color(0, 0, 255));
		btnNewButton_10.setForeground(new Color(127, 255, 0));
		panel.add(btnNewButton_10);
		
		JButton btnNewButton_12 = new JButton("14");
		btnNewButton_12.setBackground(new Color(0, 0, 255));
		btnNewButton_12.setForeground(new Color(127, 255, 0));
		panel.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("15");
		btnNewButton_13.setBackground(new Color(0, 0, 255));
		btnNewButton_13.setForeground(new Color(127, 255, 0));
		panel.add(btnNewButton_13);
		
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
		
		JLabel lblX = new JLabel("X");
		lblX.setBounds(773, 0, 34, 15);
		panel_2.add(lblX);
		
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
