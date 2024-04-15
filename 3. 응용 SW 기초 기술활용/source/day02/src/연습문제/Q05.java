package 연습문제;

public class Q05 { // 구구단을 단보다 곱하는 수가 크거나 같은 경우만 출력하는 프로그램 구현 소스
    public static void main(String[] args) {

            for (int 단 = 2; 단 <= 9; 단++) {
                System.out.println(단 + "단===============");
                for (int 곱 = 1; 곱 <= 9; 곱++) {
                    //if (곱 >= 단) {
                    if (곱 < 단) {
                        continue;
                    }
                        System.out.printf("%d X %d = %d%n", 단, 곱, 단 * 곱);
                }

            }
    }
}
