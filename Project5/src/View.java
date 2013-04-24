import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

/**
 * Gui for Project5.
 * @author Drew Wilson
 * @version 1.0
*/
public class View extends JPanel {
	int count = 0;
	Random r = new Random();
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
	JButton testButton = new JButton();
	private ImageIcon deathStarBig = new ImageIcon("DeathStarBig.png");
	private ImageIcon starDestroyerBig = new ImageIcon("ImperialStarDestroyerBig.png");
	private ImageIcon sithInfiltratorBig = new ImageIcon("SithInfiltratorBig.png");
	private ImageIcon tieFighterBig = new ImageIcon("TieFighterBig.png");
	private ImageIcon tieBomberBig = new ImageIcon("TieBomberBig.png");
	private ImageIcon starCruiserBig = new ImageIcon("StarCruiserBig.png");
	private ImageIcon attackCruiserBig = new ImageIcon("AttackCruiserBig.png");
	private ImageIcon starFighterBig = new ImageIcon("StarFighterBig.png");
	private ImageIcon xWingBig = new ImageIcon("XWingBig.png");
	private ImageIcon millFalconBig = new ImageIcon("MillFalconBig.png");
	private ImageIcon rebelButton = new ImageIcon("RebelAlliance.png");
	private ImageIcon galacticButton = new ImageIcon("GalacticEmpire.png");
	Cell[][] grid = new Cell[10][10];
	Cell[][] enemyGrid = new Cell[10][10];
	Ship[] userShips;

	/**
	 * Create the panel.
	 */
	public View() {
		testButton.setSize(34,27);
		testButton.setLocation(221,186);
		add(testButton);
		setLayout(null);

		for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
            	enemyGrid[i][j] = new Cell();
            	enemyGrid[i][j].setSize(35,29);
            	enemyGrid[i][j].addActionListener(new FireClickHandler());
            	add(enemyGrid[i][j]);
            }
        }
		enemyGrid[0][0].setLocation(637,393);
		enemyGrid[0][1].setLocation(675,393);
		enemyGrid[0][2].setLocation(714,393);
		enemyGrid[0][3].setLocation(752,393);
		enemyGrid[0][4].setLocation(791,393);
		enemyGrid[0][5].setLocation(829,393);
		enemyGrid[0][6].setLocation(867,393);
		enemyGrid[0][7].setLocation(906,393);
		enemyGrid[0][8].setLocation(944,393);
		enemyGrid[0][9].setLocation(982,393);
		enemyGrid[1][0].setLocation(637,423);
		enemyGrid[1][1].setLocation(675,423);
		enemyGrid[1][2].setLocation(714,423);
		enemyGrid[1][3].setLocation(752,423);
		enemyGrid[1][4].setLocation(791,423);
		enemyGrid[1][5].setLocation(829,423);
		enemyGrid[1][6].setLocation(867,423);
		enemyGrid[1][7].setLocation(906,423);
		enemyGrid[1][8].setLocation(944,423);
		enemyGrid[1][9].setLocation(982,423);
		enemyGrid[2][0].setLocation(637,454);
		enemyGrid[2][1].setLocation(675,454);
		enemyGrid[2][2].setLocation(714,454);
		enemyGrid[2][3].setLocation(752,454);
		enemyGrid[2][4].setLocation(791,454);
		enemyGrid[2][5].setLocation(829,454);
		enemyGrid[2][6].setLocation(867,454);
		enemyGrid[2][7].setLocation(906,454);
		enemyGrid[2][8].setLocation(944,454);
		enemyGrid[2][9].setLocation(982,454);
		enemyGrid[3][0].setLocation(637,485);
		enemyGrid[3][1].setLocation(675,485);
		enemyGrid[3][2].setLocation(714,485);
		enemyGrid[3][3].setLocation(752,485);
		enemyGrid[3][4].setLocation(791,485);
		enemyGrid[3][5].setLocation(829,485);
		enemyGrid[3][6].setLocation(867,485);
		enemyGrid[3][7].setLocation(906,485);
		enemyGrid[3][8].setLocation(944,485);
		enemyGrid[3][9].setLocation(982,485);
		enemyGrid[4][0].setLocation(637,516);
		enemyGrid[4][1].setLocation(675,516);
		enemyGrid[4][2].setLocation(714,516);
		enemyGrid[4][3].setLocation(752,516);
		enemyGrid[4][4].setLocation(791,516);
		enemyGrid[4][5].setLocation(829,516);
		enemyGrid[4][6].setLocation(867,516);
		enemyGrid[4][7].setLocation(906,516);
		enemyGrid[4][8].setLocation(944,516);
		enemyGrid[4][9].setLocation(982,516);
		enemyGrid[5][0].setLocation(637,547);
		enemyGrid[5][1].setLocation(675,547);
		enemyGrid[5][2].setLocation(714,547);
		enemyGrid[5][3].setLocation(752,547);
		enemyGrid[5][4].setLocation(791,547);
		enemyGrid[5][5].setLocation(829,547);
		enemyGrid[5][6].setLocation(867,547);
		enemyGrid[5][7].setLocation(906,547);
		enemyGrid[5][8].setLocation(944,547);
		enemyGrid[5][9].setLocation(982,547);
		enemyGrid[6][0].setLocation(637,578);
		enemyGrid[6][1].setLocation(675,578);
		enemyGrid[6][2].setLocation(714,578);
		enemyGrid[6][3].setLocation(752,578);
		enemyGrid[6][4].setLocation(791,578);
		enemyGrid[6][5].setLocation(829,578);
		enemyGrid[6][6].setLocation(867,578);
		enemyGrid[6][7].setLocation(906,578);
		enemyGrid[6][8].setLocation(944,578);
		enemyGrid[6][9].setLocation(982,578);
		enemyGrid[7][0].setLocation(637,609);
		enemyGrid[7][1].setLocation(675,609);
		enemyGrid[7][2].setLocation(714,609);
		enemyGrid[7][3].setLocation(752,609);
		enemyGrid[7][4].setLocation(791,609);
		enemyGrid[7][5].setLocation(829,609);
		enemyGrid[7][6].setLocation(867,609);
		enemyGrid[7][7].setLocation(906,609);
		enemyGrid[7][8].setLocation(944,609);
		enemyGrid[7][9].setLocation(982,609);
		enemyGrid[8][0].setLocation(637,638);
		enemyGrid[8][1].setLocation(675,638);
		enemyGrid[8][2].setLocation(714,638);
		enemyGrid[8][3].setLocation(752,638);
		enemyGrid[8][4].setLocation(791,638);
		enemyGrid[8][5].setLocation(829,638);
		enemyGrid[8][6].setLocation(867,638);
		enemyGrid[8][7].setLocation(906,638);
		enemyGrid[8][8].setLocation(944,638);
		enemyGrid[8][9].setLocation(982,638);
		enemyGrid[9][0].setLocation(637,669);
		enemyGrid[9][1].setLocation(675,669);
		enemyGrid[9][2].setLocation(714,669);
		enemyGrid[9][3].setLocation(752,669);
		enemyGrid[9][4].setLocation(791,669);
		enemyGrid[9][5].setLocation(829,669);
		enemyGrid[9][6].setLocation(867,669);
		enemyGrid[9][7].setLocation(906,669);
		enemyGrid[9][8].setLocation(944,669);
		enemyGrid[9][9].setLocation(982,669);
		setSize(1125,750);
		background = new ImageIcon("Project5-1.png").getImage();
		attack.setFont(new Font("Times", Font.BOLD, 18));
		attack.setSize(115,30);
		attack.setLocation(240,520);
		attack.setBackground(Color.white);
		attack.setOpaque(true);
		attack.setHorizontalAlignment(SwingConstants.CENTER);
		add(attack);
		shipName.setFont(new Font("Times", Font.BOLD, 13));
		shipName.setSize(115,25);
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
		fire.addActionListener(new FireClickHandler());
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
		rebelShips[0] = new Ship("Star Cruiser", 5, 72, 72, 351, 139, starCruiserBig);
		rebelShips[0].setBorderPainted(false);
		rebelShips[0].setSize(351,139);
		rebelShips[0].setLocation(725,150);
		rebelShips[1] = new Ship("Attack Cruiser", 4, 50, 120, 290, 205, attackCruiserBig);
		rebelShips[1].setBorderPainted(false);
		rebelShips[1].setSize(290,205);
		rebelShips[1].setLocation(775,120);
		rebelShips[2] = new Ship("Star Fighter", 3, 60, 120, 351, 200, starFighterBig);
		rebelShips[2].setBorderPainted(false);
		rebelShips[2].setSize(351,200);
		rebelShips[2].setLocation(720,125);
		rebelShips[3] = new Ship("X-Wing Fighter", 2, 80, 35, 330, 215, xWingBig);
		rebelShips[3].setBorderPainted(false);
		rebelShips[3].setSize(330,215);
		rebelShips[3].setLocation(735,115);
		rebelShips[4] = new Ship("Millennium Falcon", 2, 75, 30, 320, 210, millFalconBig);
		rebelShips[4].setBorderPainted(false);
		rebelShips[4].setSize(320,210);
		rebelShips[4].setLocation(750,120);
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
	
	public void setEnemyGrid() {
		int i = r.nextInt(10);
		int j = r.nextInt(10);
		System.out.println(i + " " + j);
		if (userShips == rebelShips) {
			enemyGrid[i][j].setStatus(1);
			if (i==9 && j<9) {
				enemyGrid[i][j+1].setStatus(1);
				enemyGrid[i-1][j].setStatus(1);
				enemyGrid[i-1][j+1].setStatus(1);
			}
			else if (i==9 && j==9) {
				enemyGrid[i-1][j].setStatus(1);
				enemyGrid[i-1][j-1].setStatus(1);
				enemyGrid[i-1][j-1].setStatus(1);
			}
			else if (i<9 && j==9) {
				enemyGrid[i][j-1].setStatus(1);
				enemyGrid[i+1][j-1].setStatus(1);
				enemyGrid[i+1][j].setStatus(1);
			}
			else {
				enemyGrid[i][j+1].setStatus(1);
				enemyGrid[i+1][j].setStatus(1);
				enemyGrid[i+1][j+1].setStatus(1);
			}
		}
		else {
			enemyGrid[i][j].setStatus(1);
			enemyGrid[i][j+1].setStatus(1);
			enemyGrid[i][j+2].setStatus(1);
			enemyGrid[i][j+3].setStatus(1);
			enemyGrid[i][j+4].setStatus(1);
		}
	}
	
	/**
	 * SplashClickHandler provides the action listener for the splash screen
	 */
	private class SplashClickHandler implements ActionListener {

		/**
		 * This method handles the tasks of setting the ship
		 *
		 * @param e the action event handled by this method
		 */
		
		public void actionPerformed(ActionEvent e) {	
			if (e.getSource() == rebel) {
				userShips = rebelShips;
			}
			else if (e.getSource() == galactic) {
				userShips = galacticShips;
			}
			setEnemyGrid();
			
			String difficulty = (selectDiff.getSelectedItem()).toString();
			System.out.println(difficulty);
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
	private class PlaceClickHandler implements ActionListener {

		/**
		 * This method handles the tasks of setting the ship
		 *
		 * @param e the action event handled by this method
		 */
		
		public void actionPerformed(ActionEvent e) {	
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
	private class FireClickHandler implements ActionListener {

		/**
		 * This method handles the tasks of firing at ships
		 *
		 * @param e the action event handled by this method
		 */
		
		public void actionPerformed(ActionEvent e) {
			Cell temp = (Cell)e.getSource();
			if (temp.getStatus() == 0) {
				//miss
				temp.setBackground(Color.blue);
				temp.setOpaque(true);
				temp.setEnabled(false);
			}
			else if (temp.getStatus() == 1) {
				temp.setBackground(Color.red);
				temp.setOpaque(true);
				temp.setEnabled(false);
				temp.setStatus(2);
			}
		}
	}
}