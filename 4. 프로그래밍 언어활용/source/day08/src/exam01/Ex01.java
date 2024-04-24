package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Book b1 = new Book(1000, "책1", "저자1");
        System.out.println(b1); // b1.toString() -> exam01.Book@3b07d329 중 3b07d329 출처 = Object toString()
                                               // = getClass().getName() + "@" + Integer.toHexString(hashCode())
                               // getClass() -> 클래스의 구성 정보가 담겨있는 객체 | getName() 구성 정보 중 이름에 관한 내용
    }
}
