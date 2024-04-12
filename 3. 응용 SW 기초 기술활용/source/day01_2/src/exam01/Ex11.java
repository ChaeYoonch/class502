package exam01;

public class Ex11 {
    public static void main(String[] args) {
        double num1 = 10.123;
        long num2 = (long)num1; // 정수는 실수 보다 숫자 범위가 적다 -> num1의 소수점 범위 유실됨 10만 넘어옴 | 명시적 형변환
        System.out.println(num2);
    }
}
