package sinon.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.Timer;

public class BuilderSplashScreen extends JWindow{
	private JFrame frame;
	private static Timer timer;
	private static BuilderSplashScreen execute;
	private static JProgressBar progressBar;
	private static int count;
	//private static LevelSelect levelSelect; LEVEL BUILDER GUI

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					execute = new BuilderSplashScreen();
					execute.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BuilderSplashScreen() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{185, 409, 0};
		gridBagLayout.rowHeights = new int[]{90, 122, 35, 32, 32, 19, 19, 19, 19, 19, 65, 14, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel label = new JLabel("Kabasuji");
		label.setForeground(new Color(51, 102, 255));
		label.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 99));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 1;
		gbc_label.gridy = 1;
		frame.getContentPane().add(label, gbc_label);
		
		JLabel label_1 = new JLabel("Software Engineering D2016");
		label_1.setFont(new Font("Century Gothic", Font.BOLD, 25));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 3;
		frame.getContentPane().add(label_1, gbc_label_1);
		
		JLabel label_2 = new JLabel("Sinon");
		label_2.setFont(new Font("Century Gothic", Font.BOLD, 25));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 0);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 4;
		frame.getContentPane().add(label_2, gbc_label_2);
		
		JLabel label_3 = new JLabel("Kyle Sposato");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 0);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 5;
		frame.getContentPane().add(label_3, gbc_label_3);
		
		JLabel label_4 = new JLabel("Kartik Thooppal Vasu");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 0);
		gbc_label_4.gridx = 1;
		gbc_label_4.gridy = 6;
		frame.getContentPane().add(label_4, gbc_label_4);
		
		JLabel label_5 = new JLabel("Josh Desmond");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 5, 0);
		gbc_label_5.gridx = 1;
		gbc_label_5.gridy = 7;
		frame.getContentPane().add(label_5, gbc_label_5);
		
		JLabel label_6 = new JLabel("Brian McCarthy");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 0);
		gbc_label_6.gridx = 1;
		gbc_label_6.gridy = 8;
		frame.getContentPane().add(label_6, gbc_label_6);
		
		JLabel label_7 = new JLabel("Peter DeBrine");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.insets = new Insets(0, 0, 5, 0);
		gbc_label_7.gridx = 1;
		gbc_label_7.gridy = 9;
		frame.getContentPane().add(label_7, gbc_label_7);
		
		JProgressBar progressBar = new JProgressBar();
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_progressBar.gridx = 1;
		gbc_progressBar.gridy = 11;
		frame.getContentPane().add(progressBar, gbc_progressBar);
		
		load();
	}
	
    private void load() {
        ActionListener al = new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                count++;
                progressBar.setValue(count);
                if (count == 100) { 
                	timer.stop();							
                    execute.frame.setVisible(false); //hide current screen & throw it away
                    execute.dispose();
                    //levelSelect.frame.setVisible(true);    //show level select menu
                }
            }
        };
        timer = new Timer(25, al);
        timer.start();
    }	
}
