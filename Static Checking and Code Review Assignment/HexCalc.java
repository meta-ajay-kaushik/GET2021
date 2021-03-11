import java.util.Scanner;
// hexadecimal calculator operations java class
public class HexCalc {
	// method to add two hexadecimal numbers
    static String add(String num1, String num2) {
        int decimalNum1 = Integer.parseInt(num1, 16);
        int decimalNum2 = Integer.parseInt(num2, 16);
        int sum = decimalNum1 + decimalNum2;
        return Integer.toHexString(sum);
    }
    // method to subtract two hexadecimal numbers
    static String subtract(String num1, String num2) {
        int decimalNum1 = Integer.parseInt(num1, 16);
        int decimalNum2 = Integer.parseInt(num2, 16);
        int subtraction = decimalNum1 - decimalNum2;
        return Integer.toHexString(subtraction);
    }
    // method to multiply two hexadecimal numbers
    static String multiply(String num1, String num2) {
        int decimalNum1 = Integer.parseInt(num1, 16);
        int decimalNum2 = Integer.parseInt(num2, 16);
        int multiplication = decimalNum1 * decimalNum2;
        return Integer.toHexString(multiplication);
    }
    // method to divide two hexadecimal numbers
    static String divide(String num1, String num2) {
        int decimalNum1 = Integer.parseInt(num1, 16);
        int decimalNum2 = Integer.parseInt(num2, 16);
        int division = decimalNum1 / decimalNum2;
        return Integer.toHexString(division);
    }
    // method to convert hexadecimal to decimal
    static int hexaToDecimal(String hexa) {
        return Integer.parseInt(hexa, 16);
    }
    // method to convert decimal to hexadecimal
    static String decimalToHexa(int deci) {
        return Integer.toHexString(deci);
    }
    // method to compare two hexadecimal numbers are equal or not
    static boolean compareForEqual(String num1, String num2) {
        int resultOfCompare = num1.compareTo(num2);
        if (resultOfCompare == 0) {
            return true;
        } else {
            return false;
        }
    }
    // method to compare if fist hexadecimal number greater or not
    static boolean compareForGreater(String num1, String num2) {
        int resultOfCompare = num1.compareTo(num2);
        if (resultOfCompare > 0) {
            return true;
        } else {
            return false;
        }
    }
    // method to compare if fist hexadecimal number lesser or not
    static boolean compareForLesser(String num1, String num2) {
        int resultOfCompare = num1.compareTo(num2);
        if (resultOfCompare < 0) {
            return true;
        } else {
            return false;
        }
    }
    // method to take user input
    static void takeInput() {
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
                takeInput();
                break;
            case 2:
                String sub = subtract(num1, num2);
                System.out.println(sub);
                takeInput();
                break;
            case 3:
                String mul = multiply(num1, num2);
                System.out.println(mul);
                takeInput();
                break;
            case 4:
                String div = divide(num1, num2);
                System.out.println(div);
                takeInput();
                break;
            case 5:
                System.out.println("Enter number in hexadecimal to convert it into decimal");
                String hexa = scan.next();
                int hexaToDeci = hexaToDecimal(hexa);
                System.out.println(hexaToDeci);
                takeInput();
                break;
            case 6:
                System.out.println("Enter number in decimal to convert it into hexadecimal");
                int deci = scan.nextInt();
                String deciToHexa = decimalToHexa(deci);
                System.out.println(deciToHexa);
                takeInput();
                break;
            case 7:
                boolean isEqual = compareForEqual(num1, num2);
                if (isEqual == true) {
                    System.out.println("both are equal");
                } else {
                    System.out.println("Not equal");
                }
                takeInput();
                break;
            case 8:
                boolean isGreater = compareForGreater(num1, num2);
                if (isGreater == true) {
                    System.out.println("num1 is greater");
                } else {
                    System.out.println("num1 is Not greater");
                }
                takeInput();
                break;
            case 9:
                boolean isLesser = compareForLesser(num1, num2);
                if (isLesser == true) {
                    System.out.println("num1 is lesser");
                } else {
                    System.out.println("num1 is Not lesser");
                }
                takeInput();
                break;
            case 0:
                System.out.println("Thanks to use this HaxCalc, good bye.");
                scan.close();
                return;
            default:
                System.out.println("Wrong Input, Try again!");
                takeInput();
        }
        scan.close();
    }

    public static void main(String[] args) {
        takeInput();
    }
}
