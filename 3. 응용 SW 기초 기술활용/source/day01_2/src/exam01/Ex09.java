package exam01;

public class Ex09 {
    public static void main(String[] args) {
        long num1 = 100000000000L; // 8byte
        double num2 = num1; // 정수 -> 실수 : 자동 형변환 (묵시적 형변환) - 8byte
        float num3 = num1;  // 모든 실수는 모든 정수보다 범위가 넓다. 모든 형태 포괄 - 4byte

        double num4 = 0.0;
        for (int i = 0; i < 1000; i++) {
            num4 += 0.1;
        }

        System.out.println(num4); // 정밀도는 떨어진다.
    }
}
