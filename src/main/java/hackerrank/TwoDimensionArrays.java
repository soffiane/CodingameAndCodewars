package hackerrank;

import java.util.Scanner;

/**
 * Day 15 : 2D Arrays
 * Objective
 * Today, we're building on our knowledge of Arrays by adding another dimension. Check out the Tutorial tab for learning materials and an instructional video!
 *
 * Context
 * Given a 6x6 2D Array, A:
 *
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * We define an hourglass in A to be a subset of values with indices falling in this pattern in A's graphical representation:
 *
 * a b c
 *   d
 * e f g
 * There are 16 hourglasses in A, and an hourglass sum is the sum of an hourglass' values.
 *
 * Task
 * Calculate the hourglass sum for every hourglass in , then print the maximum hourglass sum.
 *
 * Input Format
 *
 * There are 6 lines of input, where each line contains 6 space-separated integers describing 2D Array A; every value in A will be in the inclusive range of -9 to 9.
 *
 * Constraints
 * -9 <= A[i][j] <= 9
 * 0 <= i,j <= 5
 * Output Format
 *
 * Print the largest (maximum) hourglass sum found in A.
 *
 * Sample Input
 *
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 2 4 4 0
 * 0 0 0 2 0 0
 * 0 0 1 2 4 0
 * Sample Output
 *
 * 19
 * Explanation
 *
 * A contains the following hourglasses:
 *
 * 1 1 1   1 1 0   1 0 0   0 0 0
 *   1       0       0       0
 * 1 1 1   1 1 0   1 0 0   0 0 0
 *
 * 0 1 0   1 0 0   0 0 0   0 0 0
 *   1       1       0       0
 * 0 0 2   0 2 4   2 4 4   4 4 0
 *
 * 1 1 1   1 1 0   1 0 0   0 0 0
 *   0       2       4       4
 * 0 0 0   0 0 2   0 2 0   2 0 0
 *
 * 0 0 2   0 2 4   2 4 4   4 4 0
 *   0       0       2       0
 * 0 0 1   0 1 2   1 2 4   2 4 0
 * The hourglass with the maximum sum () is:
 *
 * 2 4 4
 *   2
 * 1 2 4
 */
public class TwoDimensionArrays {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] arr = new int[6][6];

		for (int i = 0; i < 6; i++) {
			String[] arrRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			
			for (int j = 0; j < 6; j++) {
				int arrItem = Integer.parseInt(arrRowItems[j]);
				arr[i][j] = arrItem;
			}
		}
		calculateMaxHourglass(arr);
		scanner.close();
	}

	private static void calculateMaxHourglass(int[][] arr) {
		int max=Integer.MIN_VALUE;
		int sum=0;
		//ligne par ligne
		for(int i=0;i<arr.length-2;i++){
			//colonnes
			for(int j=0;j<arr.length-2;j++){
				//on calcule la somme pour 0 0, 0 1, 0 2, 1 1, 2 0, 2 1 et 2 2 ==> et on decalle par colonne puis par ligne
				sum=arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]+arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
				if(sum>max){
					max=sum;
				}
			}
		}
		System.out.println(max);
	}
}
