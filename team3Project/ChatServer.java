package team3Project;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class ChatServer extends AbstractServer
{
	//Private data fields
	private JTextArea log;
	private JLabel status;
	private Database database;

	//Constructor
	public ChatServer()
	{
		super(12345);
//		this.setTimeout(500);
	}
	
	void setDatabase(Database database)
	{
		this.database = database;
	}

	// Setter/Getter for the log TextArea
	public void setLog(JTextArea log)
	{
		this.log = log;
	}
	
	public JTextArea getLog()
	{
		return log;
	}

	// Setter/Getter for the status
	public void setStatus(JLabel status)
	{
		this.status = status;
	}
	
	public JLabel getStatus()
	{
		return status;
	}

	// Handle Message From Client
	@Override
	protected void handleMessageFromClient(Object arg0, ConnectionToClient arg1)
	{
		//If client sends log in info to server, checking username and password
		if (arg0 instanceof LoginData)
		{
			log.append("Log In info from Client " + arg1.getId() + "\n");
			
			LoginData loginData = (LoginData)arg0;

			User user = new User(loginData.getUsername(), loginData.getPassword());
			
			database.findUser(user);

			//If can't find user, send error message to client
			if (!database.getFoundUser())
			{
				log.append("Cannot find Client " + arg1.getId() + "\n");
				try
				{
					arg1.sendToClient("Cannot find log in info. Check username/password or create an account.");
				} 
				
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			
			//If user is found, send contacts array list to client
			else 
			{
				log.append("Log in for Client " + arg1.getId() + " successful\n");
				ArrayList<String> contacts = database.getContacts(user);
				try
				{
					arg1.sendToClient(contacts);
				} 
				
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		//If client sends create account info to server, check if username exists
		else if (arg0 instanceof CreateAccountData)
		{
			log.append("Create Account info from Client " + arg1.getId() + "\n");
			
			CreateAccountData createData = (CreateAccountData)arg0;

			User user = new User(createData.getUsername(), createData.getPassword());
			
			log.append("Create Account for Client " + arg1.getId() + " Successful\n");
			user.setID();
			database.addUser(user);
			
			//If can't find username, send CreateAccountData instance to client
			if (!database.getFoundUser())
			{
				try
				{
					arg1.sendToClient(createData);
				} 
				
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			
			//If username found, send error message to client
			else 
			{
				log.append("Username already existed\n");
				try
				{
					arg1.sendToClient("Username already existed.");
				}
				
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	//Listening Exception
	protected void listeningException(Throwable exception) 
	{
		log.append("Listening Exception Occurred: " + exception.getMessage() + "Exception Occurred when Listening\n");
		status.setText("Exception Occurred when Listening");
		exception.printStackTrace();
		status.setForeground(Color.RED);
	}

	//Server Started
	protected void serverStarted()
	{
		log.append("Server Started\n");
		status.setText("Listening");
		status.setForeground(Color.GREEN);
	}

	//Server Stopped
	protected void serverStopped() 
	{
		//Pause for half a second to show message from serverClosed() in case the method is called first
		try
		{
			Thread.sleep(500);
		} 

		catch (InterruptedException e) {}
		
		log.append("Server Stopped Accepting New Clients - Press Listen to Start Accepting New Clients\n");
		status.setText("Stopped");
		status.setForeground(Color.RED);
	}

	//Server Closed
	protected void serverClosed() 
	{
		log.append("Server and all current clients are closed - Press Listen to Restart\n");
		status.setText("Closed");
		status.setForeground(Color.RED);
	}

	//Client Connected
	protected void clientConnected(Object arg0, ConnectionToClient arg1) 
	{
		//Display message in the server log
		log.append("Client " + arg1.getId() + " " + arg0.toString() + "\n");

		//Send the message back to the Client by arg1
		try 
		{
			arg1.sendToClient(arg0.toString());
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
