package team3Project;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class GamePanel extends JPanel
{
	private JButton hit;
	private JButton stand;
	private JButton quit; 
	private JButton play; 
	public JLabel status;
	public JLabel playerScore; 
	private JLabel dealerScore; 

	private player player1;
	private player dealer;
	private deck Deck;
	private card Card;
	private int games;

	//Constructor for Game panel
	public GamePanel(GameControl gc)
	{

		// creates status that is updated by control
		games = 1;
		status = new JLabel("Game " + games, JLabel.CENTER);
		playerScore = new JLabel(" Your Score: 0", JLabel.LEFT);
		dealerScore = new JLabel(" Dealer Score: 0", JLabel.LEFT);
		playerScore.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		dealerScore.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		//Creates hit/stand/quit buttons
		play = new JButton("Play");
		play.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Play();
			}
		});
		hit = new JButton("Hit");
		hit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				Hit();
			}
		});
		stand = new JButton("Stand");
		stand.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				Stand();
			}
		});
		quit = new JButton("Quit");
		quit.addActionListener(gc);

		// create panel for the status
		JPanel labelsTop = new JPanel();
		labelsTop.add(status);

		// create panel for game field
		JPanel gameField = new JPanel(new GridLayout(2, 1, 5, 5));
		gameField.setBackground(Color.green);
		gameField.add(dealerScore);
		gameField.add(playerScore);

		// create panel for buttons
		JPanel buttonsBottom = new JPanel(new GridLayout(2, 2, 5, 5));
		buttonsBottom.add(hit);
		buttonsBottom.add(stand);
		buttonsBottom.add(quit);
		buttonsBottom.add(play);

		//Arrange components on the Panel
		JPanel grid = new JPanel(new BorderLayout());
		grid.setPreferredSize(new Dimension(500,325));    //Added to set the size of the gamefield 
		grid.add(labelsTop, BorderLayout.NORTH);
		grid.add(gameField, BorderLayout.CENTER);
		grid.add(buttonsBottom, BorderLayout.SOUTH);
		this.add(grid);
	}

	private void Play() {
		//System.out.println("Listen Button Pressed");
		status.setText("Game " + games++);
		play.setVisible(false);
		//gc.start();
		player1 = new player();
		dealer = new player();
		Deck = new deck();
		Deck.shuffle();
		for(int i=0;i<2;i++)//give dealer & player first 2 cards
		{
			try {
				Card = Deck.nextCard();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			player1.hand.addCard(Card);
			try {
				Card = Deck.nextCard();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dealer.hand.addCard(Card);

		}
		playerScore.setText(" Your Score: " + player1.hand.calculateTotal());
		dealerScore.setText(" Dealer Score: " + dealer.hand.calculateTotal());//shows innitial scores
	}

	private void Hit() {
		try {
			player1.hand.addCard(Deck.nextCard());
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		playerScore.setText(" Your Score: " + player1.hand.calculateTotal());
		if(player1.hand.calculateTotal() > 21)
		{
			status.setText("You busted, you lose!");
			play.setVisible(true);
			play.setText("Play Again");
			if(play.isSelected())
			{
				Play();
			}
		}
	}

	private void Stand() {
		while(dealer.hand.calculateTotal() < 17)
		{
			try {
				dealer.hand.addCard(Deck.nextCard());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		playerScore.setText(" Your Score: " + player1.hand.calculateTotal());
		dealerScore.setText(" Dealer Score: " + dealer.hand.calculateTotal());
		if(player1.hand.calculateTotal() > dealer.hand.calculateTotal() && player1.hand.calculateTotal() <= 21)
			status.setText("You Win!");
		else if(player1.hand.calculateTotal() <= 21 && dealer.hand.calculateTotal() > 21)
			status.setText("You Win!");
		else
			status.setText("You Lose!");

		play.setVisible(true);
		play.setText("Play Again");
		if(play.isSelected())
		{
			Play();
		}
	}

}