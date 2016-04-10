package main;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SplashScreenBuilder extends JPanel {
	private JTextField txtKabasujiBuilder;
	private JTextField txtSinon;
	private JTextField txtPeterDebrineKyle;
	public SplashScreenBuilder() {
		
		txtSinon = new JTextField();
		txtSinon.setHorizontalAlignment(SwingConstants.CENTER);
		txtSinon.setText("Sinon");
		add(txtSinon);
		txtSinon.setColumns(10);
		
		txtKabasujiBuilder = new JTextField();
		txtKabasujiBuilder.setHorizontalAlignment(SwingConstants.CENTER);
		txtKabasujiBuilder.setText("Kabasuji Builder");
		add(txtKabasujiBuilder);
		txtKabasujiBuilder.setColumns(10);
		
		txtPeterDebrineKyle = new JTextField();
		txtPeterDebrineKyle.setHorizontalAlignment(SwingConstants.CENTER);
		txtPeterDebrineKyle.setText("Peter DeBrine, Kyle Sposato, Brian McCarthy, Kartik, Josh");
		add(txtPeterDebrineKyle);
		txtPeterDebrineKyle.setColumns(50);
	}

}
