import java.util.Scanner;
// hexadecimal calculator operations java class
public class HexCalc {
	// method to add two hexadecimal numbers
    static String add(String num1, String num2) {
        int decimal_num1 = Integer.parseInt(num1, 16);
        int decimal_num2 = Integer.parseInt(num2, 16);
        int sum = decimal_num1 + decimal_num2;
        return Integer.toHexString(sum);
    }
    // method to subtract two hexadecimal numbers
    static String subtract(String num1, String num2) {
        int decimal_num1 = Integer.parseInt(num1, 16);
        int decimal_num2 = Integer.parseInt(num2, 16);
        int subtraction = decimal_num1 - decimal_num2;
        return Integer.toHexString(subtraction);
    }
    // method to multiply two hexadecimal numbers
    static String multiply(String num1, String num2) {
        int decimal_num1 = Integer.parseInt(num1, 16);
        int decimal_num2 = Integer.parseInt(num2, 16);
        int multiplication = decimal_num1 * decimal_num2;
        return Integer.toHexString(multiplication);
    }
    // method to divide two hexadecimal numbers
    static String divide(String num1, String num2) {
        int decimal_num1 = Integer.parseInt(num1, 16);
        int decimal_num2 = Integer.parseInt(num2, 16);
        int division = decimal_num1 / decimal_num2;
        return Integer.toHexString(division);
    }
    // method to convert hexadecimal to decimal
    static int hexa_to_decimal(String hexa) {
        return Integer.parseInt(hexa, 16);
    }
    // method to convert decimal to hexadecimal
    static String decimal_to_hexa(int deci) {
        return Integer.toHexString(deci);
    }
    // method to compare two hexadecimal numbers are equal or not
    static boolean compare_for_equal(String num1, String num2) {
        int result_of_compare = num1.compareTo(num2);
        if (result_of_compare == 0) {
            return true;
        } else {
            return false;
        }
    }
    // method to compare if fist hexadecimal number greater or not
    static boolean compare_for_greater(String num1, String num2) {
        int result_of_compare = num1.compareTo(num2);
        if (result_of_compare > 0) {
            return true;
        } else {
            return false;
        }
    }
    // method to compare if fist hexadecimal number lesser or not
    static boolean compare_for_lesser(String num1, String num2) {
        int result_of_compare = num1.compareTo(num2);
        if (result_of_compare < 0) {
            return true;
        } else {
            return false;
        }
    }
    // method to take user input
    static void take_input() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter two Hexadecimal numbers");
        String num1 = scan.next();
        String num2 = scan.next();
        System.out.println(
                "Enter 1 to add\nEnter 2 to subtract\nEnter 3 to multiply\nEnter 4 to Divide\nEnter 5 to convert hexadecimal to decimal\nEnter 6 to convert decimal to hexadecimal\nEnter 7 to compare both hexa numbers for ==\nEnter 8 to compare both hexa numbers for >\nEnter 9 to compare both hexa numbers for <\nEnter 0 to exit from HaxCalc");
        int operation = scan.nextInt();
        switch (operation) {
            case 1:
                String sum = add(num1, num2);
                System.out.println(sum);
                take_input();
                break;
            case 2:
                String sub = subtract(num1, num2);
                System.out.println(sub);
                take_input();
                break;
            case 3:
                String mul = multiply(num1, num2);
                System.out.println(mul);
                take_input();
                break;
            case 4:
                String div = divide(num1, num2);
                System.out.println(div);
                take_input();
                break;
            case 5:
                System.out.println("Enter number in hexadecimal to convert it into decimal");
                String hexa = scan.next();
                int hexaToDeci = hexa_to_decimal(hexa);
                System.out.println(hexaToDeci);
                take_input();
                break;
            case 6:
                System.out.println("Enter number in decimal to convert it into hexadecimal");
                int deci = scan.nextInt();
                String deciToHexa = decimal_to_hexa(deci);
                System.out.println(deciToHexa);
                take_input();
                break;
            case 7:
                boolean is_equal = compare_for_equal(num1, num2);
                if (is_equal == true) {
                    System.out.println("both are equal");
                } else {
                    System.out.println("Not equal");
                }
                take_input();
                break;
            case 8:
                boolean is_greater = compare_for_greater(num1, num2);
                if (is_greater == true) {
                    System.out.println("num1 is greater");
                } else {
                    System.out.println("num1 is Not greater");
                }
                take_input();
                break;
            case 9:
                boolean is_lesser = compare_for_lesser(num1, num2);
                if (is_lesser == true) {
                    System.out.println("num1 is lesser");
                } else {
                    System.out.println("num1 is Not lesser");
                }
                take_input();
                break;
            case 0:
                System.out.println("Thanks to use this HaxCalc, good bye.");
                scan.close();
                return;
            default:
                System.out.println("Wrong Input, Try again!");
                take_input();
        }
        scan.close();
    }

    public static void main(String[] args) {
        take_input();
    }
}
