package sinon.main;

import javax.swing.JPanel;

import sinon.views.LevelSelectView;

public class Game extends Kabasuji {

	// MODELS AND VIEWS SPECIFIC TO GAME GO HERE
	Game game;
	
	public Game() {
		super();
		this.game = this;
		startSplash("Kabasuji", new LevelSelectView(game));
	}

	public static void main(String args[]) {
		Game game = new Game();
	}

}
