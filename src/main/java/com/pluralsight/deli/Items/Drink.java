package com.pluralsight.deli.Items;

public class Drink {
    //Size enum
    public enum Size { Small, Medium, Large}
    //Instance variables
    private Size size;
    private String type;
    private double price;

    //Drink object constructors
    public Drink(){}
    public Drink(Size size, String type) {
        this.size = size;
        this.type = type;
        calculatePrice();
    }

    //Getters and setters
    public Size getSize() {
        return size;
    }
    public void setSize(Size size) {
        this.size = size;
        calculatePrice();
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getPrice() {
        return price;
    }

    //Calculate price method depending on drink size
    public void calculatePrice() {
        switch (size) {
            case Small:
                price = 2.00;
                break;
            case Medium:
                price = 2.50;
                break;
            case Large:
                price = 3.00;
                break;
        }
    }

    //Print drink method
    public void printDrink() {
        System.out.println("Drink: " + size + " " + type);
    }

    //Override drink toString method
    @Override
    public String toString() {
        return "   [" + size + " " + type + "]\n" +
                "PRICE: $" + price;
    }
}
