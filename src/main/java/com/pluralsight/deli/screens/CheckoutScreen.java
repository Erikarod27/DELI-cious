package com.pluralsight.deli.screens;

import com.pluralsight.deli.Items.Chips;
import com.pluralsight.deli.Items.Drink;
import com.pluralsight.deli.Items.Order;
import com.pluralsight.deli.Items.Sandwich;

import java.util.Scanner;

public class CheckoutScreen {
    private Scanner scanner;
    private Order order;

    public CheckoutScreen() {}
    public CheckoutScreen(Order order) {
        this.order = order;
        this.scanner = new Scanner(System.in);
    }

    // Display the checkout screen
    public void display() {
        System.out.println("Checkout");
        displayOrderSummary();
        System.out.println("1) Confirm");
        System.out.println("0) Cancel and Return to Order Screen");
        System.out.print("Choice: ");
        handleInput();
    }

    // Handle user input for checkout options
    private void handleInput() {
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                confirmOrder();
                break;
            case 0:
                System.out.println("Returning to Order Screen...");
                break;
            default:
                System.out.println("Invalid choice.");
                display();
                break;
        }
    }

    // Display the order summary
    private void displayOrderSummary() {
        System.out.println("Order Summary:");
        System.out.println("Sandwiches");
        for (Sandwich sandwich : order.getSandwiches()) {
            System.out.println(sandwich);
        }
        System.out.println("Drinks:");
        for (Drink drink : order.getDrinks()) {
            System.out.println("- " + drink);
        }
        System.out.println("Chips:");
        for (Chips chips : order.getChips()) {
            System.out.println("- " + chips);
        }
        System.out.println("Total Price: $" + order.getTotalPrice());
    }

    // Confirm the order and process payment
    private void confirmOrder() {
        System.out.println("Processing...");
        System.out.println("Successful! Thank you for your order.");
        order.clearOrder();
    }
}
