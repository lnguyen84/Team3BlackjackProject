package team3Project;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ViewRulesPanel extends JPanel
{
	private JButton back;
	private JButton logout;
	private JTextField RulesArea;

	private ChatClient client;

	public ViewRulesPanel(ViewRulesControl vrp)
	{
		JLabel label = new JLabel("Rules:", JLabel.CENTER);
		JPanel labelPanel = new JPanel();
		labelPanel.add(label);
		
		//Create the area for user's contacts
		RulesArea = new JTextField("Rules go here");
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
