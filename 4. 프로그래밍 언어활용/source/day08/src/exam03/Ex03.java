package exam03;

public class Ex03 {
    public static void main(String[] args) {
        Integer num1 = Integer.valueOf(10000000); // 10 -> 둘 다 주소 서로 동일
        Integer num2 = Integer.valueOf(10000000); // 숫자가 커지면 새로운 객체 생성됨
        System.out.printf("num1 주소: %d%n", System.identityHashCode(num1));
        System.out.printf("num2 주소: %d%n", System.identityHashCode(num2));
    }
} // Integer -> 자원 낭비 | 객체 1개만 생성 => valueOf 가 권장 사항