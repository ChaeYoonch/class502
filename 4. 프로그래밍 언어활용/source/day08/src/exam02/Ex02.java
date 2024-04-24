package exam02;

public class Ex02 {
    public static void main(String[] args) {
        String s1 = "ABC"; // 힙 영역 - 문자열 상수 풀 | 객체 형태의 상수 | 문자열 상수 | "ABC" -> 1개만 존재 => 동일한 객체로 판단
        String s2 = "ABC"; // 힙 영역 - 문자열 상수 풀
        System.out.printf("s1 == s2: %s%n", s1 == s2); // 주소가 같은 객체
        System.out.printf("s1 주소: %d%n", System.identityHashCode(s1));
        System.out.printf("s2 주소: %d%n", System.identityHashCode(s2));
    }
}
