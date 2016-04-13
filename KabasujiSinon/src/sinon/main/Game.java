package sinon.main;

import sinon.views.LevelSelectView;

public class Game extends Kabasuji {

	// MODELS AND VIEWS SPECIFIC TO GAME GO HERE

	public Game() {
		super();

		startSplash("Kabasuji", new LevelSelectView());
	}

	public static void main(String args[]) {
		Game game = new Game();
	}
}
