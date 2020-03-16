package hackerrank;

import java.util.Scanner;

/**
 * Lire et afficher des parametres en entrée 3 lignes
 * un int, un double et un String qu'on ajoute a ceux existant
 */
public class ScannerClassTrick {
	public static void main(String[] args) {
		int i = 4;
		double d = 4.0;
		String s = "HackerRank ";

		Scanner scan = new Scanner(System.in);

		/* Declare second integer, double, and String variables. */
		int j = scan.nextInt();
		double d2 = scan.nextDouble(); //nextDouble ne lit pas le retour chariot
		//donc ce nextLine() ne renvoie rien
		scan.nextLine();
		String s2 = scan.nextLine();

		/* Read and save an integer, double, and String to your variables.*/
		// Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.

		/* Print the sum of both integer variables on a new line. */
		System.out.println(i + j);
		/* Print the sum of the double variables on a new line. */
		System.out.println(d + d2);
        /* Concatenate and print the String variables on a new line;
        	the 's' variable above should be printed first. */
		System.out.println(s + s2);
	}
}
