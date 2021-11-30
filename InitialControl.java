package team3Project;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class InitialControl implements ActionListener
{
	// Private data field for storing the container.
	private JPanel container;
	private ChatClient client;
	// Constructor for the initial controller.
	public InitialControl(JPanel container, ChatClient client)
	{
		this.container = container;
		this.client = client;//adding client features to allow for scaling
	}

	// Handle button clicks.
	public void actionPerformed(ActionEvent ae)
	{
		// Get the name of the button clicked.
		String command = ae.getActionCommand();

		// The Login button takes the user to the login panel.
		 if (command.equals("Log In"))
		    {
		      LoginPanel loginPanel = (LoginPanel)container.getComponent(1);
		      loginPanel.setError("");
		      CardLayout cardLayout = (CardLayout)container.getLayout();
		      cardLayout.show(container, "2");
		    }

		// The Create button takes the user to the create account panel.
		 else if (command.equals("Create"))
		    {
			 	CreateAccountPanel createPanel = (CreateAccountPanel)container.getComponent(2);
		      createPanel.setError("");
		      CardLayout cardLayout = (CardLayout)container.getLayout();
		      cardLayout.show(container, "3");
		    }
		 //added controls for connect button
		 else if (command.equals("Connect")){
			
			 
			 try {
				
				client.openConnection();
				if (client.isConnected()){
					System.out.println("connected");
					client.sendToServer("Connected");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
				
		 }
		 //
		 else if(ae.getSource() instanceof JMenuItem) {
			  String host = JOptionPane.showInputDialog("Enter IP: ", "localhost");
			  if(!(host == null)) {
				  client.setHost(host);
			  }
			  String port =JOptionPane.showInputDialog("Enter Port: ",8300);
			  int realport = Integer.parseInt(port);
			  if (!(port == null)) {
				  client.setPort(realport);
			  }
		  }
		 
		 
	}
}
