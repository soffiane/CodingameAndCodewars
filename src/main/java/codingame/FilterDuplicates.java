package codingame;

import java.io.PrintStream;
import java.util.Scanner;

public class FilterDuplicates {

        public static int[] filterDuplicates(int[] data) {
            // Write your code here
            // To debug: System.err.println("Debug messages...");
            int[] temp = data;
            for(int i=0;i<data.length;i++){
                if(data[i] == temp[i]){
                    data[i] = data[i+1];
                }
            }
            return data;
        }

        /* Ignore and do not change the code below */
        public static void main(String args[]) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int[] data = new int[n];
            for (int i = 0; i < n; i++) {
                data[i] = in.nextInt();
            }
            PrintStream outStream = System.out;
            System.setOut(System.err);
            int[] filtered = filterDuplicates(data);
            System.setOut(outStream);
            for (int i = 0; i < filtered.length; i++) {
                System.out.println(filtered[i]);
            }
        }
}
