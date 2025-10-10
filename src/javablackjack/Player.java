/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javablackjack;

import java.util.LinkedList;

/**
 *
 * @author user
 */
public class Player {
    private LinkedList<Card> playerCards = new LinkedList<Card>();
    private int score;
    private PlayerState state;
    
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
