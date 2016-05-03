package sinon.main;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import sinon.controllers.BullpenController;
import sinon.controllers.FileHandler;
import sinon.controllers.HexStashRegistrator;
import sinon.controllers.TileRegistrator;
import sinon.models.Level;
import sinon.views.MainView;
// import sinon.views.LevelSelectView;
import sinon.views.SplashScreen;
import sinon.views.TileView;

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
	/**
	 * Knowledge of the current level number. Used by some controllers to deal
	 * with serializing the proper Level.
	 */
	public int currentLevelNumber;
	/** Knowledge of the MainView. */
	protected MainView mainView;

	/**
	 * This field is in charge of registering the controllers to tiles. It is
	 * the job of all subclasses of Kabasuji to set this field.
	 */
	protected TileRegistrator tileRegistrator;

	/** Initializes a general frame. */
	Kabasuji() {
		this.setBounds(0, 0, WIDTH, HEIGHT);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Creates a SplashScreen with the given information and displays it.
	 * 
	 * @param title
	 *            Title to be displayed on the SplashScreen panel.
	 * @param nextPanel
	 *            The next panel that will be displayed after this panel.
	 */
	public void startSplash(String title, final JPanel nextPanel) {
		final SplashScreen splash = new SplashScreen(title);
		SplashScreen.theGoods.setVisible(false);
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
				
				if(SplashScreen.count == 50){
					SplashScreen.theGoods.setVisible(true);
				}
				
				if(SplashScreen.count == 60){
					SplashScreen.theGoods.setVisible(false);
				}
			}
		};
		SplashScreen.timer = new Timer(35, al);
		SplashScreen.timer.start();
	}

	/**
	 * Removes the current panel and replaces it with the nextPanel.
	 * 
	 * @param current
	 *            Panel that is currently being displayed.
	 * @param nextPanel
	 *            Panel to be put into the frame.
	 */
	public void startNextPanel(JPanel current, JPanel nextPanel) {
		this.remove(current);
		this.add(nextPanel);
		this.revalidate();
	}

	/** @return returns the MainView object. */
	public MainView getMainView() {
		return this.mainView;
	}

	/** Sets the MainView object. 
	 * @param m MainView to set.
	 */
	public void setMainView(MainView m) {
		this.mainView = m;
	}

	/** @return gets the Level object. */
	public Level getLevel() {
		return this.currentLevel;
	}

	/** Sets the Level object. 
	 * @param l level to set.
	 */
	public void setLevel(Level l) {
		this.currentLevel = l;
	}

	/**
	 * Will determine which file to set for the Game based on the currently open
	 * level.
	 */
	public void determineCurrentGameLevelFile() {
		FileHandler.determineCurrentGameLevelFile(this.currentLevelNumber);
	}

	/**
	 * @param n current level number to set.
	 */
	public void setCurrentLevelNumber(int n) {
		this.currentLevelNumber = n;
	}

	/**
	 * @return the current level number.
	 */
	public int getCurrentLevelNumber() {
		return this.currentLevelNumber;
	}

	/** Revalidate the mainView. */
	public void revalidateMainView() {
		this.mainView.revalidate();
	}

	/**
	 * Registers the BuilderTileControllers to each TileView in the Builder's
	 * BoardView. Before calling this, please assure that
	 * {@link #tileRegistrator} has been set to the proper type (depending on
	 * whether you are a builder or game).
	 */
	public void registerBoardViewControllers() {
		ArrayList<TileView> tileViews = (ArrayList<TileView>) this
				.getMainView().getBoardView().getTileViews();

		assert tileViews != null;
		assert tileViews.size() == 144;

		for (int i = 0; i < tileViews.size(); i++) {
			this.getTileRegistrator().register(tileViews.get(i));
		}
	}

	/** Getter for the tileRegistrator object. */
	protected TileRegistrator getTileRegistrator() {
		return this.tileRegistrator;
	}

	/**
	 * Adds the registrator to the bullpen, and adds the overall bullpen
	 * controller.
	 */
	protected void registerBullpenController() {
		this.getMainView().getBullpenView().setRegistrator(
				new HexStashRegistrator(getLevel(), getMainView(), false));

		JPanel bullpenPanel = this.getMainView().getBullpenView()
				.getPanelToRegisterController();

		BullpenController bullpenController = new BullpenController(this
				.getLevel().getBullpen(), this.getMainView().getBullpenView(),
				getLevel());
		bullpenPanel.addMouseListener(bullpenController);
	}
}
