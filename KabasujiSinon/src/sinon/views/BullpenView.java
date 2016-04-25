package sinon.views;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import sinon.controllers.HexominoBullpenController;
import sinon.models.BullPen;

@SuppressWarnings("serial")
public class BullpenView extends JPanel {

	public JScrollPane scrollPanel;
	public JPanel contentPanel;

	/** This is the bullpen that is associated with the view */
	BullPen bullpen;

	List<HexominoBullpenView> hexominoViews;

	public BullpenView(BullPen bullpen) {
		this.hexominoViews = new LinkedList<HexominoBullpenView>();
		this.bullpen = bullpen;

		initContentPanel();
		initBullpenViewScrollPanel();
		populateBullpen();

		this.setLayout(new GridLayout(1, 1));

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
		this.repaint();
		this.revalidate();
		this.contentPanel.repaint();
		this.contentPanel.revalidate();
	}

	public void addHexominoBullpenView(HexominoBullpenView hexBullpenView) {
		// have to create a copy so that we can register a different controller
		// to this HexominBullpenView
		HexominoBullpenView hexBPView = new HexominoBullpenView(
				hexBullpenView.getHexomino());
		// FIXME no controllers in the views.
		// TODO add the controller back on.
		hexBPView.addMouseListener(new HexominoBullpenController(hexBPView,
				this.kabasuji.getLevel(), this));
		this.hexominoViews.add(hexBPView);
		this.contentPanel.add(hexBPView);
		this.redrawBullpenView();
	}

	/**
	 * Creates a HexominoBullpenView and registers a HexominoBullpenController
	 * to it.
	 */
	private void populateBullpen() {
		// THIS SHOULD TAKE A LIST OF HEXOMINO VIEWS FOR THE CASE THAT THE
		// BULLPEN ALREADY HAS A BUNCH OF HEXOMINOS IN IT (OPEN, FOR EXAMPLE)
		// AND THEN IT WILL CALL addHexominoBullpenView ON EACH ONE
	}

}
