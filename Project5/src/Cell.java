import javax.swing.JButton;

public class Cell extends JButton {
	int status;
	public Cell() {
		status = 0;
	}
	
	public void setStatus(int i) {
		this.status = i;
	}
}