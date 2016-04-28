package sinon.controllers;

import java.io.File;

import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Level;
import sinon.models.data.BoardData;
import sinon.models.data.BullPenData;
import sinon.models.data.LevelData;
import sinon.models.data.LevelProperty;
import sinon.serial.Deserializer;
import sinon.serial.Serializer;

public class FileHandler {

	public static File currentFile;

	public static void builderSaveLevelToFile(File fileToSaveTo, Level level,
			LevelProperty levelProp) {
		// CREATE THE LEVELS BULLPENDATA AND SET IT
		BullPenData levelBullpenData = new BullPenData(level.getBullpen());
		level.getLevelData().setBullpenData(levelBullpenData);

		// CREATE THE LEVELS BOARDDATA AND SET IT
		BoardData levelBoardData = new BoardData(level.getBoard());
		level.getLevelData().setBoardData(levelBoardData);

		Serializer serializer = new Serializer(fileToSaveTo,
				level.getLevelData());
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
		String levelNumString = Integer.toString(currentLevelNumber+1);
		String fileString = "level" + levelNumString + ".dat";
		setCurrentFile(new File(fileString));
	}

	public static Level[] loadAllLevels() {
		Level[] levels = new Level[2];

		File levelFile = new File("level1.dat");
		Deserializer deserializer = new Deserializer(levelFile);
		LevelData levelData = deserializer.deserializeFile();

		Level levelOne = new Level(levelData.getLevelType(), new Board(
				levelData.getBoardData()), new BullPen(
						levelData.getBullpenData()));
		levelOne.setLevelData(levelData);

		levels[0] = levelOne;

		levelFile = new File("level2.dat");
		deserializer = new Deserializer(levelFile);
		levelData = deserializer.deserializeFile();

		Level levelTwo = new Level(levelData.getLevelType(), new Board(
				levelData.getBoardData()), new BullPen(
						levelData.getBullpenData()));
		levelTwo.setLevelData(levelData);

		levels[1] = levelTwo;

		return levels;
	}
}
