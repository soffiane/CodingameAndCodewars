package codingbat;

/**
 * codingames from https://codingbat.com/
 * Medium warmup string/array loops
 */
public class WarmupTwo {

	/**
	 * Given a string and a non-negative int n, return a larger string that is n copies of the original string.
	 * stringTimes("Hi", 2) → "HiHi"
	 * stringTimes("Hi", 3) → "HiHiHi"
	 * stringTimes("Hi", 1) → "Hi"
	 */
	public String stringTimes(String str, int n) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < n; i++) {
			result.append(str);
		}
		return result.toString();
	}

	/**
	 * Given a string, return true if the first instance of "x" in the string is immediately followed by another "x".
	 * doubleX("axxbb") → true
	 * doubleX("axaxax") → false
	 * doubleX("xxxxx") → true
	 */
	boolean doubleX(String str) {
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == 'x') {
				return str.charAt(i + 1) == 'x';
			}
		}
		return false;
		/**
		 *  int i = str.indexOf("x");
		 *   if (i == -1) return false; // no "x" at all
		 *
		 *   // Is char at i+1 also an "x"?
		 *   if (i+1 >= str.length()) return false; // check i+1 in bounds?
		 *   return str.substring(i+1, i+2).equals("x");
		 *
		 *   // Another approach -- .startsWith() simplifies the logic
		 *   // String x = str.substring(i);
		 *   // return x.startsWith("xx");
		 */
	}

	/**
	 * Given a string, return the count of the number of times that a substring length 2 appears in the string
	 * and also as the last 2 chars of the string, so "hixxxhi" yields 1 (we won't count the end substring).
	 * last2("hixxhi") → 1
	 * last2("xaxxaxaxx") → 1
	 * last2("axxxaaxx") → 2
	 */
	public static int last2(String str) {
		// Screen out too-short string case.
		if (str.length() < 2) return 0;

		String end = str.substring(str.length() - 2);
		// Note: substring() with 1 value goes through the end of the string
		int count = 0;

		// Check each substring length 2 starting at i
		for (int i = 0; i < str.length() - 2; i++) {
			String sub = str.substring(i, i + 2);
			if (sub.equals(end)) {  // Use .equals() with strings
				count++;
			}
		}
		return count;
	}

	/**
	 * Given an array of ints, return true if the sequence of numbers 1, 2, 3 appears in the array somewhere.
	 * array123([1, 1, 2, 3, 1]) → true
	 * array123([1, 1, 2, 4, 1]) → false
	 * array123([1, 1, 2, 1, 2, 3]) → true
	 */
	public boolean array123(int[] nums) {
		if (nums.length < 3) return false;
		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] == 1 && nums[i + 1] == 2 && nums[i + 2] == 3) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9 ... so "kittens" yields "kien".
	 * altPairs("kitten") → "kien"
	 * altPairs("Chocolate") → "Chole"
	 * altPairs("CodingHorror") → "Congrr"
	 */
	public String altPairs(String str) {
		String result = "";
		// Run i by 4 to hit 0, 4, 8, ...
		for (int i = 0; i < str.length(); i += 4) {
			// Append the chars between i and i+2
			int end = i + 2;
			if (end > str.length()) {
				end = str.length();
			}
			result = result + str.substring(i, end);
		}
		return result;
	}

	/**
	 * Given an array of ints, we'll say that a triple is a value appearing 3 times in a row in the array. Return true if the array does not contain any triples.
	 * noTriples([1, 1, 2, 2, 1]) → true
	 * noTriples([1, 1, 2, 2, 2, 1]) → false
	 * noTriples([1, 1, 1, 2, 2, 2, 1]) → false
	 */
	public boolean noTriples(int[] nums) {
		if (nums.length < 3) {
			return true;
		}
		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars, or whatever is there if the string is less than length 3. Return n copies of the front;
	 * frontTimes("Chocolate", 2) → "ChoCho"
	 * frontTimes("Chocolate", 3) → "ChoChoCho"
	 * frontTimes("Abc", 3) → "AbcAbcAbc"
	 */
	public String frontTimes(String str, int n) {
		String front = "";
		String result = "";
		if (str.length() < 3) {
			front += str;
		} else {
			front += str.substring(0, 3);
		}
		for (int i = 0; i < n; i++) {
			result += front;
		}
		return result;
	}

	/**
	 * Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo".
	 * stringBits("Hello") → "Hlo"
	 * stringBits("Hi") → "H"
	 * stringBits("Heeololeo") → "Hello"
	 */
	public String stringBits(String str) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < str.length(); i += 2) {
			result.append(str.charAt(i));
		}
		return result.toString();
	}

	/**
	 * Given an array of ints, return the number of 9's in the array.
	 * arrayCount9([1, 2, 9]) → 1
	 * arrayCount9([1, 9, 9]) → 2
	 * arrayCount9([1, 9, 9, 3, 9]) → 3
	 */
	public int arrayCount9(int[] nums) {
		int count9 = 0;
		for (int num : nums) {
			if (num == 9) {
				count9++;
			}
		}
		return count9;
	}

	/**
	 * Given 2 strings, a and b, return the number of the positions where they contain the same length 2 substring.
	 * So "xxcaazz" and "xxbaaz" yields 3, since the "xx", "aa", and "az" substrings appear in the same place in both strings.
	 * stringMatch("xxcaazz", "xxbaaz") → 3
	 * stringMatch("abc", "abc") → 2
	 * stringMatch("abc", "axc") → 0
	 */
	public int stringMatch(String a, String b) {
		return 0;
	}

	public static void main(String[] args) {
		last2("axxxaaxx");
	}
}
