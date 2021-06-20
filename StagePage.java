package flappyBird;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
/*
 * stage button and print difficulty of each stage and File input
 * */
public class StagePage extends JFrame {

	private static final long serialVersionUID = 1L;

	public static final int WINDOWS_WIDTH = 1000;
	public static final int WINDOWS_HEIGHT = 720;
	public static final int STAGE_BUTTON_WIDTH = 135;
	public static final int STAGE_BUTTON_HEIGHT = 120;
	private JPanel contentPane = new JPanel();

	JButton stageFirstButton;
	JButton stageSecondButton;
	JButton stageThirdButton;
	JButton stageSandboxButton;
	JButton menuButton;

	JLabel colSpeedValue = new JLabel("");
	JLabel SleepValue = new JLabel("");
	JLabel GravityValue = new JLabel("");
	JLabel SpaceValue = new JLabel("");
	JLabel intervalValue = new JLabel("");
	JLabel stageLabel = new JLabel("Select Stage");

	int click1 = 0;
	int click2 = 0;
	int click3 = 0;
	int click4 = 0;

	public BackgroundMusic bgm = new BackgroundMusic();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StagePage frame = new StagePage("Stage");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StagePage(String name) {
		super(name);
		setTitle("Flappy Bird");
		JPanel settingData = new JPanel();
		settingData.setBounds(WINDOWS_WIDTH / 2 - 400, WINDOWS_HEIGHT / 2, 800, 300);
		setSize(WINDOWS_WIDTH, WINDOWS_HEIGHT);

		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);

		ButtonIcon first = new ButtonIcon("1_off.png", "1_on.png");
		stageFirstButton = first.getButton();
		stageFirstButton.setBounds(WINDOWS_WIDTH / 2 - 400, WINDOWS_HEIGHT / 4, STAGE_BUTTON_WIDTH,
				STAGE_BUTTON_HEIGHT);
		getContentPane().add(stageFirstButton);

		ButtonIcon second = new ButtonIcon("2_off.png", "2_on.png");
		stageSecondButton = second.getButton();
		stageSecondButton.setBounds(WINDOWS_WIDTH / 2 - 180, WINDOWS_HEIGHT / 4, STAGE_BUTTON_WIDTH,
				STAGE_BUTTON_HEIGHT);
		getContentPane().add(stageSecondButton);

		ButtonIcon third = new ButtonIcon("3_off.png", "3_on.png");
		stageThirdButton = third.getButton();
		stageThirdButton.setBounds(WINDOWS_WIDTH / 2 + 40, WINDOWS_HEIGHT / 4, STAGE_BUTTON_WIDTH, STAGE_BUTTON_HEIGHT);
		getContentPane().add(stageThirdButton);

		ButtonIcon sandbox = new ButtonIcon("sandbox_off.png", "sandbox_on.png");
		stageSandboxButton = sandbox.getButton();
		stageSandboxButton.setBounds(WINDOWS_WIDTH / 2 + 260, WINDOWS_HEIGHT / 4, STAGE_BUTTON_WIDTH,
				STAGE_BUTTON_HEIGHT);
		getContentPane().add(stageSandboxButton);

		ButtonIcon menu = new ButtonIcon("menu_off.png", "menu_on.png");
		menuButton = menu.getButton();
		menuButton.setBounds(WINDOWS_WIDTH / 2 - 400, 30, 334, STAGE_BUTTON_HEIGHT);
		getContentPane().add(menuButton);
		contentPane.setLayout(null);

		JPanel settingDataPanel = new JPanel();
		settingDataPanel.setBackground(Color.WHITE);
		settingDataPanel.setBounds(100, 350, 800, 300);
		contentPane.add(settingDataPanel);
		settingDataPanel.setLayout(new GridLayout(5, 2, 0, 0));

		JLabel colSpeedLabel = new JLabel("Block Speed");
		colSpeedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		colSpeedLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		settingDataPanel.add(colSpeedLabel);

		colSpeedValue.setHorizontalAlignment(SwingConstants.CENTER);
		colSpeedValue.setFont(new Font("Verdana", Font.PLAIN, 28));
		settingDataPanel.add(colSpeedValue);

		JLabel sleepLabel = new JLabel("Sleep");
		sleepLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sleepLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		settingDataPanel.add(sleepLabel);

		SleepValue.setHorizontalAlignment(SwingConstants.CENTER);
		SleepValue.setFont(new Font("Verdana", Font.PLAIN, 28));
		settingDataPanel.add(SleepValue);

		JLabel GravityLabel = new JLabel("Gravity");
		GravityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GravityLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		settingDataPanel.add(GravityLabel);

		GravityValue.setHorizontalAlignment(SwingConstants.CENTER);
		GravityValue.setFont(new Font("Verdana", Font.PLAIN, 28));
		settingDataPanel.add(GravityValue);

		JLabel SpaceLabel = new JLabel("Space");
		SpaceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SpaceLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		settingDataPanel.add(SpaceLabel);

		SpaceValue.setHorizontalAlignment(SwingConstants.CENTER);
		SpaceValue.setFont(new Font("Verdana", Font.PLAIN, 28));
		settingDataPanel.add(SpaceValue);

		JLabel intervalLabel = new JLabel("Interval");
		intervalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		intervalLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		settingDataPanel.add(intervalLabel);

		intervalValue.setHorizontalAlignment(SwingConstants.CENTER);
		intervalValue.setFont(new Font("Verdana", Font.PLAIN, 28));
		settingDataPanel.add(intervalValue);

		JPanel stageNamePanel = new JPanel();
		stageNamePanel.setBackground(new Color(135, 206, 235));
		stageNamePanel.setBounds(500, 30, 400, 120);
		contentPane.add(stageNamePanel);

		stageLabel.setFont(new Font("Verdana", Font.BOLD, 40));
		stageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		stageNamePanel.add(stageLabel);

		bgm.playMusic("stage.wav", true);

		ButtonHandler handler = new ButtonHandler();
		stageFirstButton.addActionListener(handler);
		stageSecondButton.addActionListener(handler);
		stageThirdButton.addActionListener(handler);
		stageSandboxButton.addActionListener(handler);
		menuButton.addActionListener(handler);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == stageFirstButton) {
				/* double click check */
				click1++;
				click2 = 0;
				click3 = 0;
				click4 = 0;
				if (click1 == 1) {
					Main.setting = new Setting(3, 12, 1, 150, 400, false);
					colSpeedValue.setText("" + Setting.colSpeed);
					SleepValue.setText("" + Setting.sleep);
					GravityValue.setText("" + Setting.gravity);
					SpaceValue.setText("" + Setting.space);
					intervalValue.setText("" + Setting.interval);
					stageLabel.setText("Stage 1");
				} else if (click1 >= 2) {
					// When double click, open next stage
					new GamePage("Stage 1");
					bgm.stopMusic();
					setVisible(false);
					dispose();
				}
			}
			if (e.getSource() == stageSecondButton) {
				/* double click check */
				click1 = 0;
				click2++;
				click3 = 0;
				click4 = 0;
				if (click2 == 1) {
					Main.setting = new Setting(5, 10, 1, 120, 300, false);
					colSpeedValue.setText("" + Setting.colSpeed);
					SleepValue.setText("" + Setting.sleep);
					GravityValue.setText("" + Setting.gravity);
					SpaceValue.setText("" + Setting.space);
					intervalValue.setText("" + Setting.interval);
					stageLabel.setText("Stage 2");
				} else if (click2 >= 2) {
					// When double click, open next stage
					new GamePage("Stage 2");
					bgm.stopMusic();
					setVisible(false);
					dispose();
				}
			}
			if (e.getSource() == stageThirdButton) {
				/* double click check */
				click1 = 0;
				click2 = 0;
				click3++;
				click4 = 0;
				if (click3 == 1) {
					Main.setting = new Setting(7, 10, 1, 100, 200, false);
					colSpeedValue.setText("" + Setting.colSpeed);
					SleepValue.setText("" + Setting.sleep);
					GravityValue.setText("" + Setting.gravity);
					SpaceValue.setText("" + Setting.space);
					intervalValue.setText("" + Setting.interval);
					stageLabel.setText("Stage 3");
				} else if (click3 >= 2) {
					// When double click, open next stage
					new GamePage("Stage 3");

					bgm.stopMusic();
					setVisible(false);
					dispose();
				}

			}
			if (e.getSource() == stageSandboxButton) {
				/* double click check */
				click1 = 0;
				click2 = 0;
				click3 = 0;
				click4++;
				if (click4 == 1) {
					try {
						/* file input using FileInputStream */
						FileInputStream fInput = new FileInputStream("setting.txt");

						Scanner scanner = new Scanner(fInput);
						String userSetting = new String();
						while (scanner.hasNext()) {
							userSetting = userSetting + "" + scanner.nextLine();
						}
						String[] splitUserSetting = userSetting.split("\\|"); // delimiter "|" is need to \\
						ArrayList<Integer> setting = new ArrayList<Integer>();
						try {
							for (int i = 0; i < splitUserSetting.length; i++) {
								if (i % 2 == 1)
									setting.add(Integer.parseInt(splitUserSetting[i]));
							}
							Main.setting = new Setting(setting.get(0), setting.get(1), setting.get(2), setting.get(3),
									setting.get(4), false);
							fInput.close();
							scanner.close();
						} catch (Exception error) {
							// if the file's string is not match format, namely the file corrupted.
							click4 = 0;
							stageLabel.setText("Setting Again");
						}
					} catch (FileNotFoundException error) {
						// if file not found
						click4 = 0;
						stageLabel.setText("Setting Required");
					} catch (Exception error) {
						click4 = 0;
						error.printStackTrace();
					}
					if (click4 != 0) {
						colSpeedValue.setText("" + Setting.colSpeed);
						SleepValue.setText("" + Setting.sleep);
						GravityValue.setText("" + Setting.gravity);
						SpaceValue.setText("" + Setting.space);
						intervalValue.setText("" + Setting.interval);
						stageLabel.setText("SandBox");
					} else {
						// file input has problem. It doesn't print anything on the screen.
						colSpeedValue.setText("");
						SleepValue.setText("");
						GravityValue.setText("");
						SpaceValue.setText("");
						intervalValue.setText("");
					}

				} else if (click4 >= 2) {
					// When double click, open next stage
					new GamePage("SandBox");
					bgm.stopMusic();
					setVisible(false);
					dispose();
				}

			}
			if (e.getSource() == menuButton) {
				// menu button doesn't need double click. just one.
				new MenuPage("Menu");
				bgm.stopMusic();
				setVisible(false);
				dispose();
			}
		}
	}
}
