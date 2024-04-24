package exam02;

public class Ex01 {
    public static void main(String[] args) {
        String s1 = new String("ABC");
        String s2 = new String("ABC"); // s1 과 s2 가 서로 동일한 값 의미함
        System.out.printf("s1 == s2: %s%n", s1 == s2); // 주소가 서로 다른 객체
        System.out.printf("s1 주소: %d%n", System.identityHashCode(s1));
        System.out.printf("s2 주소: %d%n", System.identityHashCode(s2));
    }
}
