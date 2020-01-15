package codingame;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * This class defines a stream printer.
 */
class StreamPrinter {

    /**
     * Reads from the given reader and print to​​​​​​‌​​​‌​‌​‌​‌‌‌​​‌​​‌​​‌​‌‌ stdout.
     */
    void print(Reader reader) throws IOException {
        int code = reader.read();
        while (code != -1) {
            System.out.print((char) code);
            code = reader.read();
        }

        reader.close();
    }

    public static void main(String... args) throws IOException {
        Reader example = new StringReader(null);
        new StreamPrinter().print(example);
    }

}
