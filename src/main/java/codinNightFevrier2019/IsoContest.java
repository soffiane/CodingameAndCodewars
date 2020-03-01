package codinNightFevrier2019;
/**
 * /**
 *              * Votre fonction doit renvoyer un entier qui représente le nombre de binômes pouvant être formés.
 *              * Exemples
 *              *
 *              * Entrée : ['Blue','Red','Red','Yellow','Blue']
 *              * Sortie : 2
 *              * Les combattants des squads Blue et Red pourront former une équipe, mais pas le combattant de la squad Yellow.
 *              *
 *              * Entrée : ['Squad1','Squad2','Squad3','Squad4']
 *              * Sortie : 0
 *              */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class    IsoContest {
    public static void main(String[] args){
        String  line;
        Scanner sc = new Scanner(System.in);
        //while(sc.hasNextLine()) {
            //line = sc.nextLine();
            /* Lisez les données et effectuez votre traitement */
            String[] split = /*line.split(",")*/ {"Blue","Red","Red","Yellow","Blue"};
            Map<String,Integer> binomes = new HashMap<>();
            for(int i=0;i<split.length;i++){
                binomes.merge(split[i],1,(integer, integer2) -> ++integer);
            }
            long count = binomes.entrySet().stream()
                    .filter(stringIntegerEntry -> stringIntegerEntry.getValue() == 2)
                    .count();
            System.out.println(count);

        //}
        /* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
    }
}
