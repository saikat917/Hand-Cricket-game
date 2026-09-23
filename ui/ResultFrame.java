/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import javax.swing.*;
import java.awt.*;

public class ResultFrame extends JFrame {

    private JLabel titleLabel;
    private JLabel scoreLabel;
    private JLabel winnerLabel;

    private JButton playAgainButton;
    private JButton exitButton;

    public ResultFrame(
            String playerName,
            int playerScore,
            int computerScore,
            String result
    ) {

        setTitle("Hand Cricket - Match Result");

        setSize(500, 450);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        JPanel panel = new JPanel();

        panel.setLayout(
                new GridLayout(6, 1, 10, 10)
        );

        // Title
        titleLabel = new JLabel(
                "MATCH RESULT",
                SwingConstants.CENTER
        );

        titleLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        28
                )
        );

        // Score
        scoreLabel = new JLabel(
                playerName
                + ": "
                + playerScore
                + "    |    Computer: "
                + computerScore,
                SwingConstants.CENTER
        );

        scoreLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );

        // Winner
        winnerLabel = new JLabel(
                result,
                SwingConstants.CENTER
        );

        winnerLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24
                )
        );

        // Buttons
        playAgainButton =
                new JButton("Play Again");

        exitButton =
                new JButton("Exit");

        // Add components
        panel.add(titleLabel);

        panel.add(scoreLabel);

        panel.add(winnerLabel);

        panel.add(
                new JLabel("")
        );

        panel.add(playAgainButton);

        panel.add(exitButton);

        add(panel);

        // Play Again
        playAgainButton.addActionListener(e -> {

            MainMenuFrame mainMenu =
                    new MainMenuFrame();

            mainMenu.setVisible(true);

            dispose();
        });

        // Exit
        exitButton.addActionListener(e -> {

            System.exit(0);

        });
    }
}