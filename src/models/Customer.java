package models;

import models.Item.ItemType;

public class Customer {

    private int number;
    private String name;
    private ShoppingCart shoppingCart;

    public Customer(int number, String name) {
        this.number = number;
        this.name = name;
        this.shoppingCart = new ShoppingCart();
    }

    // Getters and Setters
    public Item getItem(int itemIndex) {
        return shoppingCart.items.get(itemIndex);
    }
    
    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int itemsCount() {
        return shoppingCart.items.size();
    }
    
    public void addItem(int number, String name, float price, ItemType type, int quantity){
        shoppingCart.addItem(number, name, price, type, quantity);
    }
    public void removeItem(int index) {
        shoppingCart.removeItem(index);
    }

    public boolean noItemsInStore() {
        return itemsCount() == 0;
    }
}
