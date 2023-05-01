# OnlineStoreSystem-Java


//////////////////////////////////////////////////////////////////////

        * Deyaa Stor *

//////////////////////////////////////////////////////////////////////
    
####################
Main Menue
####################
Operation:
1. Add a new Item to Store
2. Add a new Customer to Store
3. Add an item to Customer shopping cart
4. Remove an item from Customer shopping cart
5. View the items in Customer shopping cart
6. Modify customer data
7. Empty Customer shopping cart
8. End shopping and go to checkout
9. Exit the program
Operation number:

//////////////////////////////////////////////////////////////////////

Add Item Operation:
Please enter the item number[0-999]: 1
Please enter the item Name: RichDadPoorDad
Please enter the item Quantity[>=0]: 25
Please enter the item price[>=0]: 13
Please enter the Type of item (B):Book, (S):Shoes, (G):Game?: B
Item added Successfully
Your Item Name: RichDadPoorDad
Do you want to add another item[y/n]?:y
Add Item Operation:
Please enter the item number[0-999]: 2
Please enter the item Name: Programming
Please enter the item Quantity[>=0]: 35
Please enter the item price[>=0]: 10
Please enter the Type of item (B):Book, (S):Shoes, (G):Game?: B
Item added Successfully
Your Item Name: Programming
Do you want to add another item[y/n]?:n

//////////////////////////////////////////////////////////////////////

Add Customer Operation:
Please enter the Customer number[0-9999]: 1
Please enter the Customer Name: Deyaa
Customer added Successfully
Your Customer Name: Deyaa
Do you want to add another Customer [y/n]: n

//////////////////////////////////////////////////////////////////////

Add Item to Customer's Shopping Cart Operation:
Please enter the Customer number: 1
Items in the Store:
>>> 1. 1 : RichDadPoorDad. [25] 
>>> 2. 2 : Programming. [35] 
Enter your choice item: 1
The Item is 1 RichDadPoorDad [25] 
Enter the quantity you need: 12
The Item is  [1 RichDadPoorDad [13] ] adding to shopping cart is sccess
Do you want to add another item to shopping car[y/n]?:y
Add Item to Customer's Shopping Cart Operation:
Please enter the Customer number: 1
Items in the Store:
>>> 1. 1 : RichDadPoorDad. [13] 
>>> 2. 2 : Programming. [35] 
Enter your choice item: 2
The Item is 2 Programming [35] 
Enter the quantity you need: 23
The Item is  [2 Programming [12] ] adding to shopping cart is sccess
Do you want to add another item to shopping car[y/n]?:n

//////////////////////////////////////////////////////////////////////

View items in Customer's Shopping Cart Operation:
Please enter the Customer number: 1
The customer no: 1, Customer Name: Deyaa
Items in shopping cart
__________________________________________________________________________________________
|Item No.       | Item name      | Quantity       | Unit price     | Total price    | 
|1              | RichDadPoorDad | 12             | 13.0           | 156.0          | 
__________________________________________________________________________________________
|Item No.       | Item name      | Quantity       | Unit price     | Total price    | 
|2              | Programming    | 23             | 10.0           | 230.0          | 
__________________________________________________________________________________________
 # Total Price: 386.0$
Press (m/M) to return to main menu: m

//////////////////////////////////////////////////////////////////////

Modify Customer Data operation: 
Enter customer number: Please enter the Customer number: 1
The customer no: 1, The customer name: Deyaa.
Please, Enter the new customer's number: 2
Please, Enter the new customer's Name: Mo
Customer modified Successfully
Do you want to modify another customer data[y/n]?:n
Back to main menu

//////////////////////////////////////////////////////////////////////

End shopping and go to checkout operation: 
Please enter the Customer number: 2
The customer no: 2, Customer Name: Mo
# Checkout, make sure to write correct information to be capable to deliver items (^-^)
Enter your PayPal email: mo@gmail.com
Enter your location: gaza
Congratulations, Operation done.
Mo, number: 2, location: gaza, PayPalAcount; mo@gmail.com
Press any key to go back to Main Menu: 

//////////////////////////////////////////////////////////////////////
