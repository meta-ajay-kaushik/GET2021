package Recursion;

import java.util.Scanner;
// Java class NQueensProblem
public class NQueensProblem {
	public int board[][];
	public int numOfQueens;
	// constructor to initialize board and number of queens
	public NQueensProblem(int sizeOfBoard) {
		board=new int[sizeOfBoard][sizeOfBoard];
		numOfQueens=sizeOfBoard;
	}
	/**
	 * Check if any queen can kill to another or not.
	 * @param row, requires row to check that row elements
	 * @param integer, which is for the column in matrix
	 * @return true, if queens are killing each other
	 * @return false, if queens are safe
	 */
	public boolean isKilling(int row,int y){
		for (int i = 0; i < numOfQueens; i++) {
			if (board[row][i]==1 || board[i][y]==1) {
				return true;
			}
		}
		for (int i = 0; i < numOfQueens; i++) {
			for (int j = 0; j < numOfQueens; j++) {
				if (row-y==i-j) {
					if(board[i][j]==1){
						return true;
					}
				}
				if(row+y==i+j){
					if(board[i][j]==1){
						return true;
					}
				}
			}
		}
		return false;
	}
	/**
	 * Check if queens can be placed in matrix or not.
	 * @param size_of_board, requires board size to iterate on board
	 * @param row, requires row number which we iterate
	 * @return true, if queens can be placed
	 * @return false, if queens can't be placed in matrix
	 */
	public boolean findQueens(int sizeOfBoard,int row){
		if(sizeOfBoard==0){
			return true;
		}
		for (int j = 0; j < numOfQueens; j++) {
			if(!isKilling(row, j)){
				board[row][j]=1;
				if (findQueens(sizeOfBoard-1, row+1)) {
					return true;
				}else {
					board[row][j]=0;
				}
			}
		}
		return false;
	}
	// main method
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the size of board (for 4x4 enter 4)");
		int sizeOfBoard=scan.nextInt();
		NQueensProblem obj=new NQueensProblem(sizeOfBoard);
		if(obj.findQueens(sizeOfBoard,0)){
			System.out.println("Queens placement is possible");
			for (int i = 0; i < sizeOfBoard; i++) {
				for (int j = 0; j < sizeOfBoard; j++) {
					System.out.print(obj.board[i][j]+" ");
				}
				System.out.println();
			}
		}else{
			System.out.println("Queens placement Not Possible for this size of board");
		}
		scan.close();
	}
}
