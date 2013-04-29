import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 * Ship class for Project5.
 * 
 * @author Drew Wilson
 * @version 1.0
 */
public class Ship extends JButton {
	private String name;
	private int strength;
	
	/**
	 * Constructor
	 */
	public Ship(String _name, int _strength, ImageIcon s) {
		super(s);
		name = _name;
		strength = _strength;
	}
	
	/**
	 * Constructor
	 */
	public Ship(){
		name = "";
		strength = 0;
	}
	
	/**
	 * Constructor
	 */
	public Ship(ImageIcon s){
		super(s);
	}
	
	/**
	 * gets this Ships strength
	 * @return int of ships strength
	 */
	public int getStrength() {
		return this.strength;
	}
	
	/**
	 * sets this Ships strength
	 * @param i int of what to decremement from Ship
	 */
	public void setStrength(int i) {
		this.strength -= i;
	}
	
	/**
	 * gets the name of this Ship
	 */
	public String getName() {
		return this.name;
	}
}