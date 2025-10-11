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
public class BlackjackActions {
    //This class handles the actions of the blackjack game

    public static void resetGame(Player user, Player dealer, Deck deck){
        //empty both player and dealer cards back into the deck, shuffles the deck, and resets scores and player states
        user.returnCards(deck);
        dealer.returnCards(deck);
        deck.shuffleDeck();
        user.setScore(0);
        dealer.setScore(0);
        user.setState(PlayerState.NORMAL);
        dealer.setState(PlayerState.NORMAL);
        
    }
    
    public void hit(Player player, Deck deck){
        //draw a card and add its value to the score. If the score is over 21, the player state is bust. If the score is 21, the player state is blackjack.
        Card drawnCard = deck.drawCard();
        player.addCard(drawnCard);
        player.addScore(drawnCard.getValue());
        
        if (player.getScore() > 21) {
            player.setState(PlayerState.BUST);
        }
        else if (player.getScore() == 21) {
            player.setState(PlayerState.BLACKJACK);
        }
    }
}
