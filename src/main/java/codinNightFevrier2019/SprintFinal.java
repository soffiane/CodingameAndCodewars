package codinNightFevrier2019;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * # 6 - Le sprint final
 * <p>
 * Ca y est, vous êtes le dernier survivant !!
 * <p>
 * Pour définitivement survivre et remporter la Bataille, il faut vous mettre à l'abri,
 * et la **zone sécurisée** rétrécit dangereusement.
 * <p>
 * La carte est représentée en 1 dimension, et se compose de zones sécurisées (`.`) et de zones dangereuses (`#`).
 * <p>
 * Chaque minute, une zone sécurisée de la carte devient dangereuse.
 * Seule une zone sécurisée touchant une zone dangereuse peut devenir dangereuse.
 * <p>
 * Par exemple, la carte `.#..` peut devenir à la minute suivante `##..` ou `.##.`, mais pas `.#.#`.
 * <p>
 * Afin de survivre et enfin remporter la Bataille, écrivez une fonction qui à partir de la carte actuelle,
 * retourne le nombre de façons qu'il y a de complètement remplir la carte de zones dangereuses.
 * <p>
 * <p>
 * ## Entrée
 * <p>
 * La carte est représentée en 1 dimension, et est découpée en zones : `#` est une zone dangereuse, `.`
 * est une zone sécurisée. Il y a moins de 1000 zones par carte.
 * <p>
 * L'entrée est constituée de 20 testcases (tout en bas de ce fichier), chaque testcase comporte un entier
 * en première ligne qui représente la taille de la carte, et en deuxième ligne la carte.
 * <p>
 * ## Sortie
 * <p>
 * Vous devez retourner un entier par test case représentant le nombre de façons qu'il y a de complètement remplir
 * la carte de zones dangereuses.
 * <p>
 * Cet entier doit être retourné **modulo 10^9 + 7**
 * <p>
 * Envoyez par email à contact@h25.io les résultats des tests cases qui sont affichés plus bas, un entier par ligne,
 * ainsi que votre code en pièce jointe.
 * <p>
 * ## Tests d'exemple
 * <p>
 * ### **1**
 * **Entrée**
 * ```python
 * .#..
 * ```
 * **Sortie**
 * `3`
 * Explication :
 * ```
 * .#.. - ##.. - ###. - ####
 * \
 * .##. - ###. - ####
 * \
 * .### - ####
 * ```
 * <p>
 * ### **2**
 * **Entrée**
 * ```python
 * #...
 * ```
 * **Sortie**
 * `1`
 * <p>
 * <p>
 * ### **3**
 * **Entrée**
 * ```python
 * #...##...
 * ```
 * **Sortie**
 * `80`
 */
public class SprintFinal {

	public static int numPaths = 0;
	static int target = 0;


	public static int process(String fileName) throws FileNotFoundException {

		Scanner in = new Scanner(new File(fileName));
		target = in.nextInt();
		String map = in.nextLine();
		char[] path = map.toCharArray();
		Map<Character, Boolean> characterBooleanMap = new HashMap<>();
		for (int i = 0; i < path.length; i++) {
			if (path[i] == '#') {
			}
		}
		//Cet entier doit être retourné **modulo 10^9 + 7**
		return numPaths;
	}



	public static void main(String... args) throws FileNotFoundException {
		process("src/main/ressources/challenge/testcases.txt");
	}
}
