/**
 * Task
 * Given the meal price (base cost of a meal), tip percent (the percentage of the meal price being added as tip),
 * and tax percent (the percentage of the meal price being added as tax) for a meal, find and print the meal's total cost.
 *
 * Note: Be sure to use precise values for your calculations, or you may end up with an incorrectly rounded result!
 *
 * Input Format
 *
 * There are
 * lines of numeric input:
 * The first line has a double, (the cost of the meal before tax and tip).
 * The second line has an integer, (the percentage of being added as tip).
 * The third line has an integer, (the percentage of
 *
 * being added as tax).
 *
 * Output Format
 *
 * Print the total meal cost, where
 * is the rounded integer result of the entire bill (
 *
 * with added tax and tip).
 *
 * Sample Input
 *
 * 12.00
 * 20
 * 8
 *
 * Sample Output
 * 15
 *
 * Explanation
 *
 * Given: mealCost = 12, tipPercent = 20, taxPercent = 8
 * Calculations:
 * tip = 12 * (20/100) = 2,4
 * tax = 12 * 
 *
 * We round to the nearest dollar (integer) and then print our result, .
 */
package hackerrank;

import java.util.Scanner;

public class MealCost {

    static void solve(double meal_cost, int tip_percent, int tax_percent) {
        System.out.println(Math.round(meal_cost+meal_cost * tip_percent / 100+meal_cost * tax_percent / 100));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double meal_cost = scanner.nextDouble();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int tip_percent = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int tax_percent = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        solve(meal_cost, tip_percent, tax_percent);

        scanner.close();
    }
}
