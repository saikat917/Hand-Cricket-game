/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import javax.swing.*;
import java.awt.*;

public class MainMenuFrame extends JFrame {

    private JButton startButton;
    private JButton exitButton;

    public MainMenuFrame() {

        setTitle("Hand Cricket Game");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        JLabel titleLabel = new JLabel(
                "HAND CRICKET GAME",
                SwingConstants.CENTER
        );

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 28)
        );

        startButton = new JButton("Start Game");
        exitButton = new JButton("Exit");

        panel.add(titleLabel);
        panel.add(startButton);
        panel.add(exitButton);

        add(panel);

        // Start Game button
        startButton.addActionListener(e -> {

            TossFrame tossFrame = new TossFrame();

            tossFrame.setVisible(true);

            dispose();
        });

        // Exit button
        exitButton.addActionListener(e -> {

            System.exit(0);

        });
    }
}

    