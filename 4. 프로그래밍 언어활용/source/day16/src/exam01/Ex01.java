package exam01;

import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11, 13};
        boolean isOdd = Arrays.stream(nums).allMatch(x -> x % 2 == 1); // 홀수인 경우
        System.out.println(isOdd);

        boolean isEven = Arrays.stream(nums).anyMatch(x -> x % 2 == 0); // 짝수인 경우
        System.out.println(isEven);

        boolean notInculdedEven = Arrays.stream(nums).noneMatch(x -> x % 2 == 0); // 짝수가 1개도 없어야만 true
        System.out.println(notInculdedEven);
        /* boolean result = true;
        for (int num : nums) {
            if (num % 2 == 0) {
                result = false;
                break;
            }
        } */
    }
}
