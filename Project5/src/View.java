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
	private int count = 0;
	private int count2 = 0;
	private int count3 = 0;
	private int userHit = 1;
	private int enemyHit = 1;
	private int gameOver = 0;
	private int wasHit = 0;
	private Random r = new Random();
	private final int ARRAY_MAX_SIZE = 4;
	private Splash splash = new Splash();
	private RebelVictory rebelVictory = new RebelVictory();
	private ImperialVictory imperialVictory = new ImperialVictory();
	private EnemyRebelVictory enemyRebelVictory = new EnemyRebelVictory();
	private EnemyImperialVictory enemyImperialVictory = new EnemyImperialVictory();
	private JFrame frame = new JFrame("Drew Wilson - Project 5");
	private Image background;
	private JLabel shipName = new JLabel ("Ship name");
	private JTextArea messageCenter = new JTextArea("");
	private JButton rebel = new JButton();
	private JButton galactic = new JButton();
	private String[] difficulty = {"Easy", "Medium", "Hard"};
	private JComboBox selectDiff = new JComboBox(difficulty);
	private Ship[] rebelShips = new Ship[5];
	private Ship[] galacticShips = new Ship[5];
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
	private Cell[][] grid = new Cell[10][10];
	private Cell[][] enemyGrid = new Cell[10][10];
	private Ship[] userShips;
	private int shipsLeft = 5;
	private int userShipsLeft = 5;
	private int state = 0;
	private Cell cellHit;
	private Cell placed;
	private Cell deathStarPlaced;
	private boolean isDeathStarPlaced = false;
	private Cell deathStarPlusI = null;
	private Cell deathStarPlusJ = null;
	private Cell deathStarNegI = null;
	private Cell deathStarNegJ = null;
	private Cell deathStarIJ = null;
	private Cell deathStarNegIJ = null;
	private Cell deathStarINegJ = null;
	private Cell deathStarNegINegJ = null;
	private Cell plusI = null;
	private Cell plusJ = null;
	private Cell negI = null;
	private Cell negJ = null;
	private Ship galacticLogo;
	private Ship rebelLogo;
	private String gameDifficulty;
	private Thread splashSound;
	private AudioInputStream audio;
	private Clip clip;

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
            	enemyGrid[i][j].setEnabled(false);
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
		messageCenter.setSize(300,160);
		messageCenter.setLocation(155,530);
		messageCenter.setFont(new Font("Times", Font.BOLD, 38));
		messageCenter.setEditable(false);
		messageCenter.setLineWrap(true);
		messageCenter.setWrapStyleWord(true);
		add(messageCenter);
		galacticShips[0] = new Ship("Death Star", 4, deathStarBig);
		galacticShips[0].setBorderPainted(false);
		galacticShips[0].setSize(200,200);
		galacticShips[0].setLocation(800,125);
		galacticShips[1] = new Ship("Star Destroyer", 4, starDestroyerBig);
		galacticShips[1].setBorderPainted(false);
		galacticShips[1].setSize(310,185);
		galacticShips[1].setLocation(725,125);
		galacticShips[2] = new Ship("Sith Infiltrator", 4, sithInfiltratorBig);
		galacticShips[2].setBorderPainted(false);
		galacticShips[2].setSize(285,181);
		galacticShips[2].setLocation(775,125);
		galacticShips[3] = new Ship("Tie Fighter", 2, tieFighterBig);
		galacticShips[3].setBorderPainted(false);
		galacticShips[3].setSize(211,180);
		galacticShips[3].setLocation(800,125);
		galacticShips[4] = new Ship("Tie Bomber", 2, tieBomberBig);
		galacticShips[4].setBorderPainted(false);
		galacticShips[4].setSize(320,200);
		galacticShips[4].setLocation(750,125);
		rebelShips[0] = new Ship("Star Cruiser", 5, starCruiserBig);
		rebelShips[0].setBorderPainted(false);
		rebelShips[0].setSize(351,139);
		rebelShips[0].setLocation(725,150);
		rebelShips[1] = new Ship("Attack Cruiser", 4, attackCruiserBig);
		rebelShips[1].setBorderPainted(false);
		rebelShips[1].setSize(290,205);
		rebelShips[1].setLocation(775,120);
		rebelShips[2] = new Ship("Star Fighter", 3, starFighterBig);
		rebelShips[2].setBorderPainted(false);
		rebelShips[2].setSize(351,200);
		rebelShips[2].setLocation(720,125);
		rebelShips[3] = new Ship("X-Wing Fighter", 2, xWingBig);
		rebelShips[3].setBorderPainted(false);
		rebelShips[3].setSize(330,215);
		rebelShips[3].setLocation(735,115);
		rebelShips[4] = new Ship("Millennium Falcon", 2, millFalconBig);
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
	
	/**
	 * Paints the background
	 */
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
	
	/**
	 * sets the enemy grid randomly
	 */
	public void setEnemyGrid() {
		int i = r.nextInt(10);
		int j = r.nextInt(10);
		int hzOrVt = r.nextInt(2);
		int count = 1;
		int count2 = 0;
		if (userShips == rebelShips) {
			while (i+galacticShips[0].getStrength() > 9) {
				i = r.nextInt(10);
			}
			while (j+galacticShips[0].getStrength() > 9) {
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
						while (i+galacticShips[count].getStrength() > 9) {
							i = r.nextInt(10);
						}
					}
					else {
						while (j+galacticShips[count].getStrength() > 9) {
							j = r.nextInt(10);
						}
					}
					if (isAvailable(i,j,hzOrVt,galacticShips[count].getStrength())) {
						available = true;
					}
				}
				placeShip(i,j,hzOrVt, galacticShips[count], galacticShips[count].getStrength());
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
						while (i+rebelShips[count2].getStrength() > 9) {
							i = r.nextInt(10);
						}
					}
					else {
						while (j+rebelShips[count2].getStrength() > 9) {
							j = r.nextInt(10);
						}
					}
					if (isAvailable(i,j,hzOrVt,rebelShips[count2].getStrength())) {
						available = true;
					}
				}
				placeShip(i,j,hzOrVt, rebelShips[count2], rebelShips[count2].getStrength());
				count2++;
			}
		}
	}
	
	/**
	 * helper method for setEnemyGrid to set the death star Ship
	 * @param i i coordinate
	 * @param j j coordinate
	 */
	public void deathStar(int i, int j) {
		enemyGrid[i][j].setStatus(1);
		enemyGrid[i][j].setShip(galacticShips[0]);
		enemyGrid[i+1][j].setStatus(1);
		enemyGrid[i+1][j].setShip(galacticShips[0]);
		enemyGrid[i][j+1].setStatus(1);
		enemyGrid[i][j+1].setShip(galacticShips[0]);
		enemyGrid[i+1][j+1].setStatus(1);
		enemyGrid[i+1][j+1].setShip(galacticShips[0]);
	}
	
	/**
	 * tests if Cell(s) are available
	 * @param i i coordinate
	 * @param j j coordinate
	 * @param hzOrVt whether or not the Ship is horizontal or vertical
	 * @param strength the Ships strength
	 * @return boolean of available or not
	 */
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
	
	/**
	 * helper method to test a single Cell
	 * @param c the Cell being test
	 * @return int of whether or not occupied
	 */
	public int testCell(Cell c) {
		int occupied = 0;
		if (c.getStatus() == 1) {
			occupied = 1;
		}
		return occupied;
	}
	
	/**
	 * places Ship
	 * @param i i coordinate
	 * @param j j coordinate
	 * @param hzOrVt whether or not the Ship is horizontal or vertical
	 * @param s the Ship
	 * @param strength the Ship's strength
	 */
	public void placeShip(int i, int j, int hzOrVt, Ship s, int strength) {
		if (hzOrVt == 0) {
			for (int x=0;x<strength;x++) {
				enemyGrid[i+x][j].setStatus(1);
				enemyGrid[i+x][j].setShip(s);
			}
		}
		else {
			for (int x=0;x<strength;x++) {
				enemyGrid[i][j+x].setStatus(1);
				enemyGrid[i][j+x].setShip(s);
			}
		}
	}
	
	/**
	 * SplashClickHandler provides the action listener for the splash screen
	 */
	private class SplashClickHandler implements ActionListener {

		/**
		 * This method handles the tasks of determining the user's side
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
			shipName.setText(userShips[count].getName());
		}
	}
	
	/**
	 * changes the screen
	 */
	public void changeScreen() {
		frame.setContentPane(this);
		splashSound.interrupt();
	}
	
	/**
	 * PlaceClickHandler provides the action listener for placing the ship
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
				int strength = userShips[count3].getStrength();
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
	
	/**
	 * tests the positive i side for the death star Ship
	 * @param strength the Ship's strength
	 * @param x the i coordinate
	 * @param y the j coordinate
	 * @return a boolean of whether or not it is available
	 */
	public boolean isDeathStarI(int strength, int x, int y) {
		int occupied = 0;
		boolean isOcc = false;
		if(x+strength>9 || grid[x+strength][y].getStatus() == 1){
			return false;
		}
		occupied += testCell(grid[x+strength][y]);
		
		if (occupied == 0) {
			isOcc = true;
		}
		return isOcc;
	}
	
	/**
	 * tests the negative i side for the death star Ship
	 * @param strength the Ship's strength
	 * @param x the i coordinate
	 * @param y the j coordinate
	 * @return a boolean of whether or not it is available
	 */
	public boolean isDeathStarNegI(int strength, int x, int y) {
		int occupied = 0;
		boolean isOcc = false;
		if(x-strength<0 || grid[x-strength][y].getStatus() == 1){
			return false;
		}
		occupied += testCell(grid[x-strength][y]);
		
		if (occupied == 0) {
			isOcc = true;
		}
		return isOcc;
	}
	
	/**
	 * tests the positive j side for the death star Ship
	 * @param strength the Ship's strength
	 * @param x the i coordinate
	 * @param y the j coordinate
	 * @return a boolean of whether or not it is available
	 */
	public boolean isDeathStarJ(int strength, int x, int y) {
		int occupied = 0;
		boolean isOcc = false;
		if(y+strength>9 || grid[x][y+strength].getStatus() == 1){
			return false;
		}
		occupied += testCell(grid[x][y+strength]);
		
		if (occupied == 0) {
			isOcc = true;
		}
		return isOcc;
	}
	
	/**
	 * tests the negative j side for the death star Ship
	 * @param strength the Ship's strength
	 * @param x the i coordinate
	 * @param y the j coordinate
	 * @return a boolean of whether or not it is available
	 */
	public boolean isDeathStarNegJ(int strength, int x, int y) {
		int occupied = 0;
		boolean isOcc = false;
		if(y-strength<0 || grid[x][y-strength].getStatus() == 1){
			return false;
		}
		occupied += testCell(grid[x][y-strength]);
		
		if (occupied == 0) {
			isOcc = true;
		}
		return isOcc;
	}
	
	/**
	 * tests the positive i, positive j side for the death star Ship
	 * @param strength the Ship's strength
	 * @param x the i coordinate
	 * @param y the j coordinate
	 * @return a boolean of whether or not it is available
	 */
	public boolean isDeathStarIJ(int strength, int x, int y) {
		int occupied = 0;
		boolean isOcc = false;
		if(x+strength>9 || y+strength>9 || grid[x+strength][y+strength].getStatus() == 1){
			return false;
		}
		occupied += testCell(grid[x+strength][y+strength]);
		
		if (occupied == 0) {
			isOcc = true;
		}
		return isOcc;
	}
	
	/**
	 * tests the negative i, positive j side for the death star Ship
	 * @param strength the Ship's strength
	 * @param x the i coordinate
	 * @param y the j coordinate
	 * @return a boolean of whether or not it is available
	 */
	public boolean isDeathStarNegIJ(int strength, int x, int y) {
		int occupied = 0;
		boolean isOcc = false;
		if(x-strength<0 || y+strength>9 || grid[x-strength][y+strength].getStatus() == 1){
			return false;
		}
		occupied += testCell(grid[x-strength][y+strength]);
		
		if (occupied == 0) {
			isOcc = true;
		}
		return isOcc;
	}
	
	/**
	 * tests the positive i, negative j side for the death star Ship
	 * @param strength the Ship's strength
	 * @param x the i coordinate
	 * @param y the j coordinate
	 * @return a boolean of whether or not it is available
	 */
	public boolean isDeathStarINegJ(int strength, int x, int y) {
		int occupied = 0;
		boolean isOcc = false;
		if(x+strength>9 || y-strength<0 || grid[x+strength][y-strength].getStatus() == 1){
			return false;
		}
		occupied += testCell(grid[x+strength][y-strength]);

		
		if (occupied == 0) {
			isOcc = true;
		}
		return isOcc;
	}
	
	/**
	 * tests the negative i, negative j side for the death star Ship
	 * @param strength the Ship's strength
	 * @param x the i coordinate
	 * @param y the j coordinate
	 * @return a boolean of whether or not it is available
	 */
	public boolean isDeathStarNegINegJ(int strength, int x, int y) {
		int occupied = 0;
		boolean isOcc = false;
		if(x-strength<0 || y-strength<0 || grid[x-strength][y-strength].getStatus() == 1){
			return false;
		}
		occupied += testCell(grid[x-1][y-1]);
		
		if (occupied == 0) {
			isOcc = true;
		}
		return isOcc;
	}
	
	/**
	 * test positive i availability
	 * @param strength the Ship's strength
	 * @param x i coordinate
	 * @param y j coordinate
	 * @return whether or not available
	 */
	public boolean isAvailableI(int strength, int x, int y) {
		int occupied = 0;
		boolean isOcc = false;
		if(x+strength>9 || grid[x+strength][y].getStatus() == 1){
			return false;
		}
		for (int i=0; i<strength;i++) {
			occupied += testCell(grid[x+i][y]);
		}
		
		if (occupied == 0) {
			isOcc = true;
		}

		return isOcc;
	}
	
	/**
	 * test negative i availability
	 * @param strength the Ship's strength
	 * @param x i coordinate
	 * @param y j coordinate
	 * @return whether or not available
	 */
	public boolean isAvailableNegI(int strength, int x, int y) {
		int occupied = 0;
		boolean isOcc = false;
		if(x-strength<0 || grid[x-strength][y].getStatus() == 1){
			return false;
		}
		for (int i=0; i<strength;i++) {
			occupied += testCell(grid[x-i][y]);
		}
		
		if (occupied == 0) {
			isOcc = true;
		}

		return isOcc;
	}
	
	/**
	 * test positive j availability
	 * @param strength the Ship's strength
	 * @param x i coordinate
	 * @param y j coordinate
	 * @return whether or not available
	 */
	public boolean isAvailableJ(int strength, int x, int y) {
		int occupied = 0;
		boolean isOcc = false;
		if(y+strength>9 || grid[x][y+strength].getStatus() == 1){
			return false;
		}
		for (int i=0; i<strength;i++) {
			occupied += testCell(grid[x][y+i]);
		}
		
		if (occupied == 0) {
			isOcc = true;
		}
		return isOcc;
	}
	
	/**
	 * test negative j availability
	 * @param strength the Ship's strength
	 * @param x i coordinate
	 * @param y j coordinate
	 * @return whether or not available
	 */
	public boolean isAvailableNegJ(int strength, int x, int y) {
		int occupied = 0;
		boolean isOcc = false;
		if(y-strength<0 || grid[x][y-strength].getStatus() == 1){
			return false;
		}
		for (int i=0; i<strength;i++) {
			occupied += testCell(grid[x][y-i]);
		}
		
		if (occupied == 0) {
			isOcc = true;
		}
		return isOcc;
	}
	
	/**
	 * PlaceClickHandler2 provides the action listener for placing the ship
	 */
	private class PlaceClickHandler2 implements ActionListener {

		/**
		 * This method handles the tasks of setting the ship
		 *
		 * @param e the action event handled by this method
		 */
		
		public void actionPerformed(ActionEvent e) {
			Cell temp = (Cell)e.getSource();
			int strength = userShips[count].getStrength();

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
						
			if (c > a) {
				for (int g=0;g<strength;g++) {
					grid[a+g][b].setStatus(1);
					grid[a+g][b].setShip(userShips[count]);
					grid[a+g][b].setEnabled(false);
				}
			}
			else if (c < a) {
				for (int g=0;g<strength;g++) {
					grid[c+g][b].setStatus(1);
					grid[c+g][b].setShip(userShips[count]);
					grid[c+g][b].setEnabled(false);
				}
			}
			else if (d > b) {
				for (int g=0;g<strength;g++) {
					grid[a][b+g].setStatus(1);
					grid[a][b+g].setShip(userShips[count]);
					grid[a][b+g].setEnabled(false);
				}
			}
			else {
				for (int g=0;g<strength;g++) {
					grid[a][d+g].setStatus(1);
					grid[a][d+g].setShip(userShips[count]);
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
				shipName.setText(userShips[count].getName());
				repaint();
			}	
			else {
				remove(userShips[count-1]);
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
				for (int m=0;m<enemyGrid.length;m++) {
					for (int n=0;n<enemyGrid[m].length;n++) {
						enemyGrid[m][n].setEnabled(true);
					}
				}
			}
			greenEmUp();
		}
	}
	
	/**
	 * PlaceClickHandler3 provides the action listener for placing the ship
	 */
	private class PlaceClickHandler3 implements ActionListener {

		/**
		 * This method handles the tasks of setting the ship
		 *
		 * @param e the action event handled by this method
		 */
		
		public void actionPerformed(ActionEvent e) {
			Cell temp = (Cell)e.getSource();
			int strength = userShips[0].getStrength();

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
						
			if (c > a && d > b) {
				grid[a+1][b].setStatus(1);
				grid[a+1][b].setShip(userShips[0]);
				grid[a+1][b].setEnabled(false);
				grid[a][b+1].setStatus(1);
				grid[a][b+1].setShip(userShips[0]);
				grid[a][b+1].setEnabled(false);
				grid[a+1][b+1].setStatus(1);
				grid[a+1][b+1].setShip(userShips[0]);
				grid[a+1][b+1].setEnabled(false);
			}
			else if (c > a && d < b) {
				grid[a+1][b].setStatus(1);
				grid[a+1][b].setShip(userShips[0]);
				grid[a+1][b].setEnabled(false);
				grid[a][b-1].setStatus(1);
				grid[a][b-1].setShip(userShips[0]);
				grid[a][b-1].setEnabled(false);
				grid[a+1][b-1].setStatus(1);
				grid[a+1][b-1].setShip(userShips[0]);
				grid[a+1][b-1].setEnabled(false);
			}
			else if (c < a && d > b) {
				grid[a-1][b].setStatus(1);
				grid[a-1][b].setShip(userShips[0]);
				grid[a-1][b].setEnabled(false);
				grid[a][b+1].setStatus(1);
				grid[a][b+1].setShip(userShips[0]);
				grid[a][b+1].setEnabled(false);
				grid[a-1][b+1].setStatus(1);
				grid[a-1][b+1].setShip(userShips[0]);
				grid[a-1][b+1].setEnabled(false);
			}
			else if (c < a && d < b) {
				grid[a-1][b].setStatus(1);
				grid[a-1][b].setShip(userShips[0]);
				grid[a-1][b].setEnabled(false);
				grid[a][b-1].setStatus(1);
				grid[a][b-1].setShip(userShips[0]);
				grid[a][b-1].setEnabled(false);
				grid[a-1][b-1].setStatus(1);
				grid[a-1][b-1].setShip(userShips[0]);
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
			shipName.setText(userShips[count].getName());
			repaint();
			greenEmUp();	
		}
	}
	
	/**
	 * changes graphical aspects of the users placed ships
	 */
	public void greenEmUp() {
		for (int i=0;i<grid.length;i++) {
			for (int j=0;j<grid[i].length;j++) {
				if (grid[i][j].getStatus() == 1) {
					grid[i][j].setBackground(Color.green);
					grid[i][j].setOpaque(true);
					grid[i][j].setBorderPainted(false);
				}
			}
		}
	}
	
	/**
	 * FireClickHandler provides the action listener for firing on ships
	 */
	private class FireClickHandler implements ActionListener {

		/**
		 * This method handles the tasks of firing on ships
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
				temp.getShip().setStrength(1);
				if (temp.getShip().getStrength() == 0) {
					sunk(temp.getShip().getName());
				}
				userHit = 1;
			}
		}
	}
	
	/**
	 * gets userHit
	 * @return int userHit
	 */
	public int getUserHit() {
		return userHit;
	}
	
	/**
	 * sets userHit
	 * @param i int to be set as userHit
	 */
	public void setUserHit(int i) {
		userHit = i;
	}
	
	/**
	 * gets enemyHit
	 * @return int enemyHit
	 */
	public int getEnemyHit() {
		return enemyHit;
	}
	
	/**
	 * sets enemyHit
	 * @param i int to be set as enemyHit
	 */
	public void setEnemyHit(int i) {
		enemyHit = i;
	}
	
	/**
	 * method for the user's turn
	 */
	public void userTurn() {
	}
	
	/**
	 * method for enemy's turn
	 */
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
	
	/**
	 * easy difficulty
	 */
	public void easy() {
		int a = r.nextInt(10);
		int b = r.nextInt(10);
		Cell temp = grid[a][b];
		while (grid[a][b].getStatus() == 2) {
			a = r.nextInt(10);
			b = r.nextInt(10);
			temp = grid[a][b];
		}
		if (temp.getStatus() == 0) {
			temp.setBackground(Color.blue);
			temp.setOpaque(true);
			temp.setEnabled(false);
			temp.setStatus(2);
			enemyHit = 0;
			wasHit = 0;
		}
		else if (temp.getStatus() == 1) {
			temp.setBackground(Color.red);
			temp.setOpaque(true);
			temp.setEnabled(false);
			temp.setStatus(2);
			temp.getShip().setStrength(1);
			if (temp.getShip().getStrength() == 0) {
				enemySunk(temp.getShip().getName());
			}
			enemyHit = 1;
			wasHit = 1;
		}
	}
	
	/**
	 * medium difficulty
	 */
	public void medium() {
		if (wasHit == 1) {
			int random = r.nextInt(2);
			int random2 = r.nextInt(6);
			int a = 0 + (int)(Math.random() * ((4 - 0)));
			int b = 0 + (int)(Math.random() * ((4 - 0)));
			Cell newCell = null;
			for (int x=0;x<grid.length;x++) {
				for (int y=0;y<grid[x].length;y++) {
					if (grid[x][y] == cellHit) {
						if (random == 0) {
							while (newCell == null || newCell.getStatus() == 2) {
								random2 = r.nextInt(6);
								a = 0 + (int)(Math.random() * ((4 - 0)));
								b = 0 + (int)(Math.random() * ((4 - 0)));
								if (random2 == 0) {
									while (x+a > 9) {
										a = 0 + (int)(Math.random() * ((4 - 0)));
									}
									newCell = grid[x+a][y];
								}
								else if (random2 == 1){
									while (x-a < 0) {
										a = 0 + (int)(Math.random() * ((4 - 0)));
									}
									newCell = grid[x-a][y];
								}
								else if (random2 == 2){
									while (x+a > 9) {
										a = 0 + (int)(Math.random() * ((4 - 0)));
									}
									while (y+b > 9) {
										b = 0 + (int)(Math.random() * ((4 - 0)));
									}
									newCell = grid[x+a][y+b];
								}
								else if (random == 3) {
									while (x-a < 0) {
										a = 0 + (int)(Math.random() * ((4 - 0)));
									}
									while (y+b > 9) {
										b = 0 + (int)(Math.random() * ((4 - 0)));
									}
									newCell = grid[x-a][y+b];
								}
								else if (random == 4) {
									while (x+a < 0) {
										a = 0 + (int)(Math.random() * ((4 - 0)));
									}
									while (y-b < 0) {
										b = 0 + (int)(Math.random() * ((4 - 0)));
									}
									newCell = grid[x+a][y-b];
								}
								else {
									while (x-a < 0) {
										a = 0 + (int)(Math.random() * ((4 - 0)));
									}
									while (y-b < 0) {
										b = 0 + (int)(Math.random() * ((4 - 0)));
									}
									newCell = grid[x-a][y-b];
								}
							}
						}
						else {
							while (newCell == null || newCell.getStatus() == 2) {
								random2 = r.nextInt(6);
								a = 0 + (int)(Math.random() * ((4 - 0)));
								b = 0 + (int)(Math.random() * ((4 - 0)));
								if (random2 == 0) {
									while (y+a > 9) {
										a = 0 + (int)(Math.random() * ((4 - 0)));
									}
									newCell = grid[x][y+a];
								}
								else if (random2 == 1){
									while (y-a < 0) {
										a = 0 + (int)(Math.random() * ((4 - 0)));
									}
									newCell = grid[x][y-a];
								}
								else if (random2 == 2){
									while (y+a > 9) {
										a = 0 + (int)(Math.random() * ((4 - 0)));
									}
									while (x+b > 9) {
										b = 0 + (int)(Math.random() * ((4 - 0)));
									}
									newCell = grid[x+b][y+a];
								}
								else if (random == 3) {
									while (y-a < 0) {
										a = 0 + (int)(Math.random() * ((4 - 0)));
									}
									while (x+b > 9) {
										b = 0 + (int)(Math.random() * ((4 - 0)));
									}
									newCell = grid[x+b][y-a];
								}
								else if (random == 4) {
									while (y+a < 0) {
										a = 0 + (int)(Math.random() * ((4 - 0)));
									}
									while (x-b < 0) {
										b = 0 + (int)(Math.random() * ((4 - 0)));
									}
									newCell = grid[x-b][y+a];
								}
								else {
									while (y-a < 0) {
										a = 0 + (int)(Math.random() * ((4 - 0)));
									}
									while (x-b < 0) {
										b = 0 + (int)(Math.random() * ((4 - 0)));
									}
									newCell = grid[x-b][y-a];
								}
							}
						}
					}
				}
			}
			if (newCell.getStatus() == 0) {
				newCell.setBackground(Color.blue);
				newCell.setOpaque(true);
				newCell.setEnabled(false);
				newCell.setStatus(2);
				cellHit = null;
				enemyHit = 0;
				wasHit = 0;
			}
			else if (newCell.getStatus() == 1) {
				newCell.setBackground(Color.red);
				newCell.setOpaque(true);
				newCell.setEnabled(false);
				newCell.setStatus(2);
				newCell.getShip().setStrength(1);
				if (newCell.getShip().getStrength() == 0) {
					enemySunk(newCell.getShip().getName());
				}
				cellHit = newCell;
				enemyHit = 1;
				wasHit = 1;
			}
		}
		else {
			int a = r.nextInt(10);
			int b = r.nextInt(10);
			Cell temp = grid[a][b];
			while (grid[a][b].getStatus() == 2) {
				a = r.nextInt(10);
				b = r.nextInt(10);
				temp = grid[a][b];
			}
			if (temp.getStatus() == 0) {
				temp.setBackground(Color.blue);
				temp.setOpaque(true);
				temp.setEnabled(false);
				temp.setStatus(2);
				cellHit = null;
				enemyHit = 0;
				wasHit = 0;
			}
			else if (temp.getStatus() == 1) {
				temp.setBackground(Color.red);
				temp.setOpaque(true);
				temp.setEnabled(false);
				temp.setStatus(2);
				temp.getShip().setStrength(1);
				if (temp.getShip().getStrength() == 0) {
					enemySunk(temp.getShip().getName());
				}
				cellHit = temp;
				enemyHit = 1;
				wasHit = 1;
			}
		}
	}
	
	/**
	 * hard difficulty
	 */
	public void hard() {
		if (wasHit == 1) {
			int random = r.nextInt(2);
			int random2 = r.nextInt(6);
			int a = 0 + (int)(Math.random() * ((2 - 0)));
			int b = 0 + (int)(Math.random() * ((2 - 0)));
			Cell newCell = null;
			for (int x=0;x<grid.length;x++) {
				for (int y=0;y<grid[x].length;y++) {
					if (grid[x][y] == cellHit) {
						if (random == 0) {
							while (newCell == null || newCell.getStatus() == 2) {
								random2 = r.nextInt(6);
								a = 0 + (int)(Math.random() * ((2 - 0)));
								b = 0 + (int)(Math.random() * ((2 - 0)));
								if (random2 == 0) {
									while (x+a > 9) {
										a = 0 + (int)(Math.random() * ((2 - 0)));
									}
									newCell = grid[x+a][y];
								}
								else if (random2 == 1){
									while (x-a < 0) {
										a = 0 + (int)(Math.random() * ((2 - 0)));
									}
									newCell = grid[x-a][y];
								}
								else if (random2 == 2){
									while (x+a > 9) {
										a = 0 + (int)(Math.random() * ((2 - 0)));
									}
									while (y+b > 9) {
										b = 0 + (int)(Math.random() * ((2 - 0)));
									}
									newCell = grid[x+a][y+b];
								}
								else if (random == 3) {
									while (x-a < 0) {
										a = 0 + (int)(Math.random() * ((2 - 0)));
									}
									while (y+b > 9) {
										b = 0 + (int)(Math.random() * ((2 - 0)));
									}
									newCell = grid[x-a][y+b];
								}
								else if (random == 4) {
									while (x+a < 0) {
										a = 0 + (int)(Math.random() * ((2 - 0)));
									}
									while (y-b < 0) {
										b = 0 + (int)(Math.random() * ((2 - 0)));
									}
									newCell = grid[x+a][y-b];
								}
								else {
									while (x-a < 0) {
										a = 0 + (int)(Math.random() * ((2 - 0)));
									}
									while (y-b < 0) {
										b = 0 + (int)(Math.random() * ((2 - 0)));
									}
									newCell = grid[x-a][y-b];
								}
							}
						}
						else {
							while (newCell == null || newCell.getStatus() == 2) {
								random2 = r.nextInt(6);
								a = 0 + (int)(Math.random() * ((2 - 0)));
								b = 0 + (int)(Math.random() * ((2 - 0)));
								if (random2 == 0) {
									while (y+a > 9) {
										a = 0 + (int)(Math.random() * ((2 - 0)));
									}
									newCell = grid[x][y+a];
								}
								else if (random2 == 1){
									while (y-a < 0) {
										a = 0 + (int)(Math.random() * ((2 - 0)));
									}
									newCell = grid[x][y-a];
								}
								else if (random2 == 2){
									while (y+a > 9) {
										a = 0 + (int)(Math.random() * ((2 - 0)));
									}
									while (x+b > 9) {
										b = 0 + (int)(Math.random() * ((2 - 0)));
									}
									newCell = grid[x+b][y+a];
								}
								else if (random == 3) {
									while (y-a < 0) {
										a = 0 + (int)(Math.random() * ((2 - 0)));
									}
									while (x+b > 9) {
										b = 0 + (int)(Math.random() * ((2 - 0)));
									}
									newCell = grid[x+b][y-a];
								}
								else if (random == 4) {
									while (y+a < 0) {
										a = 0 + (int)(Math.random() * ((2 - 0)));
									}
									while (x-b < 0) {
										b = 0 + (int)(Math.random() * ((2 - 0)));
									}
									newCell = grid[x-b][y+a];
								}
								else {
									while (y-a < 0) {
										a = 0 + (int)(Math.random() * ((2 - 0)));
									}
									while (x-b < 0) {
										b = 0 + (int)(Math.random() * ((2 - 0)));
									}
									newCell = grid[x-b][y-a];
								}
							}
						}
					}
				}
			}
			if (newCell.getStatus() == 0) {
				newCell.setBackground(Color.blue);
				newCell.setOpaque(true);
				newCell.setEnabled(false);
				newCell.setStatus(2);
				cellHit = null;
				enemyHit = 0;
				wasHit = 0;
			}
			else if (newCell.getStatus() == 1) {
				newCell.setBackground(Color.red);
				newCell.setOpaque(true);
				newCell.setEnabled(false);
				newCell.setStatus(2);
				newCell.getShip().setStrength(1);
				if (newCell.getShip().getStrength() == 0) {
					enemySunk(newCell.getShip().getName());
				}
				cellHit = newCell;
				enemyHit = 1;
				wasHit = 1;
			}
		}
		else {
			int a = r.nextInt(10);
			int b = r.nextInt(10);
			Cell temp = grid[a][b];
			while (grid[a][b].getStatus() == 2) {
				a = r.nextInt(10);
				b = r.nextInt(10);
				temp = grid[a][b];
			}
			if (temp.getStatus() == 0) {
				temp.setBackground(Color.blue);
				temp.setOpaque(true);
				temp.setEnabled(false);
				temp.setStatus(2);
				cellHit = null;
				enemyHit = 0;
				wasHit = 0;
			}
			else if (temp.getStatus() == 1) {
				temp.setBackground(Color.red);
				temp.setOpaque(true);
				temp.setEnabled(false);
				temp.setStatus(2);
				temp.getShip().setStrength(1);
				if (temp.getShip().getStrength() == 0) {
					enemySunk(temp.getShip().getName());
				}
				cellHit = temp;
				enemyHit = 1;
				wasHit = 1;
			}
		}
	}
	
	/**
	 * method for when user sinks a Ship
	 * @param ship the sunk Ship
	 */
	public void sunk(String ship) {
		messageCenter.setText("You sunk the enemy " + ship + "!");
		shipsLeft -= 1;
		if (shipsLeft == 0) {
			gameOver = 1;
			winner("User");
		}
	}
	
	/**
	 * method for when AI sinks a Ship
	 * @param ship the sunk Ship
	 */
	public void enemySunk(String ship) {
		messageCenter.setText("The enemy sunk your " + ship + "!");
		userShipsLeft -= 1;
		if (userShipsLeft == 0) {
			gameOver = 1;
			winner("Computer");
		}
	}
	
	/**
	 * determines is the game is over
	 * @return int determining if game is over
	 */
	public int getGameOver() {
		return gameOver;
	}
	
	/**
	 * celebrates or chastises user!
	 * @param s the winner
	 */
	public void winner(String s) {
		if (s.equals("User")) {
			if (userShips == rebelShips) {
				frame.setContentPane(rebelVictory);
				Thread rebelVic = new Thread(new Runnable(){
					public void run(){
						try {
				            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("CantinaSong.wav"));
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
				rebelVic.start();
			}
			else {
				frame.setContentPane(imperialVictory);
				Thread imperialVic = new Thread(new Runnable(){
					public void run(){
						try {
				            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("ImperialMarch.wav"));
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
				imperialVic.start();
			}
		}
		else if (s.equals("Computer")) {
			if (userShips == rebelShips) {
				frame.setContentPane(enemyImperialVictory);
				Thread rebelLoss = new Thread(new Runnable(){
					public void run(){
						try {
				            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("ImperialMarch.wav"));
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
				rebelLoss.start();			}
			else {
				frame.setContentPane(enemyRebelVictory);
				Thread imperialLoss = new Thread(new Runnable(){
					public void run(){
						try {
				            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("CantinaSong.wav"));
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
				imperialLoss.start();
			}
		}
	}
}