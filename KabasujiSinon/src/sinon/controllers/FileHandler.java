package sinon.controllers;

import java.io.File;

import sinon.models.Level;
import sinon.models.LightningLevel;
import sinon.models.PuzzleLevel;
import sinon.models.ReleaseLevel;
import sinon.models.data.BoardData;
import sinon.models.data.BullPenData;
import sinon.models.data.LevelData;
import sinon.serial.Deserializer;
import sinon.serial.Serializer;

public class FileHandler {

	/** Current File being handled. */
	public static File currentFile;

	/**
	 * Will save the current level to file.
	 * 
	 * @param fileToSaveTo
	 *            File to save to.
	 * @param level
	 *            Level to save.
	 * @param levelProp
	 *            LevelProperty of level to set.
	 */
	public static void builderSaveLevelToFile(File fileToSaveTo, Level level) {
		// CREATE THE LEVELS BULLPENDATA AND SET IT
		BullPenData levelBullpenData = new BullPenData(level.getBullpen());
		level.getLevelData().setBullpenData(levelBullpenData);

		// CREATE THE LEVELS BOARDDATA AND SET IT
		BoardData levelBoardData = new BoardData(level.getBoard());
		level.getLevelData().setBoardData(levelBoardData);

		level.getLevelData().setStarRecord(0);

		Serializer serializer = new Serializer(fileToSaveTo, level.getLevelData());
		serializer.serializeFile();
	}

	public static void setCurrentFile(File f) {
		FileHandler.currentFile = f;
	}

	/**
	 * Will determine which file to set for the Game based on the currently open
	 * level.
	 */
	public static void determineCurrentGameLevelFile(int currentLevelNumber) {
		String levelNumString = Integer.toString(currentLevelNumber + 1);
		String fileString = "level" + levelNumString + ".dat";
		setCurrentFile(new File(fileString));
	}

	/**
	 * Will load all levels from the local project directory files.
	 * 
	 * @return Returns Level[].
	 */
	public static Level[] loadAllLevels() {
		Level[] levels = new Level[3];

		File levelFile;
		Deserializer deserializer;
		LevelData levelData;
		Level level;
		
		levelFile = new File("level1.dat");
		deserializer = new Deserializer(levelFile);
		levelData = deserializer.deserializeFile();
		level = new PuzzleLevel(new Level(levelData));
		levels[0] = level;

		levelFile = new File("level2.dat");
		deserializer = new Deserializer(levelFile);
		levelData = deserializer.deserializeFile();
		level = new LightningLevel(new Level(levelData));
		levels[1] = level;
		
		levelFile = new File("level3.dat");
		deserializer = new Deserializer(levelFile);
		levelData = deserializer.deserializeFile();
		level = new ReleaseLevel(new Level(levelData));
		levels[2] = level;

		return levels;
	}

	public static String determineFileStringForStars(int starsEarned) {
		String fileString = "/images/" + Integer.toString(starsEarned) + "star.png";
		return fileString;
	}
}
