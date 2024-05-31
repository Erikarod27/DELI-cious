package com.pluralsight.deli.screens;

import com.pluralsight.deli.Items.Chips;
import com.pluralsight.deli.Items.Drink;
import com.pluralsight.deli.Items.Order;
import com.pluralsight.deli.Items.Sandwich;

import java.util.List;
import java.util.Scanner;

public class OrderScreen {
    //Instance variables
    private Scanner scanner;
    public List<Sandwich> sandwiches;
    public List<Drink> drinks;
    public List<Chips> chips;
    public List<Order> orders;

    //Order screen method
    public OrderScreen() {
        scanner = new Scanner(System.in);
    }

    //Display method for new order
    public void display() {
        System.out.println("New Order");
        System.out.println("1) Add Sandwich");
        System.out.println("2) Add Drink");
        System.out.println("3) Add Chips");
        System.out.println("4) Checkout");
        System.out.println("0) Cancel Order");
        System.out.print("Choice: ");
        handleInput();
    }

    //Handle input method to display next screen of users choice
    public void handleInput() {
        boolean exit = false;
        scanner = new Scanner(System.in);
        while (!exit) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addSandwich();
                    break;
                case 2:
                    addDrink();
                    break;
                case 3:
                    addChips();
                    break;
                case 4:
                    checkout();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Order cancelled.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    //Add sandwich method that displays addSandwichScreen
    private void addSandwich() {
        AddSandwichScreen addSandwichScreen = new AddSandwichScreen();
        addSandwichScreen.display();
        sandwiches.add(addSandwichScreen.getSelectedSandwich());
    }

    //Add drink method that displays addDrinkScreen
    private void addDrink() {
        AddDrinkScreen addDrinkScreen = new AddDrinkScreen();
        addDrinkScreen.display();
        drinks.add(addDrinkScreen.getSelectedDrink());
    }

    //Add chips method that displays addChipsScreen
    private void addChips() {
        AddChipsScreen addChipsScreen = new AddChipsScreen();
        addChipsScreen.display();
        chips.add(addChipsScreen.getSelectedChips());
    }

    //Checkout method that displays checkout screen
    private void checkout() {
        CheckoutScreen checkoutScreen = new CheckoutScreen();
        checkoutScreen.display();
    }
}
