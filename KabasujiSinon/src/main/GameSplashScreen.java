package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DropMode;

public class GameSplashScreen {

	private JFrame frmKabasuji;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameSplashScreen window = new GameSplashScreen();
					window.frmKabasuji.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameSplashScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKabasuji = new JFrame();
		frmKabasuji.setTitle("Kabasuji");
		frmKabasuji.setBounds(100, 100, 800, 600);
		frmKabasuji.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{196, 392, 0};
		gridBagLayout.rowHeights = new int[]{76, 91, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmKabasuji.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Kabasuji");
		lblNewLabel.setForeground(new Color(51, 102, 255));
		lblNewLabel.setFont(new Font("GothamBlack", Font.BOLD, 90));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		frmKabasuji.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblGroupSinonSoftware = new JLabel("Software Engineering D2016");
		lblGroupSinonSoftware.setFont(new Font("GothamLight", Font.BOLD, 30));
		GridBagConstraints gbc_lblGroupSinonSoftware = new GridBagConstraints();
		gbc_lblGroupSinonSoftware.insets = new Insets(0, 0, 5, 0);
		gbc_lblGroupSinonSoftware.gridx = 1;
		gbc_lblGroupSinonSoftware.gridy = 4;
		frmKabasuji.getContentPane().add(lblGroupSinonSoftware, gbc_lblGroupSinonSoftware);
		
		JLabel lblSinon = new JLabel("Sinon");
		lblSinon.setFont(new Font("GothamLight", Font.PLAIN, 35));
		GridBagConstraints gbc_lblSinon = new GridBagConstraints();
		gbc_lblSinon.insets = new Insets(0, 0, 5, 0);
		gbc_lblSinon.gridx = 1;
		gbc_lblSinon.gridy = 5;
		frmKabasuji.getContentPane().add(lblSinon, gbc_lblSinon);
		
		JLabel lblKyleSposato = new JLabel("Kyle Sposato");
		GridBagConstraints gbc_lblKyleSposato = new GridBagConstraints();
		gbc_lblKyleSposato.insets = new Insets(0, 0, 5, 0);
		gbc_lblKyleSposato.gridx = 1;
		gbc_lblKyleSposato.gridy = 6;
		frmKabasuji.getContentPane().add(lblKyleSposato, gbc_lblKyleSposato);
		
		JLabel lblKartik = new JLabel("Kartik Thooppal Vasu");
		GridBagConstraints gbc_lblKartik = new GridBagConstraints();
		gbc_lblKartik.insets = new Insets(0, 0, 5, 0);
		gbc_lblKartik.gridx = 1;
		gbc_lblKartik.gridy = 7;
		frmKabasuji.getContentPane().add(lblKartik, gbc_lblKartik);
		
		JLabel lblJosh = new JLabel("Josh Desmond");
		GridBagConstraints gbc_lblJosh = new GridBagConstraints();
		gbc_lblJosh.insets = new Insets(0, 0, 5, 0);
		gbc_lblJosh.gridx = 1;
		gbc_lblJosh.gridy = 8;
		frmKabasuji.getContentPane().add(lblJosh, gbc_lblJosh);
		
		JLabel lblBrian = new JLabel("Brian McCarthy");
		GridBagConstraints gbc_lblBrian = new GridBagConstraints();
		gbc_lblBrian.insets = new Insets(0, 0, 5, 0);
		gbc_lblBrian.gridx = 1;
		gbc_lblBrian.gridy = 9;
		frmKabasuji.getContentPane().add(lblBrian, gbc_lblBrian);
		
		JLabel lblPeter = new JLabel("Peter DeBrine");
		GridBagConstraints gbc_lblPeter = new GridBagConstraints();
		gbc_lblPeter.insets = new Insets(0, 0, 5, 0);
		gbc_lblPeter.gridx = 1;
		gbc_lblPeter.gridy = 10;
		frmKabasuji.getContentPane().add(lblPeter, gbc_lblPeter);
	}

}
