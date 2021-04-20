package skillvalue;

import java.util.HashMap;
import java.util.Map;

public class DecipherTheCode {
	/* The name of the class has to be Main. */
	public static void main(String[] args) {
		StringBuilder result = new StringBuilder();
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		try {
			String keyword = "ENGLISH";
			String encrypted_word = "EIQMNBGR";

			/* YOUR CODE HERE */
			Map<Integer, Character> regularAlphabet = new HashMap<>();
			for (int j = 0; j < alphabet.length(); j++) {
				regularAlphabet.put(j, alphabet.charAt(j));
			}

			Map<Integer, Character> encryptedAlphabet = new HashMap<>();
			for (int j = 0; j < keyword.length(); j++) {
				encryptedAlphabet.put(j, keyword.charAt(j));
			}
			System.out.println(encryptedAlphabet.values());
			for (int j = 0; j < alphabet.length(); j++) {
				if (!encryptedAlphabet.containsValue(alphabet.charAt(j))) {
					encryptedAlphabet.put(encryptedAlphabet.size() + 1, alphabet.charAt(j));
				}
			}
			System.out.println(regularAlphabet.values());
			System.out.println(encryptedAlphabet.values());
			//lire dans l'alphabet encodé les lettres et les faire matcher avec alphabet normal
			for (int j = 0; j < encrypted_word.length(); j++) {
				for (Map.Entry<Integer, Character> entry : encryptedAlphabet.entrySet()) {
					//TODO - Fix
					if (entry.getValue().equals(encrypted_word.charAt(j))) {
						int indice = entry.getKey();
						Character character = regularAlphabet.get(indice);
						result.append(character);
					}
				}
			}
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
	}
}
