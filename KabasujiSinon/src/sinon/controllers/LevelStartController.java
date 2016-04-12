package sinon.controllers;
import sinon.main.Kabasuji;
import sinon.models.Level;
import sinon.views.LevelSelectButtonView;


public class LevelStartController  {

	Kabasuji kabasuji;
	LevelSelectButtonView view;
	
	LevelStartController(Kabasuji kabasuji, LevelSelectButtonView view){
		this.kabasuji = kabasuji;
		this.view = view;
	}
	
	void clicked(Level level){
		
	}
}
