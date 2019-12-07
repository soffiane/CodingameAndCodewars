package codingame;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class AlgoChaineParentheseSymetrique {

	/**
	 * Checks that the given string is correct.
	 */
	static boolean check(String str) {
		if (str.isEmpty())
			return true;
		if (str.length() % 2 == 1)
			return false;

		Map<Character, Character> map = new HashMap<>();
		map.put('}', '{');
		map.put(')', '(');
		map.put(']', '[');

		Stack<Character> stack = new Stack<Character>();
		for (Character c : str.toCharArray()) {
			if (map.containsKey(c)) {
				if (!stack.isEmpty() && map.get(c) == stack.peek()) {
					stack.pop();
				} else {
					return false;
				}
			} else {
				stack.push(c);
			}
		}
		return stack.isEmpty();
	}

}
