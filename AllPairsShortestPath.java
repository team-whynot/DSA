import java.util.*;

public class AllPairsShortestPath{
	static Scanner sc =  new Scanner(System.in); 
	static int n;
	// Vector v which will store the distance matrices...
	static Vector<int[][]> v = new Vector();
	// Vector which stores the paths for every vertex to every other vertex
	Vector<HashMap<Integer, Integer>> allpaths = new Vector();
	public static void main(String[] args) {
		System.out.printf("Enter number of vertices in graph: ");
		n = sc.nextInt();
		int A[][] = new int[n][n];
		int path[][]  = new int[n][n];
		System.out.println("Enter the adjacency matrix: ");
		
		for(int i=0; i<n; i++){
			for(int j=0;j<n;j++){
				int input = sc.nextInt();
				if(i==j)
					path[i][j] = 0;
				if(input == -1) {
					path[i][j] = -1;
					A[i][j] = 100000;
				}
				else {
					path[i][j] = i;
					A[i][j] = input;
	
				}
			}
		}
		// Adding initial distance matrix to distance vector
		v.add(A);
		solver(path);
		printMatrices();
		pathFinder(path);
	}

	public static void solver(int path[][]){
		for(int k=0;k<n;k++){
			// Creating a new matrix for storing distance matrix through 'k' vertex... 
			int A[][] = new int[n][n];
			// Getting the last element from vector of distances matrix
			int A_prev[][] = v.lastElement();
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if((A_prev[i][k]+A_prev[k][j]<A_prev[i][j]))
						path[i][j] = path[k][j];
					A[i][j] = Math.min(A_prev[i][j], A_prev[i][k]+A_prev[k][j]);
				}
			}
			v.add(A);
		}
	}

	public static void printMatrices(){
		for(int k=0;k<=n;k++){
			int A[][] = v.get(k);
			System.out.println("Matrix A^"+k+":");
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(100000!=A[i][j])
						System.out.printf(A[i][j]+ "     ");
					else
						System.out.printf("INF   ");
				}
				System.out.println();
			}
		}
	}
	
	public static void pathFinder(int path[][]){
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++) {
				if(i==j) {
					System.out.println("No Path available for "+(i+1)+" to "+(j+1));
					continue;
				}
				if (i != j && path[i][j] != -1) {
					System.out.printf("Shortest path from "+(i+1)+"->"+(j+1)+" is: "+(i+1)+"->"); 
					printPath(path,i,j);
					System.out.println((j+1)+"\t\t with cost = "+ v.lastElement()[i][j]);
				}
			}
		}
	}
	
	public static void printPath(int path[][], int v, int u) {
		if(path[v][u] == v)
			return ;
		printPath(path,v,path[v][u]);
		System.out.printf((path[v][u]+1)+"->");
	}
}


/*

0 3 -1 7
8 0 2 -1
5 -1 0 1 
2 -1 -1 0
 
*/

/*
0 4 11
6 0 2
3 -1 0

*/

/*
0 5 -1 10 
-1 0 3 -1 
-1 -1 0 1  
-1 -1 -1 0
 
 
 */




