package hackerrank;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Day 14 : Scope
 *
 * The absolute difference between two integers, a and b, is written as |a - b|.
 * The maximum absolute difference between two integers in a set of positive integers, elements , is the largest absolute difference between any two integers in elements.
 *
 * The Difference class is started for you in the editor. It has a private integer array (elements)
 * for storing  non-negative integers, and a public integer (maximumDifference) for storing the maximum absolute difference.
 *
 * Task
 * Complete the Difference class by writing the following:
 *
 * A class constructor that takes an array of integers as a parameter and saves it to the elements instance variable.
 * A computeDifference method that finds the maximum absolute difference between any 2 numbers in N and stores it in the maximumDifference instance variable.
 * Input Format
 *
 * You are not responsible for reading any input from stdin.
 * The locked Solution class in your editor reads in 2 lines of input; the first line contains N , and the second line describes the elements array.

 * Output Format
 *
 * You are not responsible for printing any output; the Solution class will print the value of the maximumDifference instance variable.
 *
 * Sample Input
 *
 * 3
 * 1 2 5
 * Sample Output
 *
 * 4
 */
public class MaximumDifference {

	static class Difference {
		private int[] elements;
		public int maximumDifference;

		public Difference(int[] elements) {
			this.elements = elements;
		}

		public void computeDifference() {
			IntSummaryStatistics stats = IntStream.of(elements).summaryStatistics();
			if (stats.getCount() == 0) {
				maximumDifference = 0;
			}
			maximumDifference =  stats.getMax() - stats.getMin();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();

		Difference difference = new Difference(a);
		difference.computeDifference();
		System.out.print(difference.maximumDifference);
	}
}


