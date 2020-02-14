package hackerrank;

/**
 * Write a factorial function that takes a positive integer,N as a parameter and prints the result of N! (N factorial).
 */

import java.util.Scanner;

public class Factorielle {
	private static final Scanner scanner = new Scanner(System.in);
	// Complete the factorial function below.
	static int factorial(int n) {
		if(n == 0){
			return 1;
		} else {
			return n * factorial(n-1);
		}
	}

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		int result = factorial(n);
		System.out.println(result);
		scanner.close();
	}
}
