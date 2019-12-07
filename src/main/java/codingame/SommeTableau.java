package codingame;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SommeTableau {
    public static int calc(int[] array, int n1, int n2) {
        int sum = 0;
        for(int i = n1;i<=n2;i++){
            sum+= array[i];
        }
        return sum;
        // en java 8
        // Using IntStream.sum() to find
        // sum of elements dividible by 3
        // in given range
        //IntStream stream = IntStream.of(array);
        /*int sumOfElements =  stream.range(n1, n2)
                .filter(num -> num % 3 == 0)
                .sum();*/
    }

    public static void main(String... args){
        int[] array = new int[] {0,1,2,3,4,5,3};
        System.out.println(SommeTableau.calc(array, 0, 1)); // 1
        System.out.println(SommeTableau.calc(array, 0, 5)); // 15
        System.out.println(SommeTableau.calc(array, 0, 0)); // 0
        System.out.println(SommeTableau.calc(array, 0, 6)); // 18
    }
}
