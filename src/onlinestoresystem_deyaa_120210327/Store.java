package onlinestoresystem_deyaa_120210327;

import java.util.ArrayList;
import models.Customer;
import models.Item;
import models.StoreItem;

public class Store {

    // Store Items
    private static ArrayList<StoreItem> storeItems = new ArrayList<>();

    public static void addItem(int number, String name, float price, Item.ItemType type, int quantity) {
        for (int i = 0; i < storeItems.size(); i++) {
            StoreItem tempStoreItem = storeItems.get(i);
            if (tempStoreItem.getNumber() == number && tempStoreItem.getName().equals(name) && tempStoreItem.getPrice() == price) {
                tempStoreItem.addQuantity(quantity);
                return;
            }
        }
        StoreItem newStoreItem = new StoreItem(number, name, price, type, quantity);
        addItem(newStoreItem);
    }

    public static void addItem(StoreItem storeItem) {
        storeItems.add(storeItem);
    }

    public static void removeItem(StoreItem storeItem, int quantity) {
        storeItem.removeQuantity(quantity);
        if (storeItem.getQuantity() <= 0 && storeItems.contains(storeItem)) {
            storeItems.remove(storeItem);
        }
    }

    public static boolean ItemNumberIsAvailable(int number) {
        return getItemByItemNumber(number) == null;
    }

    public static int itemsCount() {
        return storeItems.size();
    }

    public static boolean noItemsInStore() {
        return itemsCount() == 0;
    }

    // Customers
    private static ArrayList<Customer> customers = new ArrayList<>();

    public static void addCustomer(int number, String name) {
        for (int i = 0; i < customers.size(); i++) {
            Customer tempCustomer = customers.get(i);
            if (tempCustomer.getNumber() == number && tempCustomer.getName().equals(name)) {
                return;
            }
        }
        Customer newCustomer = new Customer(number, name);
        addCustomer(newCustomer);
    }

    public static void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public static boolean customerIsExist(int number) {
        return !customerNumberIsAvailable(number);
    }

    public static boolean customerNumberIsAvailable(int number) {
        return getCustomer(number) == null;
    }

    public static boolean hasNoCustomers() {
        return customers.size() == 0;
    }

    public static int customersCount() {
        return customers.size();
    }

    public static String getCustomerNameByIndex(int index) {
        return customers.get(index).getName();
    }

    public static boolean noCustomersInStore() {
        return customersCount() == 0;
    }

    // Add Item to Customer's Shopping Cart
    public static void addItemToCustomer(StoreItem storeItem, int itemQuantity, int customerNumber) {
        Customer customer = getCustomer(customerNumber);
        customer.addItem(storeItem.getNumber(), storeItem.getName(), storeItem.getPrice(), storeItem.getType(), itemQuantity);
        removeItem(storeItem, itemQuantity);
    }

    static void setCustomerNumberAndNameByNumber(int customerNumber, int newCustomerNumber, String newCustomerName) {
        getCustomer(customerNumber).setName(newCustomerName);
        getCustomer(customerNumber).setNumber(newCustomerNumber);
    }

    static void emptyCustomerShoppingCart(int customerNuber) {
        getCustomer(customerNuber).emptyShoppingCart() ;
    }
    
    // Getters and Setters
    public static StoreItem getItem(int itemIndex) {
        return storeItems.get(itemIndex);
    }

    public static StoreItem getItemByItemNumber(int number) {
        for (int i = 0; i < storeItems.size(); i++) {
            StoreItem tempStoreItem = storeItems.get(i);
            if (tempStoreItem.getNumber() == number) {
                return tempStoreItem;
            }
        }
        return null;
    }

    public static Customer getCustomer(int number) {
        for (int i = 0; i < customers.size(); i++) {
            Customer tempCustomer = customers.get(i);
            if (tempCustomer.getNumber() == number) {
                return tempCustomer;
            }
        }
        return null;
    }  
}
