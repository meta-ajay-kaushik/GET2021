package SoftwareSpecifications;

import java.util.Scanner;
// String Operations java main class
public class StringOperations {
	// initialize scanner as static
	static Scanner scan=new Scanner(System.in);
	/**
	 * Compare two strings are equal or not.
	 * Take input from user of strings
	 * @return 1 if strings are equal
	 * @return 0 if strings are not equal
	 */
	public static int compare_two_string(){
		System.out.println("Enter String 1");
		scan.nextLine();
		String string1=scan.nextLine();
		System.out.println("Enter String 2");
		String string2=scan.nextLine();
		System.out.println(string1);
		System.out.println(string2);
		if(string1.length()!=string2.length()){
			return 0;
		}else{			
			for (int i = 0; i < string1.length(); i++) {
				if(string1.charAt(i)==string2.charAt(i)){
					if(i==string1.length()-1){
						return 1;
					}
				}else{
					return 0;
				}
			}
		}
		return 0;
	}
	/**
	 * Find reverse of the string.
	 * Take input from user of string
	 * @return reverse string
	 */
	public static String reverse_string() {
		System.out.println("Enter a string");
		scan.nextLine();
		String str=scan.nextLine();
		String reverse_str="";
		for(int i=str.length()-1;i>=0;i--){
			reverse_str+=str.charAt(i);
		}
		return reverse_str;
	}
	/**
	 * Change case from lower to upper and vice-versa.
	 * @param str, requires string to change its cases
	 * print new string with changed cases
	 */
	public static void change_case_of_characters(String str){
		StringBuffer new_string=new StringBuffer(str);
		for (int i = 0; i < str.length(); i++) {
			if (Character.isLowerCase(str.charAt(i))) {
				new_string.setCharAt(i, Character.toUpperCase(str.charAt(i)));
			}
			else if (Character.isUpperCase(str.charAt(i))) {
				new_string.setCharAt(i, Character.toLowerCase(str.charAt(i)));
			}
		}
		System.out.println("String after replace case of characters is\n"+new_string);
	}
	/**
	 * Find largest word from string.
	 * @param str, requires string to find largest word
	 * @return largest word of the string
	 */
	public static String find_largest_word(String str){
		String largest_word="";
		String word="";
		String[] words=new String[20];
		int length=0;
		str=str+" ";
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)!=' '){
				word+=str.charAt(i);
			}
			else{
				words[length]=word;
				length++;
				word="";
			}
		}
		largest_word=words[0];
		for (int i = 0; i <length; i++) {
			if(largest_word.length()<=words[i].length()){
				largest_word=words[i];
			}
		}
		return largest_word;
	}
	/**
	 * Take input from user and perform various operations.
	 * @return call methods and print them on display
	 */
	public static void operations(){
		System.out.println("Enter 1 to compare two strings\n"
				+ "Enter 2 to reverse a string\n"
				+ "Enter 3 to replace characters from lower to upper case and vice versa\n"
				+ "Enter 4 to find the largest word of string\n"
				+ "Enter 5 to exit");
		int inp=scan.nextInt();
		switch (inp) {
		case 1:
			int is_equal=compare_two_string();
			if(is_equal==1){
				System.out.println("Both strings are equal");
			}else{
				System.out.println("Strings are different");
			}
			break;
		case 2:
			String reverse_str=reverse_string();
			System.out.println("Reverse string is-\n"+reverse_str);
			break;
		case 3:
			System.out.println("Enter a string");
			scan.nextLine();
			String str=scan.nextLine();
			change_case_of_characters(str);
			break;
		case 4:
			System.out.println("Enter a string");
			scan.nextLine();
			String string=scan.nextLine();
			String largest_word=find_largest_word(string);
			System.out.println("The largest word is = "+largest_word);
			break;
		case 5:
			System.out.println("Good bye...");
			return;
		default:
			System.out.println("Wrong input, Try again");
			break;
		}
		operations();
	}
	// main method
	public static void main(String[] args) {
		operations();
		scan.close();
	}
}
