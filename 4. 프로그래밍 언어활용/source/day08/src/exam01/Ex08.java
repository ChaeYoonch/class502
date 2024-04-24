package exam01;

import java.util.Arrays;

public class Ex08 {
    public static void main(String[] args) {
        int result1 = sum(10, 20, 30, 40);
        int result2 = sum(10, 20);
        System.out.println(result1);
        System.out.println(result2);
    }

    public static int sum(int... nums) { // 가변적 형태의 매개변수 | 자료형 뒤에 ...
        int total = 0;
        for (int num : nums) { // 향상된 for 문
            total += num;
        }

        return total;
    }
}
