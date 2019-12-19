/**
 * Your task is to sort a given string. Each word in the string will contain a single number. This number is the position the word should have in the result.
 * <p>
 * Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).
 * <p>
 * If the input string is empty, return an empty string. The words in the input String will only contain valid consecutive numbers.
 * <p>
 * Examples
 * "is2 Thi1s T4est 3a"  -->  "Thi1s is2 3a T4est"
 * "4of Fo1r pe6ople g3ood th5e the2"  -->  "Fo1r the2 g3ood 4of th5e pe6ople"
 * ""  -->  ""
 */
package codeKata;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class StringOrder {

    public static String order(String words) {
        // split string - ignoring empty strings
       /* String[] split = Stream.of(words.split(" ")).filter(w -> !w.isEmpty()).toArray(String[]::new);

        //map pour ranger cle chiffre - value string
        Map<Integer, String> ordering = Arrays.stream(split)
                .collect(Collectors.toMap(s -> Integer.valueOf(s.replaceAll("[^0-9]", "")), s -> s));

        //creer un string en mappant toutes les valeurs de la map
        return ordering.isEmpty() ? "" : ordering.entrySet().stream().map(integerStringEntry -> integerStringEntry.getValue()).collect(Collectors.joining(" "));*/

        //solution plus elegante
        return Arrays.stream(words.split(" "))
                .sorted(Comparator.comparing(s -> Integer.valueOf(s.replaceAll("\\D", ""))))
                .reduce((a, b) -> a + " " + b).get();
    }

    @Test
    public void test1() {
        assertThat(StringOrder.order("is2 Thi1s T4est 3a"), equalTo("Thi1s is2 3a T4est"));
    }

    @Test
    public void test2() {
        assertThat(StringOrder.order("4of Fo1r pe6ople g3ood th5e the2"), equalTo("Fo1r the2 g3ood 4of th5e pe6ople"));
    }

    @Test
    public void test3() {
        assertThat("Empty input should return empty string", StringOrder.order(""), equalTo(""));
    }
}
