package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Day 6 : Let's review
 *
 * Given a string,S , of length N that is indexed from 0 to N-1,
 * print its even-indexed and odd-indexed characters as 2 space-separated strings on a single line (see the Sample below for more detail).
 *
 * Note:  is considered to be an even index.
 *
 * Input Format
 *
 * The first line contains an integer, T (the number of test cases).
 * Each line i of the T subsequent lines contain a String, S .
 */
public class SplitStringEvenOddIndexes {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        List<String> strings = new ArrayList<>();
        for(int i=0;i<T;i++){
            strings.add(scanner.next());
        }
        for(String input : strings){
            StringBuilder result = new StringBuilder();
            result.append(filter(input, index -> index % 2 == 0));
            result.append(' ');
            result.append(filter(input, index -> index % 2 == 1));
            System.out.println("filter : "+result.toString());
            System.out.println("reindex : "+reindex(input));
        }
        //splitString(strings).forEach(System.out::println);
        scanner.close();
    }

    /**
     * Solution using Java 8
     * @param input
     * @param predicate
     * @return
     */
    private static StringBuilder filter(String input, IntPredicate predicate) {
        //We need a instream to stream into a String with indexes - stream is the size of the string
        return IntStream.range(0, input.length())
                //we filter char corresponding to the predicate : even/odd index
                .filter(predicate)
                //then fetching the string for each char
                .map(input::charAt)
                //collect the one char String resulting map() into a StringBuilder with appendCodePoint - takes 3 arguments :
                //- the supplier of the mutable container, (StringBuilder::new);
                //- the accumulator of each element into the container (appending the code point of the character);
                //- a combiner combining two containers into one (used in parallel processing).
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append);
    }
    /**
     * Another solution
     */
    private static String reindex(String input) {
        StringBuilder[] result =
                IntStream.range(0, input.length())
                        //collect 1st param : instanciating a StringBuilder tab of size 2
                        //2nd param : accumulator
                        //3rd param : combiner of containers
                        .collect(
                                () -> new StringBuilder[] { new StringBuilder(), new StringBuilder() },
                                (b, i) -> b[i % 2].appendCodePoint(input.charAt(i)),
                                (b1, b2) -> {
                                    b1[0].append(b2[0]);
                                    b1[1].append(b2[1]);
                                }
                        );

        return result[0] + " " + result[1];
    }

    /**
     * Old programming style method to print even/odd indexed strings
     * @param strings
     * @return
     */
    private static List<String> splitString(List<String> strings) {
        List<String> results = new ArrayList<>();
        for(String s : strings) {
            char[] chars = s.toCharArray();
            StringBuilder even = new StringBuilder();
            StringBuilder odd = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                if (i % 2 == 0) {
                    even.append(chars[i]);
                } else {
                    odd.append(chars[i]);
                }
            }
            results.add(even+" "+odd);
        }
        return results;
    }
}
