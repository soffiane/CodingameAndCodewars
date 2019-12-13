/**
 * Given an array of integers, return a new array with each value doubled.
 *
 * For example:
 *
 * [1, 2, 3] --> [2, 4, 6]
 *
 * For the beginner, try to use the map method - it comes in very handy quite a lot so is a good one to know.
 */
package codeKata;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class LostWithoutAMap {
    public static int[] map(int[] arr) {
        return Arrays.stream(arr).map(operand -> Math.multiplyExact(operand, 2)).toArray();
    }

    @Test
    public void sampleTests() {
        assertArrayEquals(new int[] {2, 4, 6}, LostWithoutAMap.map(new int[] {1, 2, 3}));
        assertArrayEquals(new int[] {8, 2, 2, 2, 8}, LostWithoutAMap.map(new int[] {4, 1, 1, 1, 4}));
        assertArrayEquals(new int[] {2, 2, 2, 2, 2, 2}, LostWithoutAMap.map(new int[] {1, 1, 1, 1, 1, 1}));
    }
}
