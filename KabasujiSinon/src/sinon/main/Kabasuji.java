package sinon.main;

import java.util.Stack;
import javax.swing.JFrame;
import javax.swing.JPanel;
import sinon.models.Level;
import sinon.views.SplashScreen;

public abstract class Kabasuji extends JFrame{

	//COMMON VIEWS AND MODELS BETWEEN BOTH BUILDER AND GAME GO HERE
	//Stack undo = new Stack();
	//Stack redo = new Stack();
	//public Level[] levels = new Level[15];
	
	public Kabasuji(){
		this.setBounds(100, 100, 800, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Creates a SplashScreen with the given information and displays it
	 * @param nextPanel The next panel that will be displayed after this panel
	 */
	public void startSplash(String title, JPanel nextPanel){
		SplashScreen splash = new SplashScreen(title);
		this.add(splash);
	}

}
