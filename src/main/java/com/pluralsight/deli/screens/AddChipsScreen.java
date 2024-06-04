package com.pluralsight.deli.screens;

import com.pluralsight.deli.Items.Chips;
import com.pluralsight.deli.Items.Order;

import java.util.Scanner;

public class AddChipsScreen {
    //Instance variables
    private Scanner scanner;
    private Chips chips = new Chips();
    private Order order = new Order();

    //Add chips screen constructor method
    public AddChipsScreen() {
        scanner = new Scanner(System.in);
    }

    //Display method for add chips screen
    public void display() {
        System.out.println("---- Add Chips ----");
        System.out.println("1) Continue");
        System.out.println("0) Return");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                selectType();
                break;
            case 0:
                System.out.println("Returning...");
                break;
            default:
                System.out.println("Invalid entry");
                break;
        }
    }

    //Select type of chips method
    private void selectType() {
        System.out.println("Select Type");
        System.out.println("1) Potato Chips");
        System.out.println("2) Pretzels");
        System.out.println("3) Veggie Sticks");
        System.out.print("4) Doritos");
        System.out.print("Enter: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                chips.setType("Potato Chips");
                break;
            case 2:
                chips.setType("Pretzels");
                break;
            case 3:
                chips.setType("Veggie Sticks");
                break;
            case 4:
                chips.setType("Doritos");
                break;
            default:
                System.out.println("Invalid entry");
                break;
        }
        chips.printChips();
        order.addChips(chips);
        confirmOrder();
    }

    //Confirm order method
    private void confirmOrder() {
        System.out.println("Chips added to order");
        System.out.println("1) Add sandwich");
        System.out.println("2) Add chips");
        System.out.println("3) Add drink");
        System.out.println("4) Checkout");
        System.out.println("0) Cancel");
        System.out.print("Enter: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                AddSandwichScreen addSandwichScreen = new AddSandwichScreen();
                addSandwichScreen.display();
                break;
            case 2:
                chips = new Chips();
                display();
                break;
            case 3:
                AddDrinkScreen addDrinkScreen = new AddDrinkScreen();
                addDrinkScreen.display();
                break;
            case 4:
                CheckoutScreen checkoutScreen = new CheckoutScreen();
                checkoutScreen.display();
                break;
            case 0:
                System.out.println("Cancelling...");
                break;
            default:
                System.out.println("Invalid entry");
                confirmOrder();
                break;
        }
    }

    //Get chips method
    public Chips getSelectedChips() {
        return chips;
    }
}
