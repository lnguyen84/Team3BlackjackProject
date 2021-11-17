package team3Project;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JPanel;

public class CreateAccountControl implements ActionListener
{
	// Private data fields
	private JPanel container;
	private ChatClient client;
	
	// Constructors
	public CreateAccountControl(JPanel container, ChatClient client)
	{
		this.container = container;
	    this.client = client;
	}

	//Handle button clicks
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		// Get action after each click
		String command = ae.getActionCommand();
		
		//The Cancel button takes the user back to the initial panel
				if (command == "Cancel")
				{
					//Reset the create account panel
					CreateAccountPanel createPanel = (CreateAccountPanel)container.getComponent(2);
					createPanel.clearContents();
					
					CardLayout cardLayout = (CardLayout)container.getLayout();
					cardLayout.show(container, "1");
				}

				//The Submit button submits the login information to the server
				else if (command == "Submit")
				{
					//Get the username and password the user entered
					CreateAccountPanel createPanel = (CreateAccountPanel)container.getComponent(2);
					CreateAccountData data = new CreateAccountData(createPanel.getUsername(), createPanel.getPassword(), createPanel.getVerifiedPassword());

					//Check the validity of the info locally
					if (data.getUsername().equals("") || data.getPassword().equals("") || data.getVerifiedPassword().equals(""))
					{
						displayError("Please complete all fields.");
						return;
					}
					else if (data.getPassword().length() < 6)
					{
						displayError("Password needs to be at least 6 characters.");
						return;
					}
					else if (!(data.getPassword().equals(data.getVerifiedPassword())))
					{
						displayError("Password verification error.");
						return;
					}

					//Submit the create info to the server
					try
					{
						client.sendToServer(data);
					} catch (IOException e)
					{
						e.printStackTrace();
					}
				}
			}

	public void createSuccess()
	{	
		CardLayout cardLayout = (CardLayout)container.getLayout();
		cardLayout.show(container, "1");

		//Reset the create account panel
		CreateAccountPanel createPanel = (CreateAccountPanel)container.getComponent(2);
		createPanel.clearContents();
	}

	// Display error message
	public void displayError(String error)
	{
		CreateAccountPanel createPanel = (CreateAccountPanel)container.getComponent(2);
		createPanel.setError(error);
	}
}