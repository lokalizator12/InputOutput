import java.io.*;

public class Main {
    public static void main(String[] args) {
      File directory = new File("Folder1");
      directory.mkdir();
      File file = new File("Folder1/Mike.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream inputStream = new FileInputStream(file)) {
            int b = inputStream.read();
            while (b != -1){
                System.out.print((char)b);
                b = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
