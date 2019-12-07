package codingame;

import java.util.Arrays;

public class StringArrayCompare {

    public static void main(String... args) {
        System.out.println(new StringArrayCompare().areArraysEquals(new String[] { "a", "b", "c" }, new String[] { "a", "b", "c" }));
    }

    public boolean areArraysEquals(String[] array1, String[] array2) {
        return Arrays.equals(array1, array2);
    }
}
