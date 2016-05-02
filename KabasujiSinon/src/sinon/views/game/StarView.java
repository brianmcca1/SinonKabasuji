package sinon.views.game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sinon.models.Level;

/**
 * The view for the stars that the player earns when playing the Game.
 */
public class StarView extends JPanel{
	
	private static final long serialVersionUID = -6975138273991553460L;
	/** Image to buffer on the JLabel. */
	private BufferedImage image;
	/** JLabel on which the image is placed. */
	public JLabel starLabel;
	/** Level to keep track of stars for. */
	public Level level;
	

	/**
	 * Creates the in-game stars.
	 * @param filePath filePath File path to get the stars image from. MUST be in form "/images/x.y".
	 * @param level Level to keep track of stars for. 
	 */
	public StarView(String filePath, Level level){
		try {                
			 this.image = ImageIO.read(new File(getClass().getResource(filePath).toURI()));
			 ImageIcon icon = new ImageIcon(this.image);
			 this.starLabel = new JLabel(icon);
			 this.add(this.starLabel);
			 this.level = level;
		} catch (URISyntaxException ex) {
			ex.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
