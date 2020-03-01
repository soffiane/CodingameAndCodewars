package coderPower;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Objectif
 * <p>
 * Vous êtes une grenouille (oui pardon, une sombre histoire de maléfice, ça ne durera pas trop longtemps).
 * <p>
 * Vous essayez de vous faire à votre condition de batracien lorsque vous tombez nez à nez avec un point d'eau !
 * Vous ne savez cependant pas nager (vous avez à tort pensé que cela ne vous serait pas utile d'apprendre),
 * vous songez donc à traverser en vous aidant de nénuphars sur lesquels vous pouvez sauter.
 * Mais les nénuphars sont fragiles si bien qu’après avoir sauté sur un, celui-ci coule rapidement de tel manière
 * à ce qu'il ne soit pas possible de sauter 2 fois sur le même nénuphar.
 * Vous prenez goût à faire couler les nénuphars (c'est vrai que c'est rigolo, ça détend, vous en avez besoin),
 * vous cherchez donc dans quel ordre sauter sur les nénuphars afin d'en faire couler le plus possible.
 * <p>
 * Vous connaissez l'emplacement des nénuphars, votre portée de saut et votre point de départ qui est une pierre.
 * <p>
 * Rappel : la distance entre deux points de coordonnées (X1, Y1) et (X2, Y2) est donnée par racine carrée ((X2-X1)^2 + (Y2-Y1)^2)
 * <p>
 * On pourra procéder par énumération exhaustive, cependant avec 15 nénuphars cela fait 1 307 674 368 000 chemins possibles,
 * il va donc falloir optimiser significativement votre énumération !
 * <p>
 * Données
 * Entrée
 * Ligne 1 : deux entiers N et D séparés par un espace respectivement compris entre 1 et 15 et 1 et 100.
 * N est le nombre de nénuphars et D est la portée de maximale de vos sauts.
 * Ligne 2 : deux entiers X et Y compris chacun entre 0 et 1 000, représentant les coordonnées de la pierre dont vous partez.
 * Lignes 3 à N + 2 : deux entiers, la position d'un nénuphar, compris chacun entre 0 et 1 000.
 * <p>
 * Sortie
 * Un entier, le nombre maximal de nénuphars que vous pouvez faire couler !
 * <p>
 * Exemple
 * Entrée
 * 2 10
 * 5 5
 * 3 3
 * 15 18
 * <p>
 * Sortie
 * 1
 */
public class Grenouille {

    private static int distMax2;

    public static class Coord {
        int x;
        int y;

        public Coord(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

        public int dist2(Coord c2) {
            return (x - c2.x) * (x - c2.x) + (y - c2.y) * (y - c2.y);
        }

    }

    public static void main(String[] argv) throws Exception {
        String line;
        Scanner sc = new Scanner(System.in);

        int nb = sc.nextInt();
        int distMax = sc.nextInt();
        distMax2 = distMax * distMax;

        int ox = sc.nextInt();
        int oy = sc.nextInt();
        Coord origine = new Coord(ox, oy);


        List<Coord> coords = new ArrayList<>();

        for (int i = 0; i < nb; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            Coord c = new Coord(x, y);
            coords.add(c);
        }

        System.out.println(max(coords, origine));
    }


    public static int max(List<Coord> neph, Coord from) {
        int max = 0;
        for (Coord c : neph) {
            if (c.dist2(from) < distMax2) {
                List<Coord> next = new ArrayList<>(neph);
                next.remove(c);

                int with = 1 + max(next, c);
                if (with > max) {
                    max = with;
                }

                int without = max(next, c);
                if (without > max) {
                    max = without;
                }

                if (max == neph.size()) {
                    return max;
                }
            }
        }
        return max;
    }
}
