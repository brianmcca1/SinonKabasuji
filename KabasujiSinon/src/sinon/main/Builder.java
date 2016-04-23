package sinon.main;

import java.io.File;

import javax.swing.JPanel;

import sinon.models.Level;
import sinon.views.MainView;
import sinon.views.builder.BankView;
import sinon.views.builder.BuilderMenuBar;

@SuppressWarnings("serial")
public class Builder extends Kabasuji {

	/** Used by JMenuItem controllers to deal with file operations. */
	File currentFile;
	/** Builder's knowledge of the level. */
	Level currentLevel;
	
	JPanel blankPanel;
	
	Builder() {
		super();
		this.currentFile = null;
		//startSplash("Kabasuji Builder", new MainView(this, new BankView(this)));
		this.blankPanel = new JPanel();
		startSplash("Kabasuji Builder", this.blankPanel);
		BuilderMenuBar menuBar = new BuilderMenuBar(this, this.blankPanel);
		this.setJMenuBar(menuBar);
	}

	public static void main(String args[]) {
		@SuppressWarnings("unused")
		Builder builder = new Builder();
	}
	
	public void setCurrentFile(File f){this.currentFile = f;}
	
	public void setCurrentLevel(Level l){this.currentLevel = l;}
	
	public File getCurrentFile(){return this.currentFile;}
	
	public Level getCurrentLevel(){return this.currentLevel;}
}
