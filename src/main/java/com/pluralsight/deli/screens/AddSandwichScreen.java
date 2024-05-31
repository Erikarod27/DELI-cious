package com.pluralsight.deli.screens;

import com.pluralsight.deli.Items.Bread;
import com.pluralsight.deli.Items.Sandwich;
import com.pluralsight.deli.Items.Topping;

import java.util.Scanner;

public class AddSandwichScreen {
    //Instance variables
    private Scanner scanner;
    private Sandwich sandwich = new Sandwich();

    //Add sandwich screen method
    public AddSandwichScreen() {
        this.scanner = new Scanner(System.in);
    }

    //Display method for add sandwich screen
    public void display() {
        System.out.println("Add Sandwich");
        System.out.println("+ Bread");
        System.out.println("+ Size");
        System.out.println("+ Toppings");
        System.out.println("+ Sauces");
        System.out.println("+ Toasting");
        System.out.println("1) Add");
        System.out.println("0) Cancel");
        System.out.print("Choice: ");
        handleInput();
    }

    //Handle input method to display next prompt from users choice
    private void handleInput() {
        boolean done = false;
        while (!done) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    selectBread();
                    break;
                case 0:
                    System.out.println("Cancelling...");
                    break;
                default:
                    System.out.println("Invalid choice");
                    return;
            }
        }
    }

    //Select bread method
    private void selectBread() {
        System.out.println("Select Bread");
        System.out.println("1) White");
        System.out.println("2) Wheat");
        System.out.println("3) Rye");
        System.out.println("4) Wrap");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                sandwich.setBread(new Bread("White"));
                break;
            case 2:
                sandwich.setBread(new Bread("Wheat"));
                break;
            case 3:
                sandwich.setBread(new Bread("Rye"));
                break;
            case 4:
                sandwich.setBread(new Bread("Wrap"));
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }
        sandwich.printBread();
        selectSize();
    }

    //Select size method
    private void selectSize() {
        System.out.println("Select Size");
        System.out.println("1) 4\" Small");
        System.out.println("2) 8\" Medium");
        System.out.println("3) 12\" Large");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        String breadSize;
        switch (choice) {
            case 1:
                sandwich.setSize(Sandwich.Size.Small);
                breadSize = "Small 4\"";
                break;
            case 2:
                sandwich.setSize(Sandwich.Size.Medium);
                breadSize = "Medium 8\"";
                break;
            case 3:
                sandwich.setSize(Sandwich.Size.Large);
                breadSize = "Large 12\"";
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }
        System.out.println("Size : " + breadSize);
        selectToppings();
        }

    //Select toppings method that lets user add different toppings
    private void selectToppings() {
        System.out.println("Add Toppings");
        addMeat();
    }

    //Add meat topping method
    private void addMeat() {
        System.out.println("Select Meat");
        System.out.println("1) Steak");
        System.out.println("2) Ham");
        System.out.println("3) Salami");
        System.out.println("4) Roast Beef");
        System.out.println("5) Chicken");
        System.out.println("6) Bacon");
        System.out.println("7) No Meat");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        Topping selectedMeat = null;
        switch(choice) {
            case 1:
                selectedMeat = Topping.STEAK;
                break;
            case 2:
                selectedMeat = Topping.HAM;
                break;
            case 3:
                selectedMeat = Topping.SALAMI;
                break;
            case 4:
                selectedMeat = Topping.ROASTBEEF;
                break;
            case 5:
                selectedMeat = Topping.CHICKEN;
                break;
            case 6:
                selectedMeat = Topping.BACON;
                break;
            case 7:
                selectedMeat = Topping.NONE;
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }
        sandwich.setMeat(selectedMeat);
        if (selectedMeat != Topping.NONE) {
            System.out.println("Would you like to add extra meat for an additional charge? (y/n): ");
            String extra = scanner.next();
            if (extra.toLowerCase().equals("y")) {
                sandwich.setExtraMeat(true);
            }
        }
        sandwich.printMeat();
        addCheese();
    }

    //Add cheese topping method
    private void addCheese() {
        System.out.println("Select Cheese");
        System.out.println("1) American");
        System.out.println("2) Provolone");
        System.out.println("3) Cheddar");
        System.out.println("4) Swiss");
        System.out.println("5) No Cheese");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        Topping selectedCheese = null;
        switch(choice) {
            case 1:
                selectedCheese = Topping.AMERICAN;
                break;
            case 2:
                selectedCheese = Topping.PROVOLONE;
                break;
            case 3:
                selectedCheese = Topping.CHEDDAR;
                break;
            case 4:
                selectedCheese = Topping.SWISS;
                break;
            case 5:
                selectedCheese = Topping.NONE;
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }
        sandwich.setCheese(selectedCheese);
        if (selectedCheese != Topping.NONE) {
            System.out.print("Would you like to add extra cheese for an additional charge? (y/n): ");
            String extra = scanner.next();
            if (extra.equalsIgnoreCase("y")) {
                sandwich.setExtraCheese(true);
            }
        }
        sandwich.printCheese();
        addVeggies();
    }

    //Add veggies topping method
    private void addVeggies() {
        System.out.println("Select Veggies");
        System.out.println("1) Lettuce");
        System.out.println("2) Peppers");
        System.out.println("3) Onions");
        System.out.println("4) Tomatoes");
        System.out.println("5) Jalapenos");
        System.out.println("6) Cucumbers");
        System.out.println("7) Pickles");
        System.out.println("8) Guacamole");
        System.out.println("9) Mushrooms");
        System.out.println("0) Done");
        boolean done = false;
        while (!done) {
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    sandwich.addVeggies(Topping.LETTUCE);
                    break;
                case 2:
                    sandwich.addVeggies(Topping.PEPPERS);
                    break;
                case 3:
                    sandwich.addVeggies(Topping.ONIONS);
                    break;
                case 4:
                    sandwich.addVeggies(Topping.TOMATOES);
                    break;
                case 5:
                    sandwich.addVeggies(Topping.JALAPENOS);
                    break;
                case 6:
                    sandwich.addVeggies(Topping.CUCUMBERS);
                    break;
                case 7:
                    sandwich.addVeggies(Topping.PICKLES);
                    break;
                case 8:
                    sandwich.addVeggies(Topping.GUACAMOLE);
                    break;
                case 9:
                    sandwich.addVeggies(Topping.MUSHROOMS);
                    break;
                case 0:
                    done = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        sandwich.printVeggies();
        selectSauces();
    }

    //Add sauce topping method
    private void selectSauces() {
        System.out.println("Select Sauces");
        System.out.println("1) Mayonnaise");
        System.out.println("2) Mustard");
        System.out.println("3) Ketchup");
        System.out.println("4) Ranch");
        System.out.println("5) Thousand Islands");
        System.out.println("6) Vinaigrette");
        System.out.println("0) Done");
        boolean done = false;
        while (!done) {
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    sandwich.addSauce(Topping.MAYO);
                    break;
                case 2:
                    sandwich.addSauce(Topping.MUSTARD);
                    break;
                case 3:
                    sandwich.addSauce(Topping.KETCHUP);
                    break;
                case 4:
                    sandwich.addSauce(Topping.RANCH);
                    break;
                case 5:
                    sandwich.addSauce(Topping.THOUSANDISLANDS);
                    break;
                case 6:
                    sandwich.addSauce(Topping.VINAIGRETTE);
                    break;
                case 0:
                    done = true;
                    break;
                default:
                    System.out.println("Invalid choice");
                    return;
            }
        }
        sandwich.printSauces();
        confirmToasting();
    }

    //Confirm toasting method
    private void confirmToasting() {
        System.out.println("Would you like your sandwich toasted? (y/n): ");
        String toasting = scanner.next();
        sandwich.setToasted(toasting.equalsIgnoreCase("y"));
        System.out.println("Toasted: " + (sandwich.isToasted() ? "Yes" : "No"));
        confirmOrder();
    }

    // Confirm order method
    private void confirmOrder() {
        System.out.println("Sandwich added to order");
        System.out.println("1) Add sandwich");
        System.out.println("2) Add chips");
        System.out.println("3) Add drink");
        System.out.println("4) Checkout");
        System.out.println("0) Cancel");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                sandwich = new Sandwich();
                display();
                break;
            case 2:
                AddChipsScreen addChipsScreen = new AddChipsScreen();
                addChipsScreen.display();
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

    //Get sandwich method
    public Sandwich getSelectedSandwich() {
        return sandwich;
    }
}
