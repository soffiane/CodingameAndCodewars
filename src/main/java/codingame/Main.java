/**
 * C'est un code issu d'un test technique sur skillvalue pour alteca
 */
package codingame;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public  static void main(String... args){
        Comparator<String> alphabetical = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2){
                return s2.compareTo(s1);
            }
        };
        Comparator<String> size = Comparator.comparingInt(String::length);
        IntStream.range(1,1000).boxed().map(Object::toString)
                .sorted(alphabetical.thenComparing(size))
                .collect(Collectors.toList());
    }
}
