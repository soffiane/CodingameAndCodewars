package codingame;

import com.sun.deploy.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EncodeDecode {


    private String encodedAlphabet;
    private String decodedAlphabet;

    private static String regex = "[a-z ]+";
    //private char[] alphabet = "{ 'a', 'b', 'c', 'd', 'e' }";

    // Constructor will be called by test methods
    public EncodeDecode (String encodedAlphabet, String decodedAlphabet) {
        this.encodedAlphabet = encodedAlphabet;
        this.decodedAlphabet = decodedAlphabet;
    }

    public String decode(String text) {
        // Your code here
        if(text == null){
            return null;
        }
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        if(!m.matches()){
            throw new IllegalArgumentException("chaine invalide");
        }
        return "";
    }

    public static String encode(String text) {
        // Your code here
        if(text == null){
            return null;
        }
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        System.out.println("avant decode");
        if(!m.matches()){
            throw new IllegalArgumentException("chaine invalide");
        }
        String result = "";
        //code ascii lettre compris entre 97 et 122
        for(int i =0; i<text.length();i++){

            char c = text.charAt(i);
            int ascii = (int) c;
            if(ascii == 32){ //espace
                result += (char)ascii;
            }
            else if(ascii + 15 < 122){
                ascii += 15;
                result += (char)ascii;
            } else if(ascii + 15 > 122){

            }
        }
        return result;
    }

    public static void main(String [] args){
        System.out.println(encode("bpzp"));
    }

}
