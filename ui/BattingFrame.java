/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class BattingFrame extends JFrame {

    private JLabel scoreLabel;
    private JLabel ballLabel;
    private JLabel resultLabel;

    private JButton[] runButtons;

    private int score = 0;
    private int balls = 0;
    private int wickets = 0;

    private final int MAX_BALLS = 6;

    public BattingFrame() {

        setTitle("Hand Cricket - Batting");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        panel.setLayout(
                new GridLayout(10, 1, 10, 10)
        );

        JLabel titleLabel = new JLabel(
                "BATTING",
                SwingConstants.CENTER
        );

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 28)
        );

        scoreLabel = new JLabel(
                "Score: 0/0",
                SwingConstants.CENTER
        );

        ballLabel = new JLabel(
                "Balls: 0/6",
                SwingConstants.CENTER
        );

        resultLabel = new JLabel(
                "Choose your run (1-6)",
                SwingConstants.CENTER
        );

        panel.add(titleLabel);
        panel.add(scoreLabel);
        panel.add(ballLabel);
        panel.add(resultLabel);

        runButtons = new JButton[6];

        for (int i = 1; i <= 6; i++) {

            JButton runButton =
                    new JButton("Run " + i);

            runButtons[i - 1] = runButton;

            final int playerRun = i;

            runButton.addActionListener(e -> {

                playBall(playerRun);

            });

            panel.add(runButton);
        }

        add(panel);
    }

    private void playBall(int playerRun) {

        // Stop after 6 balls
        if (balls >= MAX_BALLS) {

            resultLabel.setText(
                    "Innings already completed!"
            );

            return;
        }

        Random random = new Random();

        int computerRun =
                random.nextInt(6) + 1;

        balls++;

        // Wicket
        if (playerRun == computerRun) {

            wickets++;

            resultLabel.setText(
                    "OUT! Computer played " +
                    computerRun
            );

        } 
        
        // Runs
        else {

            score += playerRun;

            resultLabel.setText(
                    "You scored " +
                    playerRun +
                    " | Computer played " +
                    computerRun
            );
        }

        updateScoreboard();

        // Disable buttons after 6 balls
        if (balls >= MAX_BALLS) {

            disableRunButtons();

            resultLabel.setText(
                    "INNINGS OVER! Final Score: "
                    + score + "/" + wickets
            );
        }
    }

    private void updateScoreboard() {

        scoreLabel.setText(
                "Score: " + score + "/" + wickets
        );

        ballLabel.setText(
                "Balls: " + balls + "/" + MAX_BALLS
        );
    }

    private void disableRunButtons() {

        for (JButton button : runButtons) {

            button.setEnabled(false);
        }
    }
}