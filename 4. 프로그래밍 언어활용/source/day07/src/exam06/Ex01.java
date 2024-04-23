package exam06;

public class Ex01 {
    public static void main(String[] args) {
        Book book = new Book(1000, "책1", "저자1");
        System.out.println(book); // book.toString() -> 메서드 자동 추가
        Class cls = Book.class; // class 의 구성 정보가 담겨져 있는 객체
        Class cls2 = book.getClass();
    }
}
