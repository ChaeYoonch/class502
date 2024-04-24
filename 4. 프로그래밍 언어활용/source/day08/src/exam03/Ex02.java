package exam03;

public class Ex02 {
    public static void main(String[] args) {
       Integer num1 = new Integer(10);
       Integer num2 = new Integer(10); // 각각 다른 주소, 다른 객체로 생성
        System.out.printf("num1 주소: %d%n", System.identityHashCode(num1));
        System.out.printf("num2 주소: %d%n", System.identityHashCode(num2));
    }
}
