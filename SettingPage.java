package flappyBird;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/* input textfield and check whether integer and given boundary number or not*/
public class SettingPage extends JDialog {

	private static final long serialVersionUID = 1L;

	// Event Handler is able to access to textFields.
	private final JPanel contentPanel = new JPanel();
	private JTextField colSpeedTextField;
	private JTextField sleepTextField;
	private JTextField gravityTextField;
	private JTextField spaceTextField;
	private JTextField intervalTextField;

	/**
	 * Create the dialog.
	 */
	public SettingPage(JFrame parentFrame, String name) {
		super(parentFrame, true); // set parentFrame and true it means the user needs to do child JDialog first.
		setSize(500, 620);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(135, 206, 235));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 3, 5, 20));
		setTitle("Flappy Bird");

		setResizable(false);
		setLocationRelativeTo(null);

		{
			JLabel colSpeedLabel = new JLabel("Block Speed");
			colSpeedLabel.setFont(new Font("Verdana", Font.PLAIN, 22));
			colSpeedLabel.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(colSpeedLabel);
		}
		{
			JLabel colSpeedConditionLabel = new JLabel("( 1 ~ 8 )");
			colSpeedConditionLabel.setHorizontalAlignment(SwingConstants.CENTER);
			colSpeedConditionLabel.setFont(new Font("Verdana", Font.PLAIN, 22));
			contentPanel.add(colSpeedConditionLabel);
		}
		{
			colSpeedTextField = new JTextField();
			colSpeedTextField.setHorizontalAlignment(SwingConstants.CENTER);
			colSpeedTextField.setFont(new Font("Verdana", Font.PLAIN, 22));
			contentPanel.add(colSpeedTextField);
			colSpeedTextField.setColumns(10);
		}
		{
			JLabel sleepLabel = new JLabel("Sleep Time");
			sleepLabel.setHorizontalAlignment(SwingConstants.CENTER);
			sleepLabel.setFont(new Font("Verdana", Font.PLAIN, 22));
			contentPanel.add(sleepLabel);
		}
		{
			JLabel sleepConditionLabel = new JLabel("( 6 ~ 20 )");
			sleepConditionLabel.setHorizontalAlignment(SwingConstants.CENTER);
			sleepConditionLabel.setFont(new Font("Verdana", Font.PLAIN, 22));
			contentPanel.add(sleepConditionLabel);
		}
		{
			sleepTextField = new JTextField();
			sleepTextField.setHorizontalAlignment(SwingConstants.CENTER);
			sleepTextField.setFont(new Font("Verdana", Font.PLAIN, 22));
			contentPanel.add(sleepTextField);
			sleepTextField.setColumns(10);
		}
		{
			JLabel gravityLabel = new JLabel("Gravity");
			gravityLabel.setHorizontalAlignment(SwingConstants.CENTER);
			gravityLabel.setFont(new Font("Verdana", Font.PLAIN, 22));
			contentPanel.add(gravityLabel);
		}
		{
			JLabel gravityConditionLabel = new JLabel("( 1 ~ 2 )");
			gravityConditionLabel.setHorizontalAlignment(SwingConstants.CENTER);
			gravityConditionLabel.setFont(new Font("Verdana", Font.PLAIN, 22));
			contentPanel.add(gravityConditionLabel);
		}
		{
			gravityTextField = new JTextField();
			gravityTextField.setHorizontalAlignment(SwingConstants.CENTER);
			gravityTextField.setFont(new Font("Verdana", Font.PLAIN, 22));
			gravityTextField.setColumns(10);
			contentPanel.add(gravityTextField);
		}
		{
			JLabel spaceLabel = new JLabel("Space");
			spaceLabel.setHorizontalAlignment(SwingConstants.CENTER);
			spaceLabel.setFont(new Font("Verdana", Font.PLAIN, 22));
			contentPanel.add(spaceLabel);
		}
		{
			JLabel spaceConditionLabel = new JLabel("( 60 ~ 240 )");
			spaceConditionLabel.setHorizontalAlignment(SwingConstants.CENTER);
			spaceConditionLabel.setFont(new Font("Verdana", Font.PLAIN, 22));
			contentPanel.add(spaceConditionLabel);
		}
		{
			spaceTextField = new JTextField();
			spaceTextField.setHorizontalAlignment(SwingConstants.CENTER);
			spaceTextField.setFont(new Font("Verdana", Font.PLAIN, 22));
			spaceTextField.setColumns(10);
			contentPanel.add(spaceTextField);
		}
		{
			JLabel intervalLabel = new JLabel("Interval");
			intervalLabel.setHorizontalAlignment(SwingConstants.CENTER);
			intervalLabel.setFont(new Font("Verdana", Font.PLAIN, 22));
			contentPanel.add(intervalLabel);
		}
		{
			JLabel intervalConditionLabel = new JLabel("( 100 ~ 500)");
			intervalConditionLabel.setHorizontalAlignment(SwingConstants.CENTER);
			intervalConditionLabel.setFont(new Font("Verdana", Font.PLAIN, 22));
			contentPanel.add(intervalConditionLabel);
		}
		{
			intervalTextField = new JTextField();
			intervalTextField.setHorizontalAlignment(SwingConstants.CENTER);
			intervalTextField.setFont(new Font("Verdana", Font.PLAIN, 22));
			intervalTextField.setColumns(10);
			contentPanel.add(intervalTextField);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			JLabel messageLabel = new JLabel("");
			messageLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
			messageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			buttonPane.add(messageLabel);

			JButton okButton = new JButton("OK");
			buttonPane.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == okButton) {

						try {
							int colSpeed = Integer.parseInt(colSpeedTextField.getText());
							int sleep = Integer.parseInt(sleepTextField.getText());
							int gravity = Integer.parseInt(gravityTextField.getText());
							int space = Integer.parseInt(spaceTextField.getText());
							int interval = Integer.parseInt(intervalTextField.getText());
							
							// All case check given condition.
							if (colSpeed < 1 || 8 < colSpeed) {
								throw new outOfBoundException("outOfBound Exception");
							} else if (sleep < 6 || 20 < sleep) {
								throw new outOfBoundException("outOfBound Exception");
							} else if (gravity < 1 || 8 < gravity) {
								throw new outOfBoundException("outOfBound Exception");
							} else if (space < 60 || 240 < space) {
								throw new outOfBoundException("outOfBound Exception");
							} else if (interval < 100 || 500 < interval) {
								throw new outOfBoundException("outOfBound Exception");
							} else {
								Main.setting = new Setting(colSpeed, sleep, gravity, space, interval, true); // file save
								messageLabel.setText("Everything has been applied.");

								dispose();
							}

						} catch (NumberFormatException error) {
							// Exception: your inputs are not integer type(string or float)
							messageLabel.setText("Enter an Integer!");
						} catch (outOfBoundException error) {
							// Exception: your inputs are out of given boundary.
							messageLabel.setText("Check proposed boundary!");

						} catch (Exception error) {
							messageLabel.setText("Error!");
						}
					}

				}
			});

			JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();

				}
			});
			cancelButton.setActionCommand("Cancel");
			buttonPane.add(cancelButton);

		}
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);

	}

	public class outOfBoundException extends Exception {

		private static final long serialVersionUID = 1L;

		// defined Exception. so extends Exception
		// Out from the proposed setting boundary causes an exception.
		outOfBoundException(String message) {
			super(message);
		}

	}

}
