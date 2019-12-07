package codingame;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class IsoContest {

    public static void main( String[] argv ) throws Exception {
        String  line;
        int i = 0;
        Map<String,Integer> personne = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            ++i;
            line = sc.nextLine();
            if(i >= 3){
                String[] infos = line.split("\\s");
                personne.put(infos[0],Integer.valueOf(infos[1]));
            }
            /* Lisez les données et effectuez votre traitement */
        }
        Stream<Map.Entry<String, Integer>> sorted =
                personne.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue());
        System.out.println(sorted.findFirst().get().getKey());
        /* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
    }
}