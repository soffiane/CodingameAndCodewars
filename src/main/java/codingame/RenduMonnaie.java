package codingame;

class Change {
    long coin2 = 0;
    long bill5 = 0;
    long bill10 = 0;
}

public class RenduMonnaie {
    static Change optimalChange(long s) {
        Change change = new Change();
        long initialAmount = s;
        if( s / 10 > 0){
            change.bill10 = s / 10;
            s = s % 10;
        }
        if( s / 5 > 0){
            change.bill5 = s / 5;
            s = s % 5;
        }
        if( s / 2 > 0){
            change.coin2 = s / 2;
            s = s % 2;
        }
        if(s == initialAmount){
            return null;
        } else {
            return change;
        }
    }
    public static void main(String... args){
        long s = 10L; // Change this value to perform other tests
        Change m = RenduMonnaie.optimalChange(s);

        System.out.println("Coin(s)  2€: " + m.coin2);
        System.out.println("Bill(s)  5€: " + m.bill5);
        System.out.println("Bill(s) 10€: " + m.bill10);

        long result = m.coin2 * 2 + m.bill5 * 5 + m.bill10 * 10;
        System.out.println("\nChange given = " + result);
    }

}
