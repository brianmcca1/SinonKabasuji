package sinon.main;

import java.io.File;

import sinon.controllers.BullpenController;
import sinon.controllers.ExitGameController;
import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Level;
import sinon.models.data.LevelData;
import sinon.serial.Deserializer;
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
        File levelOneFile = new File("level1.dat");
        Deserializer deserializer = new Deserializer(levelOneFile);
        LevelData levelOneData = deserializer.deserializeFile();

        Level levelOne = new Level(levelOneData.getLevelType(),
                new Board(levelOneData.getBoardData()),
                new BullPen(levelOneData.getBullpenData()));
        levelOne.setLevelData(levelOneData);

        allLevels[0] = levelOne;

        System.out.println(
                "GAME HAS LOADED ALL LEVELS INTO INTO ARRAY FROM FILES");
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
        this.setMainView(new MainView(this.getLevel(),
                new GameInfoView(this.getLevel()), lvlTypeInfoView));
        this.startNextPanel(levelSelectView, this.getMainView());
    }

    public void initializeMainControllers() {
        GameInfoView gameInfoView = (GameInfoView) this.mainView.getInfoPanel();
        gameInfoView.getExitButton()
                .addActionListener(new ExitGameController(this));
        mainView.getBullpenView().addMouseListener(
                new BullpenController(this.currentLevel.getBullpen(),
                        mainView.getBullpenView(), this.currentLevel));
        this.tileRegistrator = new TileRegistrator(getLevel(), mainView);
        this.tileRegistrator.setToGameType();
        registerBoardViewControllers();
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
