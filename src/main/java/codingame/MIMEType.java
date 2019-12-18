package codingame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class MIMEType {

    public static void process(String fileName) throws FileNotFoundException {

        Scanner in = new Scanner(new File(fileName));
        int types_n = in.nextInt();
        int files_n = in.nextInt();

        Map<String, String> map = new HashMap<String, String>();

        for (int i = 0; i < types_n; i++) {
            map.put(in.next().toLowerCase(), in.next());
            in.nextLine();
        }

        for (int i = 0; i < files_n; i++) {
            String FNAME = in.nextLine().toLowerCase(); // One file name per line.
            int dotI = FNAME.lastIndexOf(".");
            String ext = dotI == -1 ? "" : FNAME.substring(dotI + 1);
            System.out.println(map.containsKey(ext) ? map.get(ext) : "UNKNOWN");
        }
    }

    public static void main(String... args) throws FileNotFoundException {
        process("src/main/ressources/codingameFile/MIMEType/Exemple_simple.txt");
        process("src/main/ressources/codingameFile/MIMEType/decoupage_extension.txt");
        process("src/main/ressources/codingameFile/MIMEType/casse.txt");
    }
}