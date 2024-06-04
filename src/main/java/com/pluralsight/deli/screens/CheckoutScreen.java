package com.pluralsight.deli.screens;

import com.pluralsight.deli.Items.Chips;
import com.pluralsight.deli.Items.Drink;
import com.pluralsight.deli.Items.Order;
import com.pluralsight.deli.Items.Sandwich;

import java.util.Scanner;

public class CheckoutScreen {
    //Instance variables
    private Scanner scanner = new Scanner(System.in);
    Order order = new Order();

    //Checkout screen constructor methods
    public CheckoutScreen() {}
    public CheckoutScreen(Order order) {
        this.order = order;
    }

    // Display the checkout screen
    public void display() {
        System.out.println("------ Checkout ------");
        displayOrderSummary();
        System.out.println("1) Confirm");
        System.out.println("0) Cancel and Return to Order Screen");
        System.out.print("Enter: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                confirmOrder();
                break;
            case 0:
                System.out.println("Order cancelled.");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid entry");
                display();
                break;
        }
    }

    // Display the order summary
    private void displayOrderSummary() {
        System.out.println("----Order Summary----");
        if (!order.getSandwiches().isEmpty()) {
            System.out.println("----------------------");
            System.out.println("Sandwiches:");
            for (Sandwich sandwich : order.getSandwiches()) {
                order.addTotalPrice(sandwich.getPrice());
                System.out.println(sandwich);
            }
        }
        if (!order.getDrinks().isEmpty()) {
            System.out.println("----------------------");
            System.out.println("Drinks:");
            for (Drink drink : order.getDrinks()) {
                order.addTotalPrice(drink.getPrice());
                System.out.println(drink);
            }
        }
        if (!order.getChips().isEmpty()) {
            System.out.println("----------------------");
            System.out.println("Chips:");
            for (Chips chips : order.getChips()) {
                order.addTotalPrice(chips.getPrice());
                System.out.println(chips);
            }
        }
        System.out.println("--- TOTAL PRICE: $" + order.getTotalPrice() + " ---");
    }

    // Confirm the order and process payment
    private void confirmOrder() {
        System.out.println("Successful! Thank you for your order.");
        order.saveOrder();
        order.clearOrder();
        System.exit(0);
    }
}
