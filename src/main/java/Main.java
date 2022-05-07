import jdk.jshell.spi.ExecutionControlProvider;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        File directory = new File("Folder1");
        File fileWithName = new File(directory, "Names.txt");


        Scanner scanner = new Scanner(System.in);
        String line = "";

        while (!line.equals("stop")) {
            System.out.println("Please enter number line: ");
            line = scanner.nextLine();

            try (RandomAccessFile randomAccessFile = new RandomAccessFile(fileWithName, "rw");
            ) {
                randomAccessFile.seek(Integer.parseInt(line));
                String rline = randomAccessFile.readLine();
                System.out.println(rline);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


}
