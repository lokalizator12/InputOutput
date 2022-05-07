import jdk.jshell.spi.ExecutionControlProvider;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
    cats();
    }
    private static void cats(){

        List<Cat> arrayCats = new ArrayList<>();
        for (int i = 1; i <= 5; i++){
            arrayCats.add(new Cat("Simska"+i,"Murze"+i, 64.3+i*2));
        }
        File fileWithCats = new File("Cats.or");
        try {
            fileWithCats.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileWithCats,true))){

            outputStream.writeObject(arrayCats);

        }catch (Exception ex){
            ex.printStackTrace();
        }


        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileWithCats))){
            List<Cat> catsRes = (List<Cat>) objectInputStream.readObject();
                for (Cat catRes : catsRes)
                    System.out.println(catRes.getNickname());

        }catch (Exception ex){
            ex.printStackTrace();
        }


    }
    private void persons(){

        User user1 = new User("Klop", "Klopoich", 20, new Address("9 may", 37));
        File file1 = new File("loastWork.pnh");
        try {
            file1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file1))) {

            outputStream.writeObject(user1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file1))) {
            User userRes = (User) objectInputStream.readObject();
            System.out.println(userRes);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
//        File file2 = new File("loastWork2.pnh");
//        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file2))) {
//            outputStream.writeObject(userRes);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
    }
}
