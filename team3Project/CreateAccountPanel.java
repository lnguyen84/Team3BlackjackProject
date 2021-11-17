package team3Project;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CreateAccountPanel extends JPanel
{
	// Private data fields
	private JLabel errorLabel;
	private JPasswordField passwordField;
	private JTextField usernameField;
	private JPasswordField verifiedPasswordField;
	private JButton submit;
	private JButton cancel;
	
	// Getter for username
	public String getUsername()
	{
		return usernameField.getText();
	}
		
	// Getter for password
	public String getPassword()
	{
		return new String(passwordField.getPassword());
	}
	
	// Getter for verifiedPassword
	public String getVerifiedPassword()
	{
		return new String(verifiedPasswordField.getPassword());
	}
		
	// Setter for errorLabel
	public void setError(String error)
	{
	    errorLabel.setText(error);
	}
	
	// Constructor
	public CreateAccountPanel(CreateAccountControl cc)
	{
		// Create a panel for the labels at the top of the GUI.
		JPanel labelPanel = new JPanel(new GridLayout(3, 1, 5, 5));

		errorLabel = new JLabel("", JLabel.CENTER);
		errorLabel.setForeground(Color.RED);
		
		JLabel instructionLabel = new JLabel("Enter your username and password to create an account.", JLabel.CENTER);
		JLabel instructionLabel2 = new JLabel("Your password must be at least 6 characters.", JLabel.CENTER);
		
		labelPanel.add(errorLabel);
		labelPanel.add(instructionLabel);
		labelPanel.add(instructionLabel2);

		// Create a panel for the login information form.
		JPanel loginPanel = new JPanel(new GridLayout(3, 2, 5, 5));
		
		JLabel usernameLabel = new JLabel("Username:", JLabel.RIGHT);
		usernameField = new JTextField(10);
		
		JLabel passwordLabel = new JLabel("Password:", JLabel.RIGHT);
		passwordField = new JPasswordField(10);
		
		JLabel verifyLabel = new JLabel("Verify Password:", JLabel.RIGHT);
		verifiedPasswordField = new JPasswordField(10);
		
		loginPanel.add(usernameLabel);
		loginPanel.add(usernameField);
		loginPanel.add(passwordLabel);
		loginPanel.add(passwordField);
		loginPanel.add(verifyLabel);
		loginPanel.add(verifiedPasswordField);
		
		// Create a panel for the buttons.
		JPanel buttonPanel = new JPanel();
		
		submit = new JButton("Submit");
		submit.addActionListener(cc);
		
		cancel = new JButton("Cancel");
		cancel.addActionListener(cc);

		buttonPanel.add(submit);
		buttonPanel.add(cancel);

		//Arrange the three panels in a grid
		JPanel grid = new JPanel(new GridLayout(3, 1, 0, 10));
		grid.add(labelPanel);
		grid.add(loginPanel);
		grid.add(buttonPanel);
		this.add(grid);
	}
	
	public void clearContents()
	{
		usernameField.setText("");
		passwordField.setText("");
		verifiedPasswordField.setText("");
	}
}