package sinon.main;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import sinon.models.Level;
import sinon.views.BoardView;
import sinon.views.BullpenView;
import sinon.views.MainView;
//import sinon.views.LevelSelectView;
import sinon.views.SplashScreen;

/**
 * Kabasuji is a parent class which is the equivalent of the "Application" class
 * in some of the example EBC projects we've seen.
 * 
 * By extending JFrame, it is therefore the class in charge of switching out
 * what's being displayed. Do this with {@link #startNextPanel(JPanel, JPanel)}.
 */
@SuppressWarnings("serial")
public abstract class Kabasuji extends JFrame {
	
    /** Width in pixels of the frame */
    static final int WIDTH = 800;
    /** Height in pixels of the frame */
    static final int HEIGHT = 600;
	/** Knowledge of the current level. */
	public Level currentLevel;
	/** Knowledge of the current level number. 
	 * Used by some controllers to deal with serializing the proper Level. */
	public int currentLevelNumber;
	/** Knowledge of the MainView.*/
    public MainView mainView;
    /** Knowledge of the BullpenView. */
    public BullpenView bullpenView;
    /** Knowledge of the BoardView. */
    public BoardView boardView;
	
	/** Initializes a general frame. */
    Kabasuji() {
        this.setBounds(0, 0, WIDTH, HEIGHT);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

	/**
	 * Creates a SplashScreen with the given information and displays it.
	 * @param title Title to be displayed on the SplashScreen panel.
	 * @param nextPanel The next panel that will be displayed after this panel.
	 */
	public void startSplash(String title, final JPanel nextPanel) {
		final SplashScreen splash = new SplashScreen(title);
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
     * Removes the current panel and replaces it with the nextPanel.
     * @param current Panel that is currently being displayed.
     * @param nextPanel Panel to be put into the frame.
     */
    public void startNextPanel(JPanel current, JPanel nextPanel) {
        this.remove(current);
        this.add(nextPanel);
        this.revalidate();
    }
    
    public BullpenView getBullpenView(){return this.bullpenView;}
    
    /** @return returns the MainView object. */
    public MainView getMainView(){ return this.mainView;}
    
    /** Sets the MainView object. */
    public void setMainView(MainView m){ this.mainView = m;}
    
    /** @return gets the Level object. */
    public Level getLevel(){ return this.currentLevel;}
    
    /** Sets the Level object. */
    public void setLevel(Level l){this.currentLevel = l;}
    
    public void registerBoardViewControllers(){}
    
    public void setCurrentLevelNumber(int n){
    	this.currentLevelNumber = n;
    }
    
    public void revalidateMainView(){
    	this.mainView.revalidate();
    }
}
