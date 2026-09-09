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

    public TossFrame() {

        setTitle("Hand Cricket - Toss");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        panel.setLayout(
                new GridLayout(9, 1, 10, 10)
        );

        JLabel titleLabel = new JLabel(
                "TOSS",
                SwingConstants.CENTER
        );

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 28)
        );

        JLabel instructionLabel = new JLabel(
                "Choose Head or Tail",
                SwingConstants.CENTER
        );

        resultLabel = new JLabel(
                "Waiting for your choice...",
                SwingConstants.CENTER
        );

        choiceLabel = new JLabel(
                "",
                SwingConstants.CENTER
        );

        headButton = new JButton("Head");
        tailButton = new JButton("Tail");

        batButton = new JButton("Bat");
        bowlButton = new JButton("Bowl");

        backButton = new JButton("Back");

        // Initially Bat and Bowl buttons are hidden
        batButton.setVisible(false);
        bowlButton.setVisible(false);

        // Add components to panel
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

        // Head button
        headButton.addActionListener(e -> {

            performToss("Head");

        });

        // Tail button
        tailButton.addActionListener(e -> {

            performToss("Tail");

        });

        // Bat button
        batButton.addActionListener(e -> {

            GameFrame gameFrame =
                    new GameFrame();

            gameFrame.setVisible(true);

            dispose();

        });

        // Bowl button
        bowlButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "Bowling screen will be added next."
            );

        });

        // Back button
        backButton.addActionListener(e -> {

            MainMenuFrame mainMenuFrame =
                    new MainMenuFrame();

            mainMenuFrame.setVisible(true);

            dispose();

        });
    }

    private void performToss(String playerChoice) {

        Random random = new Random();

        String computerChoice;

        if (random.nextBoolean()) {

            computerChoice = "Head";

        } else {

            computerChoice = "Tail";
        }

        // Player wins toss
        if (playerChoice.equals(computerChoice)) {

            resultLabel.setText(
                    "You won the toss! (" +
                    computerChoice + ")"
            );

            choiceLabel.setText(
                    "Choose Bat or Bowl"
            );

            batButton.setVisible(true);
            bowlButton.setVisible(true);

            headButton.setEnabled(false);
            tailButton.setEnabled(false);

        } 
        
        // Player loses toss
        else {

            resultLabel.setText(
                    "You lost the toss! (" +
                    computerChoice + ")"
            );

            choiceLabel.setText(
                    "Computer will choose Bat/Bowl"
            );

            // For now computer chooses Bat
            GameFrame gameFrame =
                    new GameFrame();

            gameFrame.setVisible(true);

            dispose();
        }
    }
}