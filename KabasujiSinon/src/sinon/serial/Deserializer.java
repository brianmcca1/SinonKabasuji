package sinon.serial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import sinon.models.Hexomino;
import sinon.models.data.LevelData;

/**
 * This class will take a selected file and open it to deserialize a LevelData object.
 * @author Kyle
 */
public class Deserializer {
	
	/** File to read a LevelData from.*/
	private File fileToOpen;
	/** LevelData object read from file.*/
	private LevelData levelData;
	
	/**
	 * @param f File to open/read from.
	 */
	public Deserializer(File f){
		this.fileToOpen = f;
	}


	/**
	 * Reads a LevelData object from a file and stores it.
	 * NOTE: this function also takes into account the selected directory from the JFileChooser.
	 * @return indicates success or failure of deserialization
	 */
	public boolean deserializeFile() {
	    try{
	    	FileInputStream fin = new FileInputStream(fileToOpen);
	    	ObjectInputStream ois = new ObjectInputStream(fin);
	    	this.levelData = (LevelData) ois.readObject();
	    	ois.close();
	    	return true;
	    }catch(Exception ex){
	    	ex.printStackTrace();
	    	return false;
	    } 
	}
	
}
