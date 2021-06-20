package flappyBird;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
/* variables collection of affect to ingame */
public class Setting {
	public static final int WINDOWS_WIDTH = 1000;
	public static final int WINDOWS_HEIGHT = 720;
	public static final int TITLE_WIDTH = 800;
	public static final int BUTTON_WIDTH = 320;
	public static final int BUTTON_HEIGHT = 170;
	public static final int GROUND_HEIGHT = 100;

	public static int colSpeed = 5; // default 5 ( setting able 1~8)
	public static int sleep = 10; // default 10 (setting able 6~20)
	public static int gravity = 1; // default 1 (setting able 1~2)
	public static int space = 120; // default 120 (setting able 60 ~ 240)
	public static int interval = 300; // default 300 (setting able 100 ~ 500)

	Setting(int colSpeedValue, int sleepValue, int gravityValue, int spaceValue, int intervalValue, boolean filing) {
		colSpeed = colSpeedValue;
		sleep = sleepValue;
		gravity = gravityValue;
		space = spaceValue;
		interval = intervalValue;

		if (filing) { // if want to save in file, filing must be true.
			printFileSetting();
		}
	}
	/* File Output using FileOutputStream */
	private void printFileSetting() {
		try {
			PrintWriter settingFile = new PrintWriter(new FileOutputStream("setting.txt", false));

			settingFile.print("colSpeed|" + colSpeed + "|\n");
			settingFile.print("sleep|" + sleep + "|\n");
			settingFile.print("gravity|" + gravity + "|\n");
			settingFile.print("space|" + space + "|\n");
			settingFile.print("interval|" + interval + "|\n");

			settingFile.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
