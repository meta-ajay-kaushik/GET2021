package SoftwareSpecifications;
import java.util.Scanner;
// java class of Area
public class Area {
	static Scanner scan =new Scanner(System.in);
	/**
	 * Calculate the area of triangle.
	 * @param requires width of the triangle
	 * @param requires height of the triangle
	 * @return area of triangle
	 */
	public static Double Area_of_Triangle(Double width,Double height){
		return (width*height/2);
	}
	/**
	 * Calculate the area of Rectangle.
	 * @param requires width of the Rectangle
	 * @param requires height of the Rectangle
	 * @return area of Rectangle
	 */
	public static Double Area_of_Rectangle(Double width,Double height){
		return width*height;
	}
	/**
	 * Calculate the area of Square.
	 * @param requires width of the Square
	 * @return area of Square
	 */
	public static Double Area_of_Square(Double width){
		return width*width;
	}
	/**
	 * Calculate the area of Circle.
	 * @param requires radius of the Circle
	 * @return area of Circle
	 */
	public static Double Area_of_Circle(Double radius){
		return (22*radius*radius)/7;
	}
	/**
	 * Take input from user and perform various operations.
	 * @return call methods to get area and print them on display
	 */
	public static void operations(){
		System.out.println("Enter 1 to find Area of Triangle\n"
				+ "Enter 2 to find Area of Rectangle\n"
				+ "Enter 3 to find Area of Square\n"
				+ "Enter 4 to find Area of Circle\n"
				+ "Enter 5 to exit");
		int input=scan.nextInt();
		switch (input) {
		case 1:
			System.out.println("Enter width of Triangle");
			Double width_of_triangle=scan.nextDouble();
			System.out.println("Enter height of Triangle");
			Double height_of_triangle=scan.nextDouble();
			Double area_of_triangle=Area_of_Triangle(width_of_triangle,height_of_triangle);
			System.out.println("The area of triangle is = "+area_of_triangle);
			break;
		case 2:
			System.out.println("Enter width of Rectangle");
			Double width_of_Rectangle=scan.nextDouble();
			System.out.println("Enter height of Rectangle");
			Double height_of_Rectangle=scan.nextDouble();
			Double area_of_rectangle=Area_of_Rectangle(width_of_Rectangle,height_of_Rectangle);
			System.out.println("The area of Rectangle is = "+area_of_rectangle);
			break;
		case 3:
			System.out.println("Enter width of Square");
			Double width_of_square=scan.nextDouble();
			Double area_of_square=Area_of_Square(width_of_square);
			System.out.println("The area of Square is = "+area_of_square);
			break;
		case 4:
			System.out.println("Enter radius of Circle");
			Double radius=scan.nextDouble();
			Double area_of_circle=Area_of_Circle(radius);
			System.out.println("The area of Circle is = "+area_of_circle);
			break;
		case 5:
			System.out.println("Thanks to use Area Calculator..");
			return;
		default:
			System.out.println("Wrong input, try again.");
			break;
		}
		operations();
	}
	// Main method
	public static void main(String[] args) {
		operations();
		scan.close();
	}
}
