package exam01;

public class Ex03 {
    public static void main(String[] args) {
        int num = 10;

        String str = num % 2 == 0 ? "짝수" : "홀수"; // 삼항 조건식
                     /* 1항           2항      3항 */
        System.out.println(str);
    }
}
