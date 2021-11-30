package team3Project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class ServerGUI extends JFrame
{
	private JLabel status; //Initialized to “Not Connected”
	private JLabel statusLabel;
	private JLabel logLabel;
	private String[] labels = {"Port #", "Timeout"};
	private JTextField[] textFields = new JTextField[labels.length];
	private JTextArea logArea;
	private JScrollPane logScroll;
	private JButton listen;
	private JButton close;
	private JButton stop;
	private JButton quit;
	private JComboBox numOfPlayers;

	private ChatServer server;

	public ServerGUI()
	{
		server = new ChatServer();

		try 
		{
			Database database = new Database();
			server.setDatabase(database);
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}

		this.setTitle("Server");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//---- Panel for status ----
		//Create “Status: Not Connected” label store in North
		JPanel north = new JPanel(new FlowLayout());
		statusLabel = new JLabel("Status: ");
		status = new JLabel("Not Connected");
		status.setForeground(Color.RED);
		north.add(statusLabel);
		north.add(status);
		server.setStatus(status);

		//---- Panel for information ----
		JPanel infoPanel = new JPanel(new FlowLayout());

		//--- Create grid for text fields
		JPanel grid = new JPanel(new GridLayout(textFields.length+1,2,5,5));
		for (int i = 0; i < textFields.length; i++)
		{
			JLabel label = new JLabel(labels[i], JLabel.RIGHT);
			textFields[i] = new JTextField();

			//Add the components into grid
			grid.add(label);
			grid.add(textFields[i]);
		}

		JLabel selectPlayersLabel = new JLabel("# of Players: ");
		selectPlayersLabel.setAlignmentX(RIGHT_ALIGNMENT);
		String players[] = {"1","2","3","4","5"};
		numOfPlayers = new JComboBox(players);
		//numOfPlayers.getSelectedItem();
		grid.add(selectPlayersLabel);
		grid.add(numOfPlayers);

		//Add the grid to the info panel
		infoPanel.add(grid);
		//infoPanel.add(grid2);

		//---- Panel for server log ----
		JPanel logPanel = new JPanel(new FlowLayout());

		//--- Inner panel holds labels and text areas
		JPanel innerLogPanel = new JPanel();
		innerLogPanel.setLayout(new BoxLayout(innerLogPanel, BoxLayout.Y_AXIS));

		//Create logLabel
		JPanel serverLog = new JPanel(new FlowLayout());
		logLabel = new JLabel("Server Log Below", JLabel.CENTER);
		serverLog.add(logLabel);
		innerLogPanel.add(serverLog);	

		//Log text area with scroll pane
		logArea = new JTextArea();
		logArea.setLineWrap(true);
		logScroll = new JScrollPane(logArea);
		logScroll.setPreferredSize(new Dimension(400,200));
		innerLogPanel.add(logScroll);

		//Add the innerLogPanel into logPanel
		logPanel.add(innerLogPanel);

		//---- Center panel holds server info/log ----
		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		center.add(infoPanel);
		center.add(logPanel);
		server.setLog(logArea);

		//---- Panel for buttons ----
		//Create 4 JButtons and store in JPanel south
		JPanel south = new JPanel(new FlowLayout());

		// The "Listen" button
		listen = new JButton("Listen");
		listen.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//System.out.println("Listen Button Pressed");
				for (int j = 0; j < 2; j++)
				{
					if (textFields[j].getText().isEmpty())
					{
						logArea.setText("Port Number/timeout not entered before pressing Listen\n");
					}
				}

				try 
				{
					server.setPort(Integer.parseInt(textFields[0].getText()));
					server.setTimeout(Integer.parseInt(textFields[1].getText()));
					server.listen();
					server.setNumOfPlayers(numOfPlayers.getSelectedIndex() + 1);
				} 

				catch(IOException e1)
				{
					e1.printStackTrace();
				}
			}
		});
		south.add(listen);

		// The "Close" button
		close = new JButton("Close");
		close.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//System.out.println("Close Button Pressed");
				if (server.isListening())
				{
					try 
					{
						server.close();
					} 

					catch (IOException e1) 
					{
						e1.printStackTrace();
					}
				}
				else
				{
					logArea.append("Server is not currently started\n");
				}
			}
		});
		south.add(close);

		// The "Stop" button
		stop = new JButton("Stop");
		stop.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//System.out.println("Stop Button Pressed");
				if (server.isListening())
				{
					server.stopListening();
				}
				else
				{
					logArea.append("Server is not currently started\n");
				}
			}
		});
		south.add(stop);

		// The "Quit" button
		quit = new JButton("Quit");
		quit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		south.add(quit);

		setVisible(true);		

		//---- Putting all north, center, and south panels into one panel ----
		JPanel all = new JPanel();
		all.setLayout(new BoxLayout(all, BoxLayout.Y_AXIS));
		all.add(north);
		all.add(center);
		all.add(south);

		//---- Add JPanel to JFrame ----
		JPanel panel = new JPanel();
		panel.add(all);
		this.add(panel,BorderLayout.CENTER);

		//Display frame
		setSize(450,500);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		new ServerGUI();
	}
}