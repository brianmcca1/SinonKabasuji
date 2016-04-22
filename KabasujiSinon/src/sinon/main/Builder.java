package sinon.main;

import sinon.views.MainView;
import sinon.views.builder.BankView;
import sinon.views.builder.BuilderMenuBar;

@SuppressWarnings("serial")
public class Builder extends Kabasuji {

	Builder() {
		super();
		
		// Start the splash screen.
		startSplash("Kabasuji Builder", new MainView(this, new BankView(this)));
	}

	public static void main(String args[]) {
		@SuppressWarnings("unused")
		Builder builder = new Builder();
	}
}
