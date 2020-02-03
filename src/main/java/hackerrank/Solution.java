package hackerrank;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Day 5 : Loops
 *
 * Task
 * Given an integer,n , print its first 10 multiples. Each multiple n*i (where 1 <= i <= 10 )
 * should be printed on a new line in the form: n x i = result.
 */
public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        IntStream.rangeClosed(1,10).forEach(value ->  System.out.println(n +" x "+value+" = "+(n*value)));
        scanner.close();
    }
}
