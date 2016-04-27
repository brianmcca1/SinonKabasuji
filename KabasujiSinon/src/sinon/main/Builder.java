package sinon.main;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JPanel;
import sinon.controllers.BuilderTileController;
import sinon.models.BullPen;
import sinon.models.data.HexominoBankData;
import sinon.views.LevelTypeInfoView;
import sinon.views.MainView;
import sinon.views.TileView;
import sinon.views.builder.BankView;
import sinon.views.builder.BuilderMenuBar;
@SuppressWarnings("serial")
public class Builder extends Kabasuji {

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
	
	public void initializeMainView(LevelTypeInfoView lvlTypeInfoView){
		if(this.mainView != null){
			this.remove(this.mainView);
			this.revalidate();
		}
		MainView mv = new MainView(this, new BankView(this, this.bullpen), lvlTypeInfoView);
		this.setMainView(mv);
		this.mainView.revalidate();
		this.startNextPanel(this.blankPanel, mv);
	}
	
	public BullPen getBullpen(){return this.bullpen;}
	
	/** Registers the BuilderTileControllers to each TileView in the Builder's BoardView. */
	public void registerBoardViewControllers(){
		ArrayList<TileView> tileViews = (ArrayList<TileView>)this.getMainView().getBoardView().getTileViews();
		
		for(int i = 0; i < tileViews.size(); i++){
			tileViews.get(i).addMouseListener(new BuilderTileController(this, tileViews.get(i), this.currentLevel));
		}
		
	}
	
	public static void main(String args[]) {
		@SuppressWarnings("unused")
		Builder builder = new Builder();
	}
}
