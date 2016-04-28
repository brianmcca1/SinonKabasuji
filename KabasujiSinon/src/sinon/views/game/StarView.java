package sinon.views.game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sinon.views.Observer;

/**
 * The view for the stars that the player earns when playing the Game.
 */
public class StarView extends JPanel implements Observer{
	
	private static final long serialVersionUID = -6975138273991553460L;
	/** Image to buffer on the JLabel. */
	private BufferedImage image;
	/** JLabel on which the image is placed. */
	public JLabel starLabel;
	
	/**
	 * @param filePath File path to get the stars image from. MUST be in form "/images/x.y"
	 */
	public StarView(String filePath){
		try {                
			 this.image = ImageIO.read(new File(getClass().getResource(filePath).toURI()));
			 ImageIcon icon = new ImageIcon(this.image);
			 this.starLabel = new JLabel(icon);
			 this.add(this.starLabel);
		} catch (URISyntaxException ex) {
			ex.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updated() {
		this.starLabel.repaint();
		this.starLabel.revalidate();
		this.repaint();
		this.revalidate();
	}
	
}
