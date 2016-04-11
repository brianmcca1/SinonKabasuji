package sinon.controllers;
import sinon.main.Kabasuji;
import sinon.views.LevelStartView;

public class LevelStartController {

	Kabasuji kabasuji;
	LevelStartView view;
	
	LevelStartController(Kabasuji kabasuji, LevelStartView view){
		this.kabasuji = kabasuji;
		this.view = view;
	}
	
	void clicked(int levelNum){
		kabasuji.levels[levelNum].open();
	}
}
