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
    private BlackjackFrame frame;
    private final int DRAW_DELAY = 300;
    private final int BLACKJACK = 21;
    private final int NUMBER_OF_STARTING_CARDS = 4;
    
    public BlackjackActions(Player dealer, Player user, Deck deck){
        this.dealer = dealer;
        this.user = user;
        this.deck = deck;
    }
    public void addFrame(BlackjackFrame frame) {
        this.frame = frame;
    }
    public void drawFirstCards(){
        //draw the initial two cards for the player and the dealer     
        int count = 0;
        Timer timer = new Timer(DRAW_DELAY, new drawFirstListener());
        timer.start();
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
        //draw a card and add its value to the score. If the score is greater than or equal to BLACKJACK, the panel changes accordingly.
        Card drawnCard = deck.drawCard();
        player.addCard(drawnCard);
        player.addScore(drawnCard.getValue());
        user.revalidate();
        user.repaint(); 
        
        if (player.getScore() > BLACKJACK) { //If the user busts
            player.bust();
        }
        else if (player.getScore() == BLACKJACK) { //If the user gets a blackjack
            player.blackjack();
        }
    }
    
    public void userHit(){
        //the hit method with code specific to if it is the user hitting
        hit(user);
        if (user.getScore() > BLACKJACK) { //If the user busts
            dealer.loseScreen();
            frame.newGameButtonPanel();
        }
        else if (user.getScore() == BLACKJACK) { //If the user gets a blackjack
            frame.clearButtonPanel();
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
    
    private class drawFirstListener implements ActionListener {
        int count = 0;
        @Override
        public void actionPerformed(ActionEvent event){
            if (count < NUMBER_OF_STARTING_CARDS) {
                if (count % 2 == 0){ userHit(); }
                else{ hit(dealer); }
                count++;
            } 
        }
    }
}
    

