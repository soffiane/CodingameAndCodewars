package spideo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Exercice entretien spideo
 * <p>
 * Ecrire un code permettant de verifier si une liste de magazine permet
 * d'ecrire en entier une lettre de rancon, les mots sont decoupés à la main dans le magazine
 */
public class LettreDeRancon {

    public static void main(String[] args) {
        //la pile de magazine est en fait une liste de livre, un livre n'etant qu'une liste de mots
        List<List<String>> magazine = new ArrayList<>();
        //la lettre de rancon est une liste de string
        List<String> lettre = new ArrayList<>();
        lettre.add("Tuer");
        lettre.add("Mourir");
        lettre.add("Mourir");
        lettre.add("Tuer");
        lettre.add("Tuer");

        List<String> m1 = new ArrayList<>();
        m1.add("Toto");
        m1.add("Pouet");
        m1.add("Assasin");
        m1.add("Mort");
        m1.add("Mourir");
        m1.add("Tuer");
        m1.add("Mourir");
        m1.add("Tuer");
        magazine.add(m1);
        List<String> m2 = new ArrayList<>();
        m2.add("Toto");
        m2.add("Pouet");
        m2.add("Assasin");
        m2.add("Mort");
        m2.add("Tuer");
        m2.add("Tuer");
        magazine.add(m2);

        //il faut extraire la liste de mots des magazine et la comparer avec la liste des mots de la lettre
        //il faut prendre en compte le nombre d'occurence de chaque mot dans les deux ensembles

        //compter le nombre d'occurence de chaque mot dans les magasines
        Map<String, Integer> countWordsMagazines = magazine.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.reducing(0, e -> 1, Integer::sum)/*Collectors.counting()*/));
        //compter le nombre d'occurence de chaque mot dans la lettre
        Map<String, Integer> countWordsLettres = lettre.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.reducing(0, e -> 1, Integer::sum)));

        System.out.println("liste mot magazine");
        countWordsMagazines.entrySet().forEach(System.out::println);
        System.out.println("liste mot lettre");
        countWordsLettres.entrySet().forEach(System.out::println);

        //il faut enfin comparer les deux map voir si les magazine contiennent les mots de la lettre en quantité suffisantes
        System.out.println(countWordsLettres.entrySet().stream()
                .allMatch(e -> e.getValue() <= countWordsMagazines.get(e.getKey())));
    }
}
