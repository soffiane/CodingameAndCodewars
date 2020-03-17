package hackerrank;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Day 19 : Interfaces
 * <p>
 * The AdvancedArithmetic interface and the method declaration for the abstract divisorSum(n) method are provided for you in the editor below.
 * <p>
 * Complete the implementation of Calculator class, which implements the AdvancedArithmetic interface.
 * The implementation for the divisorSum(n) method must return the sum of all divisors of N.
 * <p>
 * Input Format
 * <p>
 * A single line containing an integer, N.
 * <p>
 * Output Format
 * <p>
 * You are not responsible for printing anything to stdout. The locked template code in the editor below will call your code and print the necessary output.
 * <p>
 * Sample Input
 * <p>
 * 6
 * <p>
 * Sample Output
 * I implemented: AdvancedArithmetic
 * 12
 * Explanation
 * <p>
 * The integer 6 is evenly divisible by 1,2 ,3 and 6. Our divisorSum method should return the sum of these numbers, which is 1+2+3+6=12.
 * The Solution class then prints I implemented: AdvancedArithmetic on the first line, followed by the sum returned by divisorSum (which is 12) on the second line.
 */
public class Interfaces {

	interface AdvancedArithmetic {
		int divisorSum(int n);
	}

	static class Calculatorr implements AdvancedArithmetic {
		public int divisorSum(int n) {
			return IntStream.rangeClosed(1, n)
					.filter(i -> n % i == 0)
					.sum();
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();

		AdvancedArithmetic myCalculator = new Calculatorr();
		int sum = myCalculator.divisorSum(n);
		System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName());
		System.out.println(sum);
	}
}


