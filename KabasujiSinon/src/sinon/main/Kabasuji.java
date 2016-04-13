package sinon.main;

import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import sinon.models.Level;
import sinon.views.LevelSelectView;
import sinon.views.SplashScreen;

public abstract class Kabasuji extends JFrame {

	// COMMON VIEWS AND MODELS BETWEEN BOTH BUILDER AND GAME GO HERE
	// Stack undo = new Stack();
	// Stack redo = new Stack();
	// public Level[] levels = new Level[15];

	public Kabasuji() {
		this.setBounds(100, 100, 800, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Creates a SplashScreen with the given information and displays it
	 * 
	 * @param nextPanel
	 *            The next panel that will be displayed after this panel
	 */
	public void startSplash(String title, JPanel nextPanel) {
		SplashScreen splash = new SplashScreen(title);
		this.add(splash);
		
		this.validate();

		ActionListener al = new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				SplashScreen.count++;
				SplashScreen.progressBar.setValue(SplashScreen.count);
				if (SplashScreen.count == 100) {
					SplashScreen.timer.stop();
					startNextPanel(splash, nextPanel);
				}
			}
		};
		SplashScreen.timer = new Timer(25, al);
		SplashScreen.timer.start();
	}

	/**
	 * Removes SplashScreen panel and replaces it with the nextPanel
	 * @param s SplashScreen panel that is currently in the frame
	 * @param nextPanel Panel to be put into the frame
	 */
	public void startNextPanel(SplashScreen s, JPanel nextPanel) {
		this.remove(s);
		this.add(nextPanel);
		nextPanel.validate();
		this.repaint();
	}

}
