package flappyBird;

import java.awt.Graphics2D;
/*
 * Bird's Motion, graphics, and ground or ceiling touch Game over control
 * */
public class Bird extends GameObject {

	private int gravity;
	private int yMotion;

	private int cnt = 0;

	public Bird(int x, int y, int width, int height, String fileName) {
		super(x, y, width, height, fileName);
		setVar();
	}

	public void setVar() {
		setGravity(Setting.gravity); // set static value;
		setyMotion(0);
	}

	public void generateOnScreen(Graphics2D g) {
		/* bird position update */
		g.drawImage(super.getIcon().getImage(), super.getX(), super.getY(), null);
	}

	public void fly() {
		/* If user don't press the mouse, it keeps falling. */
		super.setY(super.getY() + getyMotion());
	}

	@Override
	public void run() {
		/* multithreading */
		while (!GamePage.isGameOver) {
			fly();
			// block too fast falling
			if (cnt >= 4 && getyMotion() <= 8) {
				setyMotion(getyMotion() + getGravity());
				cnt = 0;
			}
			cnt++;

			try {
				Thread.sleep(Setting.sleep << 1);
			} catch (InterruptedException error) {
				System.err.println(error.getMessage());
			}
			if (super.getY() > 600 || super.getY() <= 100) {
				// if touch ground of sky, then game over.
				GamePage.isGameOver = true;
			}
		}
	}

	/* Getter and Setter Methods */
	public int getGravity() {
		return gravity;
	}

	public void setGravity(int gravity) {
		this.gravity = gravity;
	}

	public int getyMotion() {
		return yMotion;
	}

	public void setyMotion(int yMotion) {
		this.yMotion = yMotion;
	}
}
