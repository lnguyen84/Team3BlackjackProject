package team3Project;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ViewRulesPanel extends JPanel
{
	private JButton back;
	private JButton logout;
	private JTextArea RulesArea;

	private ChatClient client;

	public ViewRulesPanel(ViewRulesControl vrp)
	{
		JLabel label = new JLabel("Rules:", JLabel.CENTER);
		JPanel labelPanel = new JPanel();
		labelPanel.add(label);
		
		//Create the area for user's contacts
		RulesArea = new JTextArea("Blackjack is a well-known card game that is a \n"
				+ "standard game for all casinos.\n"
				+ "Each game can consist of 1 to 5 players and 1 dealer.\n"
				+ "They will be using a standard deck of cards that consists \n"
				+ "of 52 cards, where the ace can be counted as 1 or 11, \n"
				+ "while face cards are 10. The game starts with the dealer \n"
				+ "shuffling and dealing 2 cards to every player including themselves,\n"
				+ "the players can ask for more cards from the dealer if \n"
				+ "necessary to reach the goal of 21 but not over 21.\n"
				+ "In order to win, the player's cards must be 21 or closer \n"
				+ "when compared to the dealer’s cards.\n");
		RulesArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(RulesArea);
		scroll.setPreferredSize(new Dimension(400,200));

		JPanel contactsPanel = new JPanel();
		contactsPanel.add(scroll);

		//Create the 3 buttons
		back = new JButton("Back");
		back.addActionListener(vrp);
		logout = new JButton("Log Out");
		logout.addActionListener(vrp);

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