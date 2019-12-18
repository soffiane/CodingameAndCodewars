/**
 * You take your son to the forest to see the monkeys.
 * You know that there are a certain number there (n),
 * but your son is too young to just appreciate the full number,
 * he has to start counting them from 1.
 *
 * As a good parent, you will sit and count with him. Given the number (n), populate an array with all numbers up to and including that number, but excluding zero.
 *
 * For example:
 *
 * monkeyCount(10) // --> new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
 * monkeyCount(1) // --> new int[]{1}
 */
package codeKata;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;

public class MonkeyCounter
{
    public static int[] monkeyCount(final int n){
        int[] num = new int [n];
        for (int i = 0; i < n; i++) {
            num[i] = i+1;
        }
        return num;
    }

    //ou en java 8
    public static int[] monkeyCountJava8(final int n) {
        return IntStream.rangeClosed(1, n).toArray();
    }

    //ou encore
    private static int[] monkeyCountParallelSetAll(final int n){
        int[] result = new int[n];
        Arrays.parallelSetAll(result, i-> i+1);
        return result;
    }


    @Test
    public void basicTests() {
        int[] array=new int[]{1,2,3,4,5};
        assertArrayEquals(array,MonkeyCounter.monkeyCount(5));
        array=new int[]{1,2,3};
        assertArrayEquals(array,MonkeyCounter.monkeyCount(3));
        array=new int[]{1,2,3,4,5,6,7,8,9};
        assertArrayEquals(array,MonkeyCounter.monkeyCount(9));
        array=new int[]{1,2,3,4,5,6,7,8,9,10};
        assertArrayEquals(array,MonkeyCounter.monkeyCount(10));
        array=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        assertArrayEquals(array,MonkeyCounter.monkeyCount(20));
    }

    @Test
    public void basicTestsJava8() {
        int[] array=new int[]{1,2,3,4,5};
        assertArrayEquals(array,MonkeyCounter.monkeyCountJava8(5));
        array=new int[]{1,2,3};
        assertArrayEquals(array,MonkeyCounter.monkeyCountJava8(3));
        array=new int[]{1,2,3,4,5,6,7,8,9};
        assertArrayEquals(array,MonkeyCounter.monkeyCountJava8(9));
        array=new int[]{1,2,3,4,5,6,7,8,9,10};
        assertArrayEquals(array,MonkeyCounter.monkeyCountJava8(10));
        array=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        assertArrayEquals(array,MonkeyCounter.monkeyCountJava8(20));
    }

    @Test
    public void basicTestsParralelSet() {
        int[] array=new int[]{1,2,3,4,5};
        assertArrayEquals(array,MonkeyCounter.monkeyCountParallelSetAll(5));
        array=new int[]{1,2,3};
        assertArrayEquals(array,MonkeyCounter.monkeyCountParallelSetAll(3));
        array=new int[]{1,2,3,4,5,6,7,8,9};
        assertArrayEquals(array,MonkeyCounter.monkeyCountParallelSetAll(9));
        array=new int[]{1,2,3,4,5,6,7,8,9,10};
        assertArrayEquals(array,MonkeyCounter.monkeyCountParallelSetAll(10));
        array=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        assertArrayEquals(array,MonkeyCounter.monkeyCountParallelSetAll(20));
    }

    @Test
    public void randomTests() {
        final Random rand = new Random();
        for(int i=0;i<10;i++){
            final int entero=1+rand.nextInt(100);
            assertArrayEquals(monkeyCount(entero),MonkeyCounter.monkeyCount(entero));
            assertArrayEquals(monkeyCountJava8(entero),MonkeyCounter.monkeyCountJava8(entero));
            assertArrayEquals(monkeyCountParallelSetAll(entero),MonkeyCounter.monkeyCountParallelSetAll(entero));
        }
    }

}
