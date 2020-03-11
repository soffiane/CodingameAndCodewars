package codingame;
/**
 * Indiquez si un nombre positif N est heureux ou pas.
 *
 * Un nombre est heureux (HAPPY) si la somme répétée des carrés des chiffres constituant ce nombre vaut 1.
 *
 * Par exemple, si N=86, ses chiffres sont 8 et 6, alors:
 *
 * 86 => 8^2 + 6^2 = 64 + 36 = 100
 * 100 => 1^2 + 0^2 + 0^2 = 1
 *
 * donc 86 est heureux.
 */

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class IsNumberHappy {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigInteger N = in.nextBigInteger();
		String number = String.valueOf(N);
		String[] digits2 = number.split("(?<=.)");
		int collect = 0;
		while(digits2.length != 1){
			 collect = Arrays.stream(digits2)
					.map(s -> Math.pow(Integer.parseInt(s), 2))
					.mapToInt(Double::intValue).sum();
			digits2 = String.valueOf(collect).split("(?<=.)");
		}
		System.out.println(collect == 1 ? N+" IS HAPPY" :N+" IS UNHAPPY" );
	}

	/**
	 * Python
	 * n = input()
	 *
	 * aux = n
	 * while len(aux)!=1:
	 *     aux = str(sum([int(i)**2 for i in aux]))
	 *
	 * print(f"{n} IS HAPPY" if aux=="1" else f"{n} IS UNHAPPY")
	 */
}
