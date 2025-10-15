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
    private Timer timer = new Timer(DRAW_DELAY, null);
    private int count;
    
    public BlackjackActions(Player dealer, Player user, Deck deck){
        // initializes variables
        this.dealer = dealer;
        this.user = user;
        this.deck = deck;
    }
    public void addFrame(BlackjackFrame frame) {
        // initializes the frame variable
        this.frame = frame;
    }
    public void drawFirstCards(){
        //draw the initial two cards for the player and the dealer
        count = 0;
        timer.addActionListener(new DrawFirstListener());
        timer.start();
    }

    public void resetGame(){
        //empty both player and dealer cards back into the deck, shuffles the deck, and resets scores and player states
        deck.shuffleDeck();
        user.resetPlayer(deck);
        dealer.resetPlayer(deck);
        frame.clearWinLoseLabel();
        
        
    }
    
    public void hit(Player player){
        //draw a card and add its value to the score. If the score is greater than or equal to BLACKJACK, the panel changes accordingly.
        Card drawnCard = deck.drawCard();
        player.addCard(drawnCard);
        user.refresh(); 
        updateScore(player, drawnCard);
    }
    
    public void flipHit(Player player) {
        //the player draws a card face down - the score isn't added until it gets flipped back over
        player.addCard(deck.drawCard(), "flipped");
    }
    
    public void userHit(){
        //the hit method with code specific to if it is the user hitting
        hit(user);
        if (user.getScore() > BLACKJACK) { //If the user busts
            endGame("LOSE!");
            frame.newGameButtonPanel();
        }
        else if (user.getScore() == BLACKJACK) { //If the user gets a blackjack
            frame.clearButtonPanel();
            dealersTurn();
        }
    }
    
    public void dealersTurn() { // After the user stands or gets a blackjack, the dealer starts drawing cards
        //add the value of the flipped card
        dealer.remove(dealer.getFlippedCardLabel());
        Card flippedCard = dealer.flipCard();
        updateScore(dealer, flippedCard);
        

        // draw cards until either the dealer busts or the dealer gets a score that is greater than or equal to the user
        timer.addActionListener(new DealersTurnListener());
        timer.start();
    }
    
    public void updateScore(Player player, Card card) {
        if (card.getRank() == Rank.ACE) {
            player.addAceCount();
        }
        player.addScore(card.getValue());

        if (player.getScore() > BLACKJACK) { //If the user busts
            if (player.getAceCount() > player.getAceFlips()) {
                player.flipAce();
            }
            else {
                player.status("BUST");
            }
        }
        else if (player.getScore() == BLACKJACK) { //If the user gets a blackjack
            player.status("BLACKJACK");
        }
    }
    
    public void resetTimer(ActionListener listener) {
        timer.stop();
        timer.removeActionListener(listener);
    }
    
    public void endGame(String endState) {
        frame.setWinLoseLabel(endState);
        frame.newGameButtonPanel();
    }
    
    private class DrawFirstListener implements ActionListener {
        // alternates between giving a card to the user and then the dealer until 4 cards are dealt
        @Override
        public void actionPerformed(ActionEvent event){
            if (count < NUMBER_OF_STARTING_CARDS) {
                if (count % 2 == 0){ userHit(); }
                else if (count == 1) {hit(dealer); }
                else {flipHit(dealer);}
                count++;
            } 
            else {
                frame.enableHitStandButtons();
                resetTimer(this);
            }
        }
    }
    
    private class DealersTurnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event){
            if (dealer.getScore() < BLACKJACK && dealer.getScore() < user.getScore()) {
                    hit(dealer);
            } 
            
            //if the dealer wins
            else if (dealer.getScore() > user.getScore() && dealer.getScore() <= BLACKJACK) {
                endGame("LOSE");
                resetTimer(this); 
            }
            
            //if the user wins
            else if (dealer.getScore() > BLACKJACK) { 
                endGame("WIN");
                resetTimer(this);
            }
            
            //if both players get the same score
            else if (dealer.getScore() == user.getScore()) {
                endGame("TIE");
                resetTimer(this);
            }
        }
    }
}
    

