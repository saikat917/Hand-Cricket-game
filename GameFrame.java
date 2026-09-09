/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import javax.swing.*;
import java.awt.*;
import game.GameManager;

public class GameFrame extends JFrame {

    private ScoreBoardPanel scoreBoardPanel;
    private JButton[] runButtons;
    private JLabel inningsLabel;

    private GameManager gameManager;

    public GameFrame() {

        setTitle("Hand Cricket - Game");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gameManager = new GameManager("Player");

        setLayout(new BorderLayout(10, 10));

        // ==============================
        // TITLE
        // ==============================

        JLabel titleLabel = new JLabel(
                "HAND CRICKET GAME",
                SwingConstants.CENTER
        );
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(titleLabel, BorderLayout.NORTH);

        inningsLabel = new JLabel(
                "FIRST INNINGS - You are batting",
                SwingConstants.CENTER
        );
        inningsLabel.setFont(new Font("Arial", Font.BOLD, 16));
        topPanel.add(inningsLabel, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);

        // ==============================
        // SCOREBOARD
        // ==============================

        scoreBoardPanel = new ScoreBoardPanel();
        add(scoreBoardPanel, BorderLayout.CENTER);

        // ==============================
        // RUN BUTTONS
        // ==============================

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 3, 10, 10));

        runButtons = new JButton[6];

        for (int i = 1; i <= 6; i++) {

            JButton button = new JButton("Run " + i);
            runButtons[i - 1] = button;

            final int chosenNumber = i;

            button.addActionListener(e -> {
                playGame(chosenNumber);
            });

            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.SOUTH);
    }

    // ==============================
    // PLAY GAME (routes to correct innings)
    // ==============================

    private void playGame(int number) {

        if (gameManager.getCurrentInnings() == 1) {
            playFirstInningsBall(number);
        } else {
            playSecondInningsBall(number);
        }
    }

    // ==============================
    // FIRST INNINGS
    // ==============================

    private void playFirstInningsBall(int playerRun) {

        String result = gameManager.playBall(playerRun);

        scoreBoardPanel.updateResult(result);

        scoreBoardPanel.updateScore(
                gameManager.getPlayerScore(),
                gameManager.getWickets(),
                gameManager.getBalls()
        );

        if (gameManager.isInningsOver()) {

            scoreBoardPanel.updateResult(
                    "FIRST INNINGS OVER! Score: "
                    + gameManager.getPlayerScore()
                    + "/"
                    + gameManager.getWickets()
            );

            startSecondInnings();
        }
    }

    // ==============================
    // START SECOND INNINGS
    // ==============================

    private void startSecondInnings() {

        gameManager.startSecondInnings();

        inningsLabel.setText(
                "SECOND INNINGS - Computer batting | Target: "
                + gameManager.getTarget()
        );

        // Reset scoreboard display for second innings
        scoreBoardPanel.updateScore(0, 0, 0);

        JOptionPane.showMessageDialog(
                this,
                "Target for Computer: " + gameManager.getTarget()
                + "\nNow you are bowling. Pick a number each ball.",
                "Second Innings",
                JOptionPane.INFORMATION_MESSAGE
        );

        // Buttons stay enabled — now they act as "bowl number" buttons
    }

    // ==============================
    // SECOND INNINGS
    // ==============================

    private void playSecondInningsBall(int playerBowl) {

        String result = gameManager.playSecondBall(playerBowl);

        scoreBoardPanel.updateResult(result);

        scoreBoardPanel.updateScore(
                gameManager.getComputerScore(),
                gameManager.getComputerWickets(),
                gameManager.getComputerBalls()
        );

        if (gameManager.isSecondInningsOver()) {

            disableButtons();

            String matchResult = gameManager.getMatchResult();

            scoreBoardPanel.updateResult(matchResult);

            JOptionPane.showMessageDialog(
                    this,
                    matchResult,
                    "Match Result",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // ==============================
    // DISABLE BUTTONS
    // ==============================

    private void disableButtons() {
        for (JButton button : runButtons) {
            button.setEnabled(false);
        }
    }
}