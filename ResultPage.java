package flappyBird;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
/*Score, Menu button, Stage button, restart button*/
public class ResultPage extends JDialog {

	private static final long serialVersionUID = 1L;

	private final JPanel contentPane = new JPanel();

	public final int WIDTH = Setting.WINDOWS_WIDTH / 2;
	public final int HEIGHT = Setting.WINDOWS_HEIGHT - 100;
	public final int BUTTON_WIDTH = 270;
	public final int BUTTON_HEIGHT = 78;
	JButton restartButton;
	JButton stageButton;
	JButton menuButton;

	public static String stageName;

	public static String getStageName() {
		return stageName;
	}

	public static void setStageName(String stageName) {
		ResultPage.stageName = stageName;
	}

	public BackgroundMusic bgm = new BackgroundMusic();

	/**
	 * Create the frame.
	 */
	public ResultPage(JFrame parentFrame, String name, int score) {
		super(parentFrame, true); // set parentFrame and true it means user needs to do child JDialog first.
		setStageName(name);
		setTitle("Flappy Bird");

		setSize(WIDTH, HEIGHT);
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);

		JLabel textLabel;
		textLabel = new JLabel();
		textLabel.setHorizontalAlignment(SwingConstants.CENTER);
		textLabel.setFont(new Font("Verdana", Font.PLAIN, 40));
		textLabel.setText("YOUR SCORE");
		textLabel.setBounds(WIDTH / 2 - BUTTON_WIDTH / 2, 50, BUTTON_WIDTH, BUTTON_HEIGHT);
		getContentPane().add(textLabel);

		JLabel scoreLabel;
		scoreLabel = new JLabel();
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setFont(new Font("Verdana", Font.PLAIN, 78));
		scoreLabel.setText("" + score);
		scoreLabel.setBounds(WIDTH / 2 - BUTTON_WIDTH / 2, 130, BUTTON_WIDTH, BUTTON_HEIGHT);
		getContentPane().add(scoreLabel);

		ButtonIcon restart = new ButtonIcon("restart_off.png", "restart_on.png");
		restartButton = restart.getButton();
		restartButton.setBounds(WIDTH / 2 - BUTTON_WIDTH / 2, 240, BUTTON_WIDTH, BUTTON_HEIGHT);
		getContentPane().add(restartButton);
		contentPane.setLayout(null);

		ButtonIcon stage = new ButtonIcon("stage_off.png", "stage_on.png");
		stageButton = stage.getButton();
		stageButton.setBounds(WIDTH / 2 - BUTTON_WIDTH / 2, 350, BUTTON_WIDTH, BUTTON_HEIGHT);
		getContentPane().add(stageButton);
		contentPane.setLayout(null);

		ButtonIcon menu = new ButtonIcon("small_menu_off.png", "small_menu_on.png");
		menuButton = menu.getButton();
		menuButton.setBounds(WIDTH / 2 - BUTTON_WIDTH / 2, 460, BUTTON_WIDTH, BUTTON_HEIGHT);
		getContentPane().add(menuButton);
		contentPane.setLayout(null);

		ButtonHandler handler = new ButtonHandler();

		restartButton.addActionListener(handler);
		stageButton.addActionListener(handler);
		menuButton.addActionListener(handler);

		bgm.playMusic("gameover.wav", true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == restartButton) {
				//restart button event
				bgm.stopMusic();
				setVisible(false);
				GamePage.isStarted = false;
				GamePage.isGameOver = false;
				new GamePage(getStageName());
				dispose();

			}
			if (e.getSource() == stageButton) {
				//stage button event
				new StagePage("Stage");
				bgm.stopMusic();
				setVisible(false);
				GamePage.isStarted = false;
				GamePage.isGameOver = false;
				dispose();

			}

			if (e.getSource() == menuButton) {
				//menu button event
				new MenuPage("Menu");
				bgm.stopMusic();
				GamePage.isStarted = false;
				GamePage.isGameOver = false;
				setVisible(false);
				dispose();
			}
		}
	}
}
