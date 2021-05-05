package interviews;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Spideo {

	//la lettre de rancon
	public static void main(String[] args) {
		Map<String, Long> wordNeeded = Stream.of("abc", "def")
				.collect(groupingBy(String::toUpperCase, counting()));

		Map<String, Long> wordAvailable = Stream.of("abc", "abc", "def")
				.collect(groupingBy(String::toUpperCase, counting()));
		boolean result = wordNeeded.entrySet().stream()
				.allMatch(e -> Optional.ofNullable(wordAvailable.get(e.getKey()))
						.filter(found -> found >= e.getValue())
						.isPresent());
		System.out.println(result ? "Possible" : "Impossible");
	}
}
