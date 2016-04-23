package sinon.serial;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import sinon.models.data.LevelData;

/**
 * This class is used by the Builder to save a LevelData object to a binary file.
 * @author Kyle
 */
public class Serializer {

	/** File to save levelData to*/
	private File fileToSave;
	/** LevelData to write to file*/
	private LevelData levelData;
	
	/**
	 * @param f File to save levelData to
	 * @param ld LevelData to write to file
	 */
	public Serializer(File f, LevelData ld){
		this.fileToSave = f;
		this.levelData = ld;
	}
	
	/**
	 * Serializes levelData to fileToSave.
	 * NOTE: this function also takes into account the selected directory from the JFileChooser.
	 * @return indicates success or failure of serialization
	 */
	public void serializeFile(){
		try{
			FileOutputStream fout = new FileOutputStream(this.fileToSave);
			ObjectOutputStream oos = new ObjectOutputStream(fout);   
			oos.writeObject(this.levelData);
			oos.close();
			System.out.println("SERIALIZING FILE: " + this.fileToSave.getName());
			System.out.println("SERIALIZER SUCCESSFUL");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
