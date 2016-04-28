package sinon.controllers;

import java.io.File;
import sinon.main.Game;
import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Level;
import sinon.models.data.BoardData;
import sinon.models.data.BullPenData;
import sinon.models.data.LevelData;
import sinon.models.data.LevelProperty;
import sinon.serial.Deserializer;
import sinon.serial.Serializer;

/**
 * Class that handles all the game files that are created using the builder.
 * It is used to set the current file static field.
 *
 */
public class FileHandler {

	public static File currentFile;
	
	/**
	 * Saves builder to the file after converting model classes into their 
	 * corresponding serializable classes.
	 * @param fileToSaveTo This is the file that is being saved to.
	 * @param level This is the level that is being saved.
	 * @param levelProp Holds game specific information.
	 */
	public static void builderSaveLevelToFile(File fileToSaveTo, Level level, LevelProperty levelProp){
        //CREATE THE LEVELS BULLPENDATA AND SET IT
        BullPenData levelBullpenData = new BullPenData(level.getBullpen());
        level.getLevelData().setBullpenData(levelBullpenData);
        
        //CREATE THE LEVELS BOARDDATA AND SET IT
        BoardData levelBoardData = new BoardData(level.getBoard());
        level.getLevelData().setBoardData(levelBoardData);
		
        Serializer serializer = new Serializer(fileToSaveTo, level.getLevelData());
        serializer.serializeFile();
	}
	
	/**
	 * Sets the static current file to f.
	 * @param f
	 */
	public static void setCurrentFile(File f){
		FileHandler.currentFile = f;
	}
	
    /** Will determine which file to set for the Game based on the currently open level. */
    public static void determineCurrentGameLevelFile(int currentLevelNumber){
    	switch(currentLevelNumber){
    		case 0:
    			setCurrentFile(new File("level1.dat"));
    			break;
    		case 1:
    			setCurrentFile(new File("level2.dat"));
    			break;
    		case 2:
    			setCurrentFile(new File("level3.dat"));
    			break;
    		case 3:
    			setCurrentFile(new File("level4.dat"));
    			break;
    		case 4:
    			setCurrentFile(new File("level5.dat"));
    			break;
    		case 5:
    			setCurrentFile(new File("level6.dat"));
    			break;
    		case 6:
    			setCurrentFile(new File("level7.dat"));
    			break;
    		case 7:
    			setCurrentFile(new File("level8.dat"));
    			break;
    		case 8:
    			setCurrentFile(new File("level9.dat"));
    			break;
    		case 9:
    			setCurrentFile(new File("level10.dat"));
    			break;
    		case 10:
    			setCurrentFile(new File("level11.dat"));
    			break;
    		case 11:
    			setCurrentFile(new File("level12.dat"));
    			break;
    		case 12:
    			setCurrentFile(new File("level13.dat"));
    			break;
    		case 13:
    			setCurrentFile(new File("level14.dat"));
    			break;
    		case 14:
    			setCurrentFile(new File("level15.dat"));
    			break;
    	}
    }
    
    /**
     * Deserializes all the levels that exist and loads them into the game/builder.
     * @return Array of levels that were deserialized.
     */
    public static Level[] loadAllLevels(){
    	Level[] levels = new Level[2];
    	
        File levelFile = new File("level1.dat");
        Deserializer deserializer = new Deserializer(levelFile);
        LevelData levelData = deserializer.deserializeFile();

        Level levelOne = new Level(levelData.getLevelType(), new Board(levelData.getBoardData()), new BullPen(levelData.getBullpenData()));
        levelOne.setLevelData(levelData);

        levels[0] = levelOne;

        
        levelFile = new File("level2.dat");
        deserializer = new Deserializer(levelFile);
        levelData = deserializer.deserializeFile();
        
        Level levelTwo = new Level(levelData.getLevelType(), new Board(levelData.getBoardData()), new BullPen(levelData.getBullpenData()));
        levelTwo.setLevelData(levelData);
        
        levels[1] = levelTwo;
        
        
        return levels;
    }
}
