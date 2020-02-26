package coderPower;

import java.util.Arrays;

public class RecolteXp {

    public static void main(String[] args) {
        // Sample 1 (expected 15)
        int[] sample1 = {100, 200, 100, 400, 200, 500};
        System.out.println(getLevel(sample1));
        // Sample 2 (expected 2)
        int[] sample2 = {10, 20, 30, 40, 50, 60, 70};
        System.out.println(getLevel(sample2));
    }

    public static int getLevel(int[] xp) {
        return Arrays.stream(xp).sum() / 100;
    }
}
