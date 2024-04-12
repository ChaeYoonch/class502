package exam01;

public class Ex12 {
    public static void main(String[] args) {
        int num1 = 13;
        double num2 = 3.6;

        // double num3 = num1 * num2; -> 오답
        // 곱셈 결과를 정수로 표현 | 연산 중에도 자동 형변환 발생 O => 평가에 나옴!

        // int num3 = num1 * (int)num2; // 오답! : 3.6 -> 3 으로 바뀌어 오차 발생
        int num3 = (int)(num1 * num2); // (int)(13 * 3.6) | 46
        System.out.println(num3);
    }
}
