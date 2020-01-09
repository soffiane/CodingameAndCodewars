/**
 * Alice and Bob each created one problem for HackerRank. A reviewer rates the two challenges,
 * awarding points on a scale from  to  for three categories: problem clarity, originality, and difficulty.
 * <p>
 * We define the rating for Alice's challenge to be the triplet , and the rating for Bob's challenge to be the triplet .
 * <p>
 * Your task is to find their comparison points by comparing  with ,  with , and  with .
 * <p>
 * If , then Alice is awarded  point.
 * If , then Bob is awarded  point.
 * If , then neither person receives a point.
 * Comparison points is the total points a person earned.
 * <p>
 * Given  and , determine their respective comparison points.
 * <p>
 * For example,  and . For elements , Bob is awarded a point because . For the equal elements  and , no points are earned.
 * Finally, for elements ,  so Alice receives a point. Your return array would be  with Alice's score first and Bob's second.
 * Function Description
 * <p>
 * Complete the function compareTriplets in the editor below. It must return an array of two integers, the first being Alice's score and the second being Bob's.
 * <p>
 * compareTriplets has the following parameter(s):
 * <p>
 * a: an array of integers representing Alice's challenge rating
 * b: an array of integers representing Bob's challenge rating
 * Input Format
 * <p>
 * The first line contains  space-separated integers, , , and , describing the respective values in triplet .
 * The second line contains  space-separated integers, , , and , describing the respective values in triplet .
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Return an array of two integers denoting the respective comparison points earned by Alice and Bob.
 * <p>
 * Sample Input 0
 * <p>
 * 5 6 7
 * 3 6 10
 * Sample Output 0
 * <p>
 * 1 1
 */
package hackerrank;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class CompareTwoLists {

    public static void main(String[] args) {
        List<Integer> alice = new ArrayList<>();
        alice.add(17);
        alice.add(28);
        alice.add(30);

        List<Integer> bob = new ArrayList<>();
        bob.add(99);
        bob.add(16);
        bob.add(8);
        List<Integer> integers = compareTriplets(alice, bob);
        System.out.println(integers.stream()
                .map(Object::toString)
                .collect(joining(" ")));

    }

    private static List<Integer> compareTriplets(List<Integer> alice, List<Integer> bob) {
        int a = 0;
        int b = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < alice.size(); i++) {
            if (alice.get(i).compareTo(bob.get(i)) == -1) {
                b++;
            } else if (alice.get(i).compareTo(bob.get(i)) == 1) {
                a++;
            }
        }
        result.add(a);
        result.add(b);
        return result;
    }
}
