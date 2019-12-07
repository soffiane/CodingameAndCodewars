package codingame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MIMEType {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
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
            String[] fileAndExtension = FNAME.split("\\.");
            String extension = fileAndExtension[fileAndExtension.length - 1];
            System.err.println("extension "+extension);
            String MT = (String) association.get(extension);
            System.err.println("MT "+MT);
            char[] c = ".".toCharArray();
            int nbPoints = compterOccurrences(FNAME,c[0]);
            if(MT != null && !MT.isEmpty() && nbPoints == 1){
                System.out.println(MT);
            } else {
                System.out.println("UNKNOWN");
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");


        // For each of the Q filenames, display on a line the corresponding MIME type. If there is no corresponding type, then display UNKNOWN.
        //System.out.println("UNKNOWN");
    }

    public static int compterOccurrences(String maChaine, char recherche)
    {
        int nb = 0;
        for (int i=0; i < maChaine.length(); i++)
        {
            if (maChaine.charAt(i) == recherche)
                nb++;
        }
        return nb;
    }
}
