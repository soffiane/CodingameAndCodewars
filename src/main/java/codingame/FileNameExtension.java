package codingame;

public class FileNameExtension {

    public String getFileNameExtension(String filename) {
        String result = "";
        if(filename != null && !filename.isEmpty()) {
            String[] parts = filename.split("\\.");
            if(parts.length == 2){
                result = parts[1];
            } else {
                result = null;
            }
        }
        return result;
    }

    public static void main(String... args){
        System.out.println(new FileNameExtension().getFileNameExtension("file.ext"));
    }
}
