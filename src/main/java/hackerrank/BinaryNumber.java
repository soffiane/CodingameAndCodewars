package hackerrank;


import java.util.Scanner;

/**
 * Given a base-10 integer,N , convert it to binary (base-2).
 * Then find and print the base-10 integer denoting the maximum number of consecutive 1's in n's binary representation.
 */
public class BinaryNumber {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		String s = Integer.toBinaryString(n);
		char[] chars = s.toCharArray();
		int cpt = 1;
		int max = 0;
		for (int i = 0; i < chars.length - 1; i++) {
			if (chars[i] == '1' && chars[i] == chars[i + 1]) {
				cpt++;
				if (max < cpt) {
					max = cpt;
				} else {
					cpt = 1;
				}
			}
		}
		if (max < cpt) {
			max = cpt;
		}
		System.out.println(max);
		scanner.close();
	}
}
