package codingame;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Le but de cette classe est de compter le nombre de caracteres consecutifs et de les afficher dans une chaine
 */
public class CompressedString {

    static Character currentChar = null;
    static int counter = 0;

    public String countConsecutives(String input) {
        String result = "";
        int c = 1;
        char[] s = input.toCharArray();
        for (int i = 1; i < input.length(); i++) {
            if (s[i] == s[i - 1]) {
                c += 1;
            } else {
                result += c > 1 ? String.valueOf(c) + s[i - 1] : s[i - 1];
                c = 1;
            }
        }
        int last = s.length - 1;
        //The last letter has to be checked separately
        if(s.length > 1) {
            if (s[last] == s[last - 1]) {
                result += String.valueOf(c) + s[last];
            } else {
                result += s[last];
            }
        } else {
            result += s[last];
        }
        return result;
    }

    /*public String getCompressedStringJava8(String input) {
        //Arrays.stream(input.split("")).map(s -> );
        //return "".join([str(sum(1 for _ in group)) + str(label) for label, group in groupby(s)])
    }*/

    public static void main(String... strings) {
        CompressedString cc = new CompressedString();
        System.out.println(cc.countConsecutives("abc")); // expected abc
        System.out.println(cc.countConsecutives("aaabbc")); // expected 3a2bc
        System.out.println(cc.countConsecutives("aabbbaa"));// expected 2a3b2a
        System.out.println(cc.countConsecutives("a")); // expected "1a"
        System.out.println(cc.countConsecutives("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));// expected "50a"
        System.out.println(cc.countConsecutives("ab"));// expected "1a1b"
        System.out.println(cc.countConsecutives("aaabbccc"));// expected "3a2b3c"
        System.out.println(cc.countConsecutives("aaaaaaaaaab"));// expected "10a1b"
        System.out.println(cc.countConsecutives("aaaaaaaaaab"));// expected "10a1b"
        System.out.println(cc.countConsecutives("aaaAabBbCcccZ"));// expected "3a1A1a1b1B1b1C3c1Z"
        System.out.println(cc.countConsecutives("aa0sobTeST333"));// expected "2a101s1o1b1T1e1S1T33"
        System.out.println(cc.countConsecutives("122333444455555"));// expected "1122334455"
        System.out.println(cc.countConsecutives("aa###bb@ccc@@"));// expected "2a3#2b1@3c2@"
        System.out.println(cc.countConsecutives("aa aAab BbCcc   cZ"));// expected "2a1 1a1A1a1b1 1B1b1C2c3 1c1Z"
        System.out.println(cc.countConsecutives("annie mommy dummy "));// expected "1a2n1i1e1 1m1o2m1y1 1d1u2m1y1 "
    }
}
