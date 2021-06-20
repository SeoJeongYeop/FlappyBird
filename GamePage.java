package flappyBird;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import java.awt.event.MouseAdapter;

/*
 * graphic Double Buffering, administer start and over 
 * */
public class GamePage extends JFrame {
	private static final long serialVersionUID = 1L;

	private JFrame flappyBird = GamePage.this;
	private final int WIDTH = Setting.WINDOWS_WIDTH;
	private final int HEIGHT = Setting.WINDOWS_HEIGHT;

	public BackgroundMusic bgm = new BackgroundMusic();
	private Image screenImage;
	private Graphics screenGraphic;

	public static Bird bird = new Bird(Setting.WINDOWS_WIDTH / 6, Setting.WINDOWS_HEIGHT / 2 - 10, 40, 30,
			"inGameBird.png");

	public static boolean isStarted = false;
	public static boolean isGameOver = false;

	public static Control control;

	public static String stageName;

	public static String getStageName() {
		return stageName;
	}

	public static void setStageName(String stageName) {
		GamePage.stageName = stageName;
	}

	/**
	 * Create the frame.
	 */
	public GamePage(String name) {
		setStageName(name);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (isGameOver == true && isStarted == true) {
					bgm.stopMusic(); // stop bgm
					// open JDialog and set this GamePage to parentFarme
					new ResultPage(flappyBird, getStageName(), Control.score);
					dispose();
				} else if (isStarted) {
					control.makeColumns();
					bird.setyMotion(bird.getyMotion() - 5);
				} else {
					// Play BGM
					bgm.stopMusic();
					bgm.playMusic("ingame.wav", true);
					// initialize game variables
					isGameOver = false;
					isStarted = true;
					bird = new Bird(Setting.WINDOWS_WIDTH / 6, Setting.WINDOWS_HEIGHT / 2 - 10, 40, 30,
							"inGameBird.png");
					Control.columns.clear();
					bird.setyMotion(0);
					Control.bomb = 2;
					Control.score = 0;
					// Threads start: Multithreading.
					control.start();
					bird.start();
				}

			}
		});
		control = new Control(name);

		setSize(WIDTH, HEIGHT);
		setTitle("Flappy Bird");
		setResizable(false);
		setLocationRelativeTo(null); // open frame on middle of windows
		addKeyListener(new KeyListener());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);

	}

	/* Double Buffering: Create an image then output 'completed' image */
	public void paint(Graphics g) {
		screenImage = createImage(WIDTH, HEIGHT); // make buffer image
		screenGraphic = screenImage.getGraphics(); // get Graphics of buffer image
		generateOnScreen((Graphics2D) screenGraphic); // draw image
		g.drawImage(screenImage, 0, 0, null); // show completed image on screen

	}

	public void generateOnScreen(Graphics2D g) {
		g.setColor(new Color(135, 206, 250));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		control.generateOnScreen(g); // update Graphic

		try {
			Thread.sleep(5);
		} catch (Exception error) {
			error.printStackTrace();
		}
		this.repaint(); // repaint() -> update() (omit) -> paint()
	}

}
