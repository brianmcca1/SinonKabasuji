package sinon.views;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.swing.JPanel;

import sinon.controllers.HexStashRegistrator;
import sinon.models.BullPen;
import sinon.models.Hexomino;
import sinon.models.Level;
import sinon.views.builder.BankView;

/**
 * Encapsulates the shared behaviors of the BankView and BullpenView.
 * 
 * Both of those will have a HexViewStash, which will manage the registration of
 * controllers, and the updating of the individual HexominoBullpenViews.
 * 
 * @see BankView
 * @see BullpenView
 * @author Josh Desmond
 */
public class HexViewStash implements Observer {
	/**
	 * Object which is used to register controllers to Hexominos in the stash
	 */
	Optional<HexStashRegistrator> registrator;
	/** Bullpen associated with this Stash */
	BullPen bullpen;
	/** This is a list of hexominoViews within the Bullpen. */
	List<HexominoBullpenView> hexominosList;
	/** Content Panel where Hexominos are supposed to be added. */
	JPanel contentPanel;
	/**
	 * Level which this uses to retrieve the selected hexomino. This will not be
	 * present if this is a bankView.
	 */
	Optional<Level> level;

	/**
	 * Creates a new HexViewStash for a Bullpen.
	 * 
	 * @param level
	 *            Level which is used to retrieve the bullpen and the selected
	 *            hexominos from.
	 * @param contentPanel
	 *            The JPanel where HexominoBullpenViews are to be added. Note
	 *            that this should already be initialized, and should already
	 *            have the proper layout for rendering Hexominos.
	 */
	public HexViewStash(Level level, JPanel contentPanel) {
		if (level == null) {
			throw new NullPointerException("Use the other constructor if you don't actually have a level.");
		}
		this.level = Optional.of(level);
		level.registerObserver(this);
		this.contentPanel = Objects.requireNonNull(contentPanel);
		this.bullpen = Objects.requireNonNull(level.getBullpen());
		this.hexominosList = new LinkedList<HexominoBullpenView>();
		this.registrator = Optional.empty();
	}

	/**
	 * Creates a new HexViewStash for a Bullpen.
	 * 
	 * This constructor doesn't require a level, and is used for when you create
	 * a bullpen using a bankview. This is because bankViews will never have a
	 * selected hexomino and therefore doesn't need to render selected stuff. If
	 * you aren't creating a bankView then make sure that you are using the
	 * other constructor {@link #HexViewStash(Level, JPanel)}.
	 * 
	 * @param bullpen
	 *            Bullpen which the HexViewStash is associated with.
	 * @param contentPanel
	 *            The JPanel where HexominoBullpenViews are to be added. Note
	 *            that this should already be initialized, and should already
	 *            have the proper layout for rendering Hexominos.
	 */
	public HexViewStash(BullPen bullPen, JPanel contentPanel) {
		this.level = Optional.empty();
		this.contentPanel = Objects.requireNonNull(contentPanel);
		this.bullpen = Objects.requireNonNull(bullPen);
		this.hexominosList = new LinkedList<HexominoBullpenView>();
		this.registrator = Optional.empty();
	}

	public List<HexominoBullpenView> getHexominos() {
		return hexominosList;
	}

	/** Setting the registrator of this class. */
	public void setRegistrator(HexStashRegistrator registrator) {
		Objects.requireNonNull(registrator);
		this.registrator = Optional.of(registrator);
	}

	/** Register all the hexominos with appropriate registrators. */
	private void registerHexominos() {
		assert this.hexominosList != null;
		if (!this.registrator.isPresent())
			return;

		for (HexominoBullpenView h : hexominosList) {
			registrator.get().registerHexominoView(h);
		}
	}

	/** Refresh all the views. Called after a change has been made. */
	public void refresh() {
		if (this.contentPanel == null) {
			throw new NullPointerException("content panel was null when adding Hexominos.");
		}
		if (this.hexominosList == null) {
			throw new NullPointerException("Hexomino List was null when refreshing the view");
		}
		clearHexominoViews();

		for (Hexomino h : bullpen.getPieces()) {
			HexominoBullpenView hexView = new HexominoBullpenView(h);
			hexominosList.add(hexView);
			this.contentPanel.add(hexView);
		}

		if (level.isPresent()) {
			Level lev = level.get();
			if (lev.hasSelected()) {
				final Hexomino selectedHex = lev.getSelectedHexomino().get();
				if (this.bullpen.containsHexID(selectedHex.getID())) {
					renderHexominoAsSelected(selectedHex);
				}
			}
		}

		if (this.registrator.isPresent()) {
			registerHexominos();
		}

		this.contentPanel.repaint();
		this.contentPanel.revalidate();
	}

	/**
	 * Renders the given hexomino as selected. Before calling this method, we
	 * already know that this stashView's bullpen has the selected hexomino.
	 * 
	 * @param selectedHex
	 *            Hexomino to render it's view as selected.
	 */
	private void renderHexominoAsSelected(Hexomino selectedHex) {
		for (HexominoBullpenView v : this.hexominosList) {
			if (v.getHexomino().equals(selectedHex)) {
				v.select();
			} else {
				v.deselect();
			}
		}
	}

	/**
	 * removes all of the hexominos from the list of views and from the content
	 * panel.
	 */
	private void clearHexominoViews() {
		this.getHexominos().removeIf((Object) -> true);
		this.contentPanel.removeAll();
	}

	/**
	 * Re renders the Stash it is observing.
	 */
	@Override
	public void updated() {
		this.refresh();
	}
}
