package sinon.main;

import java.io.File;
import javax.swing.JPanel;
import sinon.models.BullPen;
import sinon.models.Level;
import sinon.models.data.HexominoBankData;
import sinon.views.MainView;
import sinon.views.builder.BuilderMenuBar;
@SuppressWarnings("serial")
public class Builder extends Kabasuji {

	/** Used by JMenuItem controllers to deal with file operations. */
	File currentFile;
	/** Builder's knowledge of the level. */
	Level level;
	JPanel blankPanel;
	MainView mainView;
    BullPen bullpen = new BullPen(HexominoBankData.getHexominos());
	
	Builder() {
		super();
		
		this.currentFile = null;
		this.blankPanel = new JPanel();
		startSplash("Kabasuji Builder", this.blankPanel);
		this.setJMenuBar(new BuilderMenuBar(this, this.blankPanel));
	}
	
	public void setCurrentFile(File f){this.currentFile = f;}
	
	public void setCurrentLevel(Level l){this.level = l;}
	
	public File getCurrentFile(){return this.currentFile;}
	
	public Level getCurrentLevel(){return this.level;}
	
	public MainView getMainView(){return this.mainView;}
	
	public BullPen getBullpen(){return this.bullpen;}
	
	public static void main(String args[]) {
		@SuppressWarnings("unused")
		Builder builder = new Builder();
	}
}
