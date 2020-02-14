package hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Task
 * Given N names and phone numbers, assemble a phone book that maps friends' names to their respective phone numbers.
 * You will then be given an unknown number of names to query your phone book for.
 * For each NAME queried, print the associated entry from your phone book on a new line in the form name=phoneNumber;
 * if an entry for NAME is not found, print Not found instead.
 * <p>
 * Note: Your phone book should be a Dictionary/Map/HashMap data structure.
 * <p>
 * Input Format
 * <p>
 * The first line contains an integer, N , denoting the number of entries in the phone book.
 * Each of the N subsequent lines describes an entry in the form of 2 space-separated values on a single line. The first value is a friend's name, and the second value is an -digit phone number.
 * <p>
 * After the N lines of phone book entries, there are an unknown number of lines of queries.
 * Each line (query) contains a NAME to look up, and you must continue reading lines until there is no more input.
 * <p>
 * Note: Names consist of lowercase English alphabetic letters and are first names only.
 */
public class PhoneBook {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("src/main/ressources/hackerrankFiles/phoneBook/exemple.txt"));
		int n = in.nextInt();
		Map<String, Integer> phoneBook = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String name = in.next();
			int phone = in.nextInt();
			phoneBook.put(name, phone);
		}
		while (in.hasNext()) {
			String s = in.next();
			if (phoneBook.containsKey(s)) {
				System.out.println(s+"=" + phoneBook.get(s));
			} else {
				System.out.println("Not found");
			}
		}
		in.close();
	}
}
