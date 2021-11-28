package team3Project;

import java.util.ArrayList;

import ocsf.client.AbstractClient;

public class ChatClient extends AbstractClient
{
	// Private data fields
	private ArrayList<String> contacts;
	private LoginControl lc;
	private CreateAccountControl cc;
	private StartControl sc;
	private ViewRulesControl vrp;
	private PlayerInfoControl pic;
	private GameControl gc;

	// Constructor
	public ChatClient()
	{
		super("localhost",8300);
	}

	//Setter for login control
	public void setLoginControl(LoginControl lc)
	{
		this.lc = lc;
	}

	//Setter for create account control
	public void setCreateControl(CreateAccountControl cc)
	{
		this.cc = cc;
	}
	
	//Setter for start control
	public void setStartControl(StartControl sc)
	{
		this.sc = sc;
	}
	
	//Setter for view rules control
	public void setViewRulesControl(ViewRulesControl vrp)
	{
		this.vrp = vrp;
	}
	
	//Setter for player information control
	public void setPlayerInfoControl(PlayerInfoControl pic)
	{
		this.pic = pic;
	}
	
	//Setter for game control
	public void setGameControl(GameControl gc)
	{
		this.gc = gc;
	}

	//Getter for contacts
	public ArrayList<String> getContacts()
	{
		return contacts;
	}

	// Handle message from server
	@Override
	public void handleMessageFromServer(Object arg0)
	{
		//if arg0 is null , contacts array list is null
		if (arg0 == null)
		{
			contacts = null;
			lc.loginSuccess();
		}
		//if Server sends back array list of contacts = successful log in
		else if (arg0 instanceof ArrayList)
		{
			contacts = (ArrayList<String>) arg0;
			lc.loginSuccess();
		}
		//if Server sends back a CreateAccountData instance = successful create account
		else if (arg0 instanceof CreateAccountData)
		{
			cc.createSuccess();
		}
		
		//if Server sends back a String = error
		else 
		{
			String error = (String)arg0;

			if (error.equals("Cannot find log in info. Check username/password or create an account."))
			{
				lc.displayError(error);
			}
			else if (error.equals("Username already existed."))
			{
				cc.displayError(error);
			}
		}
	}

	//Connection established
	public void connectionException (Throwable exception) 
	{
		System.out.println("Connection Exception Occurred");
		System.out.println(exception.getMessage());
		exception.printStackTrace();
	}
}
