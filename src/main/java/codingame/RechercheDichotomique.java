package codingame;

import java.util.Arrays;

public class RechercheDichotomique {

    static boolean exists(int[] ints, int k) {
        /*int start = 0;
        int end = ints.length - 1;
        boolean found = false;

        do {
            int mil = (start + end) / 2;
            if(ints[mil] == k){
                found = true;
            } else if (k > ints[mil]){
                start = mil + 1;
            } else {
                end = mil - 1;
            }
        } while(found == false && start <= end);

        return found;*/
        //ou avec l'API java standard
        return (Arrays.binarySearch(ints, k) > 0) ? true : false;

    }

    public static void main (String[] args){
        int[] ints = {-9, 14, 37, 102};
        System.out.println(RechercheDichotomique.exists(ints, 102)); // true
        System.out.println(RechercheDichotomique.exists(ints, 36)); // false
    }
}
