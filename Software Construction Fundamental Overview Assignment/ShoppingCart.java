import java.util.Scanner;
import java.util.HashMap;
// Shopping cart main class
public class ShoppingCart {
	// initialize global variables of items, price and value	
    String items[];
    int price[];
    int stocks[];
    public ShoppingCart(String[] items,int[] price, int[] stocks) {
		this.items=items;
		this.price=price;
		this.stocks=stocks;
	}
    Scanner scan = new Scanner(System.in);
    // create Hash map for user cart
    HashMap<String, Integer> cart = new HashMap<String, Integer>();
    // method to display item menu of shop    
    void displayItems(String[] items, int[] value, int[] price) {
        System.out.println("Available items in shop - ");
        System.out.println("S.no Item Value Price");
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + " " + items[i] + " " + value[i] + " " + price[i]);
        }
    }
    // method to display cart items
    void displayCart(HashMap<String, Integer> cart) {
        System.out.println(cart);
        displayItems(items, stocks, price);
        operations();
    }
    // method to add items in user cart
    void addToCart(HashMap<String, Integer> cart, int[] stocks) {
        System.out.println("Enter S.no of item which you want to add to your cart");
        int itemNumber = scan.nextInt();
        if (itemNumber <= stocks.length && itemNumber > 0) {
            System.out.println("Enter value of item you want to you");
            int valItem = scan.nextInt();
            if (valItem <= stocks[itemNumber - 1]) {
                System.out.println("Item added to cart...");
                stocks[itemNumber - 1] -= valItem;
                // cart.put(items[item_number - 1], val_item);
                if (cart.get(items[itemNumber - 1]) != null) {
                    cart.put(items[itemNumber - 1], cart.get(items[itemNumber - 1]) + valItem);
                } else {
                    cart.put(items[itemNumber - 1], valItem);
                }
                displayCart(cart);
            } else {
                System.out.println("value is greater than available - try again");
                addToCart(cart, stocks);
            }
        } else {
            System.out.println("wrong item number, try again");
            addToCart(cart, stocks);
        }
    }
    // method to remove items from cart
    void removeFromCart(HashMap<String, Integer> cart, int[] stocks) {
        System.out.println("Enter S.no of item which you want to remove from your cart");
        int itemNumber = scan.nextInt();
        if (itemNumber <= stocks.length && itemNumber > 0) {
            if (cart.get(items[itemNumber - 1]) != null) {
                System.out.println("Enter value of item you want to remove");
                int valItem = scan.nextInt();
                if (valItem < cart.get(items[itemNumber - 1])) {
                    System.out.println("Item updated to cart...");
                    cart.put(items[itemNumber - 1], cart.get(items[itemNumber - 1]) - valItem);
                    stocks[itemNumber - 1] += valItem;
                    displayCart(cart);
                } else {
                    cart.remove(items[itemNumber - 1]);
                    displayCart(cart);
                }
            } else {
                System.out.println("Item already not in the cart");
                displayCart(cart);
            }
        } else {
            System.out.println("wrong item number, try again");
            displayCart(cart);
        }
    }
    // method to generate user bill
    void generateBill(HashMap<String, Integer> cart) {
        int totalBill = 0;
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty");
        } else {
            // display_cart(cart);
            for (int i = 0; i < items.length; i++) {
                if (cart.containsKey(items[i]) == true) {
                    totalBill += cart.get(items[i]) * price[i];
                }
            }
            System.out.println("Your total bill is = " + totalBill + " rs");
        }
        operations();
    }
    // method of all operations of shop
    void operations() {
        System.out.println(
                "\nEnter 1 to view your cart\nEnter 2 to add item to your cart\nEnter 3 to remove item from your cart\nEnter 4 to generate bill\nEnter 5 to exit from shop");
        int input = scan.nextInt();
        switch (input) {
            case 1:
                displayCart(cart);
                break;
            case 2:
                addToCart(cart, stocks);
                break;
            case 3:
                removeFromCart(cart, stocks);
                break;
            case 4:
                generateBill(cart);
                break;
            case 5:
                System.out.println("Thanks to visit out shop, good bye.");
                return;
            default:
                System.out.println("Wrong Input, Try again!");
                operations();
        }
    }
    // main method of class shopping cart
    public static void main(String[] args) {
    	String items[] = { "Bat","Video Game", "Ball", "Badminton", "Bottle" };
        int price[] = { 1000,2400, 50, 250, 100 };
        int stocks[] = { 10,15, 20, 15, 25 };
    	ShoppingCart s=new ShoppingCart(items, price, stocks);
        s.displayItems(s.items, s.stocks, s.price);
        s.operations();
        s.scan.close();
    }
}