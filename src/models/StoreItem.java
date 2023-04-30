package models;

import utils.Utils;

public class StoreItem extends Item {

    public StoreItem(int number, String name, float price, ItemType type, int quantity) {
        super(number, name, price, type, quantity);
    }

    public void removeQuantity(int removedQuantity) {
        quantity -= removedQuantity;
        if (quantity < 0) {
            quantity = 0;
        }
    }

    public String getDetailsOuterQuantity(int quantity){
        return String.valueOf(number) + " " + name + Utils.putTextInSquareBrackets(String.valueOf(quantity));
    }       
}
