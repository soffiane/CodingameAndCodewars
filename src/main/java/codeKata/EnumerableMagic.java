package codeKata;

import java.util.Arrays;

/**
 * Create a method take that accepts a list/array and a number n, and returns a list/array array of the first n elements from the list/array.
 */
public class EnumerableMagic {
	public static int[] take(int[] arr, int n) {
		return Arrays.copyOfRange(arr,0,n);
	}
	public static void main(String[]args){
		int[] take = take(new int[]{0, 1, 2, 3, 5, 8, 13}, 3);
		Arrays.stream(take).forEach(System.out::print);
	}
}
