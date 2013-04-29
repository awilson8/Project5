import javax.swing.JButton;
/**
 * Cell class for Project5.
 * 
 * @author Drew Wilson
 * @version 1.0
 */
public class Cell extends JButton {
	private int status;
	private boolean occupied;
	private Ship s;
	
	/**
	 * Constructor
	 */
	public Cell() {
		status = 0;
		occupied = false;
		s = new Ship();
	}
	
	/**
	 * Gets the status of the Cell
	 * @return int of the status
	 */
	public int getStatus() {
		return this.status;
	}
	
	/**
	 * sets the status of this Cell
	 * @param i the status to be set
	 */
	public void setStatus(int i) {
		this.status = i;
	}
	
	/**
	 * gets the occupied status of this Cell
	 * @return boolean of the status
	 */
	public boolean getOccupied() {
		return this.occupied;
	}
	
	/**
	 * sets the occupied status of this Cell
	 * @param b the boolean to be set as occupied
	 */
	public void setOccupied(boolean b) {
		this.occupied = b;
	}
	
	/**
	 * assigns a Ship to this Cell
	 * @param s the Ship being assigned
	 */
	public void setShip(Ship s) {
		this.s = s;
	}
	
	/**
	 * gets this Cell's Ship
	 * @return this Cell's Ship
	 */
	public Ship getShip() {
		return this.s;
	}
}