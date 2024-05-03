package exam01;

import java.util.Optional;

public class Ex09 {
    public static void main(String[] args) {
        Book book = null;
        Optional<Book> opt = Optional.ofNullable(book);

        // Book book2 = opt.orElseGet(() -> new Book()); // 매개변수 없이 값만 있는 Supplier 형태
        Book book2 = opt.orElseGet(Book::new); // 메서드 참조
        System.out.println(book2);
    }
}
