package com.pluralsight.deli.Items;

import java.util.ArrayList;
import java.util.List;

public class Order {
    //Instance variables
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;
    private double totalPrice;

    //Order object constructors
    public Order(){}

    public Order(List<Sandwich> sandwiches, List<Drink> drinks, List<Chips> chips) {
        sandwiches = new ArrayList<>();
        drinks = new ArrayList<>();
        chips = new ArrayList<>();
        totalPrice = 0.0;
    }

    //Add sandwich to order method
    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
        totalPrice += sandwich.getPrice();
    }

    //Add drink to order method
    public void addDrink(Drink drink) {
        drinks.add(drink);
        totalPrice += drink.getPrice();
    }

    //Add chips to order method
    public void addChips(Chips chips) {
        this.chips.add(chips);
        totalPrice += chips.getPrice();
    }

    //Get the total price of order method
    public double getTotalPrice() {
        return totalPrice;
    }

    //Get the list of sandwiches method
    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    //Get the list of drinks method
    public List<Drink> getDrinks() {
        return drinks;
    }

    //Get the list of chips method
    public List<Chips> getChips() {
        return chips;
    }

    //Clear order method
    public void clearOrder() {
        sandwiches.clear();
        drinks.clear();
        chips.clear();
        totalPrice = 0.0;
    }
}
