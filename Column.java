package flappyBird;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
/*
 * Adjusting column's image size, column's Motion , column's graphics
 * */

public class Column extends GameObject {
	private Image colImage;
	private int detectBomb;

	public Column(int x, int y, int width, int height, String fileName) {
		super(x, y, width, height, fileName);
		/* Adjust the size of the Image */
		this.setColImage(
				super.getIcon().getImage().getScaledInstance(super.getWidth(), super.getHeight(), Image.SCALE_FAST));
	}

	public void generateOnScreen(Graphics2D g) {
		/* column position update */
		g.drawImage(getColImage(), super.getX(), super.getY(), null);

	}

	public void move() {
		/* move Column */
		super.setX(super.getX() - Setting.colSpeed);
	}

	@Override
	public void run() {
		try {
			detectBomb = Control.bomb;
			while (!GamePage.isGameOver && !isInterrupted()) {
				if (!isInterrupted()) {
					move();
					sleep(Setting.sleep);
					// check go to end of screen
					if (super.getX() < -100) {
						Control.removeColumn(this);
						Control.count += 1;
						interrupt();
					}
					// check using bomb
					if (detectBomb > Control.bomb) {
						interrupt(); // remove column
					}
					// check Collision with Bird
					if (super.getX() <= 187 && 187 <= super.getX() + super.getWidth()
							&& super.getY() < (GamePage.bird.getY() + GamePage.bird.getHeight() / 2)
							&& (GamePage.bird.getY() + GamePage.bird.getHeight() / 2) <= super.getY()
									+ super.getHeight()) {
						GamePage.isGameOver = true;
					}

				}
			}

		} catch (Exception error) {
			System.err.println(error.getMessage());
		}
	}

	ImageIcon getImage() {
		return super.getIcon();
	}

	public Image getColImage() {
		return colImage;
	}

	public void setColImage(Image colImage) {
		this.colImage = colImage;
	}
}
