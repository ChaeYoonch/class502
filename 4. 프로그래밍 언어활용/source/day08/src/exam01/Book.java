package exam01;

import java.util.Objects;

public class Book extends java.lang.Object { // import java.lang.*; | import 구문 자동으로 추가
    private int isbn;
    private String title;
    private String author;

    public Book(int isbn, String title, String author) { // generate -> constructor 로 생성
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object obj) { // Object obj (범용적 기능, Object 는 전부 가능 -> Book 으로 전환) = b2
        if (obj instanceof Book) {
            Book book = (Book)obj; // 문자열은 equals 필요
            if (isbn == book.isbn && title.equals(title) && author.equals(book.author)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode() { // generate -> hashCode() 로 생성
        return Objects.hash(isbn, title, author); // 중복 제거 O
    }

    @Override
    public String toString() { // generate -> toString 으로 생성
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
