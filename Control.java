package flappyBird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Random;

/*
 * write String on Screen, make columns according to the rule, spacebar event
 * */
public class Control extends Thread {

	private final int WIDTH = Setting.WINDOWS_WIDTH;
	private final int HEIGHT = Setting.WINDOWS_HEIGHT;
	private final int GROUND_HEIGHT = Setting.GROUND_HEIGHT;

	// using GameObject's constructor
	private Ground objGround = new Ground(0, HEIGHT - GROUND_HEIGHT, WIDTH, GROUND_HEIGHT, "ground1.png");
	private Ground objWhite = new Ground(0, 0, WIDTH, 100, "white.png");

	private Image ground = objGround.getIcon().getImage();
	private Image white = objWhite.getIcon().getImage();
	private String stageName = "Stage #";
	private Random random = new Random();
	public static int score = 0;
	public static int count = 0;
	public static int bomb = 2;
	static ArrayList<Column> columns = new ArrayList<Column>(); // for saving many columnns

	public Control(String stageName) {
		this.setStageName(stageName);
	}

	public void generateOnScreen(Graphics2D g) {

		// before start message
		g.setColor(Color.black);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		if (GamePage.isStarted == false) {
			g.setFont(new Font("Verdana", Font.PLAIN, 60));
			g.drawString("Click to Start!", 320, 270);
		}
		g.drawImage(ground, objGround.getX(), objGround.getY(), null);
		g.drawImage(white, objWhite.getX(), objWhite.getY(), null);
		g.setFont(new Font("Verdana", Font.PLAIN, 50));
		// score
		g.drawString("" + score, 80, 90);

		// stage name or gameover
		if (GamePage.isGameOver == true) {
			g.setFont(new Font("Verdana", Font.PLAIN, 60));
			g.drawString("Game Over", 320, 80);
		} else {
			g.setFont(new Font("Verdana", Font.PLAIN, 60));
			g.drawString(this.getStageName(), 400, 80);
		}
		// bomb
		g.setFont(new Font("Verdana", Font.PLAIN, 50));
		g.drawString("" + bomb, 880, 90);
		GamePage.bird.generateOnScreen(g);
		for (int i = 0; i < columns.size(); i++) {
			Column column = columns.get(i);
			if (column != null) {
				column.generateOnScreen(g);
			}
		}

	}

	public void pressSpace() {
		/* using Bomb, existed every column removed */
		if (bomb > 0 && !GamePage.isGameOver) {
			new BackgroundMusic().playMusic("clear.wav", false); // sound effect
			bomb--;
			columns.clear();
		}
	}

	@Override
	public void run() {
		makeColumns();
	}

	public void makeColumns() {
		// setting value
		int interval = Setting.interval;
		int space = Setting.space;

		int colWidth = 80;

		// Bird have to pass between the two columns to get score.
		if (count == 2) {
			count = 0;
			score += 1;
		} else if (count > 2) {
			count = 0;
		}

		while (GamePage.isGameOver == false && columns.size() <= 16) {
			// Limitations have been set to prevent too many threads.
			int colHeight = 50 + random.nextInt(225); // random value for different shape every time.

			Column bottom = new Column(WIDTH + colWidth + columns.size() * interval, HEIGHT - colHeight - GROUND_HEIGHT,
					colWidth, colHeight, "bottomCol.png");
			Column top = new Column(WIDTH + colWidth + columns.size() * interval, GROUND_HEIGHT, colWidth,
					HEIGHT - colHeight - space - (GROUND_HEIGHT << 1), "topCol.png");

			bottom.start(); // Multithreading
			top.start(); // Multithreading
			columns.add(bottom); // Manage it as a list.
			columns.add(top); // Manage it as a list.
		}
	}

	public static void removeColumn(Column col) {
		// System.out.println("remove" + columns.size());
		columns.remove(col);
	}

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

}
