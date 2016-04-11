package sinon.main;

import java.awt.EventQueue;

import sinon.views.GameSplashScreen;

public class GameMain {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameSplashScreen.execute = new GameSplashScreen();
					GameSplashScreen.execute.frmKabasuji.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
