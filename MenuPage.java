package flappyBird;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/*
 * Start button, Setting button, Quit Button
 * */
public class MenuPage extends JFrame {

	private static final long serialVersionUID = 1L;

	public final int WINDOWS_WIDTH = Setting.WINDOWS_WIDTH;
	public final int WINDOWS_HEIGHT = Setting.WINDOWS_HEIGHT;
	public static final int TITLE_WIDTH = 800;
	public static final int BUTTON_WIDTH = 320;
	public static final int BUTTON_HEIGHT = 105;

	private JFrame menuPage = MenuPage.this;
	private JPanel contentPane;
	private JButton startButton;
	private JButton settingButton;
	private JButton quitButton;
	private JLabel title;
	private JLabel bird;
	public BackgroundMusic bgm = new BackgroundMusic();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPage frame = new MenuPage("Menu");
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
	public MenuPage(String name) {
		super(name);
		setTitle("Flappy Bird");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(WINDOWS_WIDTH, WINDOWS_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// search ImageIcon and save
		Icon imgTitle = new ImageIcon(getClass().getResource("./images/title.png"));
		Icon imgBird = new ImageIcon(getClass().getResource("./images/bird.png"));
		// ButtonIcon can make fancy button. when mouse on the button, image change.
		ButtonIcon start = new ButtonIcon("start_off.png", "start_on.png");
		ButtonIcon setting = new ButtonIcon("setting_off.png", "setting_on.png");
		ButtonIcon quit = new ButtonIcon("quit_off.png", "quit_on.png");

		// setting title
		title = new JLabel(imgTitle);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(WINDOWS_WIDTH / 2 - TITLE_WIDTH / 2, 43, TITLE_WIDTH, 168);
		contentPane.add(title);

		// setting flappy bird image
		bird = new JLabel(imgBird);
		bird.setHorizontalAlignment(SwingConstants.CENTER);
		bird.setBounds(WINDOWS_WIDTH / 5, WINDOWS_HEIGHT / 2 - 110, 120, 120);
		contentPane.add(bird);

		// setting start button
		startButton = start.getButton();
		startButton.setBounds(WINDOWS_WIDTH / 2 - BUTTON_WIDTH / 2, WINDOWS_HEIGHT / 2 - 120, BUTTON_WIDTH,
				BUTTON_HEIGHT);
		getContentPane().add(startButton);

		// setting setting button
		settingButton = setting.getButton();
		settingButton.setBounds(WINDOWS_WIDTH / 2 - BUTTON_WIDTH / 2, WINDOWS_HEIGHT / 2, BUTTON_WIDTH, BUTTON_HEIGHT);
		getContentPane().add(settingButton);

		// setting quit button
		quitButton = quit.getButton();
		quitButton.setBounds(WINDOWS_WIDTH / 2 - BUTTON_WIDTH / 2, WINDOWS_HEIGHT / 2 + 120, BUTTON_WIDTH,
				BUTTON_HEIGHT);
		getContentPane().add(quitButton);

		// for event
		ButtonHandler handler = new ButtonHandler();
		startButton.addActionListener(handler);
		settingButton.addActionListener(handler);
		quitButton.addActionListener(handler);

		// bgm play
		bgm.playMusic("menu.wav", true); // .wav OK but .mp3 not okay...
		setVisible(true);

	}

	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == startButton) {
				// open StagePage
				bird.setBounds(WINDOWS_WIDTH / 5, WINDOWS_HEIGHT / 2 - 110, 120, 120);
				bird.setVisible(false);
				title.setVisible(false);
				bgm.stopMusic();
				new StagePage("Stage");
				setVisible(false);
				dispose();
			}
			if (e.getSource() == settingButton) {
				// open SettingPage
				bird.setBounds(WINDOWS_WIDTH / 5, WINDOWS_HEIGHT / 2 + 10, 120, 120);
				new SettingPage(menuPage, "Setting"); // pass parameter itself. menuPage set Setting parent
			}

			if (e.getSource() == quitButton) {
				// exit
				bird.setBounds(WINDOWS_WIDTH / 5, WINDOWS_HEIGHT / 2 + 130, 120, 120);
				System.exit(0);
			}
		}
	}

}
