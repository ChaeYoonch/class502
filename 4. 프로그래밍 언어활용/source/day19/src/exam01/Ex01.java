package exam01;

public class Ex01 {
    public static void main(String[] args) {
        // %d(정수), %f(실수), %s(문자열), %c(문자)
        /**
         * %자리수s : 자리수 만큼 왼쪽에 공백으로 채워짐 | %5s :   공백3ab
         * %-자리수s %-5s :   ab공백3
         */

        System.out.print("----");
        System.out.printf("%10s", "ab"); // 왼쪽 공백 총 10개
        System.out.println("----");

        System.out.print("----");
        System.out.printf("%-10s", "ab"); // 오른쪽 공백 총 10개
        System.out.println("----");

        System.out.print("----");
        System.out.printf("%05d", 100); // 5자리 내에서 100 표시 | ----00100---- 으로 나타남
        System.out.println("----");
    }
}
