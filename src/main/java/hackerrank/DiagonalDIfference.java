package hackerrank;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Given a square matrix, calculate the absolute difference between the sums of its diagonals.
 *
 * For example, the square matrix  is shown below:
 *
 * 1 2 3
 * 4 5 6
 * 9 8 9
 * The left-to-right diagonal = 1+5+9=15. The right to left diagonal = 3+5+9=17. Their absolute difference is |15 -17|=2.
 *
 * Function description
 *
 * Complete the  function in the editor below. It must return an integer representing the absolute diagonal difference.
 *
 * diagonalDifference takes the following parameter:
 *
 * arr: an array of integers .
 */
public class DiagonalDIfference {

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/main/ressources/hackerrankFiles/diagonalDifference/exemple.txt"))))) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<List<Integer>> arr = new ArrayList<>();

            IntStream.range(0, n).forEach(i -> {
                try {
                    arr.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                    .map(Integer::parseInt)
                                    .collect(toList())
                    );
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            int result = diagonalDifference(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();


        } catch (IOException e){
            e.printStackTrace();
        } finally {
            bufferedWriter.close();
        }

    }
    public static int diagonalDifference(List<List<Integer>> arr) {
        int leftToRight = 0;
        int rightToLeft = 0;
        for(int i=0;i<arr.size();i++){
            List<Integer> integers = arr.get(i);
            leftToRight += integers.get(i);
            rightToLeft += integers.get((arr.size()-1) - i);
        }
        return Math.abs(leftToRight - rightToLeft);
    }
}
