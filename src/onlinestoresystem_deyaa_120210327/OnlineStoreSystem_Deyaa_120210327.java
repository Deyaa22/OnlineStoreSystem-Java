package onlinestoresystem_deyaa_120210327;

import java.util.Scanner;
import models.Customer;
import models.Item;
import models.StoreItem;
import utils.Constants;
import utils.Utils;

//TODO: check if user enter a letter instead of a number and fix exception.
public class OnlineStoreSystem_Deyaa_120210327 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(Constants.TABS_SPACE(2) + "* Deyaa Stor *\n");
        mainMenu();
    }

    public static void mainMenu() {
        System.out.println(Constants.TAB_SPACE + "\n####################\nMain Menue\n####################");
        int operationNumber = 0;
        do {
            System.out.println(Constants.OPERATIONS_TEXT);
            System.out.print("Operation number: ");
            operationNumber = input.nextInt();
        } while (operationNumber <= 0 || operationNumber > Constants.OPERATIONS_COUNT);
        startOperation(operationNumber);
    }

    public static void startOperation(int operationNumber) {
        switch (operationNumber) {
            case 1:
                addANewItemToStore();
                break;
            case 2:
                addANewCustomerToStore();
                break;
            case 3:
                addAnItemToCustomerShoppingCart();
                break;
            case 4:
                removeAnItemFromCustomerShoppingCart();
                break;
            case 5:
                viewTheItemsInCustomerShoppingCart();
                break;
            case 6:
                modifyCustomerData();
                break;
            case 7:
                emptyCustomerShoppingCart();
                break;
            case 8:
                endShoppingAndGoToCheckout();
                break;
            case 9:
                System.exit(0);
                break;
            default:
                mainMenu();
                break;
        }
    }

    public static void addANewItemToStore() {
        System.out.println("Add Item Operation:");

        int tempItemNumber;
        do {
            System.out.print("Please enter the item number[0-999]: ");
            tempItemNumber = input.nextInt();
        } while (tempItemNumber > 999 || tempItemNumber < 0 || !Store.ItemNumberIsAvailable(tempItemNumber));

        System.out.print("Please enter the item Name: ");
        String tempItemName = input.next();

        int tempItemQuantity = 1;
        do {
            System.out.print("Please enter the item Quantity[>=0]: ");
            tempItemQuantity = input.nextInt();
        } while (tempItemQuantity < 1);

        float tempItemPrice;
        do {
            System.out.print("Please enter the item price[>=0]: ");
            tempItemPrice = input.nextFloat();
        } while (tempItemPrice < 0);

        char tempItemTypeTextInput;
        do {
            System.out.print("Please enter the Type of item (B):Book, (S):Shoes, (G):Game?: ");
            tempItemTypeTextInput = input.next().trim().toUpperCase().charAt(0);
        } while (tempItemTypeTextInput != 'B' && tempItemTypeTextInput != 'S' && tempItemTypeTextInput != 'G');

        Item.ItemType tempItemType = Item.ItemType.Book;
        switch (tempItemTypeTextInput) {
            case 'B':
                tempItemType = Item.ItemType.Book;
                break;
            case 'S':
                tempItemType = Item.ItemType.Shoes;
                break;
            case 'G':
                tempItemType = Item.ItemType.Game;
                break;
        }
        Store.addItem(tempItemNumber, tempItemName, tempItemPrice, tempItemType, tempItemQuantity);
        System.out.println("Item added Successfully");

        System.out.println("Your Item Name: " + Store.getItemByItemNumber(tempItemNumber).getName());

        boolean yesForThisOperation = Utils.askYesOrNoQuestion("Do you want to add another item", input);
        if (yesForThisOperation) {
            addANewItemToStore();
        } else {
            mainMenu();
            return;
        }
    }

    public static void addANewCustomerToStore() {
        System.out.println("Add Customer Operation:");

        int tempCustomerNumber;
        do {
            System.out.print("Please enter the Customer number[0-9999]: ");
            tempCustomerNumber = input.nextInt();
        } while (tempCustomerNumber > 9999 || tempCustomerNumber < 0 || !Store.customerNumberIsAvailable(tempCustomerNumber));

        System.out.print("Please enter the Customer Name: ");
        String tempCustomerName = input.next();

        Store.addCustomer(tempCustomerNumber, tempCustomerName);
        System.out.println("Customer added Successfully");

        System.out.println("Your Customer Name: " + Store.getCustomer(tempCustomerNumber).getName());

        char tempYesOrNoTextInput;
        do {
            System.out.print("Do you want to add another Customer [y/n]: ");
            tempYesOrNoTextInput = input.next().trim().toUpperCase().charAt(0);
        } while (tempYesOrNoTextInput != 'Y' && tempYesOrNoTextInput != 'N');

        boolean needToStartAddNewCustomerOperation = tempYesOrNoTextInput == 'Y';

        if (needToStartAddNewCustomerOperation) {
            addANewCustomerToStore();
        } else {
            mainMenu();
        }
    }

    public static void addAnItemToCustomerShoppingCart() {
        if (Store.noItemsInStore()) {
            System.out.println("No Items in Store to add!");
            mainMenu();
            return;
        } else if (Store.noCustomersInStore()) {
            System.out.println("No Customers in Store to add items to!");
            mainMenu();
            return;
        }

        System.out.println("Add Item to Customer's Shopping Cart Operation:");
        boolean continueCustomerChecking = false;
        int tempCustomerNumber;
        do {
            System.out.print("Please enter the Customer number: ");
            tempCustomerNumber = input.nextInt();

            if (!Store.customerIsExist(tempCustomerNumber)) {
                boolean yesForThisOperation = Utils.askYesOrNoQuestion("The Customer is not exist, Do you want try again", input);
                if (yesForThisOperation) {
                    continueCustomerChecking = true;
                } else {
                    mainMenu();
                    return;
                }
            }
        } while (continueCustomerChecking == true);
        Customer currentCustomer = Store.getCustomer(tempCustomerNumber);

        // View Items Available
        if (Store.noItemsInStore()) {
            mainMenu();
            return;
        } else {
            System.out.println("Items in the Store:");
            for (int i = 0; i < Store.itemsCount(); i++) {
                StoreItem tempStoreItem = Store.getItem(i);
                System.out.println(">>> " + String.valueOf(i + 1) + ". " + tempStoreItem.getNumber() + " : " + tempStoreItem.getName() + "." + Utils.putTextInSquareBrackets(String.valueOf(tempStoreItem.getQuantity())));
            }
        }

        // Choose Item
        int choiceItemIndex;
        do {
            System.out.print("Enter your choice item: ");
            choiceItemIndex = input.nextInt() - 1;
        } while (choiceItemIndex < 0 || choiceItemIndex >= Store.itemsCount());
        StoreItem currentStoreItem = Store.getItem(choiceItemIndex);
        System.out.println("The Item is " + currentStoreItem.FullDetails());

        // Select Quantity
        int choiceItemQuantity; // >> number of items = 5 >> count = 4 >> 5
        boolean quantityIsNotAvailable = false;
        do {
            if (quantityIsNotAvailable) {
                System.out.println("Sorry, The required quantity is not available, The available quantity is " + Utils.putTextInSquareBrackets(String.valueOf(Store.getItem(choiceItemIndex).getQuantity())) + ", Try again!");

                boolean yesForThisOperation = Utils.askYesOrNoQuestion("Do you want to add another item to shopping cart", input);
                if (!yesForThisOperation) {
                    mainMenu();
                    return;
                }
            }
            System.out.print("Enter the quantity you need: ");
            choiceItemQuantity = input.nextInt();
            quantityIsNotAvailable = choiceItemQuantity <= 0 || Store.getItem(choiceItemIndex).getQuantity() < choiceItemQuantity;
        } while (quantityIsNotAvailable);

        Store.addItemToCustomer(currentStoreItem, choiceItemQuantity, tempCustomerNumber);

        System.out.println("The Item is " + Utils.putTextInSquareBrackets(currentStoreItem.FullDetails()) + "adding to shopping cart is sccess");

        boolean addAnotherItemToShoppingCart = Utils.askYesOrNoQuestion("Do you want to add another item to shopping car", input);
        if (addAnotherItemToShoppingCart) {
            addAnItemToCustomerShoppingCart();
        } else {
            mainMenu();
        }
    }

    public static void removeAnItemFromCustomerShoppingCart() {
        if (Store.noCustomersInStore()) {
            System.out.println("No Customers in Store to add items to!");
            mainMenu();
            return;
        }
        System.out.println("Remove Item from Customer's Shopping Cart Operation:");
        Customer currentCustomer = null;
        boolean continueCustomerChecking = false;
        int tempCustomerNumber;
        do {
            System.out.print("Please enter the Customer number: ");
            tempCustomerNumber = input.nextInt();

            if (!Store.customerIsExist(tempCustomerNumber)) {
                boolean yesForThisOperation = Utils.askYesOrNoQuestion("The Customer is not exist, Do you want try again", input);
                if (yesForThisOperation) {
                    continueCustomerChecking = true;
                } else {
                    mainMenu();
                    return;
                }
            }
        } while (continueCustomerChecking == true);

        currentCustomer = Store.getCustomer(tempCustomerNumber);
        System.out.println("The customer no: " + tempCustomerNumber + ", " + "The customer name: " + currentCustomer.getName());
        // View Items Available
        if (Store.noItemsInStore()) {
            mainMenu();
            return;
        }

        do {
            System.out.println("The current Items in the Shopping Cart:");
            for (int i = 0; i < currentCustomer.itemsCount(); i++) {
                Item tempItem = currentCustomer.getItem(i);
                System.out.println(">>> " + String.valueOf(i + 1) + ". " + tempItem.getNumber() + " : " + tempItem.getName() + "." + Utils.putTextInSquareBrackets(String.valueOf(tempItem.getQuantity())));
            }

            // Proccess >> Remove or Modify
            char tempRemoveOrReturntextInput;
            boolean removeForThisOperation = false;
            System.out.println("What kind of modification do you want?");
            do {
                System.out.println(">>> R: Remove item from the shopping cart.");
                System.out.println(">>> M: Return to the main menu.");
                System.out.print("Enter your choice [R: Remove, M: Main Menu]: ");
                tempRemoveOrReturntextInput = input.next().trim().toUpperCase().charAt(0);
            } while (tempRemoveOrReturntextInput != 'R' && tempRemoveOrReturntextInput != 'M');
            removeForThisOperation = tempRemoveOrReturntextInput == 'R';

            if (!removeForThisOperation) {
                mainMenu();
                return;
            }

            // Remove
            int tempItemIndex;
            do { // 3 >> 2 >> 3 >> 2
                System.out.print("Enter Your item option number: ");
                tempItemIndex = input.nextInt() - 1;
            } while (tempItemIndex < 0 && tempItemIndex > currentCustomer.itemsCount() - 1);
            String removedItemDetails = Utils.putTextInSquareBrackets(currentCustomer.getItem(tempItemIndex).FullDetails());
            currentCustomer.removeItem(tempItemIndex);
            System.out.println("The item " + removedItemDetails + " is removed from shopping cart.");
        } while (!currentCustomer.hasNoItems());

        mainMenu();
    }

    public static void viewTheItemsInCustomerShoppingCart() {
        if (Store.hasNoCustomers()) {
            System.out.println("There are not customers yet");
            mainMenu();
            return;
        }

        System.out.println("View items in Customer's Shopping Cart Operation:");
        Customer currentCustomer = null;
        boolean continueCustomerChecking = false;
        int tempCustomerNumber;
        do {
            System.out.print("Please enter the Customer number: ");
            tempCustomerNumber = input.nextInt();

            if (!Store.customerIsExist(tempCustomerNumber)) {
                if (Utils.askYesOrNoQuestion("The Customer is not exist, Do you want try again", input)) {
                    continueCustomerChecking = true;
                } else {
                    mainMenu();
                    return;
                }
            }
        } while (continueCustomerChecking == true);
        currentCustomer = Store.getCustomer(tempCustomerNumber);
        System.out.println("The customer no: " + tempCustomerNumber + ", " + "Customer Name: " + currentCustomer.getName());
        if (currentCustomer.hasNoItems()) {
            System.out.println(currentCustomer.getName() + " has no items!");
            mainMenu();
            return;
        }

        System.out.println("Items in shopping cart");
        System.out.println(Utils.lineOfSymbole('_'));
        float totalPrice = 0;
        for (int i = 0; i < currentCustomer.itemsCount(); i++) {
            String itemNumberText = String.valueOf(currentCustomer.getItem(i).getNumber());
            String itemNameText = currentCustomer.getItem(i).getName();
            String itemQuantityText = String.valueOf(currentCustomer.getItem(i).getQuantity());
            String itemPriceText = String.valueOf(currentCustomer.getItem(i).getPrice());
            float totalItemQuantityPriceOfItem = currentCustomer.getItem(i).getPrice() * currentCustomer.getItem(i).getQuantity();
            totalPrice += totalItemQuantityPriceOfItem;
            String totalItemQuantityPriceText = String.valueOf(totalItemQuantityPriceOfItem);

            String[] customerDetailsTopics = {"Item No.", "Item name", "Quantity", "Unit price", "Total price"};
            System.out.println(Utils.putSequanceOfTextsInBoxes(customerDetailsTopics));

            String[] customerDetails = {itemNumberText, itemNameText, itemQuantityText, itemPriceText, totalItemQuantityPriceText};
            String itemLineDetails = Utils.putSequanceOfTextsInBoxes(customerDetails);
            System.out.println(itemLineDetails);
            System.out.println(Utils.lineOfSymbole('_'));
        }
        System.out.println(" # Total Price: " + totalPrice + "$");

        char tempReturnToMainMenuTextInput;
        boolean yesForThisOperation = false;
        do {
            System.out.print("Press (m/M) to return to main menu: ");
            tempReturnToMainMenuTextInput = input.next().trim().toUpperCase().charAt(0);
        } while (tempReturnToMainMenuTextInput != 'm' && tempReturnToMainMenuTextInput != 'M');
        mainMenu();
    }

    public static void modifyCustomerData() {
        if (Store.noCustomersInStore()) {
            System.out.println("No customers in store to modify their data!");
            mainMenu();
            return;
        }
        System.out.println("Modify Customer Data operation: ");
        System.out.print("Enter customer number: ");
        boolean continueCustomerChecking = false;
        int tempCustomerNumber;
        do {
            System.out.print("Please enter the Customer number: ");
            tempCustomerNumber = input.nextInt();

            if (!Store.customerIsExist(tempCustomerNumber)) {
                System.out.println("The Customer no: " + tempCustomerNumber + ", not found.");
                boolean yesForThisOperation = Utils.askYesOrNoQuestion("Do you want to try another customer", input);
                if (yesForThisOperation) {
                    continueCustomerChecking = true;
                } else {
                    mainMenu();
                    return;
                }
            }
        } while (continueCustomerChecking == true);
        Customer currentCustomer = Store.getCustomer(tempCustomerNumber);
        System.out.println("The customer no: " + tempCustomerNumber + ", The customer name: " + currentCustomer.getName() + ".");

        // TODO: do while to check that number is not exist.
        continueCustomerChecking = false;
        int tempNewCustomerNumber = 0;
        do {
            System.out.print("Please, Enter the new customer's number: ");
            tempNewCustomerNumber = input.nextInt();

            if (!Store.customerNumberIsAvailable(tempNewCustomerNumber)) {
                System.out.println("New customer's number:[" + tempNewCustomerNumber + "] is not available!");
                continueCustomerChecking = true;
            }
        } while (continueCustomerChecking);
        System.out.print("Please, Enter the new customer's Name: ");
        String tempCustomerName = input.next();

        Store.setCustomerNumberAndNameByNumber(tempCustomerNumber, tempNewCustomerNumber, tempCustomerName);
        System.out.println("Customer modified Successfully");

        boolean yesForThisOperation = Utils.askYesOrNoQuestion("Do you want to modify another customer data", input);
        if (yesForThisOperation) {
            modifyCustomerData();
        } else {
            System.out.println("Back to main menu");
            mainMenu();
        }
    }

    public static void emptyCustomerShoppingCart() {
        if (Store.noCustomersInStore()) {
            System.out.println("No customers in store to modify their data!");
            mainMenu();
            return;
        }

        System.out.println("Empty Customer's shopping cart operation: ");
        boolean continueCustomerChecking = false;
        int tempCustomerNumber;
        do {
            System.out.print("Please enter the Customer number: ");
            tempCustomerNumber = input.nextInt();

            if (!Store.customerIsExist(tempCustomerNumber)) {
                System.out.println("The Customer no: " + tempCustomerNumber + ", not found.");
                boolean yesForThisOperation = Utils.askYesOrNoQuestion("Do you want to try another customer", input);
                if (yesForThisOperation) {
                    continueCustomerChecking = true;
                } else {
                    mainMenu();
                    return;
                }
            }
        } while (continueCustomerChecking == true);
        Customer currentCustomer = Store.getCustomer(tempCustomerNumber);
        Store.emptyCustomerShoppingCart(tempCustomerNumber);
        System.out.println("The customer no: " + tempCustomerNumber + ", The customer name: " + currentCustomer.getName() + ".");
        System.out.println(currentCustomer.getName() + " got a new empty Shopping Cart Successfully");

        System.out.print("Press any key to go to main menu: ");
        input.next();
    }

    public static void endShoppingAndGoToCheckout() {
        if (Store.hasNoCustomers()) {
            System.out.println("There are not customers yet");
            mainMenu();
            return;
        }

        System.out.println("End shopping and go to checkout operation: ");
        Customer currentCustomer = null;
        boolean continueCustomerChecking = false;
        int tempCustomerNumber;
        do {
            System.out.print("Please enter the Customer number: ");
            tempCustomerNumber = input.nextInt();

            if (!Store.customerIsExist(tempCustomerNumber)) {
                if (Utils.askYesOrNoQuestion("The Customer is not exist, Do you want try again", input)) {
                    continueCustomerChecking = true;
                } else {
                    mainMenu();
                    return;
                }
            }
        } while (continueCustomerChecking == true);
        currentCustomer = Store.getCustomer(tempCustomerNumber);
        System.out.println("The customer no: " + tempCustomerNumber + ", " + "Customer Name: " + currentCustomer.getName());
        if (currentCustomer.hasNoItems()) {
            System.out.println(currentCustomer.getName() + " has no items!");
            mainMenu();
            return;
        }

        System.out.println("# Checkout, make sure to write correct information to be capable to deliver items (^-^)");
        System.out.print("Enter your PayPal email: ");
        String email = input.next();
        System.out.print("Enter your location: ");
        String location = input.next();

        System.out.println("Congratulations, Operation done.");
        System.out.println(currentCustomer.getName() + ", number: " + currentCustomer.getNumber() + ", location: " + location + ", PayPalAcount; " + email);

        Store.emptyCustomerShoppingCart(tempCustomerNumber);
        
        System.out.print("Press any key to go back to Main Menu: ");
        input.next();
        mainMenu();
    }
}
