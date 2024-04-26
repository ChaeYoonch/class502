package exam01;

public class Ex03 {
    public static void main(String[] args) {
        Transportation BUS = Transportation.BUS; // 내부적으로 객체 O
        Enum trans = BUS; // 다형성
        // System.out.println(BUS instanceof Transportation); // 정적 상수 객체
    }
}
