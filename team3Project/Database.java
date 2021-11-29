package team3Project;

import java.io.*;
import java.sql.*;
import java.util.*;

public class Database 
{
	private boolean foundUser;		
	private String key = "key";
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	public Database() throws IOException
	{
		//Create properties object
		  Properties prop = new Properties();
		  FileInputStream fis = new FileInputStream("team3Project/db.properties");
		  prop.load(fis);
		  
		//Get username, password, and url
		String url = prop.getProperty("url");
		String user = prop.getProperty("user");
		String pass = prop.getProperty("password");
			    
		//Set the conn object
		try 
		{
			conn = DriverManager.getConnection(url,user,pass);
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public ArrayList<String> query(String query)
	  {
		  //Create empty ArrayList
		  ArrayList<String> result = new ArrayList<String>();
		  try 
		  {
			stmt = conn.createStatement();	//Using the conn object create a statement object
			rs = stmt.executeQuery(query);	//Using the statement object executeQuery using the input query
			if (!rs.next())
			{
				System.out.println("Result set is empty.");
				return null;
			}
			else
			{
				do
				{
					ResultSetMetaData rmd = rs.getMetaData();
					int no_col = rmd.getColumnCount();
					for (int i=1;i<=no_col;i++)
						result.add(rs.getString(i));
				}while(rs.next());
			}
		}
		  catch (SQLException e) 
		  {
			  e.printStackTrace();
			  return null;	//If no data found -> return null
		  }
		  return result;
	  }
	  
	  public void executeDML(String dml) throws SQLException
	  {
		  try
		  {
			  stmt = conn.createStatement();	//Use the conn object to create statement object
			  stmt.execute(dml);	//Run dml on the execute method of statement
		  }
		  catch (SQLException e) 
		  {
			  e.printStackTrace();
		  }
	  }
	  
	public void findUser(User user) 
	{
		ArrayList<String> result = query(
				"SELECT username, password FROM users "
				+ "WHERE username = \"" + user.getUsername() + "\" "
				+ "AND password = aes_encrypt(\"" + user.getPassword() + "\",\"" + key + "\");");
		if (result == null)
		{
			foundUser = false;
		}
		else 
		{
			foundUser = true;
		}
	}
	
	public void addUser(User user) 
	{
		try
		{
			executeDML("INSERT INTO users " 
					+ "VALUES (\"" + user.getUsername() + "\"," 
					+ "aes_encrypt(\"" + user.getPassword() + "\",\"" + key + "\"),0,0);");
			foundUser = false;
		}
		catch (SQLException e)
		{
			foundUser = true;
		}
	}
	
	
	public boolean getFoundUser()
	{
		return foundUser;
	}
}
