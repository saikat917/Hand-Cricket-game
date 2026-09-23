/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class TossFrame extends JFrame {

    private JButton headButton;
    private JButton tailButton;

    private JButton batButton;
    private JButton bowlButton;

    private JButton backButton;

    private JLabel resultLabel;
    private JLabel choiceLabel;

    private String playerName;

    public TossFrame(String playerName) {

        this.playerName = playerName;

        setTitle("Hand Cricket - Toss");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        panel.setLayout(
                new GridLayout(9, 1, 10, 10)
        );

        // =========================
        // TITLE
        // =========================

        JLabel titleLabel = new JLabel(
                "TOSS",
                SwingConstants.CENTER
        );

        titleLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        28
                )
        );

        // =========================
        // INSTRUCTION
        // =========================

        JLabel instructionLabel = new JLabel(
                "Choose Head or Tail",
                SwingConstants.CENTER
        );

        // =========================
        // RESULT
        // =========================

        resultLabel = new JLabel(
                "Waiting for your choice...",
                SwingConstants.CENTER
        );

        // =========================
        // CHOICE
        // =========================

        choiceLabel = new JLabel(
                "",
                SwingConstants.CENTER
        );

        // =========================
        // BUTTONS
        // =========================

        headButton = new JButton("Head");

        tailButton = new JButton("Tail");

        batButton = new JButton("Bat");

        bowlButton = new JButton("Bowl");

        backButton = new JButton("Back");

        // Hide Bat and Bowl initially
        batButton.setVisible(false);
        bowlButton.setVisible(false);

        // =========================
        // ADD COMPONENTS
        // =========================

        panel.add(titleLabel);

        panel.add(instructionLabel);

        panel.add(headButton);

        panel.add(tailButton);

        panel.add(resultLabel);

        panel.add(choiceLabel);

        panel.add(batButton);

        panel.add(bowlButton);

        panel.add(backButton);

        add(panel);

        // =========================
        // HEAD BUTTON
        // =========================

        headButton.addActionListener(e -> {

            performToss("Head");

        });

        // =========================
        // TAIL BUTTON
        // =========================

        tailButton.addActionListener(e -> {

            performToss("Tail");

        });

        // =========================
        // BAT BUTTON
        // =========================

        batButton.addActionListener(e -> {

            GameFrame gameFrame =
                    new GameFrame(playerName);

            gameFrame.setVisible(true);

            dispose();
        });

        // =========================
        // BOWL BUTTON
        // =========================

        bowlButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "Bowling mode will be added next."
            );
        });

        // =========================
        // BACK BUTTON
        // =========================

        backButton.addActionListener(e -> {

            MainMenuFrame mainMenuFrame =
                    new MainMenuFrame();

            mainMenuFrame.setVisible(true);

            dispose();
        });
    }

    // =========================
    // TOSS METHOD
    // =========================

    private void performToss(String playerChoice) {

        Random random = new Random();

        String computerChoice;

        if (random.nextBoolean()) {

            computerChoice = "Head";

        } else {

            computerChoice = "Tail";
        }

        // =========================
        // PLAYER WINS TOSS
        // =========================

        if (playerChoice.equals(computerChoice)) {

            resultLabel.setText(
                    "You won the toss! ("
                    + computerChoice
                    + ")"
            );

            choiceLabel.setText(
                    "Choose Bat or Bowl"
            );

            batButton.setVisible(true);

            bowlButton.setVisible(true);

            headButton.setEnabled(false);

            tailButton.setEnabled(false);

        }

        // =========================
        // PLAYER LOSES TOSS
        // =========================

        else {

            resultLabel.setText(
                    "You lost the toss! ("
                    + computerChoice
                    + ")"
            );

            choiceLabel.setText(
                    "Computer will choose Bat/Bowl"
            );

            GameFrame gameFrame =
                    new GameFrame(playerName);

            gameFrame.setVisible(true);

            dispose();
        }
    }
}