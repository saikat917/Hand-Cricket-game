/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
import javax.swing.SwingUtilities;
import ui.MainMenuFrame;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            MainMenuFrame mainMenu = new MainMenuFrame();

            mainMenu.setVisible(true);
        });
    }
}