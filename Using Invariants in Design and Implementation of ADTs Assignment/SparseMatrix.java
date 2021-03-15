import java.util.Scanner;
// sparse matrix java class
public class SparseMatrix {
    private int max = 100;
    private int arr[][] = new int[max][3];
    private int row, col;
    private int length;
    static Scanner scan = new Scanner(System.in);
    // sparse matrix constructor
    private SparseMatrix(int r, int c) {
        row = r;
        col = c;
        length = 0;
    }
    // method to insert item into sparse matrix
    private void insert(int r, int c, int val) {
        arr[length][0] = r;
        arr[length][1] = c;
        arr[length][2] = val;
        length++;
    }
    // method to print sparse matrix
    private void print() {
        System.out.println("Sparse Matrix: "+row+"x"+col+"\nRow Col Value");
        for (int i = 0; i < length; i++) {
            System.out.println(arr[i][0] + "  " + arr[i][1] + "  " + arr[i][2]);
        }
    }
    // method to check a sparse matrix is symmetrical or not
    private static boolean isSymmetric(SparseMatrix s1){
    	if(s1.row!=s1.col){
    		return false;
    	}else{
    		// call transpose method to find transpose of the matrix
    		SparseMatrix transpose = s1.transpose();
    		int i = 0;
    		while(i<s1.length){
    			if(s1.arr[i][0]==transpose.arr[i][0]
    					&& s1.arr[i][1]==transpose.arr[i][1] 
    							&& s1.arr[i][2]==transpose.arr[i][2]){
    				if(i==s1.length-1){
    					return true;
    				}
    				i++;
    			}else{
    				return false;
    			}
    		}
		}
    	return false;
    }
    // method to add two sparse matrix
    private void add(SparseMatrix s2) {
        if (row != s2.row || col != s2.col) {
            System.out.println("Matrices can't be added");
        } else {
            int i = 0, j = 0;
            SparseMatrix output = new SparseMatrix(row, col);
            while (i < length && j < s2.length) {
                if (arr[i][0] > s2.arr[j][0]
                        || (arr[i][0] == s2.arr[j][0] && arr[i][1] > s2.arr[j][1])) {
                    output.insert(s2.arr[j][0], s2.arr[j][1], s2.arr[j][2]);
                    j++;
                } else if (arr[i][0] < s2.arr[j][0]
                        || (arr[i][0] == s2.arr[j][0] && arr[i][1] < s2.arr[j][1])) {
                    output.insert(arr[i][0], arr[i][1], arr[i][2]);
                    i++;
                } else {
                    int sum = arr[i][2] + s2.arr[j][2];
                    if (sum != 0)
                        output.insert(arr[i][0], arr[i][1], sum);
                    i++;
                    j++;
                }
            }
            while (i < length)
                output.insert(arr[i][0], arr[i][1], arr[i++][2]);
            while (j < s2.length)
                output.insert(s2.arr[j][0], s2.arr[j][1], s2.arr[j++][2]);
            output.print();
        }
    }
    // method to find transpose of a sparse matrix
    private SparseMatrix transpose() {
        SparseMatrix output = new SparseMatrix(col, row);
        output.length = length;
        int count[] = new int[col + 1];
        for (int i = 1; i <= col; i++)
            count[i] = 0;
        for (int i = 0; i < length; i++)
            count[arr[i][1]]++;
        int[] index = new int[col + 1];
        index[1] = 0;
        for (int i = 2; i <= col; i++)
            index[i] = index[i - 1] + count[i - 1];
        for (int i = 0; i < length; i++) {
            int rpos = index[arr[i][1]]++;
            output.arr[rpos][0] = arr[i][1];
            output.arr[rpos][1] = arr[i][0];
            output.arr[rpos][2] = arr[i][2];
        }
        return output;
    }
    // method to multiply two sparse matrix
    private void multiply(SparseMatrix s2) {
        if (col != s2.row) {
            System.out.println("Can't multiply, " + "Invalid dimensions");
            return;
        }
        s2 = s2.transpose();
        int i, j;
        SparseMatrix result = new SparseMatrix(row, s2.row);
        for (i = 0; i < length;) {
            int r = arr[i][0];
            for (j = 0; j < s2.length;) {
                int c = s2.arr[j][0];
                int tempS1 = i;
                int tempS2 = j;
                int sum = 0;
                while (tempS1 < length && arr[tempS1][0] == r && tempS2 < s2.length && s2.arr[tempS2][0] == c) {
                    if (arr[tempS1][1] < s2.arr[tempS2][1])
                        tempS1++;
                    else if (arr[tempS1][1] > s2.arr[tempS2][1])
                        tempS2++;
                    else
                        sum += arr[tempS1++][2] * s2.arr[tempS2++][2];
                }
                if (sum != 0)
                    result.insert(r, c, sum);
                while (j < s2.length && s2.arr[j][0] == c)
                    j++;
            }
            while (i < length && arr[i][0] == r)
                i++;
        }
        result.print();
    }
    // method to take input from user and perform operations
    private static void operations(SparseMatrix s1) {
        System.out.println(
                "Enter 1 to transpose\nEnter 2 to check symmetrical or not\nEnter 3 to add two matrices\nEnter 4 to multiply two matrices\nEnter 5 to exit.");
        int input = scan.nextInt();
        switch (input) {
            case 1:
                SparseMatrix transpose = s1.transpose();
                transpose.print();
                break;
            case 2:
            	boolean output=isSymmetric(s1);
            	if(output==true){
            		System.out.println("Matrix is Symmetric");
            	}
            	else{
            		System.out.println("Matrix is not Symmetric");
            	}
                break;
            case 3:
                SparseMatrix s3 = takeSparseMatrix();
                System.out.println("Addition: ");
                s1.add(s3);
                break;
            case 4:
                SparseMatrix s2 = takeSparseMatrix();
                System.out.println("\nMultiplication: ");
                s1.multiply(s2);
                break;
            case 5:
                System.out.println("Good Bye ...");
                return;
            default:
                System.out.println("Wrong Input, Try again.");
                break;
        }
        operations(s1);
    }
    // method to take input of a sparse matrix
    private static SparseMatrix takeSparseMatrix() {
        System.out.println("Enter rows of matrix");
        int row = scan.nextInt();
        if (row < 1) {
            System.out.println("Wrong input, try again");
            takeSparseMatrix();
        }
        System.out.println("Enter columns of matrix");
        int col = scan.nextInt();
        if (col < 1) {
            System.out.println("Wrong input, try again");
            takeSparseMatrix();
        }
        SparseMatrix s1 = new SparseMatrix(row, col);
        System.out.println("How much non zero elements you want to insert.");
        int y = scan.nextInt();
        if (y < 1 || y > row * col) {
            System.out.println(y + " elements can't be inserted, try again.");
            takeSparseMatrix();
        } else {
            for (int i = 0; i < y; i++) {
                System.out.println("Enter row index");
                int r = scan.nextInt();
                if (r < 1 || r > row) {
                    System.out.println("Row not present.");
                    takeSparseMatrix();
                } else {
                    System.out.println("Enter col index");
                    int c = scan.nextInt();
                    if (c < 1 || c > col) {
                        System.out.println("Column not present.");
                        takeSparseMatrix();
                    } else {
                        System.out.println("Enter value");
                        int v = scan.nextInt();
                        s1.insert(r, c, v);
                        s1.print();
                    }
                }
            }
        }
        return s1;
    }
    // main method
    public static void main(String args[]) {
        SparseMatrix s1 = takeSparseMatrix();
        operations(s1);
        scan.close();
    }
}