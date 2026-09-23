/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author HP
 */
import java.util.Scanner;
import java.util.Random;

public class TossManager {
    
    public void startToss() {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("===== HAND CRICKET TOSS =====");

        System.out.println("Choose:");
        System.out.println("1. Head");
        System.out.println("2. Tail");

        int choice = sc.nextInt();

        while(choice != 1 && choice != 2){

            System.out.println("Invalid Input!");
            System.out.print("Enter Again : ");

            choice = sc.nextInt();

        }

        int toss = random.nextInt(2) + 1;

        if(choice == toss){

            System.out.println("You won the toss!");

            System.out.println("Choose:");
            System.out.println("1. Bat");
            System.out.println("2. Bowl");

            int option = sc.nextInt();

            while(option != 1 && option != 2){

                System.out.println("Invalid Choice!");
                option = sc.nextInt();

            }

            if(option == 1){

                System.out.println("You choose Batting.");

            }
            else{

                System.out.println("You choose Bowling.");

            }

        }

        else{

            System.out.println("You lost the toss!");

            int computer = random.nextInt(2)+1;

            if(computer==1){

                System.out.println("Computer chooses Batting.");

            }

            else{

                System.out.println("Computer chooses Bowling.");

            }

        }

    }

}
