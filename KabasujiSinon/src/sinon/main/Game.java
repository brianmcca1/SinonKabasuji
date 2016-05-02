package sinon.main;

import sinon.controllers.ExitGameController;
import sinon.controllers.FileHandler;
import sinon.controllers.HexStashRegistrator;
import sinon.controllers.TileRegistrator;
import sinon.models.Level;
import sinon.views.LevelTypeInfoView;
import sinon.views.MainView;
import sinon.views.game.GameInfoView;
import sinon.views.game.LevelSelectView;

/**
 * This is the main application class for the Game that extends the superclass
 * {@link Kabasuji}. Therefore it is a JFrame.
 *
 */
@SuppressWarnings("serial")
public class Game extends Kabasuji {

	/** Holds all the levels for the game. */
	public Level[] allLevels = new Level[15];

	public LevelSelectView levelSelectView;

	public Game() {
		super();
		loadAllLevels();
		this.levelSelectView = new LevelSelectView(this);
		startSplash("Kabasuji", this.levelSelectView);
	}

	/** Will pull every level from file and reset it. */
	public void loadAllLevels() {
		Level[] levels;
		levels = FileHandler.loadAllLevels();
		allLevels = levels.clone();
	}

	/**
	 * Called by the LevelStartController to open the MainView.
	 * 
	 * @param levelSelectView
	 *            LevelSelectView to remove from the frame.
	 */
	public void initializeMainView(LevelSelectView levelSelectView, LevelTypeInfoView lvlTypeInfoView) {
		if(this.levelSelectView != null){
			this.remove(this.levelSelectView);
			this.revalidate();
		}
		if (this.mainView != null) {
			this.remove(this.mainView);
			this.revalidate();
		}
		this.setMainView(new MainView(this.getLevel(), new GameInfoView(this.getLevel()), lvlTypeInfoView));
		this.startNextPanel(levelSelectView, this.getMainView());
	}

	public void initializeControllers() {
		GameInfoView gameInfoView = (GameInfoView) this.mainView.getInfoPanel();
		gameInfoView.getExitButton().addActionListener(
				new ExitGameController(this));
		this.tileRegistrator = new TileRegistrator(getLevel(), mainView);
		this.tileRegistrator.setToGameType();
		registerBoardViewControllers();
		getMainView().getBullpenView().setRegistrator(new HexStashRegistrator(getLevel(), getMainView(), false));

		registerBullpenController();
	}

	/** @return Level object from the specified index in the allLevels array. */
	public Level getLevel(int index) {
		return this.allLevels[index];
	}
	
	public void determineUnlocking(){
		if(this.getCurrentLevelNumber() == 14) return;
		if(this.getLevel().getLevelData().getStarRecord() >= 1){
			this.getLevel(this.getCurrentLevelNumber() + 1).getLevelData().setUnlocked(true);
		}
	}

	public static void main(String args[]) {
		@SuppressWarnings("unused")
		Game game = new Game();
	}

}
