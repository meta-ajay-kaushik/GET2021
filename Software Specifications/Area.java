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
	public static Double areaOfTriangle(Double width,Double height){
		return (width*height/2);
	}
	/**
	 * Calculate the area of Rectangle.
	 * @param requires width of the Rectangle
	 * @param requires height of the Rectangle
	 * @return area of Rectangle
	 */
	public static Double areaOfRectangle(Double width,Double height){
		return width*height;
	}
	/**
	 * Calculate the area of Square.
	 * @param requires width of the Square
	 * @return area of Square
	 */
	public static Double areaOfSquare(Double width){
		return width*width;
	}
	/**
	 * Calculate the area of Circle.
	 * @param requires radius of the Circle
	 * @return area of Circle
	 */
	public static Double areaOfCircle(Double radius){
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
			Double widthOfTriangle=scan.nextDouble();
			System.out.println("Enter height of Triangle");
			Double heightOfTriangle=scan.nextDouble();
			Double areaOfTriangle=areaOfTriangle(widthOfTriangle,heightOfTriangle);
			System.out.println("The area of triangle is = "+areaOfTriangle);
			break;
		case 2:
			System.out.println("Enter width of Rectangle");
			Double widthOfRectangle=scan.nextDouble();
			System.out.println("Enter height of Rectangle");
			Double heightOfRectangle=scan.nextDouble();
			Double areaOfRectangle=areaOfRectangle(widthOfRectangle,heightOfRectangle);
			System.out.println("The area of Rectangle is = "+areaOfRectangle);
			break;
		case 3:
			System.out.println("Enter width of Square");
			Double widthOfSquare=scan.nextDouble();
			Double areaOfSquare=areaOfSquare(widthOfSquare);
			System.out.println("The area of Square is = "+areaOfSquare);
			break;
		case 4:
			System.out.println("Enter radius of Circle");
			Double radius=scan.nextDouble();
			Double areaOfCircle=areaOfCircle(radius);
			System.out.println("The area of Circle is = "+areaOfCircle);
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
