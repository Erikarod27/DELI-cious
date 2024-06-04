package com.pluralsight.deli.screens;

import com.pluralsight.deli.Items.Drink;
import com.pluralsight.deli.Items.Order;

import java.util.Scanner;

public class AddDrinkScreen {
    //Instance variables
    private Scanner scanner;
    private Drink drink = new Drink();
    private Order order = new Order();

    //Add drink screen constructor method
    public AddDrinkScreen() {
        scanner = new Scanner(System.in);
    }

    //Display method for add drink screen
    public void display() {
        System.out.println("---- Add Drink -----");
        System.out.println("1) Continue");
        System.out.println("0) Return");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                selectSize();
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

    //Select drink size for drink object
    private void selectSize() {
        System.out.println("Select Size");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");
        System.out.print("Enter: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                drink.setSize(Drink.Size.Small);
                break;
            case 2:
                drink.setSize(Drink.Size.Medium);
                break;
            case 3:
                drink.setSize(Drink.Size.Large);
                break;
            default:
                System.out.println("Invalid entry");
                selectSize();
        }
    }

    //Select drink type for drink object
    private void selectType() {
        System.out.println("Select Type");
        System.out.println("1) Cola");
        System.out.println("2) Lemonade");
        System.out.println("3) Tea");
        System.out.println("4) Water");
        System.out.print("Enter: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                drink.setType("Cola");
                break;
            case 2:
                drink.setType("Lemonade");
                break;
            case 3:
                drink.setType("Tea");
                break;
            case 4:
                drink.setType("Water");
                break;
            default:
                System.out.println("Invalid entry");
                selectType();
        }
        drink.printDrink();
        order.addDrink(drink);
        confirmOrder();
    }

    //Confirm order method
    private void confirmOrder() {
        System.out.println("Drink added to order");
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
                AddChipsScreen addChipsScreen = new AddChipsScreen();
                addChipsScreen.display();
                break;
            case 3:
                drink = new Drink();
                display();
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

    //Get drink method
    public Drink getSelectedDrink() {
        return drink;
    }
}
