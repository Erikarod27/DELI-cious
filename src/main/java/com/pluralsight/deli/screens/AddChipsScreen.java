package com.pluralsight.deli.screens;

import com.pluralsight.deli.Items.Chips;
import com.pluralsight.deli.Items.Sandwich;

import java.util.Scanner;

public class AddChipsScreen {
    //Instance variables
    private Scanner scanner;
    private Chips chips = new Chips();

    //Add chips method
    public AddChipsScreen() {
        scanner = new Scanner(System.in);
    }

    //Display method for add chips screen
    public void display() {
        System.out.println("Add Chips");
        System.out.println("1) Add");
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
                System.out.println("Invalid choice");
                break;
        }
    }

    private void selectType() {
        System.out.println("Select Type");
        System.out.println("1) Potato Chips");
        System.out.println("2) Pretzels");
        System.out.println("3) Veggie Stix");
        System.out.print("4) Doritos");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                chips.setType("Potato Chips");
                break;
            case 2:
                chips.setType("Pretzels");
                break;
            case 3:
                chips.setType("Veggie Stix");
                break;
            case 4:
                chips.setType("Doritos");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        chips.printChips();
        confirmOrder();
    }


    // Confirm order method
    private void confirmOrder() {
        System.out.println("Chips added to order");
        System.out.println("1) Add sandwich");
        System.out.println("2) Add chips");
        System.out.println("3) Add drink");
        System.out.println("4) Checkout");
        System.out.println("0) Cancel");
        System.out.print("Choice: ");
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
                System.out.println("Invalid choice");
                confirmOrder();
                break;
        }
    }

    public Chips getSelectedChips() {
        return chips;
    }
}
