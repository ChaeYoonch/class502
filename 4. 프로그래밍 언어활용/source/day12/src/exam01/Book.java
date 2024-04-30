package exam01;

public class Book { // 단순한 데이터 용도의 클래스
    private int isbn; // 도서번호
    private String title; // 도서명
    private String author; // 저자

    public Book(int isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    } // 초기화 작업 -> generate 자동 완성으로 생성

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
