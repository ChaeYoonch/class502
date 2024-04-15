package 연습문제;

public class Q01 { // 변수 두 개 선언해서 20과 3.0을 대입 + 두 변수의 사칙연산 결과 정수로 출력
    public static void main(String[] args) {
        int num1 = 20;
        double num2 = 3.0; // 형 변환 필요!

        int result = (int)(num1 * num2);  // int num1 -> double
        System.out.println(result);

        /* int result1 = (int)(num1 * num2); // int num1 -> double 로 자동 형변환
        System.out.println(result1);

         int result2 = (int)(num1 + num2);
        System.out.println(result2);

        int result3 = (int)(num1 - num2);
        System.out.println(result3);

        int result4 = (int)(num1 / num2);
        System.out.println(result4); */
    }
}