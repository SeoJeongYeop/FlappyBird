package flappyBird;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/*
 * Using two image, make RolloverIcon Button and pass through Getter method.
 * */
public class ButtonIcon extends JButton {

	private static final long serialVersionUID = 1L;

	private String filePath = "./images/";
	private String mouseOffFileName;
	private String mouseOnFileName;
	private Icon mouseOffImage;
	private Icon mouseOnImage;
	private JButton button;

	/* get two string file name */
	ButtonIcon(String mouseOffFileName, String mouseOnFileName) {
		try {
			this.setMouseOffFileName(mouseOffFileName);
			this.setMouseOnFileName(mouseOnFileName);

			// Get the image icon through the file name.
			this.setMouseOffImage(new ImageIcon(getClass().getResource(filePath + mouseOffFileName)));
			this.setMouseOnImage(new ImageIcon(getClass().getResource(filePath + mouseOnFileName)));

			button = new JButton(getMouseOffImage());
			button.setRolloverIcon(getMouseOnImage()); // on mouse cursor, Image change

			// fill full image on the button
			button.setBorderPainted(false);
			button.setFocusPainted(false);
			button.setContentAreaFilled(false);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* Getter and Setter Method */
	public String getMouseOffFileName() {
		return mouseOffFileName;
	}

	public void setMouseOffFileName(String mouseOffFileName) {
		this.mouseOffFileName = mouseOffFileName;
	}

	public String getMouseOnFileName() {
		return mouseOnFileName;
	}

	public void setMouseOnFileName(String mouseOnFileName) {
		this.mouseOnFileName = mouseOnFileName;
	}

	public JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}

	public Icon getMouseOffImage() {
		return mouseOffImage;
	}

	public void setMouseOffImage(Icon mouseOffImage) {
		this.mouseOffImage = mouseOffImage;
	}

	public Icon getMouseOnImage() {
		return mouseOnImage;
	}

	public void setMouseOnImage(Icon mouseOnImage) {
		this.mouseOnImage = mouseOnImage;
	}
}
