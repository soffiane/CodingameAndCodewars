package coderPower;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Enoncé
 *
 * Dans ce challenge, vous devez calculer la distance maximale entre deux ordinateurs situés sur un réseau arborescent.
 * Sur ce réseau virtuel, chaque ordinateur a un ordinateur situé en "amont" (sauf l’ordinateur source qui est à la racine de l’arborescence) et 0 ou plusieurs ordinateurs en "aval".
 * Chaque ordinateur est désigné par un identifiant unique composé d'entre 1 et 16 caractères (lettres minuscules ou chiffres).
 *
 * Le format de description du réseau virtuel arborescent est le suivant : chaque ligne contient une liste d’identifiants séparés par des espaces,
 * les identifiants à partir du second indiquent les ordinateurs situés "en aval" de l’ordinateur dont l’identifiant est le premier de la ligne.
 *
 * Vous devez trouver les deux ordinateurs les plus éloignés et indiquer par combien de liaisons ils sont séparés.
 *
 * Exemples:
 * 1. Réseau trivial composé d'un seul ordinateur (la source) :
 * entrée : src
 * sortie attendue : 0
 * 2. Réseau composé de 4 ordinateurs :
 * entrée: src o1 o2
 * o2 o21
 * sortie attendue : 2
 * 3. Réseau composé de 8 ordinateurs :
 * entrée : s0 o1 o2 o3
 * o1 o11 o12
 * o2 o21
 * o11 o111
 * sortie attendue : 3
 *
 *
 * Données
 *
 * Entrée
 * Entre 1 et 100 lignes décrivant le réseau virtuel. Chaque ligne contient entre 1 et 99 identifiants séparés par des espaces.
 * Un identifiant est une suite de 1 à 16 caractères (lettres minuscules ou chiffres).
 * Le premier identifiant de chaque ligne indique un ordinateur, tous les identifiants suivants sur la ligne indiquent les ordinateurs situés
 * en aval de l'ordinateur correspondant au premier identifiant de la ligne. Chaque ordinateur n'apparaît au plus qu'une fois comme premier identifiant d'une ligne.
 *
 *
 * Sortie
 * Un entier indiquant le nombre de liaisons entre les deux ordinateurs les plus éloignés.
 */
public class DistanceReseauArborescent {

	public static void main( String[] args ) throws Exception {
		String  line;
		Map<String, List<String>> nodes;
		String firstNode;
		try (Scanner sc = new Scanner(new File("src/main/ressources/isograd/reseau.txt"))) {
			nodes = new HashMap<>();
			firstNode = null;
			while (sc.hasNextLine()) {
				line = sc.nextLine();
				List<String> split = Arrays.asList(line.split(" "));
				if (firstNode == null) {
					firstNode = split.get(0);
				}
				nodes.put(split.get(0), split.subList(1, split.size()));
			}
		}
		System.out.println(calculateMax(nodes, firstNode));
	}

	public static int calculateMax(Map<String, List<String>> nodes, String currentNode) {
		if (nodes.get(currentNode) == null) {
			return 0;
		}
		int currentMax = 1;
		int max = 0;
		for (String nextNode : nodes.get(currentNode)) {
			int maybeMax = calculateMax(nodes, nextNode);
			if (maybeMax > max) {
				max = maybeMax;
			}
		}
		return currentMax + max;
	}
}

/**
 *
 */
