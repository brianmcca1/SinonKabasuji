package sinon.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.ImageIcon;
/**
 * A SplashScreen for both the Game and Builder applications.
 * @author Kyle
 */
@SuppressWarnings("serial")
public class SplashScreen extends JPanel {
	
	/** Timer for the SplashScreen to exist. */ 
	public static Timer timer;
	/** Loading progress displayed on the SplashScreen. */
	public static JProgressBar progressBar;
	/** Used to count the load progress for the progressBar. */
	public static int count;
	
	public static JLabel theGoods;

	/** "Kabasuji" or "Kabasuji Builder" */
	private String labelText;

	/**
	 * @param text
	 * 		Large blue text to be displayed on splash screen
	 */
	public SplashScreen(String text) {
		this.labelText = text;
		initializePanel();
	}

	/**
	 * Sets up all the information to be displayed on the SplashScreen.
	 */
	private void initializePanel() {
		this.setBounds(100, 100, 800, 600);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 196, 392, 0 };
		gridBagLayout.rowHeights = new int[] { 76, 91, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		this.setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel(labelText);
		lblNewLabel.setForeground(new Color(51, 102, 255));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 50));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		this.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblTheGoods = new JLabel("");
		lblTheGoods.setIcon(new ImageIcon(SplashScreen.class.getResource("/images/theGoods.png")));
		GridBagConstraints gbc_lblTheGoods = new GridBagConstraints();
		gbc_lblTheGoods.fill = GridBagConstraints.VERTICAL;
		gbc_lblTheGoods.insets = new Insets(0, 0, 5, 5);
		gbc_lblTheGoods.gridx = 0;
		gbc_lblTheGoods.gridy = 2;
		add(lblTheGoods, gbc_lblTheGoods);
		
		theGoods = lblTheGoods;
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(SplashScreen.class.getResource("/images/wpi.png")));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		JLabel lblGroupSinonSoftware = new JLabel("Software Engineering D2016");
		lblGroupSinonSoftware.setFont(new Font("Century Gothic", Font.BOLD, 25));
		GridBagConstraints gbc_lblGroupSinonSoftware = new GridBagConstraints();
		gbc_lblGroupSinonSoftware.insets = new Insets(0, 0, 5, 0);
		gbc_lblGroupSinonSoftware.gridx = 1;
		gbc_lblGroupSinonSoftware.gridy = 3;
		this.add(lblGroupSinonSoftware, gbc_lblGroupSinonSoftware);

		JLabel lblSinon = new JLabel("Sinon");
		lblSinon.setFont(new Font("Century Gothic", Font.BOLD, 25));
		GridBagConstraints gbc_lblSinon = new GridBagConstraints();
		gbc_lblSinon.insets = new Insets(0, 0, 5, 0);
		gbc_lblSinon.gridx = 1;
		gbc_lblSinon.gridy = 4;
		this.add(lblSinon, gbc_lblSinon);

		JLabel lblKyleSposato = new JLabel("Kyle Sposato");
		lblKyleSposato.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblKyleSposato = new GridBagConstraints();
		gbc_lblKyleSposato.insets = new Insets(0, 0, 5, 0);
		gbc_lblKyleSposato.gridx = 1;
		gbc_lblKyleSposato.gridy = 5;
		this.add(lblKyleSposato, gbc_lblKyleSposato);

		JLabel lblKartik = new JLabel("Kartik Thooppal Vasu");
		lblKartik.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblKartik = new GridBagConstraints();
		gbc_lblKartik.insets = new Insets(0, 0, 5, 0);
		gbc_lblKartik.gridx = 1;
		gbc_lblKartik.gridy = 6;
		this.add(lblKartik, gbc_lblKartik);

		JLabel lblJosh = new JLabel("Josh Desmond");
		lblJosh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblJosh = new GridBagConstraints();
		gbc_lblJosh.insets = new Insets(0, 0, 5, 0);
		gbc_lblJosh.gridx = 1;
		gbc_lblJosh.gridy = 7;
		this.add(lblJosh, gbc_lblJosh);

		JLabel lblBrian = new JLabel("Brian McCarthy");
		lblBrian.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblBrian = new GridBagConstraints();
		gbc_lblBrian.insets = new Insets(0, 0, 5, 0);
		gbc_lblBrian.gridx = 1;
		gbc_lblBrian.gridy = 8;
		this.add(lblBrian, gbc_lblBrian);

		JLabel lblPeter = new JLabel("Peter DeBrine");
		lblPeter.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblPeter = new GridBagConstraints();
		gbc_lblPeter.insets = new Insets(0, 0, 5, 0);
		gbc_lblPeter.gridx = 1;
		gbc_lblPeter.gridy = 9;
		this.add(lblPeter, gbc_lblPeter);

		progressBar = new JProgressBar();
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.fill = GridBagConstraints.BOTH;
		gbc_progressBar.gridx = 1;
		gbc_progressBar.gridy = 12;
		this.add(progressBar, gbc_progressBar);
	}
}
