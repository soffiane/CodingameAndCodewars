package codingame;

import java.util.Scanner;

/**
 * You are tasked with implementing a simple encoding algorithm where you take a string, split it in two and then alternate between each character in the halves starting with the first half.
 *
 * Example:
 * s = "Hello!"
 * Half1 = "Hel"
 * Half2 = "lo!"
 * Half1:....H.e.l
 * ..........↓.↓.↓
 * answer = "Hleol!"
 * ...........↑.↑.↑
 * Half2:.....l.o.!
 *
 *
 * Note that if the strings length is odd then Half1 will get the center character.
 *
 * Example:
 * s = "Hello"
 * Half1 =  "Hel"
 * Half2 =  "lo"
 * answer = "Hleol"
 */
public class SplitAndAlternateStrings {
	//TODO : more concise solution
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		String half1 = "";
		String half2 = "";
		if(s.length() % 2 == 0){
			half1 = s.substring(0, s.length() / 2);
			half2 = s.substring(s.length() / 2);
		} else {
			half1 = s.substring(0, (s.length() / 2)+1);
			half2 = s.substring((s.length() / 2)+1);
		}
		StringBuilder result = new StringBuilder();
		for(int i=0;i<half1.length();i++){
			result.append(half1.charAt(i));
			if(i < half2.length()){
				result.append(half2.charAt(i));
			}
		}
		System.out.println(result.toString());
	}
}
