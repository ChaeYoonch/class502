package exam01;

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
    public String toString() { // generate -> toString 으로 생성
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
