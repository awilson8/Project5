import java.awt.*;
import javax.swing.*;

/**
 * Splash for Project5.
 * @author Drew Wilson
 * @version 1.
*/
public class ImperialVictory extends JPanel {
	Image imperialBackground;

	/**
	 * Create the panel.
	 */
	public ImperialVictory() {
		setLayout(null);
		
		imperialBackground = new ImageIcon("ImperialVictory.png").getImage();
		setSize(1125,750);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imperialBackground, 0, 0, 1125, 750, null);
	}	
}