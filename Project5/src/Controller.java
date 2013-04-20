import java.util.*;
/**
 * Controller runs the Ships game.
 * 
 * @author Drew Wilson
 * @version 1.0
 */
public class Controller {
    Scanner scan = new Scanner(System.in);
    View cView = new View();
    Game cGame = new Game();
    
    /**
     * runProgram runs the program.
     */
    public void runProgram () {
    	cView.display();
    	while (!cGame.gameComplete()) {
    		cGame.userTurn();
    		cGame.aiTurn();
    	}
    	String winner = cGame.determineWinner();
    	
    }
}
