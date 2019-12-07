package codingame;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Concatenation {

    public static void main(String[] args ){
        System.out.println(concat(new String[]{"f","o","o","bar"}));
    }

    static String concat(String[] strings){
        //StringBuffer sb = new StringBuffer();
        String join = String.join("", strings);
        /*for(int i = 0 ; i <strings.length - 1;i++){
            sb.append(strings[i]);
        }*/
        return join;
    }
}
