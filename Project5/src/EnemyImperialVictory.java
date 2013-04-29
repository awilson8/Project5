import java.awt.*;
import javax.swing.*;

/**
 * EnemyImperialVictory Splash for Project5.
 * @author Drew Wilson
 * @version 1.
*/
public class EnemyImperialVictory extends JPanel {
	Image enemyImperialBackground;

	/**
	 * Create the panel.
	 */
	public EnemyImperialVictory() {
		setLayout(null);
		
		enemyImperialBackground = new ImageIcon("EnemyImperialVictory.png").getImage();
		setSize(1125,750);
	}
	
	/**
	 * Paints the background
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(enemyImperialBackground, 0, 0, 1125, 750, null);
	}	
}