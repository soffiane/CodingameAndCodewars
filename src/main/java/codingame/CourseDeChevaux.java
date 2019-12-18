/**
 * <<<<<<< Updated upstream
 * L’Hippodrome de Casablanca organise un nouveau type de course de chevaux : les duels. Lors d’un duel, seulement deux chevaux participent à la course.
 * Pour que la course soit intéressante, il faut sélectionner deux chevaux qui ont une puissance similaire.
 * <p>
 * Écrivez un programme qui, à partir d’un ensemble donné de puissances, identifie les deux puissances les plus proches et affiche leur écart avec un nombre entier positif.
 */
package codingame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CourseDeChevaux {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int diff = Integer.MAX_VALUE;
        List<Integer> horses = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int pi = in.nextInt();
            horses.add(pi);
        }

        Collections.sort(horses);
        for (int i = 0; i < N - 1; i++) {
            if (horses.get(i + 1) - horses.get(i) < diff) {
                diff = horses.get(i + 1) - horses.get(i);
            }
        }

        System.out.println(diff);
    }
}
