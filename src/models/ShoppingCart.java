package models;

import java.util.ArrayList;

public class ShoppingCart {

    ArrayList<Item> items = new ArrayList<>();

    private void addItem(Item item) {
        items.add(item);
    }

    public void addItem(int number, String name, float price, Item.ItemType type, int quantity) {
        for (int i = 0; i < items.size(); i++) {
            Item tempItem = items.get(i);
            if (tempItem.getNumber() == number && tempItem.getName().equals(name) && tempItem.getPrice() == price) {
                tempItem.addQuantity(quantity);
                return;
            }
        }
        Item newItem = new Item(number, name, price, type, quantity);
        addItem(newItem);
    }

    public void removeItem(int index) {
        items.remove(index); // .remove(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    // Getters and Setters       
    public Item getItem(int itemNumber) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getNumber() == itemNumber) {
                return items.get(i);
            }
        }
        return null;
    }

    public Item getItem(String itemName) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(itemName)) {
                return items.get(i);
            }
        }
        return null;
    }
}
