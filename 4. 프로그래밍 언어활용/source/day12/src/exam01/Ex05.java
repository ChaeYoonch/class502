package exam01;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex05 {
    public static void main(String[] args) {
        // HashSet<Book> books = new HashSet<>();
        Set<Book> books = new TreeSet<>(Comparator.reverseOrder()); // 다형성 but 정렬 기준이 정해지지 않아 오류 발생

        books.add(new Book(1003, "책4", "저자4"));
        books.add(new Book(1004, "책5", "저자5"));
        books.add(new Book(1000, "책1", "저자1"));
        books.add(new Book(1001, "책2", "저자2"));
        books.add(new Book(1001, "책2", "저자2"));
        books.add(new Book(1002, "책3", "저자3"));

        for (Book book : books) {
            System.out.println(book);
        } // Book.java 에서 equals() & hashCode() 로
         // 논리적 동일성 -> 내부 체크 -> 중복 제거
    } // Book.java 에 comparable 정의 -> isbn 순으로 정렬
}
