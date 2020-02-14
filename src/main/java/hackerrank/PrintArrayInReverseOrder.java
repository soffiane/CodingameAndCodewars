package hackerrank;

import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.rangeClosed;

/**
 * Task
 * Given an array, A , of N integers, print 's elements in reverse order as a single line of space-separated numbers.
 */
public class PrintArrayInReverseOrder {
    private static final Scanner scanner = new Scanner(System.in);

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

        System.out.println(rangeClosed(1, arr.length)
                .mapToObj(i -> arr[arr.length - i])
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));

        scanner.close();
    }
}
