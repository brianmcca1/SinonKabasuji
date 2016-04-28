package sinon.main;

import sinon.controllers.BullpenController;
import sinon.controllers.ExitGameController;
import sinon.controllers.FileHandler;
import sinon.controllers.HexStashRegistrator;
import sinon.controllers.TileRegistrator;
import sinon.models.Level;
import sinon.views.LevelTypeInfoView;
import sinon.views.MainView;
import sinon.views.game.GameInfoView;
import sinon.views.game.LevelSelectView;

@SuppressWarnings("serial")
public class Game extends Kabasuji {

	/** Holds all the levels for the game. */
	public Level[] allLevels = new Level[15];

	public Game() {
		super();

		startSplash("Kabasuji", new LevelSelectView(this));

		loadAllLevels();

	}

	/** Will pull every level from file and reset it. */
	public void loadAllLevels() {
		Level[] levels;
		levels = FileHandler.loadAllLevels();
		allLevels = levels.clone();

		System.out
		.println("GAME HAS LOADED ALL LEVELS INTO INTO ARRAY FROM FILES");
	}

	/**
	 * Called by the LevelStartController to open the MainView.
	 * 
	 * @param levelSelectView
	 *            LevelSelectView to remove from the frame.
	 */
	public void initializeMainView(LevelSelectView levelSelectView,
			LevelTypeInfoView lvlTypeInfoView) {
		if (this.mainView != null) {
			this.remove(this.mainView);
			this.revalidate();
		}
		this.setMainView(new MainView(this.getLevel(), new GameInfoView(this
				.getLevel()), lvlTypeInfoView));
		this.startNextPanel(levelSelectView, this.getMainView());
	}

	public void initializeMainControllers() {
		GameInfoView gameInfoView = (GameInfoView) this.mainView.getInfoPanel();
		gameInfoView.getExitButton().addActionListener(
				new ExitGameController(this));
		mainView.getBullpenView().addMouseListener(
				new BullpenController(this.currentLevel.getBullpen(), mainView
						.getBullpenView(), this.currentLevel));
		this.tileRegistrator = new TileRegistrator(getLevel(), mainView);
		this.tileRegistrator.setToGameType();
		registerBoardViewControllers();
		this.mainView.getBullpenView().setRegistrator(
				new HexStashRegistrator(getLevel(), getMainView(),
						false));
		this.getMainView()
		.getBullpenView()
		.getPanelToRegisterController()
		.addMouseListener(
				new BullpenController(this.getLevel().getBullpen(),
						this.getMainView().getBullpenView(), getLevel()));
	}

	/** @return Level object from the specified index in the allLevels array. */
	public Level getLevel(int index) {
		return this.allLevels[index];
	}

	public static void main(String args[]) {
		@SuppressWarnings("unused")
		Game game = new Game();
	}

}
