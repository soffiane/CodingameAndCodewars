package coderPower;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Pour les 80 ans de votre grand-mère, vous êtes chargé de préparer le cadeau des invités : un cadre carré en bois pour y coller une photo de la star de la soirée.
 *
 * Votre budget étant assez serré, vous décidez de fabriquer les cadres dans votre atelier.
 * Et tant qu’à faire, si vous vous en chargez vous -même, autant utiliser de la récup.
 * Vous avez un carton plein de fines planches de bois de même épaisseur et de même largeur mais de longueurs différentes.
 * Votre grand-mère ne vous en voudra pas si les cadres ne sont pas tous de la même taille, par-contre elle insiste pour qu’ils soient carrés.
 *
 * Vous décidez alors de prendre au hasard 4 planches dans le carton et de les découper, si besoin, de manière à avoir un cadre carré le plus grand possible.
 *
 * À noter que lorsque vous découpez une planche, vous gardez la partie qui vous intéresse et vous jetez la seconde partie dans le carton, vous ne pouvez plus l’utiliser pour ce cadre.
 *
 * L’objectif est de déterminer combien de centimètres de bois vous aurez jeté dans le carton au total si vous construisez le cadre carré le plus grand possible.
 *
 * Format des données
 *
 * Entrée
 *
 * Lignes 1 à 4 : un entier compris entre 1 et 1 000 correspondant à la longueur d'une planche en bois en centimètres.
 *
 * Sortie
 *
 * Un entier correspondant au nombre de centimètres de bois que vous jetez dans le carton si vous réalisez le plus grand cadre carré possible.
 */
public class CadrePhoto {

	public static void main(String... args) throws FileNotFoundException {
		process("src/main/ressources/isograd/cadrephoto.txt");
	}

	private static void process(String fileName) throws FileNotFoundException {
		try (Scanner sc = new Scanner(new File(fileName))) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();

			//trouver le min des 4 elements
			int max = Math.min(a, Math.min(b, Math.min(c, d)));
			//le reste de cartons est la somme de tous les element - 4 fois le min
			//exemple : 71+1+44+37 - 4*1 = 152
			System.out.println(a+b+c+d - max*4);
		}
	}
}
