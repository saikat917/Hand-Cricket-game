/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import model.player;
import model.ScoreBoard;

public class GameManager {

    private player user;
    private player computer;

    private ScoreBoard firstScoreBoard;
    private ScoreBoard secondScoreBoard;

    private BattingManager battingManager;
    private BowlingManager bowlingManager;

    private int currentInnings = 1;
    private int target = 0;

    public GameManager(String playerName) {

        user = new player(playerName);
        computer = new player("Computer");

        firstScoreBoard = new ScoreBoard();
        secondScoreBoard = new ScoreBoard();

        battingManager = new BattingManager(user, firstScoreBoard);
        bowlingManager = new BowlingManager(computer, secondScoreBoard);
    }

    // ==============================
    // OLD CONSOLE MATCH (unchanged)
    // ==============================

    public void startMatch() {

        System.out.println();
        System.out.println("================================");
        System.out.println("       HAND CRICKET MATCH");
        System.out.println("================================");

        System.out.println();
        System.out.println("FIRST INNINGS");
        System.out.println("You are batting.");

        battingManager.startInnings();

        int consoleTarget = firstScoreBoard.getScore() + 1;

        System.out.println();
        System.out.println("Target for Computer: " + consoleTarget);

        System.out.println();
        System.out.println("SECOND INNINGS");
        System.out.println("Computer is batting.");

        bowlingManager.startBowling(consoleTarget);

        determineWinnerConsole(
                firstScoreBoard.getScore(),
                secondScoreBoard.getScore()
        );
    }

    private void determineWinnerConsole(int playerScore, int computerScore) {

        System.out.println();
        System.out.println("================================");
        System.out.println("           MATCH RESULT");
        System.out.println("================================");

        System.out.println("Your Score: " + playerScore);
        System.out.println("Computer Score: " + computerScore);

        if (computerScore >= playerScore + 1) {
            System.out.println("Computer wins!");
        } else {
            System.out.println("You win!");
        }
    }

    // ==============================
    // GUI GAME METHODS - FIRST INNINGS
    // ==============================

    public String playBall(int playerRun) {
        return battingManager.playSingleBall(playerRun);
    }

    public boolean isInningsOver() {
        return battingManager.isInningsOver();
    }

    public int getPlayerScore() {
        return battingManager.getScore();
    }

    public int getWickets() {
        return battingManager.getWickets();
    }

    public int getBalls() {
        return battingManager.getBalls();
    }

    // ==============================
    // GUI GAME METHODS - SECOND INNINGS
    // ==============================

    public void startSecondInnings() {

        target = battingManager.getScore() + 1;
        currentInnings = 2;

        bowlingManager.setTarget(target);
    }

    public String playSecondBall(int playerBowl) {
        return bowlingManager.playSingleBall(playerBowl);
    }

    public boolean isSecondInningsOver() {
        return bowlingManager.isInningsOver();
    }

    public int getComputerScore() {
        return bowlingManager.getScore();
    }

    public int getComputerWickets() {
        return bowlingManager.getWickets();
    }

    public int getComputerBalls() {
        return bowlingManager.getBalls();
    }

    public int getTarget() {
        return target;
    }

    public int getCurrentInnings() {
        return currentInnings;
    }

    // ==============================
    // WINNER DETERMINATION - GUI
    // ==============================

    public String getMatchResult() {

        int playerScore = battingManager.getScore();
        int playerWickets = battingManager.getWickets();
        int compScore = bowlingManager.getScore();
        int compWickets = bowlingManager.getWickets();

        StringBuilder result = new StringBuilder();

        result.append("Your Score: ")
                .append(playerScore)
                .append("/")
                .append(playerWickets)
                .append("\n");

        result.append("Computer Score: ")
                .append(compScore)
                .append("/")
                .append(compWickets)
                .append("\n\n");

        if (compScore >= target) {
            result.append("Computer wins!");
        } else if (compScore == playerScore) {
            result.append("Match Tied!");
        } else {
            result.append("You win!");
        }

        return result.toString();
    }
}