package sinon.main;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

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
        this.validate();
        this.repaint();
    }
}
