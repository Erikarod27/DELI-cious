package com.pluralsight.deli.screens;

import java.util.Scanner;

public class HomeScreen {
    private Scanner scanner;

    public void display() {
        System.out.println("Welcome to DELI-cious");
        System.out.println("1) New Order");
        System.out.println("0) Exit");
        System.out.print("Choice: ");
        handleInput();
    }

    public void handleInput() {
        boolean exit = false;
        scanner = new Scanner(System.in);
        while (!exit) {

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    startNewOrder();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Thank you for using DELI-cious POS!");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void startNewOrder() {
        OrderScreen orderScreen = new OrderScreen();
        orderScreen.display();
    }

}
