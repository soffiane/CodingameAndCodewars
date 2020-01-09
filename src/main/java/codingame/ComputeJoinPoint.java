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

    /**
     *   public static int computeJoinPoint(int s1, int s2) {
     *         if(s1 <= 0 || s2 <= 0 || s1 > 20000000 || s2 > 20000000) {
     *             return 0;
     *
     *         } else if(s1 == s2) {
     *             return s1;
     *
     *         } else if(s1 < s2) {
     *             return computeJoinPoint(s1 + sumOfDigits(s1), s2);
     *
     *         } else {
     *             return computeJoinPoint(s1, s2 + sumOfDigits(s2));
     *         }
     *     }
     *
     *     private static int sumOfDigits(int n) {
     *         int sum = 0;
     *         while (n != 0) {
     *             sum = sum + n % 10;
     *             n = n/10;
     *         }
     *         return sum;
     *     }
     *     /* Ignore and do not change the code below
     *      public static void main(String args[]) {
     *      Scanner in = new Scanner(System.in);
     *      int s1 = in.nextInt();
     *      int s2 = in.nextInt();
     *      PrintStream outStream = System.out;
     *      System.setOut(System.err);
     *      int res = computeJoinPoint(s1, s2);
     *      System.setOut(outStream);
     *      System.out.println(res);
     *      }
     */
}
