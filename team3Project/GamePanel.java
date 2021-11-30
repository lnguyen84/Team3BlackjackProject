package team3Project;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GamePanel extends JPanel
{
    private JButton hit;
    private JButton stand;
    private JButton quit; 
    private JLabel win; 
    private JLabel lose; 

    //Constructor for Game panel
    public GamePanel(GameControl gc)
    {
        //Creates hit/stand/quit buttons
        hit = new JButton("Hit");
        hit.addActionListener(gc);
        JPanel hitBuffer = new JPanel(); 
        hitBuffer.add(hit);

        stand = new JButton("Stand");
        stand.addActionListener(gc);
        JPanel standBuffer = new JPanel();
        standBuffer.add(stand);

        quit = new JButton("Quit");
        quit.addActionListener(gc);
        JPanel quitBuffer = new JPanel();
        quitBuffer.add(quit);

        //Creates win/lose labels
        win = new JLabel("Win", JLabel.CENTER);
        lose = new JLabel("Lose", JLabel.CENTER);

        //Arrange components on the Panel
        JPanel grid = new JPanel(new BorderLayout());
        grid.add(hit, BorderLayout.SOUTH);
        grid.add(stand, BorderLayout.SOUTH);
        grid.add(quit, BorderLayout.NORTH);
        grid.add(win, BorderLayout.CENTER);
        grid.add(lose, BorderLayout.CENTER);
        this.add(grid);

    }
}