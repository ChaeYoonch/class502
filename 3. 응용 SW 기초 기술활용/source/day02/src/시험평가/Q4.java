package 시험평가;

public class Q4 {
    public static void main(String[] args) {

        for (int 단 = 1; 단 <= 9; 단++) {  // 1단부터 구구단이죠..?
            System.out.println(단 + "단===============");
            for (int 곱 = 1; 곱 <= 9; 곱++) {
                if (곱 < 단) {
                    continue;
                }
                System.out.printf("%d X %d = %d%n", 단, 곱, 단 * 곱);
            }
        }
    }
}
