package coderPower;

import java.util.*;

/**
 * En balade à Las Vegas, vous tombez sur un stand avec un jeu simple : le croupier mélange le jeu de carte (limité aux cartes de 1 à 9) et en tire une au hasard.
 * Avant le tirage, si vous aviez annoncé le bon chiffre, vous remportez huit fois votre mise, sinon vous perdez votre argent.
 * <p>
 * Vous savez que les gains potentiels sur ce type de jeu sont très faibles mais votre ami, n'est pas du même avis. Il se lance !
 * Quitte à le regarder jouer, vous lui conseillez de jouer les chiffres qui tombent souvent consécutivement
 * (il n'y a pas vraiment d'explication pour cette méthode, mais bon, cela fait au moins une stratégie).
 * Vous étudiez donc les tirages passés qui sont affichés sur un écran au-dessus de la table pour déterminer la longueur de la plus grande série où un chiffre est répété.
 * <p>
 * Données
 * <p>
 * Entrée
 * <p>
 * Ligne 1 : un entier N compris entre 1 et 10 000 correspondant au nombre de tirages affichés dans l'historique.
 * Lignes 2 à N+1 : un chiffre entre 1 et 9 correspondant au numéro de la carte tirée.
 * <p>
 * Sortie
 * <p>
 * Un nombre correspondant à la longueur de la plus grande série où un chiffre est répété.
 * <p>
 * Exemple
 * <p>
 * Pour l'entrée :
 * 10
 * 5
 * 3
 * 3
 * 4
 * 9
 * 9
 * 9
 * 9
 * 9
 * 6
 * <p>
 * La sortie sera 5, car la plus longue série où un chiffre s'est répété est lorsque le 9 est tombé 5 fois de suite.
 */
public class SerieDeCartes {
	public static void main(String[] argv) throws Exception {
		Scanner sc = new Scanner(System.in);
		int numCards = Integer.parseInt(sc.nextLine());
		List<Integer> cards = new ArrayList<>();
		for (int i = 0; i < numCards; i++) {
			cards.add(Integer.parseInt(sc.nextLine()));
		}
		/**
		 * Au départ, il faut initialiser 3 variables, la première qu'on va nommer D est la valeur de la dernière carte (pour commencer mettez -1).
		 * La 2ème est la longueur de la plus grande série (au départ 0), on va l'appeler M.
		 * La 3ème est la longueur de la série en cours, on va l'appeler L et vaut initialement 0.
		 * Ensuite on parcours la série de tirages. Pour chaque carte, si la carte actuelle est égale à D alors L=L+1 et M = Max(L,M).
		 * Sinon D= carte actuelle, L=1. A la fin on affiche M.
		 */
		int D = -1;
		int M = 0;
		int L = 0;
		for(int i =0;i<cards.size();i++){
			if(cards.get(i).equals(D)){
				L++;
				M = Math.max(L,M);
			} else {
				D = cards.get(i);
				L=1;
			}
		}

		System.out.println(M);
	}
}
