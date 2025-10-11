/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javablackjack;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author user
 */
public class Card {
    private Rank rank;
    private Suit suit;
    private Icon icon;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
        icon = new ImageIcon(getClass().getResource("./PlayingCards/" + toString() + ".png"));;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
    
    public Icon getIcon() {
        return icon;
    }
    
    public int getValue() {
        return rank.getValue();
    }

    @Override
    public String toString() {
        return (String.format("%sof%s", rank, suit));
    }
    
    
    
}
