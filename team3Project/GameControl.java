package team3Project;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GameControl implements ActionListener
{
	// Private data field for storing the container.
	private JPanel container;
	private ChatClient client;

	// Constructors
	public GameControl(JPanel container, ChatClient client)
	{
		this.container = container;
	    this.client = client;
	}

	// Handle button clicks.
	public void actionPerformed(ActionEvent ae)
	{
		// Get the name of the button clicked.
		String command = ae.getActionCommand();

		// The quit button takes the user out of the game
		if (command.equals("Quit"))
		{
			CardLayout cardLayout = (CardLayout)container.getLayout();
			cardLayout.show(container, "4");
		}
	}
}
