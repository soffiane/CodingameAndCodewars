package coderPower;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Objectif
 *
 * L'animation d'une colonie de vacances suppose parfois de la préparation.
 * Dans votre groupe, les enfants ayant entre 5 ans (inclus) et 9 ans (inclus) vont participer à l'activité toboggan. Vous connaissez l'age de tous les enfants et vous cherchez à déterminer combien d'enfants vont participer à l'activité.
 *
 * Données
 * Entrée
 * Ligne 1 : un entier N compris entre 3 et 100 représentant le nombre d'enfants.
 * Ligne 2 : une suite de N entiers compris entre 1 et 20 séparés par des espaces représentant les âges des enfants.
 *
 * Sortie
 * Un entier, indiquant le nombre d'enfants participant à l'activité toboggan.
 *
 * Exemple
 * Pour l'entrée :
 * 13
 * 2 15 8 4 10 11 6 6 12 3 9 9 8
 * La sortie est :
 * 6
 * Car il y a 6 enfants entre 5 et 9 ans (8, 6, 6, 9, 9, 8 dans la liste des entrées).
 */
public class Toboggan {
    public static void main( String[] argv) throws Exception {
        String  line;
        String kids;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            line = sc.nextLine();
            /* Lisez les données et effectuez votre traitement */
            kids = sc.nextLine();
            System.out.println(Arrays.stream(kids.split(" "))
                    .map(Integer::valueOf)
                    .filter(age -> age <= 9 && age >= 5)
                    .map(e -> 1)
                    .reduce(0, Integer::sum));
            //.collect(Collectors.reducing(0,e->1,Integer::sum);
        }

        /* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
    }
}
