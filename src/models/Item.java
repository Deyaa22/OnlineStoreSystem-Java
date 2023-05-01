package models;

import utils.Utils;

public class Item {

    protected final int number;
    protected final String name;
    protected final float price;
    protected final ItemType type;
    protected int quantity = 0;

    public static enum ItemType {
        Book,
        Shoes,
        Game
    }

    public Item(int number, String name, float price, ItemType type, int quantity) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
    }

    public void addQuantity(int newQuantity) {
        quantity += newQuantity;
    }

    // Getters
    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public ItemType getType() {
        return type;
    }

    public String FullDetails() {
        return String.valueOf(number) + " " + name + Utils.putTextInSquareBrackets(String.valueOf(quantity));
    }

    // Getters and Settters  
    public int getQuantity() {
        return quantity;
    }
}
