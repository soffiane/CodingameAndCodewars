package codingame;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

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
        //convertir Object[] en String[] ou en List<String>
        /*for (int i = 0; i < array.length; i++)
            strArray[i] = String.valueOf(array[i]);*/

        //Arrays.stream(array).flatMap(x -> Arrays.stream(x)).map(Object::toString).forEach(System.out::println);//max(Comparator.comparing(s -> s.length()));
        // XXX implement me !
        return "";

    }

    public static void main(String... args) {
        System.out.println(new LongestString().getLongestString(new Object[]{"a", "ab", "abc", new Object[]{"a", "b", "abc"}}));
    }
}
