package sinon.views;

import java.awt.Dimension;

import javax.swing.JButton;

/** GUI element representing one of the Hexominos in the Bullpen */
@SuppressWarnings("serial")
public class HexominoBullpenView extends JButton {

	private static final Dimension size = new Dimension(150, 150);

	public HexominoBullpenView() {
		super("Button");
		this.setBounds(0,0,size.width,size.height);
		this.setSize(size);
	}
}
