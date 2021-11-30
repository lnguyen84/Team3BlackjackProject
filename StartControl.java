package team3Project;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class StartControl implements ActionListener
{
	// Private data field for storing the container.
	private JPanel container;
	private ChatClient client;

	// Constructors
	public StartControl(JPanel container, ChatClient client)
	{
		this.container = container;
	    this.client = client;
	}

	// Handle button clicks.
	public void actionPerformed(ActionEvent ae)
	{
		// Get the name of the button clicked.
		String command = ae.getActionCommand();

		// The start button takes the user to the game panel.
		if (command.equals("Start"))
		{
			CardLayout cardLayout = (CardLayout)container.getLayout();
			cardLayout.show(container, "7");
		}

		// The view rules button takes the user to the viewRulesPanel.
		else if (command.equals("View Rules"))
		{
			CardLayout cardLayout = (CardLayout)container.getLayout();
			cardLayout.show(container, "5");
		}

		// The player information button takes the user to the PlayerInfoPanel.
		else if (command.equals("Player Information"))
		{
			CardLayout cardLayout = (CardLayout)container.getLayout();
			cardLayout.show(container, "6");
		}
		
		// The logout button takes the user to the create account panel.
		else if (command.equals("Log Out"))
		{
			CardLayout cardLayout = (CardLayout)container.getLayout();
			cardLayout.show(container, "1");
		}
	}
}
