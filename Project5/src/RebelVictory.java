import java.awt.*;
import javax.swing.*;

/**
 * RebelVictory Splash for Project5.
 * @author Drew Wilson
 * @version 1.0
*/
public class RebelVictory extends JPanel {
	Image rebelBackground;

	/**
	 * Create the panel.
	 */
	public RebelVictory() {
		setLayout(null);
		
		rebelBackground = new ImageIcon("RebelVictory.png").getImage();
		setSize(1125,750);
	}
	
	/**
	 * Paints the background
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(rebelBackground, 0, 0, 1125, 750, null);
	}	
}