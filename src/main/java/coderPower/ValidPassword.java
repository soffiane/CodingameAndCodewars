package coderPower;

import java.util.regex.Pattern;

public class ValidPassword {
    private static final String PASSWORD_PATTERN = "(?=.{8,})" +
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])|" +
            "(?=.*\\d)(?=.*[a-zA-Z])(?=.*[\\W_])|" +
            "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W_])).*";

    public static void main(String[] args) {
        // Sample 1 (expected true) : "m<W_?^<tf*u/M"
        // Sample 2 (expected false) : "passw0rd"
        System.out.println(passwordIsStrong("m<W_?^<tf*u/M"));
        System.out.println(passwordIsStrong("passw0rd"));
    }

    public static boolean passwordIsStrong(String password) {
        return Pattern.compile(PASSWORD_PATTERN).matcher(password).matches();
    }
}
