package sinon.views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JWindow;
import javax.swing.Timer;
import javax.swing.JProgressBar;

public class GameSplashScreen extends JWindow{
	private JFrame frmKabasuji;
	private static Timer timer;
	private static GameSplashScreen execute;
	private static JProgressBar progressBar;
	private static int count;
	private static LevelSelectView levelSelectView;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					execute = new GameSplashScreen();
					execute.frmKabasuji.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GameSplashScreen() {
		frmKabasuji = new JFrame();
		frmKabasuji.setTitle("Kabasuji");
		frmKabasuji.setBounds(100, 100, 800, 600);
		frmKabasuji.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{196, 392, 0};
		gridBagLayout.rowHeights = new int[]{76, 91, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmKabasuji.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Kabasuji");
		lblNewLabel.setForeground(new Color(51, 102, 255));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 99));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		frmKabasuji.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblGroupSinonSoftware = new JLabel("Software Engineering D2016");
		lblGroupSinonSoftware.setFont(new Font("Century Gothic", Font.BOLD, 25));
		GridBagConstraints gbc_lblGroupSinonSoftware = new GridBagConstraints();
		gbc_lblGroupSinonSoftware.insets = new Insets(0, 0, 5, 0);
		gbc_lblGroupSinonSoftware.gridx = 1;
		gbc_lblGroupSinonSoftware.gridy = 3;
		frmKabasuji.getContentPane().add(lblGroupSinonSoftware, gbc_lblGroupSinonSoftware);
		
		JLabel lblSinon = new JLabel("Sinon");
		lblSinon.setFont(new Font("Century Gothic", Font.BOLD, 25));
		GridBagConstraints gbc_lblSinon = new GridBagConstraints();
		gbc_lblSinon.insets = new Insets(0, 0, 5, 0);
		gbc_lblSinon.gridx = 1;
		gbc_lblSinon.gridy = 4;
		frmKabasuji.getContentPane().add(lblSinon, gbc_lblSinon);
		
		JLabel lblKyleSposato = new JLabel("Kyle Sposato");
		lblKyleSposato.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblKyleSposato = new GridBagConstraints();
		gbc_lblKyleSposato.insets = new Insets(0, 0, 5, 0);
		gbc_lblKyleSposato.gridx = 1;
		gbc_lblKyleSposato.gridy = 5;
		frmKabasuji.getContentPane().add(lblKyleSposato, gbc_lblKyleSposato);
		
		JLabel lblKartik = new JLabel("Kartik Thooppal Vasu");
		lblKartik.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblKartik = new GridBagConstraints();
		gbc_lblKartik.insets = new Insets(0, 0, 5, 0);
		gbc_lblKartik.gridx = 1;
		gbc_lblKartik.gridy = 6;
		frmKabasuji.getContentPane().add(lblKartik, gbc_lblKartik);
		
		JLabel lblJosh = new JLabel("Josh Desmond");
		lblJosh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblJosh = new GridBagConstraints();
		gbc_lblJosh.insets = new Insets(0, 0, 5, 0);
		gbc_lblJosh.gridx = 1;
		gbc_lblJosh.gridy = 7;
		frmKabasuji.getContentPane().add(lblJosh, gbc_lblJosh);
		
		JLabel lblBrian = new JLabel("Brian McCarthy");
		lblBrian.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblBrian = new GridBagConstraints();
		gbc_lblBrian.insets = new Insets(0, 0, 5, 0);
		gbc_lblBrian.gridx = 1;
		gbc_lblBrian.gridy = 8;
		frmKabasuji.getContentPane().add(lblBrian, gbc_lblBrian);
		
		JLabel lblPeter = new JLabel("Peter DeBrine");
		lblPeter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblPeter = new GridBagConstraints();
		gbc_lblPeter.insets = new Insets(0, 0, 5, 0);
		gbc_lblPeter.gridx = 1;
		gbc_lblPeter.gridy = 9;
		frmKabasuji.getContentPane().add(lblPeter, gbc_lblPeter);
		
		progressBar = new JProgressBar();
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.fill = GridBagConstraints.BOTH;
		gbc_progressBar.gridx = 1;
		gbc_progressBar.gridy = 12;
		frmKabasuji.getContentPane().add(progressBar, gbc_progressBar);
		
		levelSelectView = new LevelSelectView(); //begin loading level select menu (hidden)
		load(); //begin handling timer
	}
	
    private void load() {
        ActionListener al = new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                count++;
                progressBar.setValue(count);
                if (count == 100) { 
                	timer.stop();							
                    execute.frmKabasuji.setVisible(false); //hide current screen & throw it away
                    execute.dispose();
                    levelSelectView.frame.setVisible(true);    //show level select menu
                }

            }

        };
        timer = new Timer(25, al);
        timer.start();
    }	
}
