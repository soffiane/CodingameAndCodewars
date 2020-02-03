package codingame;

import java.math.BigDecimal;

class Calculator {

    /**
     * Sums an array of​​​​​​‌​​​‌​‌​​​​​‌​​​‌​​​​‌‌​​ numbers.
     *
     * @return the exact sum of the given numbers
     */
    static String sum(String... numbers) throws Exception {
        BigDecimal total = new BigDecimal(0);

        for (String number : numbers) {
            total = total.add(new BigDecimal(number));
        }
        return String.valueOf(total);
    }

    public static void main(String... args) throws Exception {
        System.out.println(Calculator.sum("99.35", "1.10"));
    }

}
