package test;

import java.util.Arrays;

public class Q5 {
    public static void main(String[] args) {
        int[] nums = {21, 22, 30, 11, 99, 31};
        /* int temp = nums[0];
        nums[0] = nums[5];
        nums[5] = temp; // 이와 같이 나열해도 가능함 but, 효율적이지는 않음 */

        // int index = nums.length - 2 - 1; // 절반 길이만 반복
        for (int i = 0; i < nums.length / 2; i++) {
            int index = nums.length - i - 1;
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
        }
        System.out.println(Arrays.toString(nums));
    }

}
