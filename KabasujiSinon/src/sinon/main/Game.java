package sinon.main;

import sinon.views.game.LevelSelectView;

@SuppressWarnings("serial")
public class Game extends Kabasuji {

	// MODELS AND VIEWS SPECIFIC TO GAME GO HERE

	public Game() {
		super();
		startSplash("Kabasuji", new LevelSelectView(this));
	}

	public static void main(String args[]) {
		@SuppressWarnings("unused")
		Game game = new Game();
	}
}
