/**
 * Person of Interest est une série TV dans laquelle Harold Finch, un développeur multi-milliardaire, a développé une intelligence artificielle nommée "The Machine", capable de prédire les crimes.
 *
 * Pour chaque période de 30 jours, "The Machine" doit sortir la liste de données suivantes:
 *
 * ﻿Crime predicted: 555-55-5555
 * Calling: 1-555-555-5555
 *
 * ﻿
 *
 * Chaque jour étant séparé par une ligne vide.
 *
 * Le premier numéro est un numéro de sécurité sociale américain, de la forme 342-98-1613, chaque nombre étant aléatoire (respectivement avec 3 chiffres, 2 chiffres, 4 chiffres).
 *
 * Le deuxième numéro est un numéro de téléphone américain, de la forme 1-814-555-3857, avec:
 *
 *     le premier chiffre toujours égal à 1 (indicatif du pays)
 *     le nombre à 3 chiffres suivant est aléatoire
 *     le nombre suivant est toujours égal à 555
 *     enfin le dernier nombre à 4 chiffres est aléatoire
 *
 * Pour chaque mois, une personne ne peut commettre qu'un seul crime: les numéros de sécurité sociale et de téléphone doivent donc être uniques.
 */
package codingame;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class RandomIppon {
    private static SecureRandom random = new SecureRandom();
    private static int VALEUR_MIN_100 = 100;
    private static int VALEUR_MAX_999 = 999;
    private static int VALEUR_MIN_1000 = 1000;
    private static int VALEUR_MAX_9999 = 9999;
    private static int VALEUR_MIN_100000000 = 100000000;
    private static int VALEUR_MAX_999999999 = 999999999;

    private static volatile boolean running = true;

    private static Map<String, String> previousCriminals = new HashMap<>();

    public void arreter() {
        this.running = false;
    }

    public static void main(String[] args){
        AtomicInteger days = new AtomicInteger(0);
        Thread thread = new Thread(() -> {
            while(running) {
                try {
                    days.getAndIncrement();
                    Thread.sleep(200);
                    if (days.get() == 30) {
                        days.set(0);
                        predictCrimes();
                    } else {
                        System.out.println("");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    private static String predictCrimes(){
        String socialSecurityNumber = getSocialSecurityNumber();
        String phoneNumber = getPhoneNumber();
        previousCriminals.put(socialSecurityNumber,phoneNumber);
        System.out.println("couple of value added : "+socialSecurityNumber+" "+phoneNumber);
        StringBuilder sbSsn = new StringBuilder(socialSecurityNumber)
                .insert(0,"Crime predicted: ")
                .insert(20,"-")
                .insert(23,"-");
        StringBuilder sbPhoneNumber = new StringBuilder(phoneNumber)
                .insert(0,"Calling: ")
                .insert(10,"-")
                .insert(14,"-")
                .insert(18,"-");

        String crimePredicted = sbSsn.toString();
        String calling = sbPhoneNumber.toString();
        return crimePredicted +"\n"+ calling;
    }

    private static String getPhoneNumber() {
        String phoneNumber = "1"+ (VALEUR_MIN_100 + random.nextInt(VALEUR_MAX_999 - VALEUR_MIN_100)) +"555"+ (VALEUR_MIN_1000 +random.nextInt(VALEUR_MAX_9999 - VALEUR_MIN_1000));
        if(checkUnicity(phoneNumber)){
            System.out.println(phoneNumber+ " is unique");
            return phoneNumber;
        }else {
            System.out.println(phoneNumber+ " already exists");
            return getPhoneNumber();
        }
    }

    private static String getSocialSecurityNumber() {
        String socialSecurityNumber = String.valueOf( VALEUR_MIN_100000000 + random.nextInt(VALEUR_MAX_999999999 - VALEUR_MIN_100000000));
        if(checkUnicity(socialSecurityNumber)){
            System.out.println(socialSecurityNumber+ " is unique");
            return socialSecurityNumber;
        }else {
            System.out.println(socialSecurityNumber+ " already exists");
            return getSocialSecurityNumber();
        }
    }

    private static boolean checkUnicity(String number) {
        return !previousCriminals.containsValue(number) && !previousCriminals.containsKey(number);
    }
}
