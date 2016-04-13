package sinon.main;

import javax.swing.JPanel;

import sinon.views.LevelSelectView;

public class Game extends Kabasuji {

	// MODELS AND VIEWS SPECIFIC TO GAME GO HERE
	
	public Game() {
		super();
		startSplash("Kabasuji", new LevelSelectView(this));
	}

	public static void main(String args[]) {
		Game game = new Game();
	}
}
