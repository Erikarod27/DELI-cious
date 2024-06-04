package com.pluralsight.deli.Items;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    //Instance variables
    static List<Sandwich> sandwiches = new ArrayList<>();
    static List<Drink> drinks = new ArrayList<>();
    static List<Chips> chips = new ArrayList<>();
    static double totalPrice;

    //Order object constructors
    public Order(){}
    public Order(List<Sandwich> sandwiches, List<Drink> drinks, List<Chips> chips) {
        this.sandwiches = sandwiches;
        this.drinks = drinks;
        this.chips = chips;
        totalPrice = 0.0;
    }

    //Add sandwich method
    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    //Add drink method
    public void addDrink(Drink drink) {
        drinks.add(drink);
    }


    //Add chips method
    public void addChips(Chips chips) {
        this.chips.add(chips);
    }

    //Get total price of order method
    public double getTotalPrice() {
        return totalPrice;
    }

    public void addTotalPrice(double totalPrice) {
        this.totalPrice += totalPrice;
    }

    //Get list of sandwiches method
    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    //Get list of drinks method
    public List<Drink> getDrinks() {
        return drinks;
    }

    //Get list of chips method
    public List<Chips> getChips() {
        return chips;
    }

    //Save order method
    public void saveOrder() {
        //Get local date and time and format it
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String formattedDateTime = now.format(formatter);
        //Create file name
        String fileName = "receipts/" + formattedDateTime + ".txt";
        Path filePath = Paths.get(fileName);
        //Try/catch block to create file directory if it doesn't exist
        try {
            Files.createDirectories(filePath.getParent());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        //Build the order details
        StringBuilder orderDetails = new StringBuilder();
        orderDetails.append("Order\n");
        //Add sandwiches if not null
        if (sandwiches.size() > 0) {
            orderDetails.append("----------------------\n");
            orderDetails.append("Sandwiches\n");
            for (Sandwich sandwich : sandwiches) {
                orderDetails.append(sandwich.toString() + "\n");
            }
        }
        //Add drinks if not null
        if (drinks.size() > 0) {
            orderDetails.append("----------------------\n");
            orderDetails.append("Drinks\n");
            for (Drink drink : drinks) {
                orderDetails.append(drink.toString() + "\n");
            }
        }
        //Add chips if not null
        if (chips.size() > 0) {
            orderDetails.append("----------------------\n");
            orderDetails.append("Chips\n");
            for (Chips chip : chips) {
                orderDetails.append(chip.toString() + "\n");
            }
        }
        orderDetails.append("--- TOTAL PRICE: $" + totalPrice + " ---\n");
        //Write the order details to the file
        try {
            Files.write(filePath, orderDetails.toString().getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Clear order method
    public void clearOrder() {
        sandwiches.clear();
        drinks.clear();
        chips.clear();
        totalPrice = 0.0;
    }
}
