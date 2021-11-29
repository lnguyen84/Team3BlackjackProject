package team3Project;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GamePanel extends JPanel
{
    private JButton hit;
    private JButton stand;
    private JButton quit; 
    public JLabel status;
    public JLabel playerScore; 
    private JLabel dealerScore; 

    //Constructor for Game panel
    public GamePanel(GameControl gc)
    {
    	// creates status that is updated by control
        status = new JLabel("Your Score: ", JLabel.CENTER);
        playerScore = new JLabel("Your Score: 0", JLabel.LEFT);
        dealerScore = new JLabel("Dealer Score: 0", JLabel.LEFT);
    	
        //Creates hit/stand/quit buttons
        hit = new JButton("Hit");
        hit.addActionListener(gc);
        stand = new JButton("Stand");
        stand.addActionListener(gc);
        quit = new JButton("Quit");
        quit.addActionListener(gc);

        // create panel for the status
        JPanel labelsTop = new JPanel();
        labelsTop.add(status);

        // create panel for game field
        JPanel gameField = new JPanel();
        gameField.setBackground(Color.green);
        gameField.add(dealerScore);
        gameField.add(playerScore);

        // create panel for buttons
        JPanel buttonsBottom = new JPanel(new GridLayout(1, 3, 5, 5));
        buttonsBottom.add(hit);
        buttonsBottom.add(stand);
        buttonsBottom.add(quit);

        //Arrange components on the Panel
        JPanel grid = new JPanel(new BorderLayout());
        grid.setPreferredSize(new Dimension(500,325));    //Added to set the size of the gamefield 
        grid.add(labelsTop, BorderLayout.NORTH);
        grid.add(gameField, BorderLayout.CENTER);
        grid.add(buttonsBottom, BorderLayout.SOUTH);
        this.add(grid);
    }
}