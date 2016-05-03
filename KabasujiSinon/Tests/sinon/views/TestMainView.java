package sinon.views;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import sinon.models.Board;
import sinon.models.BullPen;
import sinon.models.Hexomino;
import sinon.models.PuzzleLevel;
import sinon.models.ReleaseLevel;
import sinon.views.builder.BankView;
import sinon.views.game.GameInfoView;

public class TestMainView {

	/**
	 * Initialized during {@link #setUp()}. Bullpen contains the hexomino
	 * {@link #hex}, and the board is all playable except tile (1,1)
	 */
	PuzzleLevel level;
	/**
	 * ReleaseLevel.
	 */
	ReleaseLevel releaseLevel;
	/** Single hexomino that is in the bullpen of all levels. */
	Hexomino hex;
	/** BankView for use during creating MainViews. */
	BankView bankView;
	/** PuzzleInfoView. */
	LevelTypeInfoView editablePuzzleInfoView;
	/**
	 * Just a blank ReleaseInfoView created using empty constructor
	 * #PuzzleInfoView()
	 */
	LevelTypeInfoView releaseInfoView;
	GameInfoView releaseInGameInfoView;

	@Before
	public void setUp() throws Exception {
		Board board = new Board();
		board.getTile(1, 1).setPlayable(false);
		List<Hexomino> bullpenList = new ArrayList<Hexomino>();
		bullpenList.add(Hexomino.getExampleHexomino());
		BullPen bullpen = new BullPen(bullpenList);
		level = new PuzzleLevel(board, bullpen, 10);
		releaseLevel = ReleaseLevel.getExampleReleaseLevel();
		editablePuzzleInfoView = new PuzzleInfoView(true, level);

		releaseInfoView = new ReleaseInfoView(releaseLevel);
		releaseInGameInfoView = new GameInfoView(releaseLevel);
		bankView = new BankView();
	}

	@Test
	public void testCreateBuilderView() {
		MainView m = new MainView(level, bankView, editablePuzzleInfoView);
		assertNotNull(m.getBullpenView());
		assertNotNull(m.getBoardView());
		InfoPanel i = m.getInfoPanel();
		// We created the mainView with a bankView.
		assertTrue(i instanceof BankView);
		LevelTypeInfoView v = m.getLevelTypeInfoView();
		assertTrue(v instanceof PuzzleInfoView);
		assertNotNull(m.level);
		assertTrue(m.level.getBullpen().getPieces().size() > 0);
	}

	@Test
	public void testCreateReleaseMainView() {
		MainView m = new MainView(releaseLevel, releaseInGameInfoView, releaseInfoView);
		assertNotNull(m.getBullpenView());
		assertNotNull(m.getBoardView());
		InfoPanel i = m.getInfoPanel();
		// We created the mainView with a GameInfoView.
		assertTrue(i instanceof GameInfoView);
		assertNotNull(m.level);
		LevelTypeInfoView v = m.getLevelTypeInfoView();
		assertTrue(v instanceof ReleaseInfoView);
		ReleaseInfoView rv = (ReleaseInfoView) v;
		assertTrue(rv.buttons.size() > 1);
	}

}
