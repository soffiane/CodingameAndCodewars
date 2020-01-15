/**
 * Le but de cet exercice est de vérifier la présence d’un nombre dans un tableau.
 *
 * Spécifications :
 *
 *     Les éléments sont des nombres entiers classés du plus petit au plus grand
 *     Le tableau peut contenir jusqu’à 1 million d’éléments
 *     Le tableau n’est jamais null
 *
 * Implémentez la méthode boolean A.exists(int[] ints, int k) afin qu’elle retourne true si k est présent dans ints, sinon la méthode devra retourner false.
 *
 * Important : Essayez de privilégier le temps d'exécution.
 *
 * Exemple :
 * int[] ints = {-9, 14, 37, 102};
 * A.exists(ints, 102) retourne true
 * A.exists(ints, 36) retourne false
 * La solution fonctionne avec un 'petit' tableau
 * Résolution de problèmes+52pts
 * La solution fonctionne avec un tableau vide
 * Fiabilité+13pts
 * La solution fonctionne en un temps raisonnable avec 1 million d'items ==> KO
 * Résolution de problèmes+183pts
 * La solution utilise l'api J2SE pour effectuer la recherche dichotomique.
 * Connaissance du langage+52pts
 */
package codingame;

import java.util.Arrays;

class TrouveDansUnTableau {

	static boolean exists(int[] ints, int k) {

		boolean b = Arrays.stream(ints).parallel().anyMatch(value -> value == k);
		if(ints.length == 0){
			return false;
		}
		boolean trouve = false;
		int id = 0;
		int ifin = ints.length;
		int im;

		while (!trouve && ((ifin - id) > 1)) {
			im = (id + ifin) / 2;
			trouve = (ints[im] == k);
			if (ints[im] > k) {
				ifin = im;
			} else {
				id = im;
			}
		}
		return (ints[id] == k);
	}
}