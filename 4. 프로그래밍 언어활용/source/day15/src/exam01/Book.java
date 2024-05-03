package exam01;

public class Book {
    private int isbn;
    private String title;

    public Book() {} // 기본 생성자 추가

    public Book(int isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    } // 초기화 작업

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                '}';
    } // 클래스 추가
}
