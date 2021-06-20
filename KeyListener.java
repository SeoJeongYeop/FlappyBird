package flappyBird;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/*
 * Keyboard event: space bar
 * */
public class KeyListener extends KeyAdapter {
	@Override
	public void keyPressed(KeyEvent e) {
		if (GamePage.control == null)
			return;

		// only space bar event for bomb.
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			GamePage.control.pressSpace();
		}
	}

}
