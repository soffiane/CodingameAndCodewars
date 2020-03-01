package codinNightFevrier2019;


import java.util.*;
import java.lang.Math;

public class App {
    //les checkpoints doivent être parcourus par coordonnée X croissante.
    //Il est garanti que l'ordre est unique (les coordonnées X des checkpoints sont distinctes).
    // Quelle sera la longueur de votre trajet ?

    //Votre fonction doit renvoyer un entier qui représente la longueur du trajet en distance euclidienne, arrondie à l'entier supérieur.
    public static int calcDistance(int[][] checkpoints) {
        Arrays.sort(checkpoints, (o1, o2) -> o1[0] - o2[0]);
        //AB = racine carrée de (xb - xa)² + (yb - ya)²
        List<Point> points = new ArrayList<>();
        for (int row = 0; row < checkpoints.length; row++) {
            points.add(new Point(checkpoints[row][0], checkpoints[row][1]));
        }
        double distance = 0;
        for(int i = 0;i<points.size()-1;i++){
            distance += points.get(i).calculeDistance(points.get(i+1));
        }
        return (int)(Math.round(distance));
    }

    public static void main(String[] args) {
        int[][] checkpoints = {{1, 10}, {-1, 5}, {4, 6}};
        System.out.println(calcDistance(checkpoints));
        //int[][] checkpointsBis = {{-55, 2}, {-55, 7}};
        //System.out.println(calcDistance(checkpointsBis));
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public double calculeDistance(Point b) {
            //AB = racine carrée de (xb - xa)² + (yb - ya)²
            return Math.sqrt((b.x - this.x) * (b.x - this.x) + (b.y - this.y) * (b.y - this.y));
        }
    }
}
