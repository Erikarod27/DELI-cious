package com.pluralsight.deli.Items;

public class Bread {
    //Instance variables
    private String type;

    //Bread object constructor
    public Bread(String type) {
        this.type = type;
    }

    //Getters and setters
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    //Override bread toString method
    @Override
    public String toString() {
        return "Bread: " + type;
    }

}
