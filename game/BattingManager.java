/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.util.Random;
import java.util.Scanner;
import model.player;
import model.ScoreBoard;

public class BattingManager {

    private player player;
    private ScoreBoard scoreBoard;

    // GUI-related state
    private int balls = 0;
    private boolean out = false;
    private final int MAX_BALLS = 6;

    public BattingManager(player player, ScoreBoard scoreBoard) {
        this.player = player;
        this.scoreBoard = scoreBoard;
    }

    // ==============================
    // OLD CONSOLE VERSION (unchanged)
    // ==============================

    public void startInnings() {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int consoleBalls = 0;

        System.out.println("================================");
        System.out.println("       BATTING INNINGS");
        System.out.println("================================");

        while (consoleBalls < 6) {

            System.out.println();
            System.out.println("Choose your run (1-6): ");

            int playerRun = sc.nextInt();

            while (playerRun < 1 || playerRun > 6) {

                System.out.println("Invalid input!");
                System.out.println("Please enter a number between 1 and 6:");

                playerRun = sc.nextInt();
            }

            int computerRun = random.nextInt(6) + 1;

            System.out.println("Computer played: " + computerRun);

            consoleBalls++;

            if (playerRun == computerRun) {

                System.out.println("WICKET!");
                System.out.println("Your innings is over.");

                player.addWicket();
                scoreBoard.addWicket();

                break;

            } else {

                player.addRuns(playerRun);
                scoreBoard.addRuns(playerRun);

                System.out.println("You scored: " + playerRun);
            }

            System.out.println(
                    "Current Score: "
                    + scoreBoard.getScore()
                    + "/"
                    + scoreBoard.getWickets()
            );

            System.out.println("Balls: " + consoleBalls);
        }

        System.out.println();
        System.out.println("================================");
        System.out.println("         INNINGS OVER");
        System.out.println("================================");

        System.out.println(
                "Final Score: "
                + scoreBoard.getScore()
                + "/"
                + scoreBoard.getWickets()
        );

        System.out.println("Balls Played: " + consoleBalls);
    }

    // ==============================
    // NEW GUI VERSION - single ball
    // ==============================

    public String playSingleBall(int playerRun) {

        if (isInningsOver()) {
            return "INNINGS OVER!";
        }

        Random random = new Random();
        int computerRun = random.nextInt(6) + 1;

        balls++;

        if (playerRun == computerRun) {

            out = true;

            player.addWicket();
            scoreBoard.addWicket();

            return "OUT! Computer played " + computerRun;
        }

        player.addRuns(playerRun);
        scoreBoard.addRuns(playerRun);

        return "You scored " + playerRun
                + " | Computer played " + computerRun;
    }

    public boolean isInningsOver() {
        return balls >= MAX_BALLS || out;
    }

    public int getBalls() {
        return balls;
    }

    public int getScore() {
        return scoreBoard.getScore();
    }

    public int getWickets() {
        return scoreBoard.getWickets();
    }
}