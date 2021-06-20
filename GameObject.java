package flappyBird;

import javax.swing.ImageIcon;
/*
 * game object: bird, column, ground's parent. position and size set and get
 * */

public class GameObject extends Thread {
	// Inherited for inheritance
	private int x;
	private int y;
	private int width;
	private int height;
	private String fileName;
	private String filePath = "./images/";
	private ImageIcon icon; // get from file name

	public GameObject(int x, int y, int width, int height, String fileName) {
		this.setX(x);
		this.setY(y);
		this.setWidth(width);
		this.setHeight(height);
		this.setFileName(fileName);
		this.setIcon(new ImageIcon(getClass().getResource(filePath + getFileName())));
	}

	public GameObject(double x, double y, double width, double height, String fileName) {
		this.setX((int) x);
		this.setY((int) y);
		this.setWidth((int) width);
		this.setHeight((int) height);
		this.setFileName(fileName);
		this.setIcon(new ImageIcon(getClass().getResource(filePath + getFileName())));
	}

	@Override
	public void run() {
		super.run();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

}
