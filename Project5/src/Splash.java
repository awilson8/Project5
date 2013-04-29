import java.awt.*;
import javax.swing.*;

/**
 * Splash for Project5.
 * @author Drew Wilson
 * @version 1.0
*/
public class Splash extends JPanel {
	private Image splashBackground;

	/**
	 * Create the panel.
	 */
	public Splash() {
		setLayout(null);
		
		splashBackground = new ImageIcon("SplashScreen.png").getImage();
		setSize(1125,750);
	}
	
	/**
	 * Paints the background
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(splashBackground, 0, 0, 1125, 750, null);
	}	
}