/**
 * A bookseller has lots of books classified in 26 categories labeled A, B, ... Z.
 * Each book has a code c of 3, 4, 5 or more capitals letters.
 * The 1st letter of a code is the capital letter of the book category.
 * In the bookseller's stocklist each code c is followed by a space and by a positive integer n (int n >= 0)
 * which indicates the quantity of books of this code in stock.
 * <p>
 * For example an extract of one of the stocklists could be:
 * <p>
 * L = {"ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"}.
 * or
 * L = ["ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"] or ....
 * <p>
 * You will be given a stocklist (e.g. : L) and a list of categories in capital letters e.g :
 * <p>
 * M = {"A", "B", "C", "W"}
 * or
 * M = ["A", "B", "C", "W"] or ...
 * <p>
 * and your task is to find all the books of L with codes belonging to each category of M
 * and to sum their quantity according to each category.
 * <p>
 * For the lists L and M of example you have to return the string (in Haskell/Clojure/Racket a list of pairs):
 * <p>
 * (A : 20) - (B : 114) - (C : 50) - (W : 0)
 * <p>
 * where A, B, C, W are the categories,
 * 20 is the sum of the unique book of category A,
 * 114 the sum corresponding to "BKWRK" and "BTSQZ",
 * 50 corresponding to "CDXEF" and 0 to category
 * 'W' since there are no code beginning with W.
 * <p>
 * If L or M are empty return string is "" (Clojure and Racket should return an empty array/list instead).
 * Note:
 * <p>
 * In the result codes and their values are in the same order as in M
 */
package codeKata;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class StockListBookseller {

    // 1st parameter is the stocklist (L in example),
    // 2nd parameter is list of categories (M in example)
    public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        // your code here
        //on transforme listofArt en Map cle valeur avec le = premier char du livre et valeur somme des valeurs
        Map<String, Integer> collect = Arrays.stream(lstOfArt)
                .map(s -> s.split(" "))
                .filter(strings -> Arrays.asList(lstOf1stLetter).contains(Character.toString(strings[0].charAt(0))))
                .collect(Collectors.toMap(s -> Character.toString(s[0].charAt(0)), s -> Integer.parseInt(s[1]), (integer, integer2) -> integer + integer2));

        //pareil qu'au dessus mais en mieux et plus concis
        Map<String,Integer> categoryQuantities = Arrays.stream(lstOfArt)
                .collect(Collectors.groupingBy(book -> book.substring(0,1), Collectors.summingInt(book -> Integer.parseInt(book.split(" ")[1]))));

        //on boucle sur le tableau des categories et pour chaque categorie on recupere la quantité dans la Map
        //generée precedemment ou 0 si null et on fabrique le string au bon format
        return collect.isEmpty() ? "" : Arrays.stream(lstOf1stLetter)
                .map(initial -> String.format("(%s : %d)", initial, collect.getOrDefault(initial, 0)))
                .collect(Collectors.joining(" - "));
    }

    @Test
    public void test1() {
        String art[] = new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"};
        String cd[] = new String[]{"A", "B", "W"};
        assertEquals("(A : 200) - (B : 1140) - (W : 0)",
                StockListBookseller.stockSummary(art, cd));
    }

    /**
     * Solution sous la forme de classe
     *
     *  private static class Book {
     *         public final String category;
     *         public final String code;
     *         public final int quantity;
     *
     *         public Book(String label) {
     *             category = label.substring(0,1);
     *             code = label.split(" ")[0].substring(1);
     *             quantity = Integer.parseInt(label.split(" ")[1]);
     *         }
     *     }
     *
     *     public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
     *         if (lstOfArt.length == 0 || lstOf1stLetter.length == 0)
     *           return "";
     *         Map<String, Integer> categoryCounts = Arrays.stream(lstOfArt)
     *                 .map(Book::new)
     *                 .collect(Collectors.groupingBy(book -> book.category,
     *                          Collectors.summingInt(book -> book.quantity)));
     *         return Arrays.stream(lstOf1stLetter)
     *                 .map(initial -> String.format("(%s : %d)",
     *                                               initial, categoryCounts.getOrDefault(initial, 0)))
     *                 .collect(Collectors.joining(" - "));
     *     }
     *
     */
}
