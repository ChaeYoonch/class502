package exam03;

public class Ex07 {
    public static void main(String[] args) {
        double result = add(10.0, 10L);
        System.out.println(result); // Number = 숫자 체계 가장 위 | 반환값 -> 정수
    }

    public static double add(Number num1, Number num2) {
        return num1.doubleValue() + num2.doubleValue();
    }
}
