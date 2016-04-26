package sinon.views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.util.Objects;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import sinon.main.HexStashRegistrator;
import sinon.models.BullPen;

@SuppressWarnings("serial")
public class BullpenView extends JPanel implements StashView {

	public JScrollPane scrollPanel;
	public JPanel contentPanel;

	HexViewStash stash;

	public BullpenView(BullPen bullpen) {
		initContentPanel();
		initBullpenViewScrollPanel();

		this.setLayout(new GridLayout(1, 1));
		this.stash = new HexViewStash(Objects.requireNonNull(bullpen),
				contentPanel);
		populateBankViewWithHexominoes();
		this.add(scrollPanel);
		this.validate();
	}

	private void initBullpenViewScrollPanel() {
		scrollPanel = new JScrollPane();
		JScrollBar scrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
		scrollPanel
		.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPanel.add(scrollBar);
		scrollPanel
		.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scrollPanel.setViewportView(contentPanel);
	}

	private void initContentPanel() {
		this.contentPanel = new JPanel();
		contentPanel.setBackground(Color.gray);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
	}

	/** Called by the HexominoBankController to repaint this bullpen. */
	public void redrawBullpenView() {
		this.stash.update();
		this.repaint();
		this.revalidate();
		this.contentPanel.repaint();
		this.contentPanel.revalidate();
	}

	public void addHexominoBullpenView(HexominoBullpenView hexBullpenView) {
		// have to create a copy so that we can register a different controller
		// to this HexominBullpenView
		removeMouseListeners(hexBullpenView);
		this.stash.add(hexBullpenView);
		this.contentPanel.add(hexBullpenView);
		this.redrawBullpenView();
	}

	/**
	 * Use this method to remove any MouseListeners from a HexominoPanel.
	 * 
	 * @param hexBullpenView
	 *            HexominoBullpenView to remove MouseListeners from.
	 */
	private static void removeMouseListeners(JPanel hexBullpenView) {
		for (MouseListener m : hexBullpenView.getMouseListeners()) {
			hexBullpenView.removeMouseListener(m);
		}
	}

	private void populateBankViewWithHexominoes() {
		stash.populateViewWithHexominos();
		// TODO move these two lines to another method.
		this.contentPanel.doLayout();
		this.validate();
	}

	@Override
	public void setRegistrator(HexStashRegistrator hexStashRegistrator) {
		stash.setRegistrator(Objects.requireNonNull(hexStashRegistrator));
	}

}
