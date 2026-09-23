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
    private String playerName;

    public GameFrame(String playerName) {

        this.playerName = playerName;

        setTitle("Hand Cricket - Game");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gameManager = new GameManager(playerName);

        setLayout(new BorderLayout(10, 10));

        // =========================
        // TOP SECTION
        // =========================

        JLabel titleLabel = new JLabel(
                "HAND CRICKET GAME",
                SwingConstants.CENTER
        );

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 28)
        );

        inningsLabel = new JLabel(
                "FIRST INNINGS - You are batting",
                SwingConstants.CENTER
        );

        inningsLabel.setFont(
                new Font("Arial", Font.BOLD, 16)
        );

        JPanel topPanel = new JPanel(
                new BorderLayout()
        );

        topPanel.add(
                titleLabel,
                BorderLayout.NORTH
        );

        topPanel.add(
                inningsLabel,
                BorderLayout.SOUTH
        );

        add(
                topPanel,
                BorderLayout.NORTH
        );

        // =========================
        // SCOREBOARD
        // =========================

        scoreBoardPanel = new ScoreBoardPanel();

        add(
                scoreBoardPanel,
                BorderLayout.CENTER
        );

        // =========================
        // RUN BUTTONS
        // =========================

        JPanel buttonPanel = new JPanel();

        buttonPanel.setLayout(
                new GridLayout(2, 3, 10, 10)
        );

        runButtons = new JButton[6];

        for (int i = 1; i <= 6; i++) {

            JButton button = new JButton(
                    "Run " + i
            );

            runButtons[i - 1] = button;

            final int chosenNumber = i;

            button.addActionListener(e -> {
                playGame(chosenNumber);
            });

            buttonPanel.add(button);
        }

        add(
                buttonPanel,
                BorderLayout.SOUTH
        );
    }

    // =========================
    // PLAY GAME
    // =========================

    private void playGame(int number) {

        if (gameManager.getCurrentInnings() == 1) {

            playFirstInningsBall(number);

        } else {

            playSecondInningsBall(number);
        }
    }

    // =========================
    // FIRST INNINGS
    // =========================

    private void playFirstInningsBall(int playerRun) {

        String result =
                gameManager.playBall(playerRun);

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

    // =========================
    // SECOND INNINGS START
    // =========================

    private void startSecondInnings() {

        gameManager.startSecondInnings();

        inningsLabel.setText(
                "SECOND INNINGS - Computer batting | Target: "
                + gameManager.getTarget()
        );

        scoreBoardPanel.updateScore(
                0,
                0,
                0
        );

        scoreBoardPanel.updateResult(
                "Now you are bowling. Pick a number."
        );

        JOptionPane.showMessageDialog(
                this,
                "Target for Computer: "
                + gameManager.getTarget()
                + "\n\nNow you are bowling."
                + "\nPick a number for each ball.",
                "Second Innings",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // =========================
    // SECOND INNINGS
    // =========================

    private void playSecondInningsBall(int playerBowl) {

        String result =
                gameManager.playSecondBall(playerBowl);

        scoreBoardPanel.updateResult(result);

        scoreBoardPanel.updateScore(
                gameManager.getComputerScore(),
                gameManager.getComputerWickets(),
                gameManager.getComputerBalls()
        );

        // =========================
        // MATCH OVER
        // =========================

        if (gameManager.isSecondInningsOver()) {

            disableButtons();

            int playerScore =
                    gameManager.getPlayerScore();

            int computerScore =
                    gameManager.getComputerScore();

            String matchResult =
                    gameManager.getMatchResult();

            // Show result message
            JOptionPane.showMessageDialog(
                    this,
                    matchResult,
                    "Match Result",
                    JOptionPane.INFORMATION_MESSAGE
            );

            // Open ResultFrame
            ResultFrame resultFrame =
                    new ResultFrame(
                            playerName,
                            playerScore,
                            computerScore,
                            getWinnerText()
                    );

            resultFrame.setVisible(true);

            // Close GameFrame
            dispose();
        }
    }

    // =========================
    // WINNER TEXT
    // =========================

    private String getWinnerText() {

        int playerScore =
                gameManager.getPlayerScore();

        int computerScore =
                gameManager.getComputerScore();

        if (
                computerScore >= gameManager.getTarget()
        ) {

            return "Computer Wins!";

        } else if (
                computerScore == playerScore
        ) {

            return "Match Tied!";

        } else {

            return "You Win!";
        }
    }

    // =========================
    // DISABLE BUTTONS
    // =========================

    private void disableButtons() {

        for (JButton button : runButtons) {

            button.setEnabled(false);
        }
    }
}