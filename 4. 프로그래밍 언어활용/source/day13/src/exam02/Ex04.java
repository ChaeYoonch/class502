package exam02; // 인터페이스 안에 1개의 메서드만 정의 | 함수형 인터페이스 = 함수형 프로그래밍에 사용할 1개의 메서드 => 단일 기능

public class Ex04 {
    public static void main(String[] args) {
        Calculator cal = (a, b) -> a + b;
    }
}
