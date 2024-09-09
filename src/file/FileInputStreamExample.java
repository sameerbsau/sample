package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileInputStreamExample {
    public static void main(String[] args) {
        try {
            FileInputStream stream = new FileInputStream("./test.txt");
            int i = stream.read();
            System.out.println(i);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
