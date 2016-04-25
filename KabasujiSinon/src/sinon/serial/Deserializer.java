package sinon.serial;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import sinon.models.data.LevelData;

/**
 * This class will take a selected file and open it to deserialize a LevelData object.
 * @author Kyle
 */
public class Deserializer {
	
	/** File to read a LevelData from. */
	private File fileToOpen;
	
	/** @param f File to open/read from. */
	public Deserializer(File f){
		this.fileToOpen = f;
	}

	/**
	 * Reads a LevelData object from a file and stores it.
	 * NOTE: this function also takes into account the selected directory from the JFileChooser.
	 * @return indicates success or failure of deserialization
	 */
	public LevelData deserializeFile() {
	    try{
	    	FileInputStream fin = new FileInputStream(fileToOpen);
	    	ObjectInputStream ois = new ObjectInputStream(fin);
	    	LevelData levelData = (LevelData) ois.readObject();
	    	ois.close();
	    	System.out.println("DESERIALIZING FILE: " + this.fileToOpen.getName());
	    	System.out.println("DESERIALIZER SUCCESSFUL");
	    	return levelData;
	    }catch(Exception ex){
	    	ex.printStackTrace();
	    	return null;
	    } 
	}
	
}
