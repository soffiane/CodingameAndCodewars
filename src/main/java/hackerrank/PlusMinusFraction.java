package hackerrank;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Given an array of integers, calculate the fractions of its elements that are positive, negative, and are zeros. Print the decimal value of each fraction on a new line.
 * <p>
 * Note: This challenge introduces precision problems. The test cases are scaled to six decimal places, though answers with absolute error of up to 10pow(-4) are acceptable.
 * <p>
 * For example, given the array arr =[1,1,0,-1,-1]  there are 5 elements, two positive, two negative and one zero. Their ratios would be 2/5 = 0,4000000, 2/5 = 0,4000000 and 1/5=0.20000.
 * It should be printed as
 * 0.400000
 * 0.400000
 * 0.200000
 * Function Description
 * Complete the plusMinus function in the editor below. It should print out the ratio of positive, negative and zero items in the array, each on a separate line rounded to six decimals.
 * plusMinus has the following parameter(s):
 * arr: an array of integers
 * Input Format
 * The first line contains an integer, N, denoting the size of the array.
 * The second line contains  space-separated integers describing an array of numbers .
 * <p>
 * Output Format
 * <p>
 * You must print the following 3 lines:
 * <p>
 * A decimal representing of the fraction of positive numbers in the array compared to its size.
 * A decimal representing of the fraction of negative numbers in the array compared to its size.
 * A decimal representing of the fraction of zeros in the array compared to its size.
 * Sample Input
 * <p>
 * 6
 * -4 3 -9 0 4 1
 * Sample Output
 * <p>
 * 0.500000
 * 0.333333
 * 0.166667
 * Explanation
 * <p>
 * There are 3 positive numbers,2  negative numbers, and 1 zero in the array.
 * The proportions of occurrence are positive:3/6=0.500000 , negative:2/6=0.333333  and zeros: 1/6=0.166667.
 */
public class PlusMinusFraction {

	private static DecimalFormat numberFormat = new DecimalFormat("0.000000");
	private static final Scanner scanner = new Scanner(System.in);

	// Complete the plusMinus function below.
	static void plusMinus(int[] arr) {
		System.out.println(numberFormat.format((double) Arrays.stream(arr).filter(operand -> operand > 0).count() / arr.length));
		System.out.println(numberFormat.format((double) Arrays.stream(arr).filter(operand -> operand < 0).count() / arr.length));
		System.out.println(numberFormat.format((double) Arrays.stream(arr).filter(operand -> operand == 0).count() / arr.length));
	}

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		int[] arr = new int[n];
		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}
		plusMinus(arr);
		scanner.close();
	}
}
