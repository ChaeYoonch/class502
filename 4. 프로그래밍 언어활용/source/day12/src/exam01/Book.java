package exam01;

import java.util.Objects;

public class Book implements Comparable<Book> { // 단순한 데이터 용도의 클래스 | Comparable -> 기준
    private int isbn; // 도서번호
    private String title; // 도서명
    private String author; // 저자

    public Book(int isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    } // 초기화 작업 -> generate 자동 완성으로 생성

    @Override
    public boolean equals(Object obj) { // Object -> 무엇이 올지 모르므로
        if(obj instanceof Book) {
            Book book = (Book)obj;
            if (isbn == book.isbn && title.equals(book.title) && author.equals(book.author)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, author);
    } // equals() & hashCode() 쌍으로 같이!! | 중복 제거 = 동등성 비교 의 기준

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public int compareTo(Book o) { // Book o -> 기준 대상
        return isbn - o.isbn; // 오름차순 = 현재 객체의 정수 - 비교 객체의 정수
        // return o.isbn - isbn; // 내림차순 = 비교 객체의 정수 - 현재 객체의 정수
    }
}
