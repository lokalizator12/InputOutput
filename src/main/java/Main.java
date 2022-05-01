import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        File directory = new File("Folder1");

        File fileWithName = new File(directory, "Names.txt");

        try (Reader reader = new InputStreamReader(new FileInputStream(fileWithName))) {
            char[] array = new char[16];
            int count = reader.read(array);
            StringBuilder stringBuilder = new StringBuilder();
            while (count > 0) {
                stringBuilder.append(new String(array, 0, count));
                count = reader.read(array);
            }
            String[] names = stringBuilder.toString().split(" ");
            Arrays.stream(names)
                    .filter((name -> name.startsWith("A")))
                    .forEach(System.out::println);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
