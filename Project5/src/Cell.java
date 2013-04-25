import javax.swing.JButton;

public class Cell extends JButton {
	int status;
	boolean occupied;
	Ship s;
	public Cell() {
		status = 0;
		occupied = false;
		s = new Ship();
	}
	
	public int getStatus() {
		return this.status;
	}
	
	public void setStatus(int i) {
		this.status = i;
	}
	
	public boolean getOccupied() {
		return this.occupied;
	}
	
	public void setOccupied(boolean b) {
		this.occupied = b;
	}
}