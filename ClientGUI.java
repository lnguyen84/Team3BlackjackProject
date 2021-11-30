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
/*
		try
		{
			client.openConnection();
		}

		catch (IOException e)
		{
			e.printStackTrace();
		}
*/ // removed as it doesn't scale moving forward.
		// Create the card layout container.
		CardLayout cardLayout = new CardLayout();
		JPanel container = new JPanel(cardLayout);

		//Create the Controllers next
		InitialControl ic = new InitialControl(container, client); 
		LoginControl lc = new LoginControl(container, client); //Probably will want to pass in ChatClient here
		CreateAccountControl cc = new CreateAccountControl(container,client);
		StartControl sc = new StartControl(container,client);
		ViewRulesControl vrp = new ViewRulesControl(container,client);
		PlayerInfoControl pic = new PlayerInfoControl(container,client);
		GameControl gc = new GameControl(container,client);

		//Set the controllers in ChatClient
	    client.setLoginControl(lc);
	    client.setCreateControl(cc);
	    
	    // should this be server or client? if so, change 
	    client.setStartControl(sc);
	    client.setPlayerInfoControl(pic);
	    
	    client.setGameControl(gc);
	    //server.setGameControl(gc);
	    
		// Create the four views. (need the controller to register with the Panels)
		JPanel view1 = new InitialPanel(ic);
		JPanel view2 = new LoginPanel(lc);
		JPanel view3 = new CreateAccountPanel(cc);
		JPanel view4 = new StartPanel(sc);
		JPanel view5 = new ViewRulesPanel(vrp);
		JPanel view6 = new PlayerInfoPanel(pic);
		JPanel view7 = new GamePanel(gc);

		// Add the views to the card layout container.
		container.add(view1, "1");
		container.add(view2, "2");
		container.add(view3, "3");
		container.add(view4, "4");
		container.add(view5, "5");
		container.add(view6, "6");
		container.add(view7, "7");

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
