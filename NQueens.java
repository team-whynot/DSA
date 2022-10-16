import java.util.*;
public class NQueens{
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int c = 1;
	static int total_nodes = 0;
	public static void main(String[] args) {
		System.out.println("\t*****N - Queens Program using Backtracking*****\n");
		System.out.printf("Enter number of Queens: ");
		n = sc.nextInt();
		boolean chess[][] = new boolean[n][n];
		makeFalse(chess);
		long start = System.currentTimeMillis();
		NQueenSolver(chess,0);
		long end = System.currentTimeMillis();
		System.out.println("Total time for finding solutions for "+n+"-Queens Problem is: "+((float)(end-start)/((float)(1000)))+" seconds");
		System.out.println("Total no. of solutions are: "+(c-1));
		System.out.println("Total number of nodes explored are: "+(total_nodes-1));
	}
	public static void makeFalse(boolean chess[][]){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
					chess[i][j] = false;
			}
		}
	}
	// isSafe function to check whether placing the queen in current position such that it is not under attack...
	public static boolean isSafe(boolean chess[][], int row, int column){
		boolean checkSafePlace = true;
		// Checking whether the any queen is not placed in same column
		for(int i=0;i<row;i++){
			if(chess[i][column]==true)
				return false;
		}
		// Checking for the diagonal attack on left side of current position....
		for(int i=row,j=column;i>=0 && j>=0;i--,j--){
			if(chess[i][j]==true)
				return false;
		}
		// Checking for the diagonal attack on right side of current position....
		for(int i=row,j=column;i>=0 && j<n;i--,j++){
			if(chess[i][j]==true)
				return false;
		}
		// Return true if all above conditions aren't true as the current position isn't under attack....
		return true;
	}
	
	// Function to print the chess board if solution is found....
	public static void printChessBoard(boolean chess[][]) {
		System.out.println("Solution "+c);
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(chess[i][j]== true)
					System.out.printf("Q  ");
				if(chess[i][j]== false)
					System.out.printf("-  ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	// Function for recursively placing a queen on the chess board....
	public static void NQueenSolver(boolean chess[][],int row){
		total_nodes++;
		// If the row no. becomes equal to length of board, then it means we got our solution.... 
		if(row == n){
			if(n<8)
			// Printing the solution...
				printChessBoard(chess);
			c++;
			return;
		}

		for(int j=0;j<n;j++){
			if(isSafe(chess,row,j) == true){
				// If the current position is safe then recursively traverse to the next position on the board...
				chess[row][j] = true;
				NQueenSolver(chess,(row+1));
				// Below statement will refresh the board if any of the queen is placed on the board...
				chess[row][j] = false;
			}
		}
	}
}




