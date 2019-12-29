/**
 * C'est un code issu d'un test technique sur skillvalue pour alteca
 * test sur les fonctionnalités de Java 8
 */
package codingame;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static void main(String... args){
        Map<Integer,String> pouet = new HashMap<>();
        pouet.put(1,"Adam");
        pouet.put(2,"Eve");
        pouet.put(3,null);
        String s1 = pouet.get(1);
        String s2 = pouet.getOrDefault(2,"Mary");
        String s3 = pouet.getOrDefault(3,"Jack");
        String s4 = pouet.getOrDefault(4,"Anne");
        System.out.println(s1+" "+s2+" "+s3+" "+s4); // Adam Eve null Anne

    }
}
