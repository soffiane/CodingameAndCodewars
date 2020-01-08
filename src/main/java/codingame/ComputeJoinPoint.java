package codingame;

public class ComputeJoinPoint {

    public static int computeJoinPoint(int s1, int s2) {
        do {
            s1 += sameNumberPlusSumpOfItsDigit(s1);
            s2 += sameNumberPlusSumpOfItsDigit(s2);
        } while (s1 != s2);
        return s1;
    }

    private static int sameNumberPlusSumpOfItsDigit(int val) {
        int somme = 0;
        for(char c : String.valueOf(val).toCharArray()){
            somme+= Character.getNumericValue(c);
        }
        return somme;
    }

    /* Ignore and do not change the code below */
    public static void main(String args[]) {
        int s1 = 471;
        int s2 = 480;
        int res = computeJoinPoint(s1, s2);
        System.out.println(res);
    }
}
