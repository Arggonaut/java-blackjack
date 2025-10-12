/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javablackjack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


/**
 *
 * @author user
 */
public class BlackjackActions {
    //This class handles the actions of the blackjack game
    private Player dealer;
    private Player user;
    private Deck deck;
    private final int DRAW_DELAY = 300;
    private final int BLACKJACK = 21;
    
    public BlackjackActions(Player dealer, Player user, Deck deck){
        this.dealer = dealer;
        this.user = user;
        this.deck = deck;
    }
    
    public void drawFirstCards(){
        //draw the initial two cards for the player and the dealer     
        hit(dealer);
        pause(DRAW_DELAY);
        hit(dealer);
        pause(DRAW_DELAY);
        hit(user);
        pause(DRAW_DELAY);
        hit(user);
    }

    public void resetGame(){
        //empty both player and dealer cards back into the deck, shuffles the deck, and resets scores and player states
        user.returnCards(deck);
        dealer.returnCards(deck);
        deck.shuffleDeck();
        user.setScore(0);
        dealer.setScore(0);
        
    }
    
    public void hit(Player player){
        //draw a card and add its value to the score. If the score is over 21, the player state is bust. If the score is 21, the player state is blackjack.
        Card drawnCard = deck.drawCard();
        player.addCard(drawnCard);
        player.addScore(drawnCard.getValue());
        user.revalidate();
        user.repaint(); 
        
        if (player.getScore() > BLACKJACK) { //If the user busts
            player.bust();
            dealer.loseScreen();
        }
        else if (player.getScore() == BLACKJACK) { //If the user gets a blackjack
            player.blackjack();
            dealersTurn();
        }
    }
    
    public void dealersTurn() { //After the user stands or gets a blackjack, the dealer starts drawing cards
       //draw cards until either the dealer busts or the dealer gets a score that is greater than or equal to the user
       Timer timer = new Timer(DRAW_DELAY, null);
       timer.start();
       timer.addActionListener(lambdaListener -> {
            if (dealer.getScore() < BLACKJACK && dealer.getScore() < user.getScore()) {
                hit(dealer);
            } 
            else {
                ((Timer) lambdaListener.getSource()).stop();
            }
        });
 
       if (dealer.getScore() > user.getScore() && dealer.getScore() <= BLACKJACK) {
           pause(DRAW_DELAY);
           user.loseScreen();
           
       }
    }
    
    public static void pause(int time) {
        //makes java pause for a certain amount of time in ms
        try {
            Thread.sleep(time);
        }
        catch (InterruptedException e) {
            
        }
    
    }   
}

