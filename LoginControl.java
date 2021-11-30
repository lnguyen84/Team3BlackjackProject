package team3Project;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class LoginControl implements ActionListener
{
	// Private data fields for the container and chat client.
	private JPanel container;
	private ChatClient client;
	private User user;		
	
	// Constructor for the login controller.
	public LoginControl(JPanel container, ChatClient client)
	{
		this.container = container;
		this.client = client;
		user = new User("", "");
	}

	//Handle button clicks
		public void actionPerformed(ActionEvent ae)
		{
			String command = ae.getActionCommand();

			//The Cancel button takes the user back to the initial panel
			if (command == "Cancel")
			{
				LoginPanel loginPanel = (LoginPanel)container.getComponent(1);
				loginPanel.clearContents();
				
				CardLayout cardLayout = (CardLayout)container.getLayout();
				cardLayout.show(container, "1");
			}

			//The Submit button submits the create information to the server
			else if (command == "Submit")
			{
				LoginPanel loginPanel = (LoginPanel)container.getComponent(1);
				LoginData data = new LoginData(loginPanel.getUsername(), loginPanel.getPassword());
				
				if (data.getUsername().equals("") || data.getPassword().equals(""))
				{
					displayError("You must enter a username and password.");
					return;
				}

				try
				{
					client.setUsername(data.getUsername());
					
					client.sendToServer(data);
					
				} 
				
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}

		//After the login is successful, set the User object and display the contacts screen
		public void loginSuccess()
		{
			//Reset the log in panel
			LoginPanel loginPanel = (LoginPanel)container.getComponent(1);
			loginPanel.clearContents();

			CardLayout cardLayout = (CardLayout)container.getLayout();
			cardLayout.show(container, "4");

			//take user to startpanel
			//StartPanel startPanel = (CardLayout)container.getLayout();
			//contactPanel.displayContacts(user, contacts);
		}

		public void displayError(String error)
		{
			LoginPanel loginPanel = (LoginPanel)container.getComponent(1);
			loginPanel.setError(error);
		}
	}