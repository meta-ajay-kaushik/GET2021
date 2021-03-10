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
    void display_items(String[] items, int[] value, int[] price) {
        System.out.println("Available items in shop - ");
        System.out.println("S.no Item Value Price");
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + " " + items[i] + " " + value[i] + " " + price[i]);
        }
    }
    // method to display cart items
    void display_cart(HashMap<String, Integer> cart) {
        System.out.println(cart);
        display_items(items, stocks, price);
        operations();
    }
    // method to add items in user cart
    void add_to_cart(HashMap<String, Integer> cart, int[] stocks) {
        System.out.println("Enter S.no of item which you want to add to your cart");
        int item_number = scan.nextInt();
        if (item_number <= stocks.length && item_number > 0) {
            System.out.println("Enter value of item you want to you");
            int val_item = scan.nextInt();
            if (val_item <= stocks[item_number - 1]) {
                System.out.println("Item added to cart...");
                stocks[item_number - 1] -= val_item;
                // cart.put(items[item_number - 1], val_item);
                if (cart.get(items[item_number - 1]) != null) {
                    cart.put(items[item_number - 1], cart.get(items[item_number - 1]) + val_item);
                } else {
                    cart.put(items[item_number - 1], val_item);
                }
                display_cart(cart);
            } else {
                System.out.println("value is greater than available - try again");
                add_to_cart(cart, stocks);
            }
        } else {
            System.out.println("wrong item number, try again");
            add_to_cart(cart, stocks);
        }
    }
    // method to remove items from cart
    void remove_from_cart(HashMap<String, Integer> cart, int[] stocks) {
        System.out.println("Enter S.no of item which you want to remove from your cart");
        int item_number = scan.nextInt();
        if (item_number <= stocks.length && item_number > 0) {
            if (cart.get(items[item_number - 1]) != null) {
                System.out.println("Enter value of item you want to remove");
                int val_item = scan.nextInt();
                if (val_item < cart.get(items[item_number - 1])) {
                    System.out.println("Item updated to cart...");
                    cart.put(items[item_number - 1], cart.get(items[item_number - 1]) - val_item);
                    stocks[item_number - 1] += val_item;
                    display_cart(cart);
                } else {
                    cart.remove(items[item_number - 1]);
                    display_cart(cart);
                }
            } else {
                System.out.println("Item already not in the cart");
                display_cart(cart);
            }
        } else {
            System.out.println("wrong item number, try again");
            display_cart(cart);
        }
    }
    // method to generate user bill
    void generate_bill(HashMap<String, Integer> cart) {
        int total_bill = 0;
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty");
        } else {
            // display_cart(cart);
            for (int i = 0; i < items.length; i++) {
                if (cart.containsKey(items[i]) == true) {
                    total_bill += cart.get(items[i]) * price[i];
                }
            }
            System.out.println("Your total bill is = " + total_bill + " rs");
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
                display_cart(cart);
                break;
            case 2:
                add_to_cart(cart, stocks);
                break;
            case 3:
                remove_from_cart(cart, stocks);
                break;
            case 4:
                generate_bill(cart);
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
        s.display_items(s.items, s.stocks, s.price);
        s.operations();
        s.scan.close();
    }
}