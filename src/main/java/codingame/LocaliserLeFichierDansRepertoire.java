package codingame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LocaliserLeFichierDansRepertoire {

    /**
     * Locates the universe-formula file.
     */
    static String locateUniverseFormula() throws IOException {
        Stream<Path> walk = Files.walk(Paths.get(""));

        return walk.map(x -> x.toString())
				.filter(f -> f.contains("universal-formula"))
				.findFirst().orElse("not found");
    }

    public static void main(String... args) throws IOException {
        System.out.println(locateUniverseFormula());
    }
}
