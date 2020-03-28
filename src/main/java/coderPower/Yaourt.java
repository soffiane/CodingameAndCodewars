package coderPower;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Objectif
 *
 * Vous êtes en charge de la réalisation d'une passionnante étude marketing sur l'emballage d'un nouveau yaourt bio issu de circuits courts. Même si vous regrettez de voir une marque "responsable" s'inspirer des méthodes des producteurs industriels, c'est votre job et vous n'avez pas le choix... Vous recevez les résultats d'une étude où des consommateurs indiquent la couleur qu'ils préfèrent pour l'emballage. Ne voulant prendre seul une décision aussi importante, vous voulez présenter les 2 couleurs les plus demandées à votre patron.
 *
 * Données
 *
 * Entrée
 *
 * Ligne 1 : un entier N compris entre 3 et 10 000 correspondant au nombre de personnes interrogées.
 * Lignes 2 à N+1 : une chaîne comprenant entre 4 et 10 caractères alphabétiques en minuscules correspondant à la couleur préférée pour l'emballage pour une personne donnée.
 *
 * Sortie
 *
 * Deux chaines de caractères séparées par un espace représentant les deux couleurs préférées. La couleur la plus populaire doit apparaître en premier.
 *
 * On vous garantit qu'il n'y aura jamais 2 couleurs d'ex-aequo.
 *
 * Exemple
 *
 * Pour l'entrée :
 * 6
 * rouge
 * jaune
 * bleu
 * rouge
 * jaune
 * rouge
 *
 * La réponse est :
 * rouge jaune
 *
 * Car le rouge a obtenu 3 votes, le jaune deux votes et le bleu 1 vote.
 */
public class Yaourt {

	public static void main( String[] argv ) throws Exception {
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		Map<String,Integer> couleurs = new HashMap<>();
		for(int i=0;i<num;i++) {
			String couleur = sc.nextLine();
			if(!couleurs.containsKey(couleur)){
				couleurs.put(couleur,1);
			} else {
				Integer integer = couleurs.get(couleur);
				integer++;
				couleurs.put(couleur,integer);
			}
		}
		List<String> collect = couleurs.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println(collect.get(0)+" "+collect.get(1));
		/* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
	}

}
