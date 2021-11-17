package team3Project;

import java.awt.*;
import javax.swing.*;

public class InitialPanel extends JPanel
{
	private JButton login;
	private JButton create;

	// Constructor for the initial panel.
	public InitialPanel(InitialControl ic)
	{
		// Create the information label.
		JLabel label = new JLabel("Account Information", JLabel.CENTER);

		// Create the login button.
		login = new JButton("Log In");
		login.addActionListener(ic);
		JPanel loginBuffer = new JPanel();
		loginBuffer.add(login);
		
		// Create the create account button.
		create = new JButton("Create");
		create.addActionListener(ic);
		JPanel createBuffer = new JPanel();
		createBuffer.add(create);

		// Arrange the components in a grid.
		JPanel grid = new JPanel(new GridLayout(3, 1, 5, 5));
		grid.add(label);
		grid.add(loginBuffer);
		grid.add(createBuffer);
		this.add(grid);
	}
}
