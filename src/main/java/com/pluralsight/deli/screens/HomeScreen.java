package com.pluralsight.deli.screens;

import java.util.Scanner;

public class HomeScreen {
    //Instance variables
    private Scanner scanner;

    //Display method
    public void display() {
        System.out.println("---- Welcome to DELI-cious ----");
        System.out.println("1) Start Order");
        System.out.println("0) Exit");
        System.out.print("Enter: ");
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
                    System.out.println("Invalid entry");
            }
        }
    }

    //Start new order method
    private void startNewOrder() {
        OrderScreen orderScreen = new OrderScreen();
        orderScreen.display();
    }

}
