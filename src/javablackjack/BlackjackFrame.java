/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javablackjack;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class BlackjackFrame extends JFrame {
    //This class handles all of the java swing for the app
    private JPanel buttonPanel;
    private JButton hitButton;
    private JButton standButton;
    
    
    public BlackjackFrame(Player dealer, Player user) {
        super("Blackjack");
        setLayout(new GridLayout(3,1)); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(720,480);
        
        add(dealer);
        add(user);
        
        //bottom slot - the buttons for hit and stand
        buttonPanel = new JPanel();
        hitButton = new JButton("HIT");
        standButton = new JButton("STAND");
        buttonPanel.add(hitButton);
        buttonPanel.add(standButton);
        add(buttonPanel);
    }
    
    public void resetFrame() {
        
        
        
        
    }
}
