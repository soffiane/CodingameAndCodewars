package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Day 12 : Inheritance
 * Task
 * You are given two classes, Person and Student, where Person is the base class and Student is the derived class.
 * Completed code for Person and a declaration for Student are provided for you in the editor. Observe that Student inherits all the properties of Person.
 * <p>
 * Complete the Student class by writing the following:
 * <p>
 * A Student class constructor, which has  parameters:
 * A string, firstName.
 * A string, lastName.
 * An integer, id.
 * An integer array (or vector) of test scores, scores.
 * A char calculate() method that calculates a Student object's average and returns the grade character representative of their calculated average:
 * Letter  Average
 * O		90 <= a <= 100
 * E		80 <= a < 90
 * A		70 <= a < 80
 * P		55 <= a < 70
 * D		40 <= a < 55
 * T 		a < 40
 * <p>
 * Input Format
 * <p>
 * The locked stub code in your editor calls your Student class constructor and passes it the necessary arguments. It also calls the calculate method (which takes no arguments).
 * <p>
 * You are not responsible for reading the following input from stdin:
 * The first line contains firstName, lastName, and id, respectively.
 * The second line contains the number of test scores.
 * The third line of space-separated integers describes scores.
 * <p>
 * Output Format
 * <p>
 * This is handled by the locked stub code in your editor.
 * Your output will be correct if your Student class constructor and calculate() method are properly implemented.
 * <p>
 * Sample Input
 * <p>
 * Heraldo Memelli 8135627
 * 2
 * 100 80
 * Sample Output
 * <p>
 * Name: Memelli, Heraldo
 * ID: 8135627
 * Grade: O
 * Explanation
 * <p>
 * This student had 2 scores to average: 100 and 80. The student's average grade is (100+80)/2=90.
 * An average grade of 90 corresponds to the letter grade O , so our calculate() method should return the character'O'.
 */
public class Inheritance {

	static class Personn {
		protected String firstName;
		protected String lastName;
		protected int idNumber;

		// Constructor
		Personn(String firstName, String lastName, int identification) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.idNumber = identification;
		}

		// Print person data
		public void printPerson() {
			System.out.println(
					"Name: " + lastName + ", " + firstName
							+ "\nID: " + idNumber);
		}
	}

	static class Student extends Personn {
		private int[] testScores;

		/*
		 *   Class Constructor
		 *
		 *   @param firstName - A string denoting the Person's first name.
		 *   @param lastName - A string denoting the Person's last name.
		 *   @param id - An integer denoting the Person's ID number.
		 *   @param scores - An array of integers denoting the Person's test scores.
		 */
		// Write your constructor here
		Student(String firstName, String lastName, int identification, int[] testScores) {
			super(firstName, lastName, identification);
			this.testScores = testScores;
		}

		/*
		 *   Method Name: calculate
		 *   @return A character denoting the grade.
		 */
		public String calculate() {
			double average = Arrays.stream(testScores).average().getAsDouble();
			if (average >= 90 && average <= 100) {
				return "O";
			}
			if (average >= 80 && average < 90) {
				return "E";
			}
			if (average >= 70 && average < 80) {
				return "A";
			}
			if (average >= 55 && average < 70) {
				return "P";
			}
			if (average >= 40 && average < 55) {
				return "D";
			} else {
				return "T";
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String firstName = scan.next();
		String lastName = scan.next();
		int id = scan.nextInt();
		int numScores = scan.nextInt();
		int[] testScores = new int[numScores];
		for (int i = 0; i < numScores; i++) {
			testScores[i] = scan.nextInt();
		}
		scan.close();

		Student s = new Student(firstName, lastName, id, testScores);
		s.printPerson();
		System.out.println("Grade: " + s.calculate());
	}
}