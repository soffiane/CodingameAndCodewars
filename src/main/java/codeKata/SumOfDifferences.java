/**
 * Your task is to sum the differences between consecutive pairs in the array in descending order.
 * <p>
 * For example: sumOfDifferences([2, 1, 10]) Returns 9
 * <p>
 * Descending order: [10, 2, 1]
 * <p>
 * Sum: (10 - 2) + (2 - 1) = 8 + 1 = 9
 * <p>
 * If the array is empty or the array has only one element the result should be 0 (Nothing in Haskell).
 */

package codeKata;

import java.util.*;
import java.util.stream.IntStream;

public class SumOfDifferences {
    public static int sumOfDifferences(int[] arr) {
        /*List<Integer> listToSum = new ArrayList<>();
        Integer[] ints = IntStream.of(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(ints, Collections.reverseOrder());
        int result;
        if (ints.length == 0 || ints.length == 1) {
            result = 0;
        } else {
            for (int i = 0; i < ints.length - 1; i++) {
                listToSum.add(ints[i] - ints[i + 1]);
            }
            result = listToSum.stream().reduce(0, Integer::sum);
        }

        return result;*/

        IntSummaryStatistics stat = Arrays.stream(arr).summaryStatistics();
        return arr.length > 1 ? stat.getMax() - stat.getMin() : 0;

        // ou int[] array = IntStream.of(arr)
        //                        .boxed()
        //                        .sorted(Comparator.reverseOrder())
        //                        .mapToInt(Integer::intValue)
        //                        .toArray();
        //   return IntStream.range(0, array.length - 1)
        //                   .map(i -> array[i] - array[i + 1])
        //                   .sum();
    }

    public static void main(String... strings) {
        SumOfDifferences.sumOfDifferences(new int[]{1, 0, 2, 2, 1, 2, 0});
    }
}
