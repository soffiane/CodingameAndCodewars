package codingame;

/**
 * Objectif : selectionner les colis du plus lours au plus leger
 *
 * Il y a 3 tapis avec des colis et il faut a chaque fois choisir l'indice du
 * tapis qui a le colis le plus lourd
 * En entree de la methode, on a les 3 colis et leur indice du tapis dans le nom
 * Si egalité, on prend n'importe lequel
 */

import java.util.*;

public class CompareThreeInt {
    public static int solve(int weight0, int weight1, int weight2) {
        Map<Integer,Integer> weights = new HashMap<>();
        weights.put(0,weight0);
        weights.put(1,weight1);
        weights.put(2,weight2);
        return Collections.max(weights.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }

    public static void main(String args[]) {
        int action = solve(110, 120, 90);
        System.out.println(action);
    }
}
