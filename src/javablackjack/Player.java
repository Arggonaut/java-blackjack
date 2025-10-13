/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javablackjack;

import java.awt.Font;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
    private int aceCount = 0;
    private int aceFlips = 0;
    private JLabel flippedCardLabel;
    
    public void setScore(int score) {
        this.score = score;
    }
    
    public int getScore() {
        return score;
    }
  
    public String getCards() {
        return playerCards.toString();
    }
    public int getAceCount() {
        return aceCount;
    }
    
    public int getAceFlips() {
        return aceFlips;
    }
    
    public JLabel getFlippedCardLabel() {
        return flippedCardLabel;
    }
    
    public void addCard(Card card) {
        playerCards.add(card);
        add(new JLabel(card.getIcon()));
    }
    
    public void addCard(Card card, String flipped) {
        playerCards.addFirst(card);
        Icon flippedCard = new ImageIcon(getClass().getResource("./PlayingCards/FlippedCard.png"));;
        flippedCardLabel = new JLabel(flippedCard);
        add(flippedCardLabel);
        repaint();
        revalidate();
        System.out.println("kilroy was here");
    }
    
    public void addScore(int score) {
        this.score += score;
    }
    
    public void addAceCount() {
        aceCount += 1;
    }
    
    public void flipAce() {
        score -= 10;
        aceFlips += 1;
    }
    
    public Card flipCard() {
        // change the icon of the flipped card to the face of what the card and return the Card object
        Card flippedCard = playerCards.getFirst();
        add(new JLabel(flippedCard.getIcon()));
        repaint();
        revalidate();
        
        return flippedCard;
    }
    public void returnCards(Deck deck) {
        while (playerCards.isEmpty() == false){
            deck.addCard(playerCards.remove());
        }
        removeAll();
        repaint();
        revalidate();
    }
    
    public void status(String status) {
        // adds the status of the player to the panel
        JLabel statusLabel = new JLabel(status + "!");
        statusLabel.setFont(new Font("Arial", Font.BOLD, 30));
        add(statusLabel);
        repaint();
        revalidate();
    }
    
    public void winLoseScreen(String status) {
        // changes the panel to a win/lose screen
        removeAll();
        JLabel loseLabel = new JLabel("YOU " + status + "!", SwingConstants.CENTER);
        loseLabel.setFont(new Font("Arial", Font.BOLD, 50));
        add(loseLabel);
        repaint();
        revalidate();
    }
}
