package exam01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.List;

public class Ex11 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("data.obj"); // 보조스트림이므로 ObjectInputStream 써야 함!
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            HashMap<String, Object> data = (HashMap<String, Object>)ois.readObject(); // data 복구

            List<Book> books = (List<Book>)data.get("books");
            String str = (String)data.get("str");

            Book book1 = (Book)data.get("book1");

            books.forEach(System.out::println);
            System.out.println(str);

        } catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
