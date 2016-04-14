package sinon.views;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

/**
 * TODO
 * 
 * @author Josh Desmond
 */
@SuppressWarnings("serial")
public class BullpenView extends JScrollPane {

	//private static final Dimension DIMENSION = new Dimension(600, 300);

	private JPanel upperPanel;

	/**
	 * TODO
	 */
	public BullpenView() {
		this.setBackground(Color.CYAN);

		this.upperPanel = new JPanel();
		upperPanel.setBackground(Color.gray);
		examplePopulateBullpen();
		examplePopulateBullpen();
		examplePopulateBullpen();

		JScrollBar scrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		this.add(scrollBar);

		/*
		JScrollPane scroll = new JScrollPane();
		scroll.setSize(DIMENSION);
		scroll.addImp
		this.setSize(DIMENSION);
		this.add(scroll);

		//examplePopulateBullpen();
		// Now add the scrollbar

		//scrollBar.setOrientation(JScrollBar.HORIZONTAL);
		//this.add(scrollBar, BorderLayout.SOUTH);
		//scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//scroll.setHorizontalScrollBar(scrollBar);
		//


		// TODO remove this.
		//examplePopulateBullpen();
		validate();
		 */
	}

	private void examplePopulateBullpen() {
		HexominoBullpenView a = new HexominoBullpenView();
		a.setBackground(Color.red);
		this.upperPanel.add(a);
		HexominoBullpenView b = new HexominoBullpenView();
		b.setBackground(Color.blue);
		this.upperPanel.add(b);
		HexominoBullpenView c = new HexominoBullpenView();
		c.setBackground(Color.green);
		this.upperPanel.add(c);
		HexominoBullpenView d = new HexominoBullpenView();
		d.setBackground(Color.black);
		this.upperPanel.add(d);
		this.validate();
	}
}
