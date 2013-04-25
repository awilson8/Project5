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
	JLabel shipName = new JLabel ("Ship name");
	JTextField placeA = new JTextField("Ex: A");
	JTextField place1 = new JTextField("Ex: 1");
	private JTextArea messageCenter = new JTextArea("");
	JButton rebel = new JButton();
	JButton galactic = new JButton();
	JButton place = new JButton ("Place");
	String[] isVT = {"Vertical", "Horizontal"};
	JComboBox selectHZ = new JComboBox(isVT);
	String[] difficulty = {"Easy", "Medium", "Hard"};
	JComboBox selectDiff = new JComboBox(difficulty);
	Ship[] rebelShips = new Ship[5];
	Ship[] galacticShips = new Ship[5];
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
		setLayout(null);

		for (int i=0; i<enemyGrid.length; i++) {
            for (int j=0; j<enemyGrid[i].length; j++) {
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
		enemyGrid[6][0].setLocation(637,577);
		enemyGrid[6][1].setLocation(675,577);
		enemyGrid[6][2].setLocation(714,577);
		enemyGrid[6][3].setLocation(752,577);
		enemyGrid[6][4].setLocation(791,577);
		enemyGrid[6][5].setLocation(829,577);
		enemyGrid[6][6].setLocation(867,577);
		enemyGrid[6][7].setLocation(906,577);
		enemyGrid[6][8].setLocation(944,577);
		enemyGrid[6][9].setLocation(982,577);
		enemyGrid[7][0].setLocation(637,608);
		enemyGrid[7][1].setLocation(675,608);
		enemyGrid[7][2].setLocation(714,608);
		enemyGrid[7][3].setLocation(752,608);
		enemyGrid[7][4].setLocation(791,608);
		enemyGrid[7][5].setLocation(829,608);
		enemyGrid[7][6].setLocation(867,608);
		enemyGrid[7][7].setLocation(906,608);
		enemyGrid[7][8].setLocation(944,608);
		enemyGrid[7][9].setLocation(982,608);
		enemyGrid[8][0].setLocation(637,637);
		enemyGrid[8][1].setLocation(675,637);
		enemyGrid[8][2].setLocation(714,637);
		enemyGrid[8][3].setLocation(752,637);
		enemyGrid[8][4].setLocation(791,637);
		enemyGrid[8][5].setLocation(829,637);
		enemyGrid[8][6].setLocation(867,637);
		enemyGrid[8][7].setLocation(906,637);
		enemyGrid[8][8].setLocation(944,637);
		enemyGrid[8][9].setLocation(982,637);
		enemyGrid[9][0].setLocation(637,668);
		enemyGrid[9][1].setLocation(675,668);
		enemyGrid[9][2].setLocation(714,668);
		enemyGrid[9][3].setLocation(752,668);
		enemyGrid[9][4].setLocation(791,668);
		enemyGrid[9][5].setLocation(829,668);
		enemyGrid[9][6].setLocation(867,668);
		enemyGrid[9][7].setLocation(906,668);
		enemyGrid[9][8].setLocation(944,668);
		enemyGrid[9][9].setLocation(982,668);
		for (int k=0; k<grid.length; k++) {
            for (int m=0; m<grid[k].length; m++) {
            	grid[k][m] = new Cell();
            	grid[k][m].setSize(35,29);
            	grid[k][m].setOpaque(false);
            	grid[k][m].setBorderPainted(false);
            	add(grid[k][m]);
            }
        }
		grid[0][0].setLocation(144,186);
		grid[0][1].setLocation(182,186);
		grid[0][2].setLocation(221,186);
		grid[0][3].setLocation(259,186);
		grid[0][4].setLocation(298,186);
		grid[0][5].setLocation(336,186);
		grid[0][6].setLocation(374,186);
		grid[0][7].setLocation(413,186);
		grid[0][8].setLocation(451,186);
		grid[0][9].setLocation(489,186);
		grid[1][0].setLocation(144,216);
		grid[1][1].setLocation(182,216);
		grid[1][2].setLocation(221,216);
		grid[1][3].setLocation(259,216);
		grid[1][4].setLocation(298,216);
		grid[1][5].setLocation(336,216);
		grid[1][6].setLocation(374,216);
		grid[1][7].setLocation(413,216);
		grid[1][8].setLocation(451,216);
		grid[1][9].setLocation(489,216);
		grid[2][0].setLocation(144,247);
		grid[2][1].setLocation(182,247);
		grid[2][2].setLocation(221,247);
		grid[2][3].setLocation(259,247);
		grid[2][4].setLocation(298,247);
		grid[2][5].setLocation(336,247);
		grid[2][6].setLocation(374,247);
		grid[2][7].setLocation(413,247);
		grid[2][8].setLocation(451,247);
		grid[2][9].setLocation(489,247);
		grid[3][0].setLocation(144,278);
		grid[3][1].setLocation(182,278);
		grid[3][2].setLocation(221,278);
		grid[3][3].setLocation(259,278);
		grid[3][4].setLocation(298,278);
		grid[3][5].setLocation(336,278);
		grid[3][6].setLocation(374,278);
		grid[3][7].setLocation(413,278);
		grid[3][8].setLocation(451,278);
		grid[3][9].setLocation(489,278);
		grid[4][0].setLocation(144,308);
		grid[4][1].setLocation(182,308);
		grid[4][2].setLocation(221,308);
		grid[4][3].setLocation(259,308);
		grid[4][4].setLocation(298,308);
		grid[4][5].setLocation(336,308);
		grid[4][6].setLocation(374,308);
		grid[4][7].setLocation(413,308);
		grid[4][8].setLocation(451,308);
		grid[4][9].setLocation(489,308);
		grid[5][0].setLocation(144,339);
		grid[5][1].setLocation(182,339);
		grid[5][2].setLocation(221,339);
		grid[5][3].setLocation(259,339);
		grid[5][4].setLocation(298,339);
		grid[5][5].setLocation(336,339);
		grid[5][6].setLocation(374,339);
		grid[5][7].setLocation(413,339);
		grid[5][8].setLocation(451,339);
		grid[5][9].setLocation(489,339);
		grid[6][0].setLocation(144,370);
		grid[6][1].setLocation(182,370);
		grid[6][2].setLocation(221,370);
		grid[6][3].setLocation(259,370);
		grid[6][4].setLocation(298,370);
		grid[6][5].setLocation(336,370);
		grid[6][6].setLocation(374,370);
		grid[6][7].setLocation(413,370);
		grid[6][8].setLocation(451,370);
		grid[6][9].setLocation(489,370);
		grid[7][0].setLocation(144,401);
		grid[7][1].setLocation(182,401);
		grid[7][2].setLocation(221,401);
		grid[7][3].setLocation(259,401);
		grid[7][4].setLocation(298,401);
		grid[7][5].setLocation(336,401);
		grid[7][6].setLocation(374,401);
		grid[7][7].setLocation(413,401);
		grid[7][8].setLocation(451,401);
		grid[7][9].setLocation(489,401);
		grid[8][0].setLocation(144,431);
		grid[8][1].setLocation(182,431);
		grid[8][2].setLocation(221,431);
		grid[8][3].setLocation(259,431);
		grid[8][4].setLocation(298,431);
		grid[8][5].setLocation(336,431);
		grid[8][6].setLocation(374,431);
		grid[8][7].setLocation(413,431);
		grid[8][8].setLocation(451,431);
		grid[8][9].setLocation(489,431);
		grid[9][0].setLocation(144,462);
		grid[9][1].setLocation(182,462);
		grid[9][2].setLocation(221,462);
		grid[9][3].setLocation(259,462);
		grid[9][4].setLocation(298,462);
		grid[9][5].setLocation(336,462);
		grid[9][6].setLocation(374,462);
		grid[9][7].setLocation(413,462);
		grid[9][8].setLocation(451,462);
		grid[9][9].setLocation(489,462);
		setSize(1125,750);
		background = new ImageIcon("Project5-1.png").getImage();
		shipName.setFont(new Font("Times", Font.BOLD, 13));
		shipName.setSize(115,25);
		shipName.setLocation(580,145);
		shipName.setBackground(Color.white);
		shipName.setOpaque(true);
		shipName.setHorizontalAlignment(SwingConstants.CENTER);
		add(shipName);
		placeA.setSize(50,20);
		placeA.setLocation(585,190);
		add(placeA);
		place1.setSize(50,20);
		place1.setLocation(640,190);
		add(place1);
		selectHZ.setLocation(580, 225);
		selectHZ.setSize(120, 20);
		add(selectHZ);
		place.setSize(70,20);
		place.setLocation(605,265);
		add(place);
		place.addActionListener(new PlaceClickHandler());
		messageCenter.setSize(300,190);
		messageCenter.setLocation(155,515);
		messageCenter.setEditable(false);
		messageCenter.setLineWrap(true);
		messageCenter.setWrapStyleWord(true);
		add(messageCenter);
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
		int hzOrVt = r.nextInt(2);
		int count = 1;
		int count2 = 0;
		if (userShips == rebelShips) {
			while (i+userShips[0].strength > 9) {
				i = r.nextInt(10);
			}
			while (j+userShips[0].strength > 9) {
				j = r.nextInt(10);
			}
			deathStar(i,j);
			while (count < userShips.length) {
				boolean available = false;
				while (available == false) {
					i = r.nextInt(10);
					j = r.nextInt(10);
					hzOrVt = r.nextInt(2);
					if (hzOrVt == 0) {
						while (i+userShips[count].strength > 9) {
							i = r.nextInt(10);
						}
					}
					else {
						while (j+userShips[count].strength > 9) {
							j = r.nextInt(10);
						}
					}
					if (isAvailable(i,j,hzOrVt,userShips[count].strength)) {
						available = true;
					}
				}
				placeShip(i,j,hzOrVt, userShips[count], userShips[count].strength);
				count++;
			}
		}
		else {
			while (count2 < userShips.length) {
				boolean available = false;
				while (available == false) {
					i = r.nextInt(10);
					j = r.nextInt(10);
					hzOrVt = r.nextInt(2);
					if (hzOrVt == 0) {
						while (i+userShips[count2].strength > 9) {
							i = r.nextInt(10);
						}
					}
					else {
						while (j+userShips[count2].strength > 9) {
							j = r.nextInt(10);
						}
					}
					if (isAvailable(i,j,hzOrVt,userShips[count2].strength)) {
						available = true;
					}
				}
				placeShip(i,j,hzOrVt, userShips[count2], userShips[count2].strength);
				count2++;
			}
		}
	}
	
	public void deathStar(int i, int j) {
		enemyGrid[i][j].setStatus(1);
		enemyGrid[i][j].s = galacticShips[0];
		enemyGrid[i+1][j].setStatus(1);
		enemyGrid[i+1][j].s = galacticShips[0];
		enemyGrid[i][j+1].setStatus(1);
		enemyGrid[i][j+1].s = galacticShips[0];
		enemyGrid[i+1][j+1].setStatus(1);
		enemyGrid[i+1][j+1].s = galacticShips[0];
	}
	
	public boolean isAvailable(int i, int j, int hzOrVt, int strength) {
		int numOccupied = 0;
		boolean response = true;
		if (hzOrVt == 0) {
			for (int x=0; x<strength; x++) {
				numOccupied += testCell(enemyGrid[i+x][j]);
			}
		}
		else {
			for (int x=0; x<strength; x++) {
				numOccupied += testCell(enemyGrid[i][j+x]);
			}
		}
		
		if (numOccupied > 0) {
			response = false;
		}
		return response;
	}
	
	public int testCell(Cell c) {
		int occupied = 0;
		if (c.status == 1) {
			occupied = 1;
		}
		return occupied;
	}
	
	public void placeShip(int i, int j, int hzOrVt, Ship s, int strength) {
		if (hzOrVt == 0) {
			for (int x=0;x<strength;x++) {
				enemyGrid[i+x][j].setStatus(1);
				enemyGrid[i+x][j].s = s;
			}
		}
		else {
			for (int x=0;x<strength;x++) {
				enemyGrid[i][j+x].setStatus(1);
				enemyGrid[i][j+x].s = s;
			}
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

			String letter = placeA.getText().substring(0, 1);
			int number = (place1.getText()).charAt(0);
			if (!(letter.matches("[a-jA-J]")) && (number >=0 && number<=9) ) {
				messageCenter.setText("Invalid Cooridinates");
			}
			else {
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
					//add side logo
					repaint();
				}
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
				temp.setBackground(Color.blue);
				temp.setOpaque(true);
				temp.setEnabled(false);
			}
			else if (temp.getStatus() == 1) {
				temp.setBackground(Color.red);
				temp.setOpaque(true);
				temp.setEnabled(false);
				temp.setStatus(2);
				temp.s.strength -= 1;
				System.out.println(temp.s.name + " " + temp.s.strength);
				if (temp.s.strength == 0) {
					sunk();
				}
			}
		}
	}
	
	public void sunk() {
		
	}
}