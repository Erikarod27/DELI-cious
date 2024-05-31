package com.pluralsight.deli.Items;

public class Chips {
    //Instance variables
    private String type;
    private double price;

    //Chip object constructors
    public Chips() {}
    public Chips(String type, double price) {
        this.type = type;
        this.price = price;
    }

    //Getters and setters
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = 1.50;
    }

    //Print chips method
    public void printChips() {
        System.out.println("Chips: " + type);
    }

    //Override chips toString method
    @Override
    public String toString() {
        return "Chips\n" + "Type: " + type;
    }
}
