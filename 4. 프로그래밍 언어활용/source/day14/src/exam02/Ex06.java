package exam02;

import java.util.function.IntUnaryOperator;

public class Ex06 {
    public static void main(String[] args) {

    }

    public static int[] map(int[] nums, IntUnaryOperator oper) { // 들어오는 게 있으면 나가는 게 있음 = Function
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) { // 내부에 반복문 O
            newNums[i] = oper.applyAsInt(nums[i]); // 추상 메서드
        }

        return newNums;
    }
}
