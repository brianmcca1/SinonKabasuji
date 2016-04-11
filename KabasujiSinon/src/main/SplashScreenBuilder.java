package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SplashScreenBuilder {
	private JTextField txtKabasujiBuilder;
	private JTextField txtSinon;
	private JTextField txtPeterDebrineKyle;
	private JFrame frame;
	public SplashScreenBuilder() {
		
		txtSinon = new JTextField();
		txtSinon.setHorizontalAlignment(SwingConstants.CENTER);
		txtSinon.setText("Sinon");
		frame.add(txtSinon);
		txtSinon.setColumns(10);
		
		txtKabasujiBuilder = new JTextField();
		txtKabasujiBuilder.setHorizontalAlignment(SwingConstants.CENTER);
		txtKabasujiBuilder.setText("Kabasuji Builder");
		frame.add(txtKabasujiBuilder);
		txtKabasujiBuilder.setColumns(10);
		
		txtPeterDebrineKyle = new JTextField();
		txtPeterDebrineKyle.setHorizontalAlignment(SwingConstants.CENTER);
		txtPeterDebrineKyle.setText("Peter DeBrine, Kyle Sposato, Brian McCarthy, Kartik, Josh");
		frame.add(txtPeterDebrineKyle);
		txtPeterDebrineKyle.setColumns(50);
		
		frame = new JFrame();
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
	}

	/**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	SplashScreenBuilder window = new SplashScreenBuilder();
                    window.frame.setVisible(true);
                    /*
                    int sum = 0;
                    for(int i = 0; i<1000; i++){
                    	for(int j = 0; j<1000; j++){
                    		sum = i+j;
                    	}
                    } */
                    window.frame.setVisible(false);
                    
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
