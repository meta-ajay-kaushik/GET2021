import java.util.Scanner;
public final class Poly {
	static Scanner scan=new Scanner(System.in);
	private static int[] addPoly(int[] poly1,int[] poly2){
		System.out.println("First polynomial expression is =");
		printPoly(poly1, poly1.length);
		System.out.println("Second polynomial expression is =");
		printPoly(poly2, poly2.length);
		int size=max(poly1.length, poly2.length);
		int sum[]=new int[size];
		for (int i = 0; i < poly1.length; i++) {
			sum[i]=poly1[i];
		}
		for (int i = 0; i < poly2.length; i++) {
			sum[i]+=poly2[i];
		}
		return sum;
	}
	private static int[] multiplyPoly(int[] poly1,int[] poly2){
		System.out.println("First polynomial expression is =");
		printPoly(poly1, poly1.length);
		System.out.println("Second polynomial expression is =");
		printPoly(poly2, poly2.length);
		int[] multiplication=new int[poly1.length+poly2.length-1];
		for (int i = 0; i < poly1.length+poly2.length-1; i++) {
			multiplication[i]=0;
		}
		for (int i = 0; i < poly1.length; i++) {
			for (int j = 0; j < poly2.length; j++) {
				multiplication[i+j]+=poly1[i]*poly2[j];
			}
		}
		return multiplication;
	}
	private static int max(int x, int y){
		return (x>y)? x :y ;
	}
	private static void printPoly(int arr[],int n){
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i]);
			if (i!=0) {
				System.out.print("x^"+i);
			}
			if(i!=n-1){
				System.out.print(" + ");
			}
		}
		System.out.println();
	}
	private static int find_degree(int[] arr){
		printPoly(arr, arr.length);
		return arr.length-1;
	}
	private static float evaluate(int[] poly,float num){
		float result=0;
		for (int i = 0; i < poly.length; i++) {
			result+=(poly[i])*(Math.pow(num, i));
		}
		return result;
	}
	private static void operations(int[] arr){
		System.out.println("Enter 1 to evaluate the value of Polynomial expression\n"
				+ "Enter 2 to find degree of polynomial expression\n"
				+ "Enter 3 to add two polynomial expressions\n"
				+ "Enter 4 to multiply 2 polynomial expressions\n"
				+ "Enter 5 to exit");
		int input=scan.nextInt();
		switch (input) {
		case 1:
			System.out.println("Enter the number, which you want to put in polynomial expression = ");
			float num=scan.nextFloat();
			float result = evaluate(arr,num);
			printPoly(arr, arr.length);
			System.out.println("The value of polynomial is = "+result);
			break;
		case 2:
			int degree = find_degree(arr);
			System.out.println("Degree of the polynomial is = "+degree);
			break;
		case 3:
			System.out.println("Enter total number of integers in 1st polynomial = ");
			int n1=scan.nextInt();
			int[] poly1=new int[n1];
			System.out.println("Enter integers = ");
			for (int i = 0; i < n1; i++) {
				poly1[i]=scan.nextInt();
			}
			System.out.println("Enter total number of integers in 2nd polynomial = ");
			int n2=scan.nextInt();
			int[] poly2=new int[n2];
			System.out.println("Enter integers = ");
			for (int i = 0; i < n2; i++) {
				poly2[i]=scan.nextInt();
			}
			int[] sum=addPoly(poly1,poly2);
			System.out.println("Sum of polynomials is =");
			printPoly(sum, sum.length);
			break;
		case 4:
			System.out.println("Enter total number of integers in 1st polynomial = ");
			int x=scan.nextInt();
			int[] exp1=new int[x];
			System.out.println("Enter integers = ");
			for (int i = 0; i < x; i++) {
				exp1[i]=scan.nextInt();
			}
			System.out.println("Enter total number of integers in 2nd polynomial = ");
			int y=scan.nextInt();
			int[] exp2=new int[y];
			System.out.println("Enter integers = ");
			for (int i = 0; i < y; i++) {
				exp2[i]=scan.nextInt();
			}
			int[] multiplication = multiplyPoly(exp1,exp2);
			System.out.println("Multiplication of polynomials is = ");
			printPoly(multiplication, multiplication.length);
			break;
		case 5:
			System.out.println("Thanks to use polynomial operations.");
			return;
		default:
			System.out.println("Wrong input, try again.");
			break;
		}
		operations(arr);
	}
	
	public static void main(String[] args) {
		System.out.println("Enter total number of integers in polynomial = ");
		int n=scan.nextInt();
		int[] arr=new int[n];
		System.out.println("Enter integers = ");
		for (int i = 0; i < n; i++) {
			arr[i]=scan.nextInt();
		}
		operations(arr);
		scan.close();
	}
}
