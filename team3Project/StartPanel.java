package team3Project;

import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartPanel extends JPanel
{
	private JButton start;
	private JButton viewRules;
	private JButton viewPlayerInfo;
	private JButton logout;

	private ChatClient client;

	public StartPanel(StartControl sc)
	{
		//Title
		JLabel label = new JLabel("Start Page", JLabel.CENTER);
		JPanel labelPanel = new JPanel();
		labelPanel.add(label);

		JPanel StartPanel = new JPanel();

		//Create the buttons and add action listeners
		start = new JButton("Join Game");
		start.addActionListener(sc);
		viewRules = new JButton("View Rules");	
		viewRules.addActionListener(sc);
		viewPlayerInfo = new JButton("Player Information");
		viewPlayerInfo.addActionListener(sc);
		logout = new JButton("Log Out");
		logout.addActionListener(sc);

		//Add buttons to panel
		JPanel buttonsPanel = new JPanel(new GridLayout(5, 1, 5, 5));
		buttonsPanel.add(start);
		buttonsPanel.add(viewRules);
		buttonsPanel.add(viewPlayerInfo);
		buttonsPanel.add(logout);

		//Arrange the components
		JPanel all = new JPanel();
		all.setLayout(new BoxLayout(all, BoxLayout.Y_AXIS));
		all.add(labelPanel);
		//all.add(Box.createVerticalStrut(10));
		//all.add(StartPanel);
		all.add(Box.createVerticalStrut(10));
		all.add(buttonsPanel);
		this.add(all);
	}
}