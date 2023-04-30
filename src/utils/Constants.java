
package utils;
public class Constants {
    public static String TAB_SPACE = "    ";
    public static String TABS_SPACE(int numberOfTabs){
        String tempTaps = "";
        for (int i = 0; i < numberOfTabs; i++) {
            tempTaps += TAB_SPACE;
        }
        return tempTaps;
    }
    public static String SPACE_BOX_15 = "               ";
    // Operations
    public static int OPERATIONS_COUNT = 9;
    public static String OPERATIONS_TEXT = 
            "Operation:\n" +
            "1. Add a new Item to Store\n" +
            "2. Add a new Customer to Store\n" + 
            "3. Add an item to Customer shopping cart\n" + 
            "4. Remove an item from Customer shopping cart\n" + 
            "5. View the items in Customer shopping cart\n" + 
            "6. Modify customer data\n" + 
            "7. Empty Customer shopping cart\n" +
            "8. End shopping and go to checkout\n" +
            "9. Exit the program";                      
}
