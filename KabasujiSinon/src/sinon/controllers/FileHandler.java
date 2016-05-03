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
		level.getLevelData().setUnlocked(false);

		Serializer serializer = new Serializer(fileToSaveTo, level.getLevelData());
		serializer.serializeFile();
	}

	/**
	 * Set the current file
	 * 
	 * @param f
	 *            The file being set
	 */
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
		Level[] levels = new Level[15];

		File levelFile;
		Deserializer deserializer;
		LevelData levelData;
		Level level;

		levelFile = new File("level1.dat");
		deserializer = new Deserializer(levelFile);
		levelData = deserializer.deserializeFile();
		//levelData.setUnlocked(true);
		level = new PuzzleLevel(new Level(levelData));
		levels[0] = level;

		levelFile = new File("level2.dat");
		deserializer = new Deserializer(levelFile);
		levelData = deserializer.deserializeFile();
		//levelData.setUnlocked(true);
		level = new LightningLevel(new Level(levelData));
		levels[1] = level;

		levelFile = new File("level3.dat");
		deserializer = new Deserializer(levelFile);
		levelData = deserializer.deserializeFile();
		//levelData.setUnlocked(true);
		level = new ReleaseLevel(new Level(levelData));
		levels[2] = level;

		levelFile = new File("level4.dat");
		deserializer = new Deserializer(levelFile);
		levelData = deserializer.deserializeFile();
		//levelData.setUnlocked(true);
		level = new PuzzleLevel(new Level(levelData));
		levels[3] = level;

		levelFile = new File("level5.dat");
		deserializer = new Deserializer(levelFile);
		levelData = deserializer.deserializeFile();
		//levelData.setUnlocked(true);
		level = new LightningLevel(new Level(levelData));
		levels[4] = level;

		levelFile = new File("level6.dat");
		deserializer = new Deserializer(levelFile);
		levelData = deserializer.deserializeFile();
		//levelData.setUnlocked(true);
		level = new ReleaseLevel(new Level(levelData));
		levels[5] = level;

		levelFile = new File("level7.dat");
		deserializer = new Deserializer(levelFile);
		levelData = deserializer.deserializeFile();
		//levelData.setUnlocked(true);
		level = new PuzzleLevel(new Level(levelData));
		levels[6] = level;

		levelFile = new File("level8.dat");
		deserializer = new Deserializer(levelFile);
		levelData = deserializer.deserializeFile();
		//levelData.setUnlocked(true);
		level = new LightningLevel(new Level(levelData));
		levels[7] = level;

		levelFile = new File("level9.dat");
		deserializer = new Deserializer(levelFile);
		levelData = deserializer.deserializeFile();
		//levelData.setUnlocked(true);
		level = new ReleaseLevel(new Level(levelData));
		levels[8] = level;

		levelFile = new File("level10.dat");
		deserializer = new Deserializer(levelFile);
		levelData = deserializer.deserializeFile();
		//levelData.setUnlocked(true);
		level = new PuzzleLevel(new Level(levelData));
		levels[9] = level;

		levelFile = new File("level11.dat");
		deserializer = new Deserializer(levelFile);
		levelData = deserializer.deserializeFile();
		//levelData.setUnlocked(true);
		level = new LightningLevel(new Level(levelData));
		levels[10] = level;

		levelFile = new File("level12.dat");
		deserializer = new Deserializer(levelFile);
		levelData = deserializer.deserializeFile();
		//levelData.setUnlocked(true);
		level = new ReleaseLevel(new Level(levelData));
		levels[11] = level;

		levelFile = new File("level13.dat");
		deserializer = new Deserializer(levelFile);
		levelData = deserializer.deserializeFile();
		//levelData.setUnlocked(true);
		level = new PuzzleLevel(new Level(levelData));
		levels[12] = level;

		levelFile = new File("level14.dat");
		deserializer = new Deserializer(levelFile);
		levelData = deserializer.deserializeFile();
		//levelData.setUnlocked(true);
		level = new LightningLevel(new Level(levelData));
		levels[13] = level;

		levelFile = new File("level15.dat");
		deserializer = new Deserializer(levelFile);
		levelData = deserializer.deserializeFile();
		//levelData.setUnlocked(true);
		level = new ReleaseLevel(new Level(levelData));
		levels[14] = level;

		return levels;
	}

	/**
	 * Find the appropriate image for a certain number of stars
	 * 
	 * @param starsEarned
	 *            The number of stars earned
	 * @return The file string for the image
	 */
	public static String determineFileStringForStars(int starsEarned) {
		String fileString = "/images/" + Integer.toString(starsEarned) + "star.png";
		return fileString;
	}

	/**
	 * Sets the number of stars for a given level when the level is exited
	 * 
	 * @param level
	 *            The level being exited
	 */
	public static void setStarsOnExit(Level level) {
		int newStarRecord = level.countStars();
		int knownStarRecord = level.getLevelData().getStarRecord();
		if (newStarRecord > knownStarRecord)
			level.getLevelData().setStarRecord(newStarRecord);

		Serializer serializer = new Serializer(currentFile, level.getLevelData());
		serializer.serializeFile();

		System.out.println("EARNED STARS: " + level.getLevelData().getStarRecord());

	}
}
