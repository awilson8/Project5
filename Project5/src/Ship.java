import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Ship extends JButton {
	String name;
	int strength;
	String letter;
	int number;
	boolean isVertical;
	int xSize;
	int ySize;
	int xBig;
	int yBig;
	
	public Ship(String _name, int _strength, int _xSize, int _ySize, int _xBig, int _yBig, ImageIcon s) {
		super(s);
		name = _name;
		strength = _strength;
		xSize = _xSize;
		ySize = _ySize;
		xBig = _xBig;
		yBig = _yBig;
	}
	
	public Ship(){
		name = "";
		strength = 0;
		letter = "A";
		number = 0;
		isVertical = true;
		xSize = 0;
		ySize = 0;
	}
	
	public Ship(ImageIcon s){
		super(s);
	}
	
	public Ship(String _name, int _strength, String _letter, int _number,
			boolean _isVertical, int _xSize, int _ySize) {
		name = _name;
		strength = _strength;
		letter = _letter;
		number = _number;
		isVertical = _isVertical;
		xSize = _xSize;
		ySize = _ySize;
	}
}