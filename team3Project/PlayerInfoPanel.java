package team3Project;

import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerInfoPanel extends JPanel
{
	private JButton back;
	private JButton logout;

	private ChatClient client;
	private Database db;
	private User user;

	public PlayerInfoPanel(PlayerInfoControl pic)
	{
		// create labels
		JLabel label = new JLabel("Player Information", JLabel.CENTER);
		JPanel labelPanel = new JPanel();
		JLabel name = new JLabel("Username: ", JLabel.CENTER);
		//JLabel wins = new JLabel("Wins: ?" + db.query("SELECT wins FROM users "
		//		+ "WHERE username = \"" + user.getUsername() + "\";"), JLabel.CENTER);
		JLabel wins = new JLabel("Wins: ?" , JLabel.CENTER);
		JLabel losses = new JLabel("Losses: ?" , JLabel.CENTER);
		JLabel ratio = new JLabel("W/L Ratio: ?" , JLabel.CENTER);
		labelPanel.add(label);
		labelPanel.add(name);
		labelPanel.add(wins);
		labelPanel.add(losses);
		labelPanel.add(ratio);

		JPanel contactsPanel = new JPanel();

		//Create the 3 buttons
		back = new JButton("Back");
		back.addActionListener(pic);
		logout = new JButton("Log Out");
		logout.addActionListener(pic);

		JPanel buttonsTop = new JPanel();
		buttonsTop.add(back);

		JPanel buttonBottom = new JPanel();
		buttonBottom.add(logout);

		JPanel buttonsPanel = new JPanel(new GridLayout(2, 1, 5, 5));
		buttonsPanel.add(buttonsTop);
		buttonsPanel.add(buttonBottom);

		//Arrange the components
		JPanel all = new JPanel();
		all.setLayout(new BoxLayout(all, BoxLayout.Y_AXIS));
		all.add(labelPanel);
		all.add(Box.createVerticalStrut(10));
		all.add(contactsPanel);
		all.add(Box.createVerticalStrut(10));
		all.add(buttonsPanel);
		this.add(all);
	}
}
