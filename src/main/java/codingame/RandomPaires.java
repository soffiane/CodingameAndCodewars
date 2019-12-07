package codingame;

import java.math.BigInteger;

public class RandomPaires {

    static int count(int n) {
        //calcul de la loi binomiale de combinaison de k=2 parmi n
        return factorielle(n)/(factorielle(2)*factorielle(n-2));
    }

    private static int factorielle(int n) {
        if (n==0) return(1);
        else return(n*factorielle(n-1));
    }

    public static void main(String... args){
        System.out.println(RandomPaires.count(4)); // 6
        System.out.println(RandomPaires.count(10000)); // 49995000
    }
}
