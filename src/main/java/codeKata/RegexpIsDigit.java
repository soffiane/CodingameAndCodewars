/**
 * Implement String#digit? (in Java StringUtils.isDigit(String)), which should return true if given object is a digit (0-9), false otherwise.
 */

package codeKata;

import java.util.regex.Pattern;

public class RegexpIsDigit {
    public static boolean isDigit(String s) {
        return Pattern.compile("[0-9]").matcher(s).matches();
        //mieux : s.matches("[0-9]"); or s.matches("\\d"); 
    }
}
