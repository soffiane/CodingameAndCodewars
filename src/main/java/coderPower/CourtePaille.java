package coderPower;
/**
 *
 En séminaire avec votre entreprise dans un pays exotique, vous avez la possibilité de participer à plusieurs activités.
 L’excursion sur une île a l’air sympa mais vous préférez participer à la randonnée sur 2 jours.
 Les paysages sur les chemins sont magnifiques et vous n’avez encore jamais dormi à la belle étoile.

 Vous êtes partis depuis plus de 10h et malheureusement tout ne se passe pas comme prévu.
 Il pleut beaucoup, les paysages ne sont pas au rendez-vous et vous êtes épuisés.
 Vous pensiez que sortir les tentes allait vous soulager mais vous vous rendez compte qu’il en manque une.

 Le soleil est presque couché donc il faut vite trouver une solution.
 C'est décidé, une personne doit se sacrifier et ça va se jouer à la courte paille.
 Vous ramassez autant de bout de bois qu’il y a de personnes et chacun votre tour vous allez en tirer un.
 Celui qui tire le plus petit bout de bois dormira sans tente.

 Vous devez déterminer le prénom de la personne qui va dormir sans tente.

 On vous garantit qu’il n’y a pas d’égalité possible.

 Format des données
 Entrée
 Ligne 1 : un entier N compris entre 10 et 100 correspondant au nombre de personnes participant à la randonnée.
 Lignes 2 à N+1 : une chaîne de caractères comprenant entre 5 et 10 caractères en minuscules et un entier compris entre 1 et 1000 séparés par un espace représentant respectivement le prénom d'un participant et la longueur de son bout de bois en centimètres.

 Sortie
 Le prénom de la personne qui dormira sans tente.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CourtePaille {

	public static void main(String... args) throws FileNotFoundException {
		process("src/main/ressources/isograd/randonnee.txt");
	}

	private static void process(String fileName) throws FileNotFoundException {
		try (Scanner sc = new Scanner(new File(fileName))) {
			int N = Integer.parseInt(sc.nextLine());
			int min = Integer.MAX_VALUE;
			String result = null;
			while(sc.hasNextLine()) {
				String[] randonneur = sc.nextLine().split(" ");
				int tailleBoutBois = Integer.parseInt(randonneur[1]);
				if (min > tailleBoutBois) {
					min = tailleBoutBois;
					result = randonneur[0];
				}
			}
			System.out.println(result);
		}
	}
}
