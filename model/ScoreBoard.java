/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HP
 */
public class ScoreBoard {

    private int score;
    private int wickets;
    private int balls;

    public ScoreBoard() {
        score = 0;
        wickets = 0;
        balls = 0;
    }

    public void addRuns(int runs) {
        score += runs;
        balls++;
    }

    public void addWicket() {
        wickets++;
        balls++;
    }

    public int getScore() {
        return score;
    }

    public int getWickets() {
        return wickets;
    }

    public int getBalls() {
        return balls;
    }

    public void showScore() {

        System.out.println("Score : "
                + score + "/"
                + wickets
                + " (" + balls + " balls)");

    }

}

    
 
