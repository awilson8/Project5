import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.sound.sampled.*;
import javax.swing.*;

/**
 * Gui for Project5.
 * @author Drew Wilson
 * @version 1.0
*/
public class View extends JPanel {
	int count = 0;
	int count2 = 0;
	int count3 = 0;
	int userHit = 1;
	int enemyHit = 1;
	int gameOver = 0;
	Random r = new Random();
	private final int ARRAY_MAX_SIZE = 4;
	Splash splash = new Splash();
	RebelVictory rebelVictory = new RebelVictory();
	ImperialVictory imperialVictory = new ImperialVictory();
	EnemyRebelVictory enemyRebelVictory = new EnemyRebelVictory();
	EnemyImperialVictory enemyImperialVictory = new EnemyImperialVictory();
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
	int shipsLeft = 5;
	int userShipsLeft = 5;
	int state = 0;
	Cell placed;
	Cell deathStarPlaced;
	boolean isDeathStarPlaced = false;
	Cell deathStarPlusI = null;
	Cell deathStarPlusJ = null;
	Cell deathStarNegI = null;
	Cell deathStarNegJ = null;
	Cell deathStarIJ = null;
	Cell deathStarNegIJ = null;
	Cell deathStarINegJ = null;
	Cell deathStarNegINegJ = null;
	Cell plusI = null;
	Cell plusJ = null;
	Cell negI = null;
	Cell negJ = null;
	Ship galacticLogo;
	Ship rebelLogo;
	String gameDifficulty;
    Thread splashSound;
    AudioInputStream audio;
    Clip clip;

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
            	grid[k][m].addActionListener(new PlaceClickHandler());
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
		messageCenter.setSize(300,160);
		messageCenter.setLocation(155,530);
		messageCenter.setFont(new Font("Times", Font.BOLD, 22));
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
		galacticLogo = new Ship(galacticButton);
		galacticLogo.setSize(200,200);
		galacticLogo.setLocation(720,120);
		galacticLogo.setBorderPainted(false);
		rebelLogo = new Ship(rebelButton);
		rebelLogo.setSize(200,200);
		rebelLogo.setLocation(720,120);
		rebelLogo.setBorderPainted(false);
		splashSound = new Thread(new Runnable(){
			public void run(){
				try {
		            audio = AudioSystem.getAudioInputStream(new File("SpaceWars.wav"));
		            clip = AudioSystem.getClip();
		            clip.open(audio);
		            clip.start();
		        }
		        
		        catch(UnsupportedAudioFileException uae) {
		            System.out.println(uae);
		        }
		        catch(IOException ioe) {
		            System.out.println(ioe);
		        }
		        catch(LineUnavailableException lua) {
		            System.out.println(lua);
		        }
			}
		});
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
		splashSound.run();
	}
	
	public void setEnemyGrid() {
		int i = r.nextInt(10);
		int j = r.nextInt(10);
		int hzOrVt = r.nextInt(2);
		int count = 1;
		int count2 = 0;
		if (userShips == rebelShips) {
			while (i+galacticShips[0].strength > 9) {
				i = r.nextInt(10);
			}
			while (j+galacticShips[0].strength > 9) {
				j = r.nextInt(10);
			}
			deathStar(i,j);
			while (count < galacticShips.length) {
				boolean available = false;
				while (available == false) {
					i = r.nextInt(10);
					j = r.nextInt(10);
					hzOrVt = r.nextInt(2);
					if (hzOrVt == 0) {
						while (i+galacticShips[count].strength > 9) {
							i = r.nextInt(10);
						}
					}
					else {
						while (j+galacticShips[count].strength > 9) {
							j = r.nextInt(10);
						}
					}
					if (isAvailable(i,j,hzOrVt,galacticShips[count].strength)) {
						available = true;
					}
				}
				placeShip(i,j,hzOrVt, galacticShips[count], galacticShips[count].strength);
				count++;
			}
		}
		else {
			while (count2 < rebelShips.length) {
				boolean available = false;
				while (available == false) {
					i = r.nextInt(10);
					j = r.nextInt(10);
					hzOrVt = r.nextInt(2);
					if (hzOrVt == 0) {
						while (i+rebelShips[count2].strength > 9) {
							i = r.nextInt(10);
						}
					}
					else {
						while (j+rebelShips[count2].strength > 9) {
							j = r.nextInt(10);
						}
					}
					if (isAvailable(i,j,hzOrVt,rebelShips[count2].strength)) {
						available = true;
					}
				}
				placeShip(i,j,hzOrVt, rebelShips[count2], rebelShips[count2].strength);
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
			clip.stop();
			splashSound.interrupt();
			if (e.getSource() == rebel) {
				userShips = rebelShips;
			}
			else if (e.getSource() == galactic) {
				userShips = galacticShips;
			}
			setEnemyGrid();
			
			gameDifficulty = (selectDiff.getSelectedItem()).toString();
			changeScreen();
			add(userShips[count]);
			shipName.setText(userShips[count].name);
		}
	}
	
	public void changeScreen() {
		frame.setContentPane(this);
		splashSound.interrupt();
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
			if (userShips == galacticShips && isDeathStarPlaced == false) {
				deathStarPlaced = (Cell)e.getSource();
				deathStarPlaced.setBackground(Color.green);
				deathStarPlaced.setOpaque(true);
				int a = -1;
				int b = -1;
				for (int i=0;i<grid.length;i++) {
					for (int j=0;j<grid[i].length;j++) {
						grid[i][j].setEnabled(false);
						if (grid[i][j] == deathStarPlaced) {
							a = i;
							b = j;
						}
					}
				}
				state = 1;
				if (state == 1) {
					if (isDeathStarIJ(1, a, b)) {
						deathStarIJ = grid[a+1][b+1];
						deathStarIJ.setBackground(Color.green);
						deathStarIJ.setOpaque(true);
						deathStarIJ.setEnabled(true);
						for (ActionListener act : deathStarIJ.getActionListeners()) {
							deathStarIJ.removeActionListener(act);
						}
						deathStarIJ.addActionListener(new PlaceClickHandler3());
					}
					if (isDeathStarNegIJ(1, a, b)) {
						deathStarNegIJ = grid[a-1][b+1];
						deathStarNegIJ.setBackground(Color.green);
						deathStarNegIJ.setOpaque(true);
						deathStarNegIJ.setEnabled(true);
						for (ActionListener act : deathStarNegIJ.getActionListeners()) {
							deathStarNegIJ.removeActionListener(act);
						}
						deathStarNegIJ.addActionListener(new PlaceClickHandler3());
					}
					if (isDeathStarINegJ(1, a, b)) {
						deathStarINegJ = grid[a+1][b-1];
						deathStarINegJ.setBackground(Color.green);
						deathStarINegJ.setOpaque(true);
						deathStarINegJ.setEnabled(true);
						for (ActionListener act : deathStarINegJ.getActionListeners()) {
							deathStarINegJ.removeActionListener(act);
						}
						deathStarINegJ.addActionListener(new PlaceClickHandler3());
					}
					if (isDeathStarNegINegJ(1, a, b)) {
						deathStarNegINegJ = grid[a-1][b-1];
						deathStarNegINegJ.setBackground(Color.green);
						deathStarNegINegJ.setOpaque(true);
						deathStarNegINegJ.setEnabled(true);
						for (ActionListener act : deathStarNegINegJ.getActionListeners()) {
							deathStarNegINegJ.removeActionListener(act);
						}
						deathStarNegINegJ.addActionListener(new PlaceClickHandler3());
					}
				}
				state = 0;
				count3++;
				isDeathStarPlaced = true;
			}
			else {
				placed = (Cell)e.getSource();
				placed.setBackground(Color.green);
				placed.setOpaque(true);
				int strength = userShips[count3].strength;
				int a = -1;
				int b = -1;
				for (int i=0;i<grid.length;i++) {
					for (int j=0;j<grid[i].length;j++) {
						grid[i][j].setEnabled(false);
						if (grid[i][j] == placed) {
							a = i;
							b = j;
						}
					}
				}
				state = 1;
				if (state == 1) {
					if (isAvailableI((strength-1),a,b)) {
						plusI = grid[a+(strength-1)][b];
						plusI.setBackground(Color.green);
						plusI.setOpaque(true);
						plusI.setEnabled(true);
						for (ActionListener act : plusI.getActionListeners()) {
							plusI.removeActionListener(act);
						}
						plusI.addActionListener(new PlaceClickHandler2());
					}
					if (isAvailableJ((strength-1),a,b)) {
						plusJ = grid[a][b+(strength-1)];
						plusJ.setBackground(Color.green);
						plusJ.setOpaque(true);
						plusJ.setEnabled(true);
						for (ActionListener act : plusJ.getActionListeners()) {
							plusJ.removeActionListener(act);
						}
						plusJ.addActionListener(new PlaceClickHandler2());
					}
					if (isAvailableNegI((strength-1),a,b)) {
						negI = grid[a-(strength-1)][b];
						negI.setBackground(Color.green);
						negI.setOpaque(true);
						negI.setEnabled(true);
						for (ActionListener act : negI.getActionListeners()) {
							negI.removeActionListener(act);
						}
						negI.addActionListener(new PlaceClickHandler2());
					}
					if (isAvailableNegJ((strength-1),a,b)) {
						negJ = grid[a][b-(strength-1)];
						negJ.setBackground(Color.green);
						negJ.setOpaque(true);
						negJ.setEnabled(true);
						for (ActionListener act : negJ.getActionListeners()) {
							negJ.removeActionListener(act);
						}	
						negJ.addActionListener(new PlaceClickHandler2());
					}
				}
				state = 0;
				count3++;
			}
		}
	}
	
	public boolean isDeathStarI(int strength, int x, int y) {
		int occupied = 0;
		boolean isOcc = false;
		if(x+strength>9 || grid[x+strength][y].status == 1){
			return false;
		}
		occupied += testCell(grid[x+strength][y]);
		System.out.println(occupied);
		
		if (occupied == 0) {
			isOcc = true;
		}
		System.out.println(isOcc);
		return isOcc;
	}
	
	public boolean isDeathStarNegI(int strength, int x, int y) {
		int occupied = 0;
		boolean isOcc = false;
		if(x-strength<0 || grid[x-strength][y].status == 1){
			return false;
		}
		occupied += testCell(grid[x-strength][y]);
		System.out.println(occupied);
		
		if (occupied == 0) {
			isOcc = true;
		}
		System.out.println(isOcc);
		return isOcc;
	}
	
	public boolean isDeathStarJ(int strength, int x, int y) {
		int occupied = 0;
		boolean isOcc = false;
		if(y+strength>9 || grid[x][y+strength].status == 1){
			return false;
		}
		occupied += testCell(grid[x][y+strength]);
		System.out.println(occupied);
		
		if (occupied == 0) {
			isOcc = true;
		}
		System.out.println(isOcc);
		return isOcc;
	}
	
	public boolean isDeathStarNegJ(int strength, int x, int y) {
		int occupied = 0;
		boolean isOcc = false;
		if(y-strength<0 || grid[x][y-strength].status == 1){
			return false;
		}
		occupied += testCell(grid[x][y-strength]);
		System.out.println(occupied);
		
		if (occupied == 0) {
			isOcc = true;
		}
		System.out.println(isOcc);
		return isOcc;
	}
	
	public boolean isDeathStarIJ(int strength, int x, int y) {
		int occupied = 0;
		boolean isOcc = false;
		if(x+strength>9 || y+strength>9 || grid[x+strength][y+strength].status == 1){
			return false;
		}
		occupied += testCell(grid[x+strength][y+strength]);
		System.out.println(occupied);
		
		if (occupied == 0) {
			isOcc = true;
		}
		System.out.println(isOcc);
		return isOcc;
	}
	
	public boolean isDeathStarNegIJ(int strength, int x, int y) {
		int occupied = 0;
		boolean isOcc = false;
		if(x-strength<0 || y+strength>9 || grid[x-strength][y+strength].status == 1){
			return false;
		}
		occupied += testCell(grid[x-strength][y+strength]);
		System.out.println(occupied);
		
		if (occupied == 0) {
			isOcc = true;
		}
		System.out.println(isOcc);
		return isOcc;
	}
	
	public boolean isDeathStarINegJ(int strength, int x, int y) {
		int occupied = 0;
		boolean isOcc = false;
		if(x+strength>9 || y-strength<0 || grid[x+strength][y-strength].status == 1){
			return false;
		}
		occupied += testCell(grid[x+strength][y-strength]);
		System.out.println(occupied);

		
		if (occupied == 0) {
			isOcc = true;
		}
		System.out.println(isOcc);
		return isOcc;
	}
	
	public boolean isDeathStarNegINegJ(int strength, int x, int y) {
		int occupied = 0;
		boolean isOcc = false;
		if(x-strength<0 || y-strength<0 || grid[x-strength][y-strength].status == 1){
			return false;
		}
		occupied += testCell(grid[x-1][y-1]);
		System.out.println(occupied);
		
		if (occupied == 0) {
			isOcc = true;
		}
		System.out.println(isOcc);
		return isOcc;
	}
	
	public boolean isAvailableI(int strength, int x, int y) {
		int occupied = 0;
		boolean isOcc = false;
		if(x+strength>9 || grid[x+strength][y].status == 1){
			return false;
		}
		for (int i=0; i<strength;i++) {
			occupied += testCell(grid[x+i][y]);
			System.out.println(occupied);
		}
		
		if (occupied == 0) {
			isOcc = true;
		}

		System.out.println(isOcc);
		return isOcc;
	}
	
	public boolean isAvailableNegI(int strength, int x, int y) {
		int occupied = 0;
		boolean isOcc = false;
		if(x-strength<0 || grid[x-strength][y].status == 1){
			return false;
		}
		for (int i=0; i<strength;i++) {
			occupied += testCell(grid[x-i][y]);
			System.out.println(occupied);
		}
		
		if (occupied == 0) {
			isOcc = true;
		}

		System.out.println(isOcc);
		return isOcc;
	}
	
	public boolean isAvailableJ(int strength, int x, int y) {
		int occupied = 0;
		boolean isOcc = false;
		if(y+strength>9 || grid[x][y+strength].status == 1){
			return false;
		}
		for (int i=0; i<strength;i++) {
			occupied += testCell(grid[x][y+i]);
			System.out.println(occupied);
		}
		
		if (occupied == 0) {
			isOcc = true;
		}
		System.out.println(isOcc);
		return isOcc;
	}
	
	public boolean isAvailableNegJ(int strength, int x, int y) {
		int occupied = 0;
		boolean isOcc = false;
		if(y-strength<0 || grid[x][y-strength].status == 1){
			return false;
		}
		for (int i=0; i<strength;i++) {
			occupied += testCell(grid[x][y-i]);
			System.out.println(occupied);
		}
		
		if (occupied == 0) {
			isOcc = true;
		}
		System.out.println(isOcc);
		return isOcc;
	}
	
	/**
	 * PlaceClickHandler2 provides the action listener for the go button
	 */
	private class PlaceClickHandler2 implements ActionListener {

		/**
		 * This method handles the tasks of setting the ship
		 *2
		 * @param e the action event handled by this method
		 */
		
		public void actionPerformed(ActionEvent e) {
			Cell temp = (Cell)e.getSource();
			int strength = userShips[count].strength;
			System.out.println("Strength1 " + strength);

			int a = -1;
			int b = -1;
			int c = -1;
			int d = -1;
			for (int i=0;i<grid.length;i++) {
				for (int j=0;j<grid[i].length;j++) {
					grid[i][j].setEnabled(true);
					if (grid[i][j] == placed) {
						a = i;
						b = j;
					}
				}
			}
			
			for (int v=0;v<grid.length;v++) {
				for (int w=0;w<grid[v].length;w++) {
					if (grid[v][w] == temp) {
						c = v;
						d = w;
					}
				}
			}
			
			System.out.println("Strength2 " + strength);
			
			if (c > a) {
				System.out.println("c>a");
				for (int g=0;g<strength;g++) {
					grid[a+g][b].setStatus(1);
					grid[a+g][b].s = userShips[count];
					grid[a+g][b].setEnabled(false);

				}
			}
			else if (c < a) {
				System.out.println("c<a");
				for (int g=0;g<strength;g++) {
					grid[c+g][b].setStatus(1);
					grid[c+g][b].s = userShips[count];
					grid[c+g][b].setEnabled(false);
				}
			}
			else if (d > b) {
				System.out.println("d>b");
				for (int g=0;g<strength;g++) {
					grid[a][b+g].setStatus(1);
					grid[a][b+g].s = userShips[count];
					grid[a][b+g].setEnabled(false);

				}
			}
			else {
				System.out.println("d<b");
				for (int g=0;g<strength;g++) {
					grid[a][d+g].setStatus(1);
					grid[a][d+g].s = userShips[count];
					grid[a][d+g].setEnabled(false);
				}
			}			
			
			placed.setBackground(null);
			placed.setOpaque(false);
			placed.setBorderPainted(false);
			
			if (plusI != null) {
				plusI.setBackground(null);
				plusI.setOpaque(false);
				plusI.setBorderPainted(false);
			}
			if (plusJ != null) {
				plusJ.setBackground(null);
				plusJ.setOpaque(false);
				plusJ.setBorderPainted(false);
			}
			if (negI != null) {
				negI.setBackground(null);
				negI.setOpaque(false);
				negI.setBorderPainted(false);
			}
			if (negJ != null) {
				negJ.setBackground(null);
				negJ.setOpaque(false);
				negJ.setBorderPainted(false);
			}

			plusI = null;
			plusJ = null;
			negI = null;
			negJ = null;
			remove(userShips[count]);
			count++;
			try {
				for (ActionListener act : plusI.getActionListeners()) {
					plusI.removeActionListener(act);
				}
				for (ActionListener act : plusJ.getActionListeners()) {
					plusJ.removeActionListener(act);
				}
				for (ActionListener act : negI.getActionListeners()) {
					negI.removeActionListener(act);
				}
				for (ActionListener act : negJ.getActionListeners()) {
					negJ.removeActionListener(act);
				}
			}
			catch (Exception e1) {
			}
			if (count <= ARRAY_MAX_SIZE) {
				try {
					plusI.addActionListener(new PlaceClickHandler());
					plusJ.addActionListener(new PlaceClickHandler());
					negI.addActionListener(new PlaceClickHandler());
					negJ.addActionListener(new PlaceClickHandler());
				}
				catch (Exception e2) {
				}
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
				if (userShips == rebelShips) {
					add(rebelLogo);
				}
				else {
					add(galacticLogo);
				}
				repaint();
				for (int x=0;x<grid.length;x++) {
					for (int y=0;y<grid[x].length;y++) {
						for (ActionListener act : grid[x][y].getActionListeners()) {
							grid[x][y].removeActionListener(act);
						}
						grid[x][y].setEnabled(false);
					}
				}
			}
			greenEmUp();
		}
	}
	
	/**
	 * PlaceClickHandler2 provides the action listener for the go button
	 */
	private class PlaceClickHandler3 implements ActionListener {

		/**
		 * This method handles the tasks of setting the ship
		 *2
		 * @param e the action event handled by this method
		 */
		
		public void actionPerformed(ActionEvent e) {
			Cell temp = (Cell)e.getSource();
			int strength = userShips[0].strength;
			System.out.println("StrengthPCH3 " + strength);

			int a = -1;
			int b = -1;
			int c = -1;
			int d = -1;
			for (int i=0;i<grid.length;i++) {
				for (int j=0;j<grid[i].length;j++) {
					grid[i][j].setEnabled(true);
					if (grid[i][j] == deathStarPlaced) {
						a = i;
						b = j;
					}
				}
			}
			
			for (int v=0;v<grid.length;v++) {
				for (int w=0;w<grid[v].length;w++) {
					if (grid[v][w] == temp) {
						c = v;
						d = w;
					}
				}
			}
			
			System.out.println("Strength2 " + strength);
			
			if (c > a && d > b) {
				System.out.println("c>a && d>b");
				grid[a+1][b].setStatus(1);
				grid[a+1][b].s = userShips[0];
				grid[a+1][b].setEnabled(false);
				grid[a][b+1].setStatus(1);
				grid[a][b+1].s = userShips[0];
				grid[a][b+1].setEnabled(false);
				grid[a+1][b+1].setStatus(1);
				grid[a+1][b+1].s = userShips[0];
				grid[a+1][b+1].setEnabled(false);
			}
			else if (c > a && d < b) {
				System.out.println("c<a");
				grid[a+1][b].setStatus(1);
				grid[a+1][b].s = userShips[0];
				grid[a+1][b].setEnabled(false);
				grid[a][b-1].setStatus(1);
				grid[a][b-1].s = userShips[0];
				grid[a][b-1].setEnabled(false);
				grid[a+1][b-1].setStatus(1);
				grid[a+1][b-1].s = userShips[0];
				grid[a+1][b-1].setEnabled(false);
			}
			else if (c < a && d > b) {
				System.out.println("d>b");
				grid[a-1][b].setStatus(1);
				grid[a-1][b].s = userShips[0];
				grid[a-1][b].setEnabled(false);
				grid[a][b+1].setStatus(1);
				grid[a][b+1].s = userShips[0];
				grid[a][b+1].setEnabled(false);
				grid[a-1][b+1].setStatus(1);
				grid[a-1][b+1].s = userShips[0];
				grid[a-1][b+1].setEnabled(false);
			}
			else if (c < a && d < b) {
				System.out.println("d<b");
				grid[a-1][b].setStatus(1);
				grid[a-1][b].s = userShips[0];
				grid[a-1][b].setEnabled(false);
				grid[a][b-1].setStatus(1);
				grid[a][b-1].s = userShips[0];
				grid[a][b-1].setEnabled(false);
				grid[a-1][b-1].setStatus(1);
				grid[a-1][b-1].s = userShips[0];
				grid[a-1][b-1].setEnabled(false);
			}			
			
			deathStarPlaced.setBackground(null);
			deathStarPlaced.setOpaque(false);
			deathStarPlaced.setBorderPainted(false);
			deathStarPlaced.setStatus(1);
			
			if (deathStarPlusI != null) {
				deathStarPlusI.setBackground(null);
				deathStarPlusI.setOpaque(false);
				deathStarPlusI.setBorderPainted(false);
			}
			if (deathStarPlusJ != null) {
				deathStarPlusJ.setBackground(null);
				deathStarPlusJ.setOpaque(false);
				deathStarPlusJ.setBorderPainted(false);
			}
			if (deathStarNegI != null) {
				deathStarNegI.setBackground(null);
				deathStarNegI.setOpaque(false);
				deathStarNegI.setBorderPainted(false);
			}
			if (deathStarNegJ != null) {
				deathStarNegJ.setBackground(null);
				deathStarNegJ.setOpaque(false);
				deathStarNegJ.setBorderPainted(false);
			}
			if (deathStarIJ != null) {
				deathStarIJ.setBackground(null);
				deathStarIJ.setOpaque(false);
				deathStarIJ.setBorderPainted(false);
			}
			if (deathStarNegIJ != null) {
				deathStarNegIJ.setBackground(null);
				deathStarNegIJ.setOpaque(false);
				deathStarNegIJ.setBorderPainted(false);
			}
			if (deathStarINegJ != null) {
				deathStarINegJ.setBackground(null);
				deathStarINegJ.setOpaque(false);
				deathStarINegJ.setBorderPainted(false);
			}
			if (deathStarNegINegJ != null) {
				deathStarNegINegJ.setBackground(null);
				deathStarNegINegJ.setOpaque(false);
				deathStarNegINegJ.setBorderPainted(false);
			}

			deathStarPlusI = null;
			deathStarPlusJ = null;
			deathStarNegI = null;
			deathStarNegJ = null;
			deathStarIJ = null;
			deathStarNegIJ = null;
			deathStarINegJ = null;
			deathStarNegINegJ = null;
			remove(userShips[0]);
			count++;
			try {
				for (ActionListener act : deathStarPlusI.getActionListeners()) {
					deathStarPlusI.removeActionListener(act);
				}
				for (ActionListener act : deathStarPlusJ.getActionListeners()) {
					deathStarPlusJ.removeActionListener(act);
				}
				for (ActionListener act : deathStarNegI.getActionListeners()) {
					deathStarNegI.removeActionListener(act);
				}
				for (ActionListener act : deathStarNegJ.getActionListeners()) {
					deathStarNegJ.removeActionListener(act);
				}
				for (ActionListener act : deathStarIJ.getActionListeners()) {
					deathStarIJ.removeActionListener(act);
				}
				for (ActionListener act : deathStarNegIJ.getActionListeners()) {
					deathStarNegIJ.removeActionListener(act);
				}
				for (ActionListener act : deathStarINegJ.getActionListeners()) {
					deathStarINegJ.removeActionListener(act);
				}
				for (ActionListener act : deathStarNegINegJ.getActionListeners()) {
					deathStarNegINegJ.removeActionListener(act);
				}
			}
			catch (Exception e1) {
			}
			try {
				deathStarPlusI.addActionListener(new PlaceClickHandler());
				deathStarPlusJ.addActionListener(new PlaceClickHandler());
				deathStarNegI.addActionListener(new PlaceClickHandler());
				deathStarNegJ.addActionListener(new PlaceClickHandler());
				deathStarIJ.addActionListener(new PlaceClickHandler());
				deathStarNegIJ.addActionListener(new PlaceClickHandler());
				deathStarINegJ.addActionListener(new PlaceClickHandler());
				deathStarNegINegJ.addActionListener(new PlaceClickHandler());
			}
			catch (Exception e2) {
			}
			add(userShips[count]);
			shipName.setText(userShips[count].name);
			repaint();
			greenEmUp();	
		}
	}
	
	public void greenEmUp() {
		for (int i=0;i<grid.length;i++) {
			for (int j=0;j<grid[i].length;j++) {
				if (grid[i][j].status == 1) {
					grid[i][j].setBackground(Color.green);
					grid[i][j].setOpaque(true);
					grid[i][j].setBorderPainted(false);
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
			Thread blaster = new Thread(new Runnable(){
				public void run(){
					try {
			            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("Blaster.wav"));
			            Clip clip = AudioSystem.getClip();
			            clip.open(audio);
			            clip.start();
			        }
			        
			        catch(UnsupportedAudioFileException uae) {
			            System.out.println(uae);
			        }
			        catch(IOException ioe) {
			            System.out.println(ioe);
			        }
			        catch(LineUnavailableException lua) {
			            System.out.println(lua);
			        }
				}
			});
			blaster.run();
			Cell temp = (Cell)e.getSource();
			if (temp.getStatus() == 0) {
				temp.setBackground(Color.blue);
				temp.setOpaque(true);
				temp.setEnabled(false);
				temp.setStatus(2);

				userHit = 0;
			}
			else if (temp.getStatus() == 1) {
				if (!(blaster.isAlive())) {
					Thread explosion = new Thread(new Runnable(){
						public void run(){
							try {
					            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("Explosion.wav"));
					            Clip clip = AudioSystem.getClip();
					            clip.open(audio);
					            clip.start();
					        }
					        
					        catch(UnsupportedAudioFileException uae) {
					            System.out.println(uae);
					        }
					        catch(IOException ioe) {
					            System.out.println(ioe);
					        }
					        catch(LineUnavailableException lua) {
					            System.out.println(lua);
					        }
						}
					});
					explosion.start();
				}
				temp.setBackground(Color.red);
				temp.setOpaque(true);
				temp.setEnabled(false);
				temp.setStatus(2);
				temp.s.strength -= 1;
				System.out.println(temp.s.name + " " + temp.s.strength);
				if (temp.s.strength == 0) {
					sunk(temp.s.name);
				}
				userHit = 1;
			}
		}
	}
	
	public int getUserHit() {
		return userHit;
	}
	
	public void setUserHit(int i) {
		userHit = i;
	}
	
	public int getEnemyHit() {
		return enemyHit;
	}
	
	public void setEnemyHit(int i) {
		enemyHit = i;
	}
	
	public void userTurn() {
	}
	
	public void enemyTurn() {
		if (gameDifficulty.equals("Easy")) {
			easy();
		}
		else if (gameDifficulty.equals("Medium")) {
			medium();
		}
		else {
			hard();
		}
	}
	
	public void easy() {
		int a = r.nextInt(10);
		int b = r.nextInt(10);
		Cell temp = grid[a][b];
		while (grid[a][b].status == 2) {
			a = r.nextInt(10);
			b = r.nextInt(10);
			temp = grid[a][b];
		}
		System.out.println("a " + a + "b " + b);
		if (temp.getStatus() == 0) {
			temp.setBackground(Color.blue);
			temp.setOpaque(true);
			temp.setEnabled(false);
			temp.setStatus(2);
			enemyHit = 0;
		}
		else if (temp.getStatus() == 1) {
			temp.setBackground(Color.red);
			temp.setOpaque(true);
			temp.setEnabled(false);
			temp.setStatus(2);
			temp.s.strength -= 1;
			if (temp.s.strength == 0) {
				enemySunk(temp.s.name);
			}
			enemyHit = 1;
		}
	}
	
	public void medium() {
		
	}
	
	public void hard() {
		
	}
	
	public void sunk(String ship) {
		messageCenter.setText("You sunk the enemy " + ship + "!");
		shipsLeft -= 1;
		if (shipsLeft == 0) {
			gameOver = 1;
			winner("User");
		}
	}
	
	public void enemySunk(String ship) {
		messageCenter.setText("The enemy sunk your " + ship + "!");
		userShipsLeft -= 1;
		if (userShipsLeft == 0) {
			gameOver = 1;
			winner("Computer");
		}
	}
	
	public int getGameOver() {
		return gameOver;
	}
	
	public void winner(String s) {
		if (s.equals("User")) {
			if (userShips == rebelShips) {
				frame.setContentPane(rebelVictory);
			}
			else {
				frame.setContentPane(imperialVictory);
			}
		}
		else {
			if (userShips == rebelShips) {
				frame.setContentPane(enemyImperialVictory);
			}
			else {
				frame.setContentPane(enemyRebelVictory);
			}
		}
	}
}