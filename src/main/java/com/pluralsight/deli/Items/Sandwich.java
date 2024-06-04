package com.pluralsight.deli.Items;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    //Size enum
    public enum Size {Small, Medium, Large}
    //Instance variables
    private Size size;
    private Bread bread;
    private Topping meat, cheese;
    private List<Topping> veggies, sauces;
    private boolean isToasted, extraMeat, extraCheese;

    //Sandwich object constructors
    public Sandwich() {
        this.veggies = new ArrayList<>();
        this.sauces = new ArrayList<>();
    }
    public Sandwich(Size size, Bread bread, Topping meat, Topping cheese, List<Topping> veggies, List<Topping> sauces, boolean isToasted, boolean extraMeat, boolean extraCheese) {
        this.size = size;
        this.bread = bread;
        this.meat = meat;
        this.cheese = cheese;
        this.veggies = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.isToasted = isToasted;
        this.extraMeat = extraMeat;
        this.extraCheese = extraCheese;
    }

    //Getters and setters for sandwich object
    public Size getSize() {
        return size;
    }
    public void setSize(Size size) {
        this.size = size;
    }
    public Bread getBread() {
        return bread;
    }
    public void setBread(Bread bread) {
        this.bread = bread;
    }
    public Topping getMeat() {
        return meat;
    }
    public void setMeat(Topping meat) {
        this.meat = meat;
    }
    public Topping getCheese() {
        return cheese;
    }
    public void setCheese(Topping cheese) {
        this.cheese = cheese;
    }
    public List<Topping> getVeggies() {
        return veggies;
    }
    public void setVeggies(List<Topping> veggies) {
        this.veggies = veggies;
    }
    public List<Topping> getSauces() {
        return sauces;
    }
    public void setSauces(List<Topping> sauces) {
        this.sauces = sauces;
    }
    public boolean isToasted() {
        return isToasted;
    }
    public void setToasted(boolean isToasted) {
        this.isToasted = isToasted;
    }
    public boolean isExtraMeat() {
        return extraMeat;
    }
    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }
    public boolean isExtraCheese() {
        return extraCheese;
    }
    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }
    public void addSauce(Topping sauce){
        this.sauces.add(sauce);
    }
    public void addVeggies(Topping veggies){
        this.veggies.add(veggies);
    }

    //Print sandwich bread method
    public void printBread() {
        System.out.println("Bread: \n- " + bread.toString());
    }

    //Print sandwich meat method
    public void printMeat(){
        System.out.println("Meat: \n - " + this.meat + (this.extraMeat ? " (extra)" : ""));
    }

    //Print sandwich cheese method
    public void printCheese(){
        System.out.println("Cheese: \n- "+ this.cheese + (this.extraCheese ? " (extra)" : ""));
    }

    //Print sandwich veggies method
    public void printVeggies(){
        System.out.println("Veggies: ");
        for (Topping veggies : veggies) {
            System.out.println("- " + veggies);
        }
    }

    //Print sandwich sauces method
    public void printSauces(){
        System.out.println("Sauces: ");
        for (Topping sauces : sauces) {
            System.out.println("- " + sauces);
        }
    }

    //Get price method
    public double getPrice() {
        //Set all prices to 0
        double breadPrice = 0.00;
        double meatPrice = 0.00;
        double cheesePrice = 0.00;
        //Run if small
        if(size.equals(Size.Small)){
            breadPrice = 5.50;
            if (meat != Topping.NONE) {
                meatPrice = 1.00;
                if (isExtraMeat()) {
                    meatPrice += 0.50;
                }
            }
            if (cheese != Topping.NONE) {
                cheesePrice = 0.75;
                if (isExtraCheese()) {
                    cheesePrice += 0.30;
                }
            }
        //Run if medium
        } else if (size.equals(Size.Medium)){
            breadPrice = 7.00;
            if (meat != Topping.NONE) {
                meatPrice = 2.00;
                if (isExtraMeat()) {
                    meatPrice += 1.00;
                }
            }
            if (cheese != Topping.NONE) {
                cheesePrice = 1.50;
                if (isExtraCheese()) {
                    cheesePrice += 0.60;
                }
            }
        //Run if large
        } else {
            breadPrice = 8.50;
            if (meat != Topping.NONE) {
                meatPrice = 3.00;
                if (isExtraMeat()) {
                    meatPrice += 1.50;
                }
            }
            if (cheese != Topping.NONE) {
                cheesePrice = 2.25;
                if (isExtraCheese()) {
                    cheesePrice += 0.90;
                }
            }
        }
        return breadPrice + meatPrice + cheesePrice;
    }

    //Override sandwich toString method
    @Override
    public String toString() {
        return "- BREAD \n   [" + size + " " + bread + " (Toasted: " + isToasted + ")]\n" +
                "- MEAT \n   [" + meat + " (Extra: " + extraMeat + ")]\n" +
                "- CHEESE \n   [" + cheese + " (Extra: " + extraCheese + ")]\n" +
                "- VEGGIES \n   " + veggies + "\n" +
                "- SAUCES \n   " + sauces +"\n" +
                "PRICE: $" + getPrice();
    }
}
