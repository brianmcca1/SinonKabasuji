package sinon.main;

import sinon.models.Level;
import sinon.views.InfoPanel;
import sinon.views.MainView;

/**
 * Builder Object for all types of MainViews.
 * 
 * Use this when creating a MainView for any game type and in the builder. For
 * details on how to use a builder class, Google "Builder Design Pattern Java".
 * 
 * @see MainView
 * @author Josh Desmond
 */
public class MainViewBuilder {

	private Level level;
	private InfoPanel infoPanel;
	private boolean hasReleaseView;

	public MainViewBuilder() {
	}

	public MainViewBuilder setLevel(Level level) {
		this.level = level;
		return this;
	}

	public MainViewBuilder setInfoPanel(InfoPanel infoPanel) {
		this.infoPanel = infoPanel;
		return this;
	}

	/**
	 * Set this to be true for release mode and builder mode versions of the
	 * game.
	 * 
	 * @param hasReleaseView
	 *            True if the MainView should display a grid of release buttons.
	 */
	public MainViewBuilder setHasReleaseView(boolean hasReleaseView) {
		this.hasReleaseView = hasReleaseView;
		return this;
	}

	// TODO add method: setExtraInfoView (for the info in the builder that goes
	// below the release tiles.

	public MainView build() {
		return new MainView(level, infoPanel, hasReleaseView);
	}

}
