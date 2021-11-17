package team3Project;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ClientGUI extends JFrame
{
	private ChatClient client;

	public ClientGUI()
	{
		// Set the title and default close operation.
		this.setTitle("Client");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Constructor that creates the client GUI.
		client = new ChatClient();

		try
		{
			client.openConnection();
		}

		catch (IOException e)
		{
			e.printStackTrace();
		}

		// Create the card layout container.
		CardLayout cardLayout = new CardLayout();
		JPanel container = new JPanel(cardLayout);

		//Create the Controllers next
		InitialControl ic = new InitialControl(container); 
		LoginControl lc = new LoginControl(container, client); //Probably will want to pass in ChatClient here
		CreateAccountControl cc = new CreateAccountControl(container,client);

		//Set the controllers in ChatClient
	    client.setLoginControl(lc);
	    client.setCreateControl(cc);
	    
		// Create the four views. (need the controller to register with the Panels)
		JPanel view1 = new InitialPanel(ic);
		JPanel view2 = new LoginPanel(lc);
		JPanel view3 = new CreateAccountPanel(cc);
		JPanel view4 = new ContactPanel();

		// Add the views to the card layout container.
		container.add(view1, "1");
		container.add(view2, "2");
		container.add(view3, "3");
		container.add(view4, "4");

		// Show the initial view in the card layout.
		cardLayout.show(container, "1");

		// Add the card layout container to the JFrame.
		this.add(container, BorderLayout.CENTER);

		// Show the JFrame.
		this.setSize(550, 390);
	    this.setLocationRelativeTo(null);
	    this.setVisible(true);
	}

	// Main function that creates the client GUI when the program is started.
	public static void main(String[] args)
	{
		new ClientGUI();
	}
}
