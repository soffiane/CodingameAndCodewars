package coderPower;
/**
 * Vous travaillez comme programmeur à bord du vaisseau ...,
 * dont le capitaine caractériel vient de décider de traverser un champ d'astéroïde malgré les chances de succès de 1/3720.
 *
 * Votre rôle est d'empêcher les astéroïdes de venir menacer de trop près la carrosserie du précieux engin.
 * Vous disposez heureusement d'images de mauvaise résolution acquises par le performant système de vidéoprotection.
 * Vous décidez donc d'écrire un programme analysant ces images pour y détecter les astéroïdes,
 * et envoyer leur position au système de défense rapprochée qui les pulvérisera, et ainsi vous éviter les foudres du capitaine.
 *
 * Votre programme devra accepter en entrée une carte rectangulaire quadrillée où certaines cases contiennent de l'astéroïde
 * et d'autres du vide sidéral, et identifier le nombre d'astéroïdes présents sur l'image.
 * Un seul astéroïde peut être composé de plusieurs cases adjacentes (les diagonales ne comptent pas)
 * et devra être compté une seule fois !
 *
 * Format des données
 *
 * Entrée
 *
 * - Ligne 1 : deux entiers M et N compris entre 2 et 100 séparés par un espace indiquant respectivement
 * le nombre de lignes et de colonnes de l'image.
 * - Lignes 2 à M+1 : N caractères représentant une ligne de l'image.
 * Chaque caractère a 2 valeurs possibles : X indiquant de l’astéroïde, ou . du vide.
 *
 * Sortie
 * Un nombre entier, indiquant le nombre d'astéroïdes détectés sur l'image.
 *
 * Exemple
 *
 * Entrée
 * 8 22
 * .....................X
 * .........XXX..........
 * X..XXXXXX.......X.....
 * X..XX..XX....XXXXX....
 * X..XX..XX...XX...XX...
 * X..XX..XX...X..X.XX...
 * ...XXXXXX...X.....X...
 * ............XXXXXXX...
 *
 * Sortie
 * 6
 *
 * Note : Attention, certains astéroïdes peuvent contenir du vide, et même d'autres astéroïdes !
 * Dans l'exemple ci-dessus, le gros astéroïde présent en bas à droite contient à l'intérieur
 * de lui-même un petit astéroïde d'une seule case.
 */

import java.util.Scanner;

public class Asteroids {

    public static void main(String[] argv) throws Exception {
        char[][] rawImage = null;

        try (Scanner sc = new Scanner(System.in)) {
            String line;

            int numLines = 0;
            int numColumns = 0;
            if (sc.hasNextLine()) {
                line = sc.nextLine();
                if (line != null && !line.isEmpty()) {
                    String[] splitted = line.split(" ");
                    numLines = Integer.parseInt(splitted[0]);
                    numColumns = Integer.parseInt(splitted[1]);
                }
            }

            rawImage = new char[numLines][numColumns];

            int curLine = 0;
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                if (line != null && !line.isEmpty()) {
                    for (int i = 0; i < numColumns; i++) {
                        rawImage[curLine][i] = line.charAt(i);
                    }
                    ++curLine;
                }
            }
        }

        System.out.println(processImage(rawImage));
    }

    private static int processImage(char[][] rawImage) {
        int numAsteroids = 0;

        for (int l = 0; l < rawImage.length; l++) {
            for (int c = 0; c < rawImage[l].length; c++) {
                if (rawImage[l][c] == 'X') {
                    removeAsteroid(rawImage, l, c);
                    numAsteroids++;
                }
            }
        }

        return numAsteroids;
    }

    private static void removeAsteroid(char[][] rawImage, int l, int c) {
        if (rawImage[l][c] == 'X') {
            rawImage[l][c] = '.';
            if (c > 0) {
                removeAsteroid(rawImage, l, c - 1);
            }
            if (l > 0) {
                removeAsteroid(rawImage, l - 1, c);

            }
            if (l + 1 < rawImage.length) {
                removeAsteroid(rawImage, l + 1, c);

            }
            if (c + 1 < rawImage[l].length) {
                removeAsteroid(rawImage, l, c + 1);

            }
        }
    }
}
