package sinon.main;

import sinon.views.MainView;
import sinon.views.builder.BankView;
import sinon.views.builder.BuilderMenuBar;

@SuppressWarnings("serial")
public class Builder extends Kabasuji {

	private BuilderMenuBar menuBar;

	Builder() {
		super();
		// Initialize the JMenuBar
		menuBar = new BuilderMenuBar();
		this.setJMenuBar(menuBar);

		// Start the splash screen.
		startSplash("Kabasuji Builder", new MainView(new BankView()));
	}

	public static void main(String args[]) {
		@SuppressWarnings("unused")
		Builder builder = new Builder();
	}
}
