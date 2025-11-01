/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javablackjack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author user
 */
public class PointsManager {
    private static int points;
    private final static int DEFAULT_POINTS = 1000;
    private static int bet;
    
    public static void addPoints(int additionalPoints) {
        try {
            points += additionalPoints;
            BufferedWriter writer = new BufferedWriter(new FileWriter("Points.txt"));
            writer.write(Integer.toString(points));
            writer.close();
        } catch (IOException ex) {
            System.getLogger(PointsManager.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    public static int getPoints() {
        return points;
    }
    
    public static void setBet(int newBet) {
        bet = newBet;
        points -= bet;
    }
    
    public static int getBet() {
        return bet;
    }
    
    public static void initializePoints() {
        try{
            BufferedReader reader = new BufferedReader(new FileReader("Points.txt"));
            points = Integer.parseInt(reader.readLine());
            reader.close();
        } catch (IOException ex) {
            System.getLogger(PointsManager.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
            
    }
    
        public static void resetPoints() {
        points = DEFAULT_POINTS;
        addPoints(0);
    }
    
    
}
