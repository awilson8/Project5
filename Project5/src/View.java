import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Gui for Project5.
 * @author Drew Wilson
 * @version 1.0
*/
public class View extends JPanel {
	int count = 0;
	private final int ARRAY_MAX_SIZE = 4;
	Splash splash = new Splash();
	JFrame frame = new JFrame("Drew Wilson - Project 5");
	Image background;
	JLabel attack = new JLabel ("Attack Here!");
	JLabel shipName = new JLabel ("Ship name");
	JTextField placeA = new JTextField("Ex: A");
	JTextField place1 = new JTextField("Ex: 1");
	JTextField location = new JTextField("Ex: A 1");
	private JTextArea messageCenter = new JTextArea("");
	JButton fire = new JButton ("FIRE!");
	JButton rebel = new JButton();
	JButton galactic = new JButton();
	JButton place = new JButton ("Place");
	String[] isVT = {"Vertical", "Horizontal"};
	JComboBox selectHZ = new JComboBox(isVT);
	String[] difficulty = {"Easy", "Medium", "Hard"};
	JComboBox selectDiff = new JComboBox(difficulty);
	Ship[] rebelShips = new Ship[5];
	Ship[] galacticShips = new Ship[5];
	Ship[] userShips;
	private ImageIcon deathStarBig = new ImageIcon("DeathStarBig.png");
	private ImageIcon starDestroyerBig = new ImageIcon("ImperialStarDestroyerBig.png");
	private ImageIcon sithInfiltratorBig = new ImageIcon("SithInfiltratorBig.png");
	private ImageIcon tieFighterBig = new ImageIcon("TieFighterBig.png");
	private ImageIcon tieBomberBig = new ImageIcon("TieBomberBig.png");
	private ImageIcon starCruiser = new ImageIcon("StarCruiserBig.png");
	private ImageIcon attackCruiser = new ImageIcon("AttackCruiserBig.png");
	//private ImageIcon starFighter = new ImageIcon("StarFighterBig.png");
	//private ImageIcon xWing = new ImageIcon("XWingBig.png");
	//private ImageIcon millFalcon = new ImageIcon("MillFalconBig.png");
	private ImageIcon rebelButton = new ImageIcon("RebelAlliance.png");
	private ImageIcon galacticButton = new ImageIcon("GalacticEmpire.png");

	/**
	 * Create the panel.
	 */
	public View() {
		setLayout(null);
		
		background = new ImageIcon("Project5-1.png").getImage();
		setSize(1125,750);
		attack.setFont(new Font("Times", Font.BOLD, 18));
		attack.setSize(115,30);
		attack.setLocation(240,520);
		attack.setBackground(Color.white);
		attack.setOpaque(true);
		attack.setHorizontalAlignment(SwingConstants.CENTER);
		add(attack);
		shipName.setFont(new Font("Times", Font.BOLD, 18));
		shipName.setSize(115,30);
		shipName.setLocation(580,145);
		shipName.setBackground(Color.white);
		shipName.setOpaque(true);
		shipName.setHorizontalAlignment(SwingConstants.CENTER);
		add(shipName);
		location.setSize(70,20);
		location.setLocation(260,585);
		add(location);
		placeA.setSize(50,20);
		placeA.setLocation(585,190);
		add(placeA);
		place1.setSize(50,20);
		place1.setLocation(640,190);
		add(place1);
		fire.setSize(70,20);
		fire.setLocation(260,630);
		add(fire);
		place.addActionListener(new FireClickHandler());
		selectHZ.setLocation(580, 225);
		selectHZ.setSize(120, 20);
		add(selectHZ);
		place.setSize(70,20);
		place.setLocation(605,265);
		add(place);
		place.addActionListener(new PlaceClickHandler());
		messageCenter.setSize(300,190);
		messageCenter.setLocation(675,130);
		messageCenter.setEditable(false);
		messageCenter.setLineWrap(true);
		messageCenter.setWrapStyleWord(true);
		galacticShips[0] = new Ship("Death Star", 4, 72, 72, 200, 200, deathStarBig);
		galacticShips[0].setBorderPainted(false);
		galacticShips[0].setSize(200,200);
		galacticShips[0].setLocation(800,125);
		galacticShips[1] = new Ship("Star Destroyer", 4, 50, 120, 310, 185, starDestroyerBig);
		galacticShips[1].setBorderPainted(false);
		galacticShips[1].setSize(310,185);
		galacticShips[1].setLocation(725,125);
		galacticShips[2] = new Ship("Sith Infiltrator", 4, 60, 120, 285, 181, sithInfiltratorBig);
		galacticShips[2].setBorderPainted(false);
		galacticShips[2].setSize(285,181);
		galacticShips[2].setLocation(775,125);
		galacticShips[3] = new Ship("Tie Fighter", 2, 80, 35, 211, 180, tieFighterBig);
		galacticShips[3].setBorderPainted(false);
		galacticShips[3].setSize(211,180);
		galacticShips[3].setLocation(800,125);
		galacticShips[4] = new Ship("Tie Bomber", 2, 75, 30, 320, 200, tieBomberBig);
		galacticShips[4].setBorderPainted(false);
		galacticShips[4].setSize(320,200);
		galacticShips[4].setLocation(750,125);
		//rebelShips[0] = new Ship("Death Star", 4, 72, 72, 200, 200, deathStarBig);
		//rebelShips[0].setBorderPainted(false);
		//rebelShips[0].setSize(200,200);
		//rebelShips[0].setLocation(775,125);
		//add(rebelShips[0]);
		//rebelShips[1] = new Ship("Star Destroyer", 4, 50, 120, 310, 185, starDestroyerBig);
		//rebelShips[1].setBorderPainted(false);
		//rebelShips[1].setSize(310,185);
		//rebelShips[1].setLocation(775,125);
		//add(rebelShips[1]);
		//rebelShips[2] = new Ship("Sith Infiltrator", 4, 60, 120, 285, 181, sithInfiltratorBig);
		//rebelShips[2].setBorderPainted(false);
		//rebelShips[2].setSize(285,181);
		//rebelShips[2].setLocation(775,125);
		//add(rebelShips[2]);
		//rebelShips[3] = new Ship("Tie Fighter", 2, 80, 35, 211, 180, tieFighterBig);
		//rebelShips[3].setBorderPainted(false);
		//rebelShips[3].setSize(211,180);
		//rebelShips[3].setLocation(775,125);
		//add(rebelShips[3]);
		//rebelShips[4] = new Ship("Tie Bomber", 2, 75, 30, 320, 200, tieBomberBig);
		//rebelShips[4].setBorderPainted(false);
		//rebelShips[4].setSize(320,200);
		//rebelShips[4].setLocation(750,125);
		//add(rebelShips[4]);
		rebel.setBorderPainted(false);
		rebel.setSize(200,205);
		rebel.setLocation(100,400);
		rebel.setIcon(rebelButton);
		rebel.addActionListener(new SplashClickHandler());
		splash.add(rebel);
		galactic.setBorderPainted(false);
		galactic.setSize(200,200);
		galactic.setLocation(800,400);
		galactic.setIcon(galacticButton);
		galactic.addActionListener(new SplashClickHandler());
		splash.add(galactic);
		selectDiff.setLocation(500, 480);
		selectDiff.setSize(120, 30);
		splash.add(selectDiff);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, 1125, 750, null);
	}
	
	/**
	 * Displays the gui
	 */
	public void display() {
		frame.setResizable(false);    
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(splash);
	    frame.setSize(1125, 750);
	    frame.setVisible(true);
	    frame.setLocationRelativeTo(null);
	}
	
	/**
	 * SplashClickHandler provides the action listener for the splash screen
	 */
	private class SplashClickHandler implements ActionListener{

		/**
		 * This method handles the tasks of setting the ship
		 *
		 * @param e the action event handled by this method
		 */
		
		public void actionPerformed(ActionEvent e){	
			if (e.getSource() == rebel) {
				userShips = rebelShips;
			}
			else if (e.getSource() == galactic) {
				userShips = galacticShips;

			}
			
			changeScreen();
			add(userShips[count]);
			shipName.setText(userShips[count].name);
		}
	}
	
	public void changeScreen() {
		frame.setContentPane(this);
	}
	
	/**
	 * PlaceClickHandler provides the action listener for the go button
	 */
	private class PlaceClickHandler implements ActionListener{

		/**
		 * This method handles the tasks of setting the ship
		 *
		 * @param e the action event handled by this method
		 */
		
		public void actionPerformed(ActionEvent e){	
			boolean isVertical = true;
			if ((selectHZ.getSelectedItem()).toString().equals("Horizontal"))  {
				isVertical = false;
			}

			char letter = (placeA.getText()).charAt(0);
			char number = (place1.getText()).charAt(0);
			userShips[count].letter = letter;
			userShips[count].number = number;
			userShips[count].isVertical = isVertical;
			remove(userShips[count]);
			count++;
			if (count <= ARRAY_MAX_SIZE) {
				add(userShips[count]);
				shipName.setText(userShips[count].name);
				repaint();
			}
			else {
				remove(userShips[count-1]);
				remove(place);
				remove(placeA);
				remove(place1);
				remove(selectHZ);
				remove(shipName);
				add(messageCenter);
				repaint();
			}
		}
	}
	
	/**
	 * FireClickHandler provides the action listener for the go button
	 */
	private class FireClickHandler implements ActionListener{

		/**
		 * This method handles the tasks of setting the ship
		 *
		 * @param e the action event handled by this method
		 */
		
		public void actionPerformed(ActionEvent e){	
		}
	}
}