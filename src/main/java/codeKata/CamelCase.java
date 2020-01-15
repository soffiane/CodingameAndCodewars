package codeKata;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Complete the method/function so that it converts dash/underscore delimited words into camel casing.
 * The first word within the output should be capitalized only if the original word was capitalized (known as Upper Camel Case, also often referred to as Pascal case).
 * <p>
 * Examples
 * toCamelCase("the-stealth-warrior"); // returns "theStealthWarrior"
 * <p>
 * toCamelCase("The_Stealth_Warrior"); // returns "TheStealthWarrior"
 */
public class CamelCase {

    static String toCamelCase(String s) {
        String[] split = s.split("[\\-_]");
        StringBuffer sb = new StringBuffer();
        sb.append(split[0]);
        for (int i = 1; i < split.length; i++) {
            sb.append(split[i].substring(0, 1).toUpperCase() + split[i].substring(1));
        }
        return sb.toString();
    }

    static String toCamelCaseJava8(String str) {
        String[] words = str.split("[-_]");
        return Arrays.stream(words, 1, words.length)
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .reduce(words[0], String::concat);
    }

    /**
     * solution alternative
     *
     *  Matcher m = Pattern.compile("[_|-](\\w)").matcher(s);
     *     StringBuffer sb = new StringBuffer();
     *     while (m.find()) {
     *         m.appendReplacement(sb, m.group(1).toUpperCase());
     *     }
     *     return m.appendTail(sb).toString();
     *
     *     ou encore
     *
     *     String[] stringArray = s.split("[-|_]");
     *
     *         return stringArray[0] + Arrays.stream(stringArray).skip(1).map(i -> i.substring(0,1).toUpperCase()+i.substring(1))
     *                 .collect(Collectors.joining());
     */


    @Test
    public void testSomeUnderscoreLowerStart() {
        String input = "the_Stealth_Warrior";
        System.out.println("input: " + input);
        Assert.assertEquals("theStealthWarrior", CamelCase.toCamelCase(input));
    }

    @Test
    public void testSomeDashLowerStart() {
        String input = "the-Stealth-Warrior";
        System.out.println("input: " + input);
        Assert.assertEquals("theStealthWarrior", CamelCase.toCamelCase(input));
    }
}
