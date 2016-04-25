package sinon.main;

import java.io.File;
import javax.swing.JPanel;
import sinon.models.BullPen;
import sinon.models.data.HexominoBankData;
import sinon.views.MainView;
import sinon.views.builder.BankView;
import sinon.views.builder.BuilderMenuBar;
@SuppressWarnings("serial")
public class Builder extends Kabasuji {

	/** File that is currently being read from / saved to. */
	File currentFile;
	/** JPanel that the builder initially starts out with. */
	public JPanel blankPanel;
	/** BullPen containing all 35 hexominos. */
    BullPen bullpen = new BullPen(HexominoBankData.getHexominos());
	
	Builder() {
		super();
		
		this.currentFile = null;
		this.blankPanel = new JPanel();
		this.setJMenuBar(new BuilderMenuBar(this, this.blankPanel));
		startSplash("Kabasuji Builder", this.blankPanel);
	}
	
	public void initializeMainView(){
		MainView mv = new MainView(this, new BankView(this, this.bullpen));
		this.setMainView(mv);
		this.startNextPanel(this.blankPanel, mv);
	}
	
	public void setCurrentFile(File f){this.currentFile = f;}
	
	public File getCurrentFile(){return this.currentFile;}
	
	public BullPen getBullpen(){return this.bullpen;}
	
	public static void main(String args[]) {
		@SuppressWarnings("unused")
		Builder builder = new Builder();
	}
}
