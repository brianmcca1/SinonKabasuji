package sinon.controllers;
import sinon.main.Kabasuji;
import sinon.views.LevelSelectButtonView;
import sinon.views.Player;


public class LevelStartController  {

	//Kabasuji kabasuji;
	LevelSelectButtonView view;
	
	public LevelStartController(LevelSelectButtonView view){
		//this.kabasuji = kabasuji;
		this.view = view;
	}
	
	public void mouseReleased(java.awt.event.MouseEvent me){
		
		// Final implementation?
		//int num = view.levelNum;
		//kabasuji.levels[num].open();	
		
		Player level = new Player();
		level.initialize();
		//Need to close current screen?
		level.frame.setVisible(true);
	}
}
