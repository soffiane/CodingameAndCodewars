package coderPower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Objectif
 * <p>
 * L'organisation d'un hackathon n'est pas une chose facile, quand on sait la logistique à mettre en œuvre pour
 * que chacun ait une prise électrique, sans parler des bornes Wifi qui doivent tenir la charge !
 * C'est pourquoi vous vous attelez à la tâche avec une attention scrupuleuse au moindre détail.
 * Tout naturellement, vous avez donc demandé à tous les participants de votre événement de renseigner
 * leur heure d'arrivée et de départ à la milliseconde près. Ainsi, vous allez pouvoir déterminer à l'avance
 * le pic de fréquentation et donc les moyens nécessaires. En effet, inutile de prévoir autant de prises
 * électriques que d'inscrits, il suffit qu'il y en ait autant que le plus grand nombre de personnes
 * simultanément présentes.
 * <p>
 * Données
 * Entrée
 * Ligne 1 : un entier N entre 2 et 100 000 inclus, indiquant le nombre de participants
 * (et oui, votre hackathon est très populaire !)
 * Lignes 2 à N+1 : deux entiers compris entre 0 et 86 400 000 séparés par une espace,
 * indiquant l'heure d'arrivée et l'heure de départ d'un même participant en nombre de millisecondes
 * depuis le début de l'événement.
 * <p>
 * On vous garantit que parmi tous les horaires qu'on vous donne, il n'y en a jamais deux égaux.
 * Ainsi il n'y aura jamais deux départs simultanés, deux arrivées simultanées, ou un départ et une arrivée simultanés.
 * <p>
 * Sortie
 * Un entier, indiquant le pic de fréquentation, c'est-à-dire le nombre maximum de personnes présentes au hackathon
 * au même moment.
 * <p>
 * Exemple
 * Entrée
 * 3
 * 0 3600000
 * 1800000 7200000
 * 4800000 6000000
 * <p>
 * Sortie
 * 2
 * <p>
 * Le premier participant arrive pile à l'heure et part après 3600000ms. Le deuxième arrive 1800000ms après le début
 * — le premier est donc toujours là — puis s'en va 7200000ms après le début — le premier est alors déjà parti.
 * Le troisième arrive après l'arrivée du deuxième et le départ du premier, et repart avant le deuxième.
 * <p>
 * Le pic de fréquentation est dans ce cas 2, il est atteint entre 1800000 ms et 3600000 ms
 * (le premier et le second sont là), puis entre 4800000 ms et 6000000 ms (le second et le troisième sont là).
 */
public class PicFrequentation {
    public static void main(String[] argv) throws Exception {
        String line;
        int ln = 0;
        int N = 0;
        List<Integer> arrivees = new ArrayList<Integer>(N);
        List<Integer> departs = new ArrayList<Integer>(N);
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            if (line.isEmpty()) {
                break;
            }
            ++ln;
            if (ln == 1) {
                N = Integer.parseInt(line);

            }
            if (ln >= 2 & ln <= N + 1) {
                arrivees.add(Integer.parseInt(line.split(" ")[0]));
                departs.add(Integer.parseInt(line.split(" ")[1]));
            }
            /* Lisez les données et effectuez votre traitement */
        }

        int count = 0;
        int max = 0;
        int a = 0;
        int d = 0;
        Collections.sort(arrivees);
        Collections.sort(departs);
        while (a != arrivees.size() && d != departs.size()) {
            if (arrivees.get(a) < departs.get(d)) {
                ++count;
                if (count > max)
                    max = count;
                a++;
            } else {
                count -= 1;
                d++;
            }
        }
        /* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
        System.out.println(max);
    }
}
