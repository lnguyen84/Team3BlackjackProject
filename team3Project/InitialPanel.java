package team3Project;

import java.awt.*;
import javax.swing.*;

public class InitialPanel extends JPanel
{
	private JButton login;
	private JButton create;
	private JButton connect;
	
	// Constructor for the initial panel.
	public InitialPanel(InitialControl ic)
	{
		// Create the information label.
		JLabel label = new JLabel("Account Information", JLabel.CENTER);

		// Create the login button.
		login = new JButton("Log In");
		login.addActionListener(ic);
	
		// Create the create account button.
		create = new JButton("Create");
		create.addActionListener(ic);
		
		//new connect button added in order to connect after setting ip
		connect = new JButton("Connect");
		connect.addActionListener(ic);
		
		//panel to hold buttons
		JPanel buttons = new JPanel();
		
		buttons.add(login);
		buttons.add(create);
		buttons.add(connect);
		//adding ip selection
		JMenuBar jmb = new JMenuBar();
		JMenu jm = new JMenu("Config Options");
		jmb.add(jm);
		JMenuItem sethost = new JMenuItem("Config Connection");
		sethost.addActionListener(ic);
		
		jm.add(sethost);
	
		buttons.add(sethost);

		// Arrange the components in a grid.
		JPanel grid = new JPanel(new GridLayout(3, 1, 5, 5));
		grid.add(label,BorderLayout.NORTH);
		
		grid.add(buttons,BorderLayout.SOUTH);

		//grid.add(jmi);
		this.add(grid);
	}
}
