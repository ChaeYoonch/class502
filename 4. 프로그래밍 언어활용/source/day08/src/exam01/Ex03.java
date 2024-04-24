package exam01;

public class Ex03 {
    public static void main(String[] args) {
        Book b1 = new Book(1000, "책1", "저자1");
        Book b2 = new Book(1000, "책1", "저자1"); // 값이 유사해도 서로 다른 객체
        System.out.printf("b1 == b2: %s%n", b1 == b2);
        System.out.printf("b1.equals(b2): %s%n", b1.equals(b2));
        // equals 를 정의하지 않은 상태 : Object - equals() -> == | Book 에서 instanceof 로 형변환 =>
        // equals 를 정의하고 난 상태 : Book - equals()
        System.out.printf("b1 주소: %d%n", System.identityHashCode(b1));
        System.out.printf("b2 주소: %d%n", System.identityHashCode(b2));
    }
}
