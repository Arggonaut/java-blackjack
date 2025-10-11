/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javablackjack;

/**
 *
 * @author user
 */
public class JavaBlackjack {

    private Player user = new Player();
    private Player dealer = new Player();
    private Deck deck = new Deck();
    private BlackjackFrame frame;
    private BlackjackActions actions;
    
    public JavaBlackjack() {
        frame = new BlackjackFrame(dealer, user);
        actions = new BlackjackActions(dealer, user, deck);
        
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        JavaBlackjack game = new JavaBlackjack();
    }
    
}
