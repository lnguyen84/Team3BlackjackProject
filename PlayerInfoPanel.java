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
		
		
		// create title
		JLabel label = new JLabel("Player Information", JLabel.CENTER);
		JPanel titlePanel = new JPanel(new GridLayout(1, 1, 5, 5));
		titlePanel.add(label);
		
		// create labels
		JLabel name = new JLabel("Username: ", JLabel.CENTER);
		//JLabel wins = new JLabel("Wins: ?" + db.query("SELECT wins FROM users " + "WHERE username = \"" + user.getUsername() + "\";"), JLabel.CENTER);
		JLabel wins = new JLabel("Wins: ?" , JLabel.CENTER);
		JLabel losses = new JLabel("Losses: ?" , JLabel.CENTER);
		JLabel ratio = new JLabel("W/L Ratio: ?" , JLabel.CENTER);

		// add labels to panel
		JPanel labelPanel = new JPanel(new GridLayout(5, 1, 5, 5));
		labelPanel.add(name);
		labelPanel.add(wins);
		labelPanel.add(losses);
		labelPanel.add(ratio);

		//Create the 3 buttons
		back = new JButton("Back");
		back.addActionListener(pic);
		logout = new JButton("Log Out");
		logout.addActionListener(pic);

		//add buttons
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(back);
		buttonsPanel.add(logout);

		//Arrange the components
		JPanel all = new JPanel();
		all.setLayout(new BoxLayout(all, BoxLayout.Y_AXIS));
		labelPanel.setAlignmentX(CENTER_ALIGNMENT);
		all.add(titlePanel);
		all.add(Box.createVerticalStrut(10));
		all.add(labelPanel);
		all.add(Box.createVerticalStrut(10));
		all.add(buttonsPanel);
		this.add(all);
	}
}
