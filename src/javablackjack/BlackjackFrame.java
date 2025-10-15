/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javablackjack;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author user
 */
public class BlackjackFrame extends JFrame {
    //This class handles most of the java swing for the app
    private JPanel topPanel;
    private JLabel winLoseLabel;
    private JPanel buttonPanel;
    private JButton hitButton;
    private JButton standButton;
    private JButton newGameButton;
    private BlackjackActions actions;
    private Player user;
    private Player dealer;
    
    public BlackjackFrame(Player dealer, Player user, BlackjackActions actions) {
        super("JavaBlackjack");
        this.actions = actions;
        this.user = user;
        this.dealer = dealer;
        setLayout(new GridLayout(4,1)); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(720,720);
        
        //top slot - displays status when game ends
        topPanel = new JPanel();
        winLoseLabel = new JLabel();
        winLoseLabel.setHorizontalAlignment(SwingConstants.CENTER);
        topPanel.add(winLoseLabel);
        add(topPanel);
        
        add(dealer);
        add(user);
        
        //bottom slot - the buttons for hit and stand
        buttonPanel = new JPanel();
        hitStandButtonPanel();
        add(buttonPanel);
        
    }
    
    public void clearButtonPanel() {
        buttonPanel.removeAll();
    }
    
    public void clearWinLoseLabel() {
        winLoseLabel.setText("");
        winLoseLabel.repaint();
        winLoseLabel.revalidate();
    }
    
    public void setWinLoseLabel(String text) {
        winLoseLabel.setText("YOU " + text + "!");
        winLoseLabel.setFont(new Font("Arial", Font.BOLD, 50));
        winLoseLabel.repaint();
        winLoseLabel.revalidate();
    }
    
    public void hitStandButtonPanel() {
        clearButtonPanel();
        hitButton = new JButton("HIT");
        standButton = new JButton("STAND");
        buttonPanel.add(hitButton);
        buttonPanel.add(standButton);
        buttonPanel.repaint();
        buttonPanel.revalidate();
    }
    
    public void newGameButtonPanel() {
        clearButtonPanel();
        newGameButton = new JButton("New Game");
        NewGameHandler newGameHandler = new NewGameHandler();
        newGameButton.addActionListener(newGameHandler);
        buttonPanel.add(newGameButton);
        buttonPanel.repaint();
        buttonPanel.revalidate();
    }
    
    public void enableHitStandButtons() {
        HitHandler hitHandler = new HitHandler();
        hitButton.addActionListener(hitHandler);
        StandHandler standHandler = new StandHandler();
        standButton.addActionListener(standHandler);
    }
    
    private class HitHandler implements ActionListener{
        //calls hit from BlackjackActions whenever the hit button is pressed
        @Override
        public void actionPerformed(ActionEvent event){
            actions.userHit();
        }
    }
    
    private class StandHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            clearButtonPanel();
            actions.dealersTurn();
        }
    }
    
    private class NewGameHandler implements ActionListener{
        //calls resetGame from BlackjackActions and switches the buttonPanel back to hit and stand
        @Override
        public void actionPerformed(ActionEvent event){
            actions.resetGame();
            hitStandButtonPanel();
            actions.drawFirstCards();
        }
    }
    
}
