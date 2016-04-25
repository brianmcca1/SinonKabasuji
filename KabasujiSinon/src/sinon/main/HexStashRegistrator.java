package sinon.main;

import java.util.Objects;

import sinon.controllers.AbstractHexStashController;
import sinon.models.Level;
import sinon.views.HexominoBullpenView;
import sinon.views.MainView;

public class HexStashRegistrator {

	Level level;
	MainView mainView;

	public HexStashRegistrator(Level level, MainView mainView) {
		this.level = Objects.requireNonNull(level);
		this.mainView = Objects.requireNonNull(mainView);
	}

	public void registerHexominoView(HexominoBullpenView hex) {
		hex.addMouseListener(new AbstractHexStashController(level, mainView,
				hex));
		assert hex != null;
		assert level != null;
		assert mainView != null;
		System.out.println("Registration attempt");

	}

}
