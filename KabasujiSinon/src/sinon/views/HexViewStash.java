package sinon.views;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import javax.swing.JPanel;

import sinon.main.HexStashRegistrator;
import sinon.models.BullPen;
import sinon.models.Hexomino;

/**
 * Encapsulates the shared behaviors of the BankView and BullpenView. Both of
 * those will have a HexViewStash, which will manage the registration of
 * controllers, and the updating of the individual HexominoBullpenViews.
 * 
 * @author Josh Desmond
 */
public class HexViewStash {
	/** Object which is used to register controllers to Hexominos in the stash */
	HexStashRegistrator registrator;
	/** Bullpen associated with this Stash */
	BullPen bullpen;
	/** This is a list of hexominoViews within the Bullpen. */
	List<HexominoBullpenView> hexominos;

	public HexViewStash(BullPen bullpen, JPanel contentPanel) {
		this.bullpen = Objects.requireNonNull(bullpen);
		this.hexominos = new LinkedList<HexominoBullpenView>();
		initializeHexominos();
	}

	private void initializeHexominos() {
		for (Hexomino h : bullpen.getPieces()) {
			hexominos.add(new HexominoBullpenView(h));
		}
	}

	public void registrateHexominos() {
		for (HexominoBullpenView h : hexominos) {
			registrator.registerHexominoView(h);
		}
	}

	public List<HexominoBullpenView> getHexominos() {
		return hexominos;
	}

	public void setRegistrator(HexStashRegistrator registrator) {
		this.registrator = Objects.requireNonNull(registrator);
		registerHexominos();
	}

	private void registerHexominos() {
		for (HexominoBullpenView h : hexominos) {
			registrator.registerHexominoView(h);
		}
	}

	public void populateViewWithHexominos() {
		// TODO Auto-generated method stub

	}
}
