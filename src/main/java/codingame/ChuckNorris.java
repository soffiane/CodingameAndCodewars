/**
 * Objectif
 *
 * Le binaire avec des 0 et des 1 c'est bien. Mais le binaire avec que des 0, ou presque, c'est encore mieux.
 * A l'origine, c'est un concept inventé par Chuck Norris pour envoyer des messages dits unaires.
 *
 * Ecrivez un programme qui, à partir d'un message en entrée, affiche le message codé façon Chuck Norris en sortie.
 *   Règles
 *
 * Voici le principe d'encodage :
 *
 *     Le message en entrée est constitué de caractères ASCII (7 bits)
 *     Le message encodé en sortie est constitué de blocs de 0
 *     Un bloc est séparé d'un autre bloc par un espace
 *     Deux blocs consécutifs servent à produire une série de bits de même valeur (que des 1 ou que des 0) :
 *     - Premier bloc : il vaut toujours 0 ou 00. S'il vaut 0 la série contient des 1, sinon elle contient des 0
 *     - Deuxième bloc : le nombre de 0 dans ce bloc correspond au nombre de bits dans la série
 *
 *     Prenons un exemple simple avec un message constitué d'un seul caractère : C majuscule. C en binaire vaut 1000011 ce qui donne avec la technique de Chuck Norris :
 *
 *     0 0 (la première série composée d'un seul 1)
 *     00 0000 (la deuxième série composée de quatre 0)
 *     0 00 (la troisième série composée de deux 1)
 *
 * C vaut donc : 0 0 00 0000 0 00
 */
package codingame;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ChuckNorris {
/*
    public static void process(String message) {
        //Scanner in = new Scanner(System.in);
        //String MESSAGE = in.nextLine();
        String res = "";
        for(int i=0;i<message.length();i++){
            char c = message.charAt(i);
            //Le message en entrée est constitué de caractères ASCII (7 bits)
            res += String.format("%7s", Integer.toBinaryString(c)).replace(' ', '0');
            res += countConsecutives(res);
        }

        System.out.println(res);
    }
    public static void main(String args[]) {
        process("C");
        process("CC");
        process("%"); //00 0 0 0 00 00 0 0 00 0 0 0 | 0 0 00 00 0 0 00 0 0 0
        process("Chuck Norris' keyboard has 2 keys: 0 and white space.");
    }

    public static String countConsecutives(String input) {
        String result = "";
        int c = 1;
        char[] s = input.toCharArray();
        for (int i = 1; i < input.length(); i++) {
            if (s[i] == s[i - 1]) {
                c += 1;
            } else {
                if(s[i - 1] == '0'){
                    result += "00 " + IntStream.range(0, c).mapToObj(value -> "0").collect(Collectors.joining("")) + " ";
                    c = 1;
                } else if (s[i - 1] == '1'){
                    result += "0 " + IntStream.range(0, c).mapToObj(value -> "0").collect(Collectors.joining("")) + " ";
                    c = 1;
                }

            }
        }
        int last = s.length - 1;
        //The last letter has to be checked separately
        if(s.length > 1) {
            if (s[last] == s[last - 1]) {
                if(s[last] == '0'){
                    result += "00 " + IntStream.range(0, c).mapToObj(value -> "0").collect(Collectors.joining(""));
                } else if (s[last] == '1'){
                    result += "0 " + IntStream.range(0, c).mapToObj(value -> "0").collect(Collectors.joining(""));
                }
            } else {
                if(s[last] == '0'){
                    result += "00 0";
                } else if(s[last] == '1'){
                    result += "0 0";
                }
            }
        } else {
            if(s[last] == '0'){
                result += "00 0";
            } else if(s[last] == '1'){
                result += "0 0";
            }
        }
        return result;
    }
}*/

    static String encodingToBinary(String inStr) {
        String binStr = "";
        char[] inChar = inStr.toCharArray();
        for (char c : inChar) {
            //on passe le code ascii du caractere + 128
            String tmpStr = Integer.toBinaryString(c + 128);
            binStr += tmpStr.substring(1);
        }
        return binStr;
    }

    public static void process(String MESSAGE) {
        String answer = (" " + encodingToBinary(MESSAGE)).replace("01", "0 1").replace("10", "1 0").replace(" 1", " 1 1").replace(" 0", " 00 0").replace("1", "0").trim();
        System.out.println(answer);
    }

    public static void main(String args[]) {
        process("C");
        process("CC");
        process("%"); //00 0 0 0 00 00 0 0 00 0 0 0 | 0 0 00 00 0 0 00 0 0 0
        process("Chuck Norris' keyboard has 2 keys: 0 and white space.");
    }
}

