import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
// intSet java class
public final class intSet {
	private static Scanner scan=new Scanner(System.in);
	// method which returns the size of array
	private static int size(int[] arr){
		return arr.length;
	}
	// method to check set is subset of universal set or not
	private static boolean isSubset(int[] universal_set){
		System.out.println("Enter total no of elements in your set = ");
		int n2=scan.nextInt();
		int set1[]=new int[n2];
		System.out.println("Enter elements of your set");
		for (int i = 0; i < set1.length; i++) {
			set1[i]=scan.nextInt();
		}
		for(int i=0;i<set1.length;i++){
			for (int j = 0; j < universal_set.length; j++) {
				if(set1[i]==universal_set[j]){
					break;
				}
				if(j==universal_set.length-1) {
					return false;
				}
			}
		}
		return true;
	}
	// method to check a number is member of universal set or not
	private static boolean isMember(int[] arr){
		System.out.println("Enter number you want to search in the set = ");
		int num=scan.nextInt();
		for(int i=0;i<arr.length;i++){
			if(arr[i]==num){
				return true;
			}
		}
		return false;
	}
	// method to find union of two sets
	private static Integer[] union(){
		System.out.println("Enter total no of elements of 1st set = ");
		int n1=scan.nextInt();
		Integer[] set1= new Integer[n1];
		System.out.println("Enter total no of elements of 2nd set = ");
		int n2=scan.nextInt();
		Integer[] set2=new Integer[n2];
		System.out.println("Enter elements of 1st set");
		for (int i = 0; i < n1; i++) {
			set1[i]=scan.nextInt();
		}
		System.out.println("Enter elements of 2nd set");
		for (int i = 0; i < n2; i++) {
			set2[i]=scan.nextInt();
		}
		HashSet<Integer> union_set=new HashSet<>();
		union_set.addAll(Arrays.asList(set1));
		union_set.addAll(Arrays.asList(set2));
		Integer[] union={};
		union=union_set.toArray(union);
		return union;
	}
	// method to get complement set of a set
	private static Integer[] getComplement(int[] universal_set){
		Integer[] uni_set=new Integer[universal_set.length];
		for (int i = 0; i < universal_set.length; i++) {
			uni_set[i]=Integer.valueOf(universal_set[i]);
		}
		System.out.println("Enter total no of elements of your set = ");
		int n1=scan.nextInt();
		Integer[] set1= new Integer[n1];
		System.out.println("Enter elements of your set");
		for (int i = 0; i < n1; i++) {
			set1[i]=scan.nextInt();
		}
		HashSet<Integer> complement_set=new HashSet<>();
		complement_set.addAll(Arrays.asList(uni_set));
		complement_set.removeAll(Arrays.asList(set1));
		Integer[] complement={};
		complement=complement_set.toArray(complement);
		return complement;
	}
	// method to take user input and perform operations on set
	private static void operations(int[] universal_set){
		System.out.println("Enter 1 to find an element in array\n"
				+ "Enter 2 to find the size of the universal set\n"
				+ "Enter 3 to find subset of universal set\n"
				+ "Enter 4 to get compliement of a set\n"
				+ "Enter 5 to get union of 2 sets\n"
				+ "Enter 6 to exit."
				);
		int input=scan.nextInt();
		switch (input) {
		case 1:
			boolean check=isMember(universal_set);
			if (check==true) {
				System.out.println("Item found in set");				
			}else {
				System.out.println("Item not found in set");
			}
			break;
		case 2:
			int size_of_set=size(universal_set);
			System.out.println("The size of set is = "+size_of_set);
			break;
		case 3:
			boolean subset=isSubset(universal_set);
			if (subset==true) {
				System.out.println("This is a subset");				
			}else {
				System.out.println("This is not a subset");
			}
			break;
		case 4:
			Integer[] complement_set=getComplement(universal_set);
			System.out.println("Complement of the set is = ");
			for (int i : complement_set) {
				System.out.print(i+ " ");
			}
			System.out.println();
			break;
		case 5:
			Integer[] union_set=union();
			System.out.println("Union of the sets is = ");
			for (int i : union_set) {
				System.out.print(i+" ");
			}
			System.out.println();
			break;
		case 6:
			System.out.println("Thanks to use set operations.");
			return;
		default:
			System.out.println("Wrong Input, Try again");
			break;
		}
		operations(universal_set);
	}
	// main method
	public static void main(String[] args) {
		System.out.println("Enter total no of elements in Universal set = ");
		int n=scan.nextInt();
		int universal_set[] = new int[n];
		for(int i=0;i<n;i++){
			universal_set[i]=i+1;
		}
		operations(universal_set);
		scan.close();
	}
}
