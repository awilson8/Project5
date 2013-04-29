import java.awt.*;
import javax.swing.*;

/**
 * EnemyRebelVictory Splash for Project5.
 * @author Drew Wilson
 * @version 1.
*/
public class EnemyRebelVictory extends JPanel {
	Image enemyRebelBackground;

	/**
	 * Create the panel.
	 */
	public EnemyRebelVictory() {
		setLayout(null);
		
		enemyRebelBackground = new ImageIcon("EnemyRebelVictory.png").getImage();
		setSize(1125,750);
	}
	
	/**
	 * Paints the background
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(enemyRebelBackground, 0, 0, 1125, 750, null);
	}	
}