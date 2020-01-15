package codeKata;

import java.util.ArrayList;
import java.util.List;

/**
 * In this kata, you will do addition and subtraction on a given string. The return value must be also a string.
 * <p>
 * Note: the input will not be empty.
 * <p>
 * Examples
 * "1plus2plus3plus4"  --> "10"
 * "1plus2plus3minus4" -->  "2"
 */
public class BasicMath {

    public static String calculate(String operation) {
        List<Integer> values = new ArrayList<>();
        List<String> operands = new ArrayList<>();
        StringBuilder operand = new StringBuilder();
        for (int i = 0; i < operation.length(); i++) {
            if (Character.isDigit(operation.charAt(i))) {
                values.add(Character.getNumericValue(operation.charAt(i)));
                if (operand.length() != 0) {
                    operands.add(operand.toString());
                    operand.delete(0, operand.length());
                }
            } else if (Character.isAlphabetic(operation.charAt(i))) {
                operand.append(operation.charAt(i));
            }
        }
        int result = values.get(0);
        for (int i = 0; i < operands.size(); i++) {
            if ("plus".equals(operands.get(i))) {
                result += values.get(i + 1);
            } else if ("moins".equals(operands.get(i))) {
                result -= values.get(i + 1);
            }
        }
        return String.valueOf(result);

    }

    public static void main(String[] args) {
        System.out.println(BasicMath.calculate("1plus2plus3plus4"));
    }
}
