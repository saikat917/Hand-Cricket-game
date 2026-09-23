/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import javax.swing.*;
import java.awt.*;

public class MainMenuFrame extends JFrame {

    private JTextField nameField;
    private JButton startButton;
    private JButton exitButton;

    public MainMenuFrame() {

        setTitle("Hand Cricket Game");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // =========================
        // MAIN PANEL
        // =========================

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));

        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        30, 40, 30, 40
                )
        );

        // =========================
        // TITLE
        // =========================

        JLabel titleLabel = new JLabel(
                "HAND CRICKET GAME",
                SwingConstants.CENTER
        );

        titleLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        28
                )
        );

        mainPanel.add(
                titleLabel,
                BorderLayout.NORTH
        );

        // =========================
        // CENTER PANEL
        // =========================

        JPanel centerPanel = new JPanel(
                new GridBagLayout()
        );

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets = new Insets(
                8, 8, 8, 8
        );

        gbc.fill = GridBagConstraints.HORIZONTAL;

        // =========================
        // NAME LABEL
        // =========================

        JLabel nameLabel = new JLabel(
                "Enter Your Name:"
        );

        nameLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        16
                )
        );

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        centerPanel.add(
                nameLabel,
                gbc
        );

        // =========================
        // NAME FIELD
        // =========================

        nameField = new JTextField();

        nameField.setPreferredSize(
                new Dimension(300, 35)
        );

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;

        centerPanel.add(
                nameField,
                gbc
        );

        // =========================
        // START BUTTON
        // =========================

        startButton = new JButton(
                "Start Game"
        );

        startButton.setPreferredSize(
                new Dimension(140, 40)
        );

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;

        centerPanel.add(
                startButton,
                gbc
        );

        // =========================
        // EXIT BUTTON
        // =========================

        exitButton = new JButton(
                "Exit"
        );

        exitButton.setPreferredSize(
                new Dimension(140, 40)
        );

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;

        centerPanel.add(
                exitButton,
                gbc
        );

        mainPanel.add(
                centerPanel,
                BorderLayout.CENTER
        );

        add(mainPanel);

        // =========================
        // START GAME ACTION
        // =========================

        startButton.addActionListener(e -> {

            String playerName =
                    nameField.getText().trim();

            if (playerName.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter your name."
                );

                return;
            }

            TossFrame tossFrame =
                    new TossFrame(playerName);

            tossFrame.setVisible(true);

            dispose();
        });

        // =========================
        // EXIT ACTION
        // =========================

        exitButton.addActionListener(e -> {

            System.exit(0);

        });
    }
}