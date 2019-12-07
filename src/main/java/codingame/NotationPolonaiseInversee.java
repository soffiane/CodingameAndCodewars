package codingame;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NotationPolonaiseInversee {

    final static String[] operations = {"+", "-", "*", "/"};


    public int compute(String expression) {
        Stack<String> op = new Stack<String>();
        String[] tableauOperandes = expression.split(" ");
        for (int i = 0; i < tableauOperandes.length; i++) {
            if (isOperande(tableauOperandes[i])) {
                int op1 = Integer.parseInt(op.pop());
                int op2 = Integer.parseInt(op.pop());
                op.push(doOperande(tableauOperandes[i], op1, op2));
            } else {
                op.push(tableauOperandes[i]);
            }
        }
        return Integer.parseInt(op.pop());
    }

    public static boolean isOperande(String operation) {
        return isIn(operation, operations);
    }

    public static boolean isIn(String operation, String[] operations) {
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals(operation)) return true;
        }
        return false;
    }

    public static String doOperande(String op, int op1, int op2) {
        if (op.equals("+")) {
            return "" + (op1 + op2);
        } else if (op.equals("-")) {
            return "" + (op2 - op1);
        } else if (op.equals("*")) {
            return "" + op1 * op2;
        } else if (op.equals("/")) {
            return "" + op2 / op1;
        }
        return "0";
    }


}
