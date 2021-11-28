package team3Project;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PlayerInfoControl implements ActionListener
{
	// Private data field for storing the container.
	private JPanel container;
	private ChatClient client;

	// Constructors
	public PlayerInfoControl(JPanel container, ChatClient client)
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
		if (command.equals("Back"))
		{
			//LoginPanel loginPanel = (LoginPanel)container.getComponent(1);
			//loginPanel.setError("");
			CardLayout cardLayout = (CardLayout)container.getLayout();
			cardLayout.show(container, "4");
		}
		
		// The logout button takes the user to the create account panel.
		else if (command.equals("Log Out"))
		{
			//CreateAccountPanel createPanel = (CreateAccountPanel)container.getComponent(2);
			//createPanel.setError("");
			CardLayout cardLayout = (CardLayout)container.getLayout();
			cardLayout.show(container, "1");
		}
	}
}
