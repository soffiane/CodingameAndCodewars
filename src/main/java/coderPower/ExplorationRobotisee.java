package coderPower;

import java.util.Scanner;

/**
 * Enoncé
 * Soit un robot pouvant effectuer des déplacements unitaires dans les quatre directions —Ouest, Nord, Est, Sud— dans sur un terrain considéré comme une grille de cases.
 * On dispose de l’enregistrement des déplacements, codépar une séquence de lettres (’O’ pour Ouest, ’N’ pour Nord, ’E’ pour Est et ’S’ pour Sud).
 * L’objectif du programme à réaliser est de trouver la séquence de N déplacements qui correspond à l’exploration du plus grand nombre de cases possible.
 * C’est-à-dire que cette séquence doit contenir le moins de retours en arrière possible.
 * Par exemple, la séquence "NNN" correspond à l’exploration de 4 cases (on compte la case initiale),
 * alors que la séquence "NSNSN" ne correspond à l’exploration que de deux cases (la case initiale et celle située au Nord de celle-ci).
 *
 * Format des données
 *
 * Entrée
 * Sur la première ligne, la taille N de la sous-séquence de déplacements à trouver, nombre entier décimal strictement positif.
 * Sur la seconde ligne, la séquence complète de déplacements, c’est-à-dire de caractères issus de l’alphabet {’O’,’N’,’E’,’S’}.
 *
 * Sortie
 * Sur la première ligne, le nombre de cases explorées par la sous-séquence de N déplacements qui maximise ce nombre.
 * Sur la seconde ligne, la sous-séquence de N déplacements extraite.
 */
public class ExplorationRobotisee {
	public static void main( String[] argv ) throws Exception {
		String  line;
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			/* Lisez les données et effectuez votre traitement */
			//TODO : implement
		}
		/* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
	}
}
//100
//SOEENONOENESESSOOSNSOSNENSEENENESEEOOOSNENNNOONNONNEOOONOONNNNSEOONOOSESSOOSOSSEESESEOESSOSESOSEEOSO
//output 77
