package sinon.main;

import java.awt.EventQueue;

import sinon.views.BuilderSplashScreen;

public class BuilderMain {
	//main for builder
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuilderSplashScreen.execute = new BuilderSplashScreen();
					BuilderSplashScreen.execute.frmKabasuji.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
