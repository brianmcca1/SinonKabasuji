package sinon.main;

import sinon.models.Level;
import sinon.views.HexominoBullpenView;
import sinon.views.MainView;

public class NewControllerParameter {
    public Level level;
    public MainView mainView;
    public HexominoBullpenView hex;

    public NewControllerParameter(Level level, MainView mainView,
            HexominoBullpenView hex) {
        this.level = level;
        this.mainView = mainView;
        this.hex = hex;
    }
}