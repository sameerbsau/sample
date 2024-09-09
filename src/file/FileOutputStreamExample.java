package file;

import java.io.FileOutputStream;

public class FileOutputStreamExample {

    public static void main(String[] args) {
        try {
            FileOutputStream stream = new FileOutputStream("./test.txt");
            stream.write(25);
            stream.close();
        }catch (Exception e){
e.printStackTrace();
        }
    }
}
