package sinon.main;

import javax.swing.JFrame;
import sinon.views.SplashScreen;

public class Game extends Kabasuji {

	// MODELS AND VIEWS SPECIFIC TO GAME GO HERE
	
	public Game() {
		super();
		startSplash("Kabasuji", null);
	}

	public static void main(String args[]) {
		Game game = new Game();
		
	}
}
