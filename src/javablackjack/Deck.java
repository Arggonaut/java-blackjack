/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javablackjack;

import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author user
 */
public class Deck {
    private LinkedList<Card> listOfCards = new LinkedList<Card>();
    
    public Deck(){
        for (Suit suit: Suit.values()){
            for (Rank rank: Rank.values()){
		listOfCards.add(new Card(rank, suit));
            }
        }
        shuffleDeck();
    }

    public void addCard(Card card){
        listOfCards.add(card);
    }
    public void shuffleDeck(){
        Collections.shuffle(listOfCards);
    }
    
    public Card drawCard(){
        if (listOfCards.size() == 0){
            throw new IllegalStateException("The deck is empty!");
        }
        else{
            return listOfCards.remove();
        }
    }
    
}
