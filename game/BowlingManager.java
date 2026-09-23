/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.util.Random;
import java.util.Scanner;
import model.player;
import model.ScoreBoard;

public class BowlingManager {

    private player computer;
    private ScoreBoard scoreBoard;

    // GUI-related state
    private int balls = 0;
    private boolean out = false;
    private int target = 0;
    private final int MAX_BALLS = 6;

    public BowlingManager(player computer, ScoreBoard scoreBoard) {
        this.computer = computer;
        this.scoreBoard = scoreBoard;
    }

    // ==============================
    // OLD CONSOLE VERSION (unchanged)
    // ==============================

    public void startBowling(int target) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int consoleBalls = 0;

        System.out.println();
        System.out.println("================================");
        System.out.println("       BOWLING INNINGS");
        System.out.println("================================");

        System.out.println("Target: " + target);

        while (consoleBalls < 6 && scoreBoard.getScore() < target) {

            System.out.println();
            System.out.println("Choose your bowling number (1-6):");

            int playerBowl = sc.nextInt();

            while (playerBowl < 1 || playerBowl > 6) {

                System.out.println("Invalid input!");
                System.out.println("Please enter a number between 1 and 6:");

                playerBowl = sc.nextInt();
            }

            int computerRun = random.nextInt(6) + 1;

            System.out.println("Computer played: " + computerRun);

            consoleBalls++;

            if (playerBowl == computerRun) {

                System.out.println("WICKET!");

                computer.addWicket();
                scoreBoard.addWicket();

                break;

            } else {

                computer.addRuns(computerRun);
                scoreBoard.addRuns(computerRun);

                System.out.println(
                        "Computer scored: " + computerRun
                );
            }

            System.out.println(
                    "Computer Score: "
                    + scoreBoard.getScore()
                    + "/"
                    + scoreBoard.getWickets()
            );

            System.out.println("Balls: " + consoleBalls);
        }

        System.out.println();
        System.out.println("================================");
        System.out.println("       BOWLING INNINGS OVER");
        System.out.println("================================");

        System.out.println(
                "Computer Final Score: "
                + scoreBoard.getScore()
                + "/"
                + scoreBoard.getWickets()
        );
    }

    // ==============================
    // NEW GUI VERSION - single ball
    // ==============================

    public void setTarget(int target) {
        this.target = target;
    }

    public String playSingleBall(int playerBowl) {

        if (isInningsOver()) {
            return "INNINGS OVER!";
        }

        Random random = new Random();
        int computerRun = random.nextInt(6) + 1;

        balls++;

        if (playerBowl == computerRun) {

            out = true;

            computer.addWicket();
            scoreBoard.addWicket();

            return "OUT! Computer tried " + computerRun;
        }

        computer.addRuns(computerRun);
        scoreBoard.addRuns(computerRun);

        if (scoreBoard.getScore() >= target) {
            return "Computer scored " + computerRun
                    + " | TARGET CHASED!";
        }

        return "Computer scored " + computerRun
                + " | You bowled " + playerBowl;
    }

    public boolean isInningsOver() {
        return balls >= MAX_BALLS || out || scoreBoard.getScore() >= target;
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