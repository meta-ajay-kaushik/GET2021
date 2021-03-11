package JUnitTesting;
import java.util.Scanner;
// main java class ArrOperation
public class ArrOperation {
	static Scanner scan=new Scanner(System.in);
	/**
	 * Find the size of the largest mirror section in the input array.
	 * @param arr, requires array to perform operation
	 * Throw AssertionError if array is empty
	 * @return size of the largest mirror section
	 */
	public static int maxMirror(int[] arr) {
		int max=-1;
		try {
			if (arr.length==0) {
				throw new AssertionError("Empty array");
			}
			else{
				for (int i = 0; i < arr.length; i++) {
					int k=i;
					int count=0;
					for (int j = arr.length-1; j>=i; j--) {
						if(arr[j]==arr[k]){
							count++;
							k++;
							if(k>=arr.length){
								if(max<count){
									max=count;
								}
								break;
							}
						}else if (count!=0) {
							if(count>max){
								max=count;
							}
							count=0;
							k=i;
						}
					}
					if(count>max){
						max=count;
					}
					if((arr.length-i)<max){
						break;
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return max;
	}
	/**
	 * Find the number of clumps in the input array.
	 * @param arr, requires array to perform operation
	 * Throw AssertionError if array is empty
	 * @return number of clumps in the array
	 */
	public static int countClumps(int[] arr){
		int count=0;
		try {
			if(arr.length==0){
				throw new AssertionError("Empty Array");
			}else{
				int num=-1;
				for (int i = 1; i < arr.length; i++) {
					if ((arr[i-1]==arr[i])&&(num!=arr[i-1])) {
						count++;
						num=arr[i];
					}
					else if ((arr[i-1]==arr[i])&&(num==arr[i-1])) {
						
					}
					else{
						num=-1;
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return count;
	}
	/**
	 * Rearrange the array as x is followed by y.
	 * @param arr, requires array to perform operation
	 * @param x, requires value x
	 * @param y, requires value y
	 * Throw AssertionError if array is empty
	 * @return rearranged array
	 */	
	public static int[] fixXY(int[] arr,int x,int y){
		try {
			if(arr.length==0){
				throw new AssertionError("Empty array");
			}else if (arr[arr.length-1]==x) {
				throw new AssertionError("X occurs at the last index of the array");
			}
			else{
				for (int i = 0; i < arr.length-1; i++) {
					if(arr[i]==x && arr[i+1]==x){
						throw new AssertionError("two adjacents X values are there");
					}
				}
				int countX=0,countY=0;
				for (int i = 0; i < arr.length; i++) {
					if(arr[i]==x){
						countX++;
					}
					if (arr[i]==y) {
						countY++;
					}
				}
				if(countX!=countY){
					throw new AssertionError("there are unequal numbers of X and Y");
				}
				for (int i = 0; i < arr.length; i++) {
					if(arr[i]==y){
						for (int j = 0; j < arr.length; j++) {
							if(arr[j]==x && arr[j+1]!=y && j!=arr.length-1){
								int temp=arr[i];
								arr[i]=arr[j+1];
								arr[j+1]=temp;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return arr;
	}

	/**
	 * Find the index where left and right elements sum is equal.
	 * @param arr, requires array to perform operation
	 * Throw AssertionError if array is empty
	 * @return index of the perfect splitting
	 * @return -1, if splitting is not possible
	 */
	public static int splitArray(int[] arr){
		int k=-1;
		try {
			int sum=0;
			if(arr.length==0){
				throw new AssertionError("Empty array");
			}
			else{
				for (int i = 0; i < arr.length; i++) {
					sum=sum+arr[i];
					arr[i]=sum;
				}
				if(sum%2==0){
					for (int i = 0; i < arr.length; i++) {
						if(arr[i]==(sum/2)){
							k=i+1;
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return k;
	}
	/**
	 * Take input from user and perform various operations.
	 * @return call methods and print output on display
	 */
	public static void operations(){
		System.out.println("Enter 1 to find largest mirror section size\n"
				+ "Enter 2 to find number of clumps in array\n"
				+ "Enter 3 to rearrange array as XY\n"
				+ "Enter 4 to find index of split array where sum of left right is equal\n"
				+ "Enter 5 to exit");
		int input=scan.nextInt();
		switch (input) {
		case 1:
			System.out.println("Enter total no of elements in array");
			int totalNum=scan.nextInt();
			int[] arr=new int[totalNum];
			System.out.println("Enter elements of array");
			for (int i = 0; i < totalNum; i++) {
				arr[i]=scan.nextInt();
			}
			int max=maxMirror(arr);
			System.out.println(max);
			break;
		case 2:
			System.out.println("Enter total no of elements in array");
			int totalNum1=scan.nextInt();
			int[] arr1=new int[totalNum1];
			System.out.println("Enter elements of array");
			for (int i = 0; i < totalNum1; i++) {
				arr1[i]=scan.nextInt();
			}
			int clumps=countClumps(arr1);
			System.out.println(clumps);
			break;
		case 3:
			System.out.println("Enter total no of elements in array");
			int totalNum2=scan.nextInt();
			int[] arr2=new int[totalNum2];
			System.out.println("Enter elements of array");
			for (int i = 0; i < totalNum2; i++) {
				arr2[i]=scan.nextInt();
			}
			System.out.println("Enter value of X");
			int x=scan.nextInt();
			System.out.println("Enter value of Y");
			int y=scan.nextInt();
			int[] fixArr=fixXY(arr2,x,y);
			for (int i = 0; i < fixArr.length; i++) {
				System.out.print(fixArr[i]+" ");
			}
			System.out.println();
			break;
		case 4:
			System.out.println("Enter total no of elements in array");
			int totalNum3=scan.nextInt();
			int[] arr3=new int[totalNum3];
			System.out.println("Enter elements of array");
			for (int i = 0; i < totalNum3; i++) {
				arr3[i]=scan.nextInt();
			}
			int splitIndex=splitArray(arr3);
			System.out.println(splitIndex);
			break;
		case 5:
			System.out.println("Good bye...");
			return;
		default:
			System.out.println("Wrong input, Try again.");
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
