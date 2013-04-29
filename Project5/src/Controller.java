import java.util.*;
/**
 * Controller runs the game.
 * 
 * @author Drew Wilson
 * @version 1.0
 */
public class Controller {
	private View cView = new View();
    
    /**
     * runProgram runs the program.
     */
    public void runProgram () {
    	cView.display();
    	while (cView.getGameOver() == 0) {
    		playGame();
    	}    	
    }
    
    /**
     * game loop
     */
    public void playGame() {
		cView.setUserHit(1);
		cView.setEnemyHit(1);
		while (cView.getUserHit() == 1) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		while (cView.getEnemyHit() == 1) {
			cView.enemyTurn();
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
    }
}