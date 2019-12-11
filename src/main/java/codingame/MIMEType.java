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
        int N = in.nextInt(); // Number of elements which make up the association table.
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        System.err.println("N "+N);
        System.err.println("Q "+Q);
        Map association = new HashMap<String,String>();
        for (int i = 0; i < N; i++) {
            String EXT = in.next(); // file extension
            String MT = in.next(); // MIME type.
            System.err.println("EXT "+EXT);
            System.err.println("MT "+MT);
            association.put(EXT,MT);
        }
        in.nextLine();
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine(); // One file name per line.
            System.err.println("FNAME "+FNAME);
            String[] fileAndExtension = FNAME.split("\\.",-1);
            String extension = fileAndExtension[fileAndExtension.length - 1];
            System.err.println("extension "+extension);
            String MT = (String) association.get(extension);
            System.err.println("MT "+MT);
            char[] c = ".".toCharArray();
            int nbPoints = compterOccurrences(FNAME,c[0]);
            if(MT != null && !MT.isEmpty() && nbPoints >= 1 /*&& fileAndExtension.length == 2*/){
                System.out.println(MT);
            } else {
                System.out.println("UNKNOWN");
            }
        }
    }

    public static int compterOccurrences(String maChaine, char recherche) {
        int nb = 0;
        for (int i = 0; i < maChaine.length(); i++) {
            if (maChaine.charAt(i) == recherche)
                nb++;
        }
        return nb;
    }

    public static void main(String... args) throws FileNotFoundException {
        //process("C:/Users/soffiane/Desktop/workspaces/codingame/src/main/ressources/codingameFile/MIMEType/Exemple_simple.txt");
        //process("C:/Users/soffiane/Desktop/workspaces/codingame/src/main/ressources/codingameFile/MIMEType/decoupage_extension.txt");
        process("C:/Users/soffiane/Desktop/workspaces/codingame/src/main/ressources/codingameFile/MIMEType/casse.txt");
    }
}