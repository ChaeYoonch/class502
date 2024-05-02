package exam02;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

public class Ex07 {
    public static void main(String[] args) { // 내부 반복 의사 코드
        int[] nums = {10, 20, 30, 40, 50};
        int[] nums2 = map(nums, x -> x * x); // 람다식 사용
        /* int[] nums2 = map(nums, new IntUnaryOperator() { // new IntUnaryOperator() -> IntUnaryOperator oper 대입
            @Override
            public int applyAsInt(int num) {
                return num * num * num; // 사용자 정의 기능 = 열린 기능
            }
        }); */
        System.out.println(Arrays.toString(nums2));
    }

    public static int[] map(int[] nums, IntUnaryOperator oper) { // map = 변경 작업
        int[] newNums = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            newNums[i] = oper.applyAsInt(nums[i]); // applyAsInt(int num) {} -> oper.applyAsInt(nums[i]) 호출
        }

        return newNums;
    }
}
