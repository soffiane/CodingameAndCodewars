package codingame;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class LongestString {

    /**
     * return the longest string contained inside the input array
     * can be array of array of array
     * @param array input Array of values
     * @return null if input is null and the longest string otherwise
     */
    public String getLongestString(Object[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        //deepToString permet d'extraire tous les strings des Arrays de Arrays de... dans un String unique
        String s = Arrays.deepToString(array);
        String[] split = s.replaceAll("[\\[\\](){}]", "").split(",");
        return Arrays.stream(split).max(Comparator.comparingInt(String::length)).get();

    }

    public static void main(String... args) {
        System.out.println(new LongestString().getLongestString(new Object[]{"a", "ab", "abc", new Object[]{"a", "b", "abc"}}));
    }
}
