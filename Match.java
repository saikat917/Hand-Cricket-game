/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HP
 */
public class Match {

    private player player;
    private ScoreBoard scoreBoard;

    public Match(player player) {

        this.player = player;
        this.scoreBoard = new ScoreBoard();

    }

    public void playBall(int run) {

        player.addRuns(run);
        scoreBoard.addRuns(run);

    }

    public void wicket() {

        player.addWicket();
        scoreBoard.addWicket();

    }

    public void showMatchInfo() {

        player.showStats();
        scoreBoard.showScore();

    }

}

