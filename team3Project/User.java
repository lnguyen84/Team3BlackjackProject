package team3Project;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable
{
	//Private data fields
	private int id;
	private String username;
	private String password;
	private ArrayList<String> contacts;
	static int userID = 0;
	
	//Constructors
	public User(String username, String password)
	{
		this.username = username;
		this.password = password;
		contacts = new ArrayList<String>();
	}
	
	public void addContact(String username)
	{
		contacts.add(username);
	}
	
	public ArrayList<String> getContacts()
	{
		return contacts;
	}
	
	public void setContacts(ArrayList<String> contacts)
	{
		this.contacts = contacts;
	}
	public void setID()
	{
		id = userID;
		userID++;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public int getID()
	{
		return id;
	}
}
