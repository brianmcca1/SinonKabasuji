package sinon.main;

import java.io.File;
import sinon.models.Level;
import sinon.views.MainView;
import sinon.views.builder.BankView;

@SuppressWarnings("serial")
public class Builder extends Kabasuji {

	/** Used by JMenuItem controllers to deal with file operations. */
	File currentFile;
	/** Builder's knowledge of the level. */
	Level currentLevel;
	
	Builder() {
		super();
		startSplash("Kabasuji Builder", new MainView(this, new BankView(this)));
	}

	public static void main(String args[]) {
		@SuppressWarnings("unused")
		Builder builder = new Builder();
	}
	
	public void setCurrentFile(File f){
		this.currentFile = f;
	}
	
	public void setCurrentLevel(Level l){
		this.currentLevel = l;
	}
	
	public File getCurrentFile(){
		return this.currentFile;
	}
}
