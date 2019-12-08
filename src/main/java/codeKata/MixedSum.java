/**
 * Given an array of integers as strings and numbers, return the sum of the array values as if all were numbers.
 *
 * Return your answer as a number.
 */
package codeKata;

import java.util.List;
import java.util.function.Function;

public class MixedSum {
    /*
     * Assume input will be only of Integer or String type
     */
    public int sum(List<?> mixed) {
        return mixed.stream().map(o -> Integer.valueOf(o.toString())).reduce(0, Integer::sum);
        // return mixed.stream().mapToInt(i -> Integer.parseInt(String.valueOf(i))).sum();
    }
}
