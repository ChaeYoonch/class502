package exam01;

import java.util.function.Supplier;

public class Ex08 {
    public static void main(String[] args) {
        Supplier<Book> s1 = () -> new Book(); // 들어오는 게 없어도 나가는 게 있는 = Supplier 인터페이스로 Book 객체 생성
        Supplier<Book> s2 = Book::new; // 위의 것과 동일 -> 메서드 참조

        Book b1 = s2.get();
        System.out.println(b1);
    }
}
