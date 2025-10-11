/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javablackjack;

import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class BlackjackFrame extends JFrame {
    //This class handles all of the java swing for the app
    private final JPanel dealerPanel;
    private final JPanel playerPanel;
    
    public BlackjackFrame() {
        super("Blackjack");
        setLayout(new GridLayout(3,1)); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        
        //Top Panel - where the dealer's cards go
        dealerPanel = new JPanel();
        
        //Middle Panele - where the player's cards go
        playerPanel = new JPanel();
        
    }
    
    public void resetFrame() {
        
        
        
        
    }
}
