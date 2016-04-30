package sinon.controllers;

import java.util.Objects;

import sinon.models.Level;
import sinon.models.ReleaseLevel;
import sinon.models.data.LevelType.Types;
import sinon.views.MainView;
import sinon.views.TileView;

public class TileRegistrator {

	private Level level;

	private MainView mainView;

	private boolean isBuilderType;

	/**
	 * Creates a new TileRegistrator.
	 * 
	 * @param level
	 *            Model which is associated with the controllers which are to be
	 *            built.
	 * @param mainView
	 *            View which is associated with the controllers which are to be
	 *            built.
	 */
	public TileRegistrator(Level level, MainView mainView) {
		this.level = Objects.requireNonNull(level);
		this.mainView = Objects.requireNonNull(mainView);
	}

	public void register(TileView tileView) {
		assert tileView != null;
		assert level != null;
		assert mainView != null;

		TileController c;

		if (isBuilderType) {
			if (this.level.getLevelData().getLevelType() == Types.RELEASE) {
				ReleaseLevel releaseLevel = new ReleaseLevel(level);
				c = new ReleaseBuilderTileController(releaseLevel, tileView, mainView);

			} else {
				c = new BuilderTileController(level, tileView, mainView);
			}
		}

		else {
			c = new GameTileController(level, tileView, mainView);
		}

		tileView.addMouseListener(c);
		tileView.addMouseMotionListener(c);
	}

	/**
	 * Sets the registrator to register Builder type tile controllers.
	 * 
	 * @return
	 */
	public void setToBuilderType() {
		this.isBuilderType = true;
	}

	/**
	 * Sets the registrator up to be registering game type tile controllers..
	 */
	public void setToGameType() {
		this.isBuilderType = false;
	}

}
