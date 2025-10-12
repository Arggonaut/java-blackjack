/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javablackjack;

import java.awt.Font;
import java.util.LinkedList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author user
 */
public class Player extends JPanel{
    private LinkedList<Card> playerCards = new LinkedList<Card>();
    private int score;
    
    public Player() {
        
    }
    
    public void setScore(int score) {
        this.score = score;
    }
    
    public int getScore() {
        return score;
    }
    
    
    public String getCards() {
        return playerCards.toString();
    }
    
    public void addCard(Card card) {
        playerCards.add(card);
        add(new JLabel(card.getIcon()));
    }
    
    public void addScore(int score) {
        this.score += score;
    }
    
    public void returnCards(Deck deck) {
        while (playerCards.isEmpty() == false){
            deck.addCard(playerCards.remove());
        }
        removeAll();
        repaint();
        revalidate();
    }
    
    public void bust() {
        JLabel bustLabel = new JLabel("BUST!");
        add(bustLabel);
    }
    
    public void blackjack() {
        JLabel blackjackLabel = new JLabel("BLACKJACK!");
        add(blackjackLabel);
    }
    
    public void loseScreen() {
        removeAll();
        JLabel loseLabel = new JLabel("YOU LOSE!", SwingConstants.CENTER);
        loseLabel.setFont(new Font("Arial", Font.BOLD, 50));
        add(loseLabel);
        repaint();
        revalidate();
    }
    
}
