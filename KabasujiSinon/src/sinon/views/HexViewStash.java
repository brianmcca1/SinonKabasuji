package sinon.views;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import javax.swing.JPanel;

import sinon.main.HexStashRegistrator;
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
	HexStashRegistrator registrator;
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
		initializeHexominoList();
	}

	/** This must be called during the constructor. */
	private void initializeHexominoList() {
		this.hexominosList = new LinkedList<HexominoBullpenView>();
		for (Hexomino h : bullpen.getPieces()) {
			hexominosList.add(new HexominoBullpenView(h));
		}
	}

	public List<HexominoBullpenView> getHexominos() {
		return hexominosList;
	}

	public void setRegistrator(HexStashRegistrator registrator) {
		this.registrator = Objects.requireNonNull(registrator);
		registerHexominos();
	}

	private void registerHexominos() {
		assert this.hexominosList != null;
		// FIXME false assertion
		assert this.hexominosList.size() >= 1;
		for (HexominoBullpenView h : hexominosList) {
			registrator.registerHexominoView(h);
		}
	}

	public void populateViewWithHexominos() {
		if (this.contentPanel == null) {
			throw new NullPointerException(
					"content panel was null when adding Hexominos.");
		}
		this.getHexominos().removeIf((Object) -> true);
		this.contentPanel.removeAll();
		for (Hexomino h : bullpen.getPieces()) {
			HexominoBullpenView hexView = new HexominoBullpenView(h);
			hexominosList.add(hexView);
			this.contentPanel.add(hexView);
		}
	}

	/**
	 * Adds a HexominoBullpenView to the Stash and registers it to a controller.
	 * 
	 * @param hexBPView
	 *            HexominoView to be added.
	 */
	public void add(HexominoBullpenView hexBPView) {
		assert this.contentPanel != null;
		assert this.hexominosList != null;
		assert this.registrator != null;
		this.contentPanel.add(Objects.requireNonNull(hexBPView));
		this.hexominosList.add(hexBPView);
		registrator.registerHexominoView(hexBPView);
	}

	/**
	 * Re renders the Stash it is observing.
	 */
	public void update() {
		if (hexominosList.size() != bullpen.getPieces().size()) {
			System.out.println("Sizes are different");
		}

		this.populateViewWithHexominos();
	}
}
