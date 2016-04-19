package sinon.main;

import java.awt.event.ActionListener;
import java.util.Optional;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import sinon.models.Board;
import sinon.models.Hexomino;
import sinon.models.Level;
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

    /**
     * Initializes a general frame.
     */
    Kabasuji() {
        this.setBounds(0, 0, WIDTH, HEIGHT);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Creates a SplashScreen with the given title and displays it.
     * 
     * @param nextPanel
     *            The next panel that will be displayed after this panel
     */
    /*
    public void startSplash(String title, JPanel nextPanel) {
        SplashScreen splash = new SplashScreen(title);
        this.add(splash);

        this.validate();

        ActionListener al = new ActionListener() {
            @Override
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
*/

<<<<<<< HEAD
	// COMMON VIEWS AND MODELS BETWEEN BOTH BUILDER AND GAME GO HERE
	// Stack undo = new Stack();
	// Stack redo = new Stack();
	// public Level[] levels = new Level[15];
	public Optional<Hexomino> selected;
	public Level opened;
	
/*
	public Kabasuji() {
		this.setBounds(100, 100, 800, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.selected = null;
	}
	*/

	/**
	 * Creates a SplashScreen with the given information and displays it
	 * 
	 * @param nextPanel
	 *            The next panel that will be displayed after this panel
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
	 * Removes The current panel and replaces it with the nextPanel
	 * @param current Panel that is currently in the frame
	 * @param nextPanel Panel to be put into the frame TODO
	 */
	public void startNextPanel(JPanel current, JPanel nextPanel) {
		this.remove(current);
		this.add(nextPanel);
		this.validate();
		this.repaint();
	}
	
	public void select(Optional<Hexomino> hex){
		this.selected = hex;
	}
	
	public void deselect(){
		this.selected.empty();
	}
	
	public boolean hasSelected(){
		return this.selected.isPresent();
	}

  
=======
    /**
     * Removes the current panel and replaces it with the nextPanel
     * 
     * @param current
     *            Panel that is currently being displayed
     * @param nextPanel
     *            Panel to be put into the frame
     */
    public void startNextPanel(JPanel current, JPanel nextPanel) {
        this.remove(current);
        this.add(nextPanel);
        // Validate just seems to really make weird errors go away.
        this.revalidate();
        this.repaint();
    }
>>>>>>> master
}
