package team3Project;

import java.io.Serializable;

public class CreateAccountData implements Serializable
{
	// Private data fields
	private String username;
	private String password;
	private String verifiedPassword;
	
	// Setter/Getter for username
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	// Setter/Getter for password
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	// Setter/Getter for verifiedPassword
	public void setVerifiedPassword(String verifiedPassword)
	{
		this.verifiedPassword = verifiedPassword;
	}	
	
	public String getVerifiedPassword()
	{
		return verifiedPassword;
	}
	
	// Constructors
	public CreateAccountData(String username, String password, String verifiedPassword)
	{
		setUsername(username);
		setPassword(password);
		setVerifiedPassword(verifiedPassword);
	}
}