/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HP
 */
public class player {
    private String name;
    private int totalRuns;
    private int ballsPlayed;
    private int wickets;

    public player(String name) {
        this.name = name;
        this.totalRuns = 0;
        this.ballsPlayed = 0;
        this.wickets = 0;
    }

    public String getName() {
        return name;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public int getBallsPlayed() {
        return ballsPlayed;
    }

    public int getWickets() {
        return wickets;
    }

    public void addRuns(int runs) {
        totalRuns += runs;
        ballsPlayed++;
    }

    public void addWicket() {
        wickets++;
    }

    public void showStats() {
        System.out.println("Player Name : " + name);
        System.out.println("Runs : " + totalRuns);
        System.out.println("Balls : " + ballsPlayed);
        System.out.println("Wickets : " + wickets);
    }

}

