/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javablackjack;

import java.util.LinkedList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class Player extends JPanel{
    private LinkedList<Card> playerCards = new LinkedList<Card>();
    private int score;
    private PlayerState state;
    
    public Player() {
        
    }
    
    public void setScore(int score) {
        this.score = score;
    }
    
    public void setState(PlayerState state) {
        this.state = state;
    }

    public int getScore() {
        return score;
    }
    
    public PlayerState getState() {
        return state;
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
    }
    
}
