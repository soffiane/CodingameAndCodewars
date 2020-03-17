package hackerrank;

import java.util.*;

/**
 * Day 18 : Queues and Stacks
 * <p>
 * A palindrome is a word, phrase, number, or other sequence of characters which reads the same backwards and forwards. Can you determine if a given string, S, is a palindrome?
 * <p>
 * To solve this challenge, we must first take each character in S, enqueue it in a queue, and also push that same character onto a stack.
 * Once that's done, we must dequeue the first character from the queue and pop the top character off the stack,
 * then compare the two characters to see if they are the same; as long as the characters match, we continue dequeueing, popping, and comparing each character
 * until our containers are empty (a non-match means  isn't a palindrome).
 * <p>
 * Write the following declarations and implementations:
 * <p>
 * 1) Two instance variables: one for your STACK, and one for your QUEUE.
 * 2) A void pushCharacter(char ch) method that pushes a character onto a stack.
 * 3) A void enqueueCharacter(char ch) method that enqueues a character in the QUEUE instance variable.
 * 4) A char popCharacter() method that pops and returns the character at the top of the STACK instance variable.
 * 5) A char dequeueCharacter() method that dequeues and returns the first character in the QUEUE instance variable.
 * Input Format
 * <p>
 * You do not need to read anything from stdin. The locked stub code in your editor reads a single line containing string S.
 * It then calls the methods specified above to pass each character to your instance variables.
 * <p>
 * Constraints
 * <p>
 * S is composed of lowercase English letters.
 * Output Format
 * <p>
 * You are not responsible for printing any output to stdout.
 * If your code is correctly written and S is a palindrome, the locked stub code will print "The word, s, is a palindrome." ;
 * otherwise, it will print "The word, s, is not a palindrome."
 * <p>
 * Sample Input
 * <p>
 * racecar
 * Sample Output
 * <p>
 * The word, racecar, is a palindrome.
 */
public class QueuesAndStacks {
	//Last In First Out
	Stack<Character> stack = new Stack<>();

	//First in first out
	Queue<Character> queue = new ArrayDeque<>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		scan.close();

		// Convert input String to an array of characters:
		char[] s = input.toCharArray();

		// Create a Solution object:
		QueuesAndStacks p = new QueuesAndStacks();

		// Enqueue/Push all chars to their respective data structures:
		for (char c : s) {
			p.pushCharacter(c);
			p.enqueueCharacter(c);
		}

		// Pop/Dequeue the chars at the head of both data structures and compare them:
		boolean isPalindrome = true;
		for (int i = 0; i < s.length / 2; i++) {
			if (p.popCharacter() != p.dequeueCharacter()) {
				isPalindrome = false;
				break;
			}
		}

		//Finally, print whether string s is palindrome or not.
		System.out.println("The word, " + input + ", is "
				+ ((!isPalindrome) ? "not a palindrome." : "a palindrome."));
	}

	private char dequeueCharacter() {
		return queue.poll();
	}

	private char popCharacter() {
		return stack.pop();
	}

	private void enqueueCharacter(char c) {
		queue.add(c);
	}

	private void pushCharacter(char c) {
		stack.push(c);
	}
}
