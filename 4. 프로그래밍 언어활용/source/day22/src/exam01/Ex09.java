package exam01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Ex09 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("book.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            /**
             * Book book = new Book(..., ..., ...);
             * - 복구시에 필요한 데이터가 저장 -> 다시 객체 생성, 값 대입
             * - 순서대로 가지고 와야 함 -> 그렇지 않으면 오류 발생
             */

            String str = (String)ois.readObject();
            System.out.println(str);

            Book book1 = (Book)ois.readObject();
            System.out.println(book1);

            Book book2 = (Book)ois.readObject();
            System.out.println(book2);



        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}