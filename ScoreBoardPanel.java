/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import javax.swing.*;
import java.awt.*;

public class ScoreBoardPanel extends JPanel {

    private JLabel scoreLabel;
    private JLabel ballLabel;
    private JLabel resultLabel;

    public ScoreBoardPanel() {

        setLayout(new GridLayout(3, 1, 5, 5));

        scoreLabel = new JLabel(
                "Score: 0/0",
                SwingConstants.CENTER
        );

        ballLabel = new JLabel(
                "Balls: 0/6",
                SwingConstants.CENTER
        );

        resultLabel = new JLabel(
                "Choose your run",
                SwingConstants.CENTER
        );

        scoreLabel.setFont(
                new Font("Arial", Font.BOLD, 22)
        );

        ballLabel.setFont(
                new Font("Arial", Font.BOLD, 18)
        );

        resultLabel.setFont(
                new Font("Arial", Font.PLAIN, 16)
        );

        add(scoreLabel);
        add(ballLabel);
        add(resultLabel);
    }

    public void updateScore(
            int score,
            int wickets,
            int balls
    ) {

        scoreLabel.setText(
                "Score: " + score + "/" + wickets
        );

        ballLabel.setText(
                "Balls: " + balls + "/6"
        );
    }

    public void updateResult(String result) {

        resultLabel.setText(result);
    }
}
