package JDBC;
import java.util.*;
public class StoreFront {
    public static void main(String args[]) {
    	Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter 1 for get order details\n"
            		+ "Enter 2 for insert images\n"
            		+ "Enter 3 for delete products not ordered in last 1 year\n"
            		+ "Enter 4 to see top categories\n"
            		+ "Enter 5 to exit");
            int option = scanner.nextInt();
            switch (option) {
            case 1:
                System.out.println("order details of a user which is in shipped state");
                System.out.println("Enter userId: ");
                int userId = scanner.nextInt();
                List<orderDetail> listOfOrders = DatabaseHelper.getOrderDetails(userId);
                for (orderDetail orderDetail : listOfOrders) {
                    System.out.println(orderDetail.getOrderId());
                    System.out.println(orderDetail.getProductId());
                    System.out.println(orderDetail.getOrderDate());
                    System.out.println(orderDetail.getOrderTotal());
                    System.out.println();
                }
                System.out.println();
                break;
            case 2:
                System.out.println("Insert Images Of Product");
                List<ProductImage> listOfImage = new ArrayList<ProductImage>();
                listOfImage.add(new ProductImage(1, "image1.jpeg"));
                listOfImage.add(new ProductImage(2, "image2.jpeg"));
                listOfImage.add(new ProductImage(2, "image2.jpeg"));
                listOfImage.add(new ProductImage(4, "image3.jpeg"));
                listOfImage.add(new ProductImage(5, "image3.jpeg"));
                listOfImage.add(new ProductImage(4, "image1.jpeg"));
                DatabaseHelper.insertImage(listOfImage);
                System.out.println();
                break;
            case 3:
                System.out.println(
                        "Delete those products which were"
                        + " not ordered by any Shopper in last 1 year");
                int updatedRows = DatabaseHelper.updateProductStatus();
                System.out.println("updated rows " + updatedRows);
                System.out.println();
                System.out.println();
                break;
            case 4:
                System.out.println("Top category details with their number of children");
                List<TopCategoryDetail> listOfTopCategories = DatabaseHelper.getTopCategoryDetails();
                for (TopCategoryDetail TopCategoryDetail : listOfTopCategories) {
                    System.out.println(TopCategoryDetail.getName());
                    System.out.println(TopCategoryDetail.getNumberOfChildren());
                    System.out.println();
                }
                break;
            case 5:
            	System.out.println("Good bye...");
            	scanner.close();
            	return;
            default:
                System.out.println("Wrong input, Try again");
            }
        }
    }
}