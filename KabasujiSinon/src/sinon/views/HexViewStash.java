package sinon.views;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.swing.JPanel;

import sinon.controllers.HexStashRegistrator;
import sinon.models.BullPen;
import sinon.models.Hexomino;
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
public class HexViewStash {
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
	 * Creates a new HexViewStash for a Bullpen/Board.
	 * 
	 * @param bullpen
	 *            Bullpen which the HexViewStash is associated with.
	 * @param contentPanel
	 *            The JPanel where HexominoBullpenViews are to be added. Note
	 *            that this should already be initialized, and should already
	 *            have the proper layout for rendering Hexominos.
	 */
	public HexViewStash(BullPen bullpen, JPanel contentPanel) {
		this.contentPanel = Objects.requireNonNull(contentPanel);
		this.bullpen = Objects.requireNonNull(bullpen);
		this.hexominosList = new LinkedList<HexominoBullpenView>();
		this.registrator = Optional.empty();
	}

	public List<HexominoBullpenView> getHexominos() {
		return hexominosList;
	}

	public void setRegistrator(HexStashRegistrator registrator) {
		Objects.requireNonNull(registrator);
		this.registrator = Optional.of(registrator);
	}

	private void registerHexominos() {
		assert this.hexominosList != null;
		if (!this.registrator.isPresent())
			return;

		for (HexominoBullpenView h : hexominosList) {
			registrator.get().registerHexominoView(h);
		}
	}

	public void refresh() {
		if (this.contentPanel == null) {
			throw new NullPointerException(
					"content panel was null when adding Hexominos.");
		}
		assert this.hexominosList != null;
		clearHexominoViews();

		for (Hexomino h : bullpen.getPieces()) {
			HexominoBullpenView hexView = new HexominoBullpenView(h);
			hexominosList.add(hexView);
			this.contentPanel.add(hexView);
		}

		if (this.registrator.isPresent()) {
			registerHexominos();
		}

		this.contentPanel.repaint();
		this.contentPanel.revalidate();
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
	public void update() {
		if (hexominosList.size() != bullpen.getPieces().size()) {
			System.out.println("Sizes are different");
		}

		this.refresh();
	}
}
