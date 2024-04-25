package exam04;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

public class Ex07 {
    public static void main(String[] args) {
        int[] nums = { 10, 20, 30, 40};
        int[] nums2 = Arrays.stream(nums).map(new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {
                return operand * operand;
            }
        }).toArray();
        System.out.println(Arrays.toString(nums2));
    }
}
